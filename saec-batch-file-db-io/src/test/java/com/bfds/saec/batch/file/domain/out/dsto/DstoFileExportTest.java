package com.bfds.saec.batch.file.domain.out.dsto;

import java.util.Date;

import org.junit.Ignore;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.TestSupport;
import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;

@ContextConfiguration({ "classpath:META-INF/spring/saec-batch-test-context.xml" })
public class DstoFileExportTest extends
		AbstractFlatFileExportFromJPAIntegrationTest<DstoRec> {

    @Autowired
    private DstoRecDataGenerator dstoRecDataGenerator;

	@Override
	protected void createTestData() {

        dstoRecDataGenerator.createDSTOData();

	}

	@Override
	protected JobParameters getJobParameters() {
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("outputResource", getOutputResource())
				.addDate("date", new Date(112, 05,29))
				.addString("fileRecordClass",
						TestSupport.getParametrisedTypeClass(this, 0).getName())
				.addString("dda", "all")
				.addString("queryProviderFilter.dstoFileType",
						DstoRec.DstoFileType.CHECKFILE.toString())
				.toJobParameters();

		return jobParameters;
	}

}
