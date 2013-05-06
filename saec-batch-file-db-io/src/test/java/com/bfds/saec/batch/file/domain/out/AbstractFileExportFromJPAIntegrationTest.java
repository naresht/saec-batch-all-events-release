package com.bfds.saec.batch.file.domain.out;


import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.file.domain.TestSupport;
import com.bfds.saec.batch.test.AbstractSingleJobExecutionIntegrationTest;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public abstract class AbstractFileExportFromJPAIntegrationTest<R extends FileRecord> extends AbstractSingleJobExecutionIntegrationTest implements ApplicationContextAware {

    protected ApplicationContext applicationContext;
    @Autowired
    protected TestSupport testSupport;

    @org.junit.Before
    public  void before() throws Exception {
        if(getJobExecution() != null) {
            // Just one execution for all tests.
            super.before();
            return;
        }
        createTestData();
        super.before();
    }

    protected abstract void createTestData();

    @AfterClass
    public static void after() {
        AbstractSingleJobExecutionIntegrationTest.after();
        TestSupport.cleanDb();
    }

    @Override
    protected Job geJOb() {
        return applicationContext.getBean(TestSupport.getParametrisedTypeClass(this, 0).getSimpleName() + "Job", Job.class);
    }

    @Override
    protected JobParameters getJobParameters() {
        JobParameters jobParameters = new JobParametersBuilder()
               .addString("outputResource", getOutputResource())
                .addDate("date", new Date(112, 0, 1))
                .addString("fileRecordClass", TestSupport.getParametrisedTypeClass(this, 0).getName())
                .addString("dda", "all")
                .toJobParameters();
        return jobParameters;
    }


    @Test
    public void theGeneratedFileMustBeSameAsExpectedFile() throws Exception {
        assertEquals(new UrlResource(getOutputResource()).getFile(), new ClassPathResource(getExpectedOutputResource()).getFile());
    }

    public abstract void assertEquals(File actual, File expected) throws Exception;

    @Test
    public void allRecordsSentOnFileMustBeUpdated() {
        List<R> recordList = findAllRecords();
        assertThat(recordList).onProperty("jobExecutionId").containsOnly(getJobExecution().getId());
        assertThat(recordList).onProperty("processed").containsOnly(Boolean.TRUE);
    }


    protected List<R> findAllRecords() {
        return (List<R>) testSupport.findAll(TestSupport.getParametrisedTypeClass(this, 0));
    }

    protected String getOutputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "file:target/" + file + ".txt";
    }

    protected String getExpectedOutputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "/" + file + ".txt";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
