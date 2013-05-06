package com.bfds.saec.batch.file.domain.in;

import com.bfds.saec.batch.file.domain.FileItemError;
import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.file.domain.TestSupport;
import com.bfds.saec.batch.test.AbstractSingleJobExecutionIntegrationTest;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Template method for all file import tests.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractFlatFileImportToJPAIntegrationTest<R extends FileRecord, H extends FileRecord, F extends FileRecord > extends AbstractSingleJobExecutionIntegrationTest implements ApplicationContextAware {

    @PersistenceContext(unitName = "batchFilesEntityManagerFactory")
    protected EntityManager entityManager;

    protected ApplicationContext applicationContext;

    @Autowired
    protected TestSupport testSupport;

    /**
     * Deleted all the file data from DB. Also the  jobExecution must be set to null for the next test class.
     */
    @AfterClass
    public static void after() {
        AbstractSingleJobExecutionIntegrationTest.after();
        TestSupport.cleanDb();
    }

    @Override
    protected Job geJOb() {
        return applicationContext.getBean(TestSupport.getParametrisedTypeClass(this, 0).getSimpleName() + "Job", Job.class);
    }

    protected  JobParameters getJobParameters() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("inputResource", getInputResource())
                .addString("fileRecordClass", TestSupport.getParametrisedTypeClass(this, 0).getName())
                .addString("dda", "all")
                .toJobParameters();
        return jobParameters;
    }

    /**
     *
     * @return the file resource to be processed by fileImport job.
     */
    protected String getInputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "classpath:" + file + ".txt";
    }

    /**
     *
     * @return The jobExecution against which all tests must/will run.
     */
    protected final JobExecution getJobExecution() {
        return jobExecution;
    }

    /**
     * All the records must have the correct data.
     * @throws Exception
     */
    @Test
    public final void validateRecordData() throws Exception {
        List<R> recordList = findAllRecords();
        assertThat(recordList).onProperty("jobExecutionId").containsOnly(getJobExecution().getId());
        validateRecordData(recordList);
    }


    /**
     *
     * @param recordList  - The record list(excluding headers and footers) that have to be validated for correctness.
     */
    protected abstract void validateRecordData(List<R> recordList) ;


    /**
     * File footer must have the correct data
     * @throws Exception
     */
    @Test
    public final void validateHeader() throws Exception {
        if(!hasHeader())  {
            return;
        }

        H header = findHeader();
        assertThat(header.getJobExecutionId()).isEqualTo(jobExecution.getId());
        validateHeaderData(header);
    }

    /**
     *
     * @param footer - The footer that must be validated for correctness.
     */
    protected abstract void validateHeaderData(H footer);

    /**
     * File footer must have the correct data
     * @throws Exception
     */
    @Test
    public final void validateFooter() throws Exception {
        if(!hasFooter())  {
            return;
        }

        F footer = findFooter();
        assertThat(footer.getJobExecutionId()).isEqualTo(jobExecution.getId());
        validateFooterData(footer);
    }

    /**
     *
     * @param footer - The footer that must be validated for correctness.
     */
    protected abstract void validateFooterData(F footer);



    /**
     * All the records in error must be persisted.
     * @throws Exception
     */
    @Test
    public final void validateErrorRecordData() throws Exception {
        List<FileItemError> recordList = FileItemError.findAllFileItemErrors();
        if(recordList.size() == 0) {
            return;
        }
        assertThat(recordList).onProperty("errorMessage").isNotNull(); // TODO: Can we do better ?
        assertThat(recordList).onProperty("jobExecutionId").containsOnly(getJobExecution().getId());
        validateErrorRecordData(recordList);
    }

    protected abstract void validateErrorRecordData(List<FileItemError> recordList);


    protected List<R> findAllRecords() {
        return (List<R>) testSupport.findAll(TestSupport.getParametrisedTypeClass(this, 0));
    }

    protected H findHeader() {
        if(!hasHeader()) {
            return null;
        }
        List<H> list =  (List<H>) testSupport.findAll(TestSupport.getParametrisedTypeClass(this, 1));
        return list.size() == 1 ? list.get(0) : null;
    }

    private boolean hasHeader() {
       return !TestSupport.getParametrisedTypeClass(this, 0).equals(TestSupport.getParametrisedTypeClass(this, 1));
    }

    protected F findFooter() {
        if(!hasFooter()) {
            return null;
        }
        List<F> list =  (List<F>) testSupport.findAll(TestSupport.getParametrisedTypeClass(this, 2));
        return list.size() == 1 ? list.get(0) : null;
    }

    private boolean hasFooter() {
        return !TestSupport.getParametrisedTypeClass(this, 0).equals(TestSupport.getParametrisedTypeClass(this, 2));
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
