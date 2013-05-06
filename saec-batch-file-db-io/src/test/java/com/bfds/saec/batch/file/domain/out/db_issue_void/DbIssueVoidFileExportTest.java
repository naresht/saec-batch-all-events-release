package com.bfds.saec.batch.file.domain.out.db_issue_void;


import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class DbIssueVoidFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<DbIssueVoidRec> {

    @Autowired
    private DbIssueVoidRecDataGenerator dbIssueVoidRecDataGenerator;

    @Override
    protected void createTestData() {
        dbIssueVoidRecDataGenerator.create();
    }
}
