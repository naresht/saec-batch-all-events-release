package com.bfds.saec.batch.file.domain.out.ss_stop_payment;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@MockStaticEntityMethods
@TestExecutionListeners({StepScopeTestExecutionListener.class,  DependencyInjectionTestExecutionListener.class})
@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class SsStopPaymentHeaderCallBackTest {

    @Autowired
    @Qualifier("SsStopPaymentRecHeaderCallback")
    private FlatFileHeaderCallback ssStopPaymentHeaderCallBack;

    public StepExecution getStepExecution() {
        JobExecution je = new JobExecution(10L);
        je.setStartTime(new Date(112, 0, 1));
        return MetaDataInstanceFactory.createStepExecution(je, "step_1", 1L);
    }

    @Test
    public void testHeader() throws IOException {

        StringWriter writer = new StringWriter();
        ssStopPaymentHeaderCallBack.writeHeader(writer);
        assertThat(writer.getBuffer().toString()).hasSize(80);
        assertThat(writer.getBuffer().toString().trim()).contains("0000000000");

    }
}
