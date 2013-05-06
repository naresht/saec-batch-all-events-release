package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.io.IOException;
import java.io.StringWriter;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml", "classpath:META-INF/spring/batch-file-common.xml"})
@TestExecutionListeners({StepScopeTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class StopPaymentFooterCallBackTest {

    @Autowired
    @Qualifier("DbStopPaymentRecFooterCallback")
    private FlatFileFooterCallback dbStopPaymentFooterCallback;

    public StepExecution getStepExecution() {
        return MetaDataInstanceFactory.createStepExecution();
    }

    @Test
    public void testHeader() throws IOException {

        StringWriter writer = new StringWriter();
        dbStopPaymentFooterCallback.writeFooter(writer);
        assertThat(writer.getBuffer().toString()).hasSize(80);
        assertThat(writer.getBuffer().toString().trim()).isEqualTo("T00000000000000000000000");

    }
}
