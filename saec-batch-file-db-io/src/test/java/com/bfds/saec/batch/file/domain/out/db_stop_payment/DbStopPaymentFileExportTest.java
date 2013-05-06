package com.bfds.saec.batch.file.domain.out.db_stop_payment;


import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class DbStopPaymentFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<DbStopPaymentRec> {

    @Autowired
    private DbStopPaymentRecDataGenerator dbStopPaymentRecDataGenerator;
    @Override
    protected void createTestData() {
        dbStopPaymentRecDataGenerator.create();
    }
}
