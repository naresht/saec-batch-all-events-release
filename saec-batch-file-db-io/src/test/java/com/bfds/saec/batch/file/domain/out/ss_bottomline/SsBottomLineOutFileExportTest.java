package com.bfds.saec.batch.file.domain.out.ss_bottomline;


import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class SsBottomLineOutFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<SsBottomLineOutRec> {

    @Autowired
    private SsBottomLineOutRecDataGenerator ssBottomLineOutRecDataGenerator;
    @Override
    protected void createTestData() {
        ssBottomLineOutRecDataGenerator.create();
    }
}
