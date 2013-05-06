package com.bfds.saec.batch.file.domain.out.ss_stop_payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;


@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class SsStopPaymentFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<SsStopPaymentRec> {

    @Autowired
    private SsStopPaymentRecDataGenerator ssStopPaymentRecDataGenerator;
    @Override
    protected void createTestData() {
        ssStopPaymentRecDataGenerator.create();
    }
}
