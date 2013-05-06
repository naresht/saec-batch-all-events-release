/**
 * 
 */
package com.bfds.saec.batch.file.domain.out.ifds_issue_void;

import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})

public class IfdsIssueVoidFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<IfdsIssueVoidRec> {

    @Autowired
    private IfdsIssueVoidRecDataGenerator ifdsIssueVoidRecDataGenerator;
	 @Override
	    protected void createTestData() {
         ifdsIssueVoidRecDataGenerator.create();
	    }
}
