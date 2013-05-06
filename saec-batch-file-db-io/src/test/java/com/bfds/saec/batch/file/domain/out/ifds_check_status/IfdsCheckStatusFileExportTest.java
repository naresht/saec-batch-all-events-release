package com.bfds.saec.batch.file.domain.out.ifds_check_status;

import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class IfdsCheckStatusFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<IfdsCheckStatusRec> {

    @Autowired
    private IfdsCheckStatusRecDataGenerator ifdsCheckStatusRecDataGenerator;
    @Override
    protected void createTestData() {
        ifdsCheckStatusRecDataGenerator.create();
    }
}