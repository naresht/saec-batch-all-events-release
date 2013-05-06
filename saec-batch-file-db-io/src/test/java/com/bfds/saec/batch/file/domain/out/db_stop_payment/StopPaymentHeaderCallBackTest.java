package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import com.bfds.saec.batch.file.domain.VendorConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml", "classpath:META-INF/spring/batch-file-common.xml"})

@MockStaticEntityMethods
@TestExecutionListeners({StepScopeTestExecutionListener.class,  DependencyInjectionTestExecutionListener.class})
public class StopPaymentHeaderCallBackTest {

    @Autowired
    @Qualifier("DbStopPaymentRecHeaderCallback")
    private FlatFileHeaderCallback stopPaymentHeaderCallBack;

    public StepExecution getStepExecution() {
        JobExecution je = new JobExecution(10L);
        je.setStartTime(new Date(112, 0, 1));
        return MetaDataInstanceFactory.createStepExecution(je, "step_1", 1L);
    }

    @Test
    public void testHeader() throws IOException {

        VendorConfig v = new VendorConfig();
        v.setDeutscheBankUserId("USER-123");
        VendorConfig.getVendorProperties();
        AnnotationDrivenStaticEntityMockingControl.expectReturn(v);
        AnnotationDrivenStaticEntityMockingControl.playback();

        StringWriter writer = new StringWriter();
        stopPaymentHeaderCallBack.writeHeader(writer);
        assertThat(writer.getBuffer().toString()).hasSize(80);
        assertThat(writer.getBuffer().toString().trim()).isEqualTo("H01/01/12USER-123");

    }
}
