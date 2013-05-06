package com.bfds.saec.batch.file.domain.out.ss_issue_void;


import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class SsIssueVoidFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<SsIssueVoidRec> {

    @Autowired
    private SsIssueVoidRecDataGenerator ssIssueVoidRecDataGenerator;

    @Override
    protected void createTestData() {
        ssIssueVoidRecDataGenerator.create();
    }
}
