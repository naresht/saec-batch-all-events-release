package com.bfds.saec.batch.file.domain.out.dsto;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
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

import com.bfds.saec.batch.file.domain.VendorConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:META-INF/spring/saec-batch-test-context.xml",
		"classpath:META-INF/spring/batch-file-common.xml" })
@MockStaticEntityMethods
@TestExecutionListeners({ StepScopeTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
public class DstoHeaderCallBackTest {
	@Qualifier("DstoRecHeaderCallback")
	@Autowired
	private FlatFileHeaderCallback dstoCheckFileheaderCallback;
	
	public StepExecution getStepExection() {
		StepExecution execution = MetaDataInstanceFactory.createStepExecution();
		execution.setWriteCount(2);
		return execution;
	}

	@Test
	public void testHeader() throws IOException {
		
		VendorConfig v = new VendorConfig();
		v.setBankNameOnDstoFile("Boston Finance");
        VendorConfig.getVendorProperties();
        AnnotationDrivenStaticEntityMockingControl.expectReturn(v);
        AnnotationDrivenStaticEntityMockingControl.playback();

        DateFormat df = new SimpleDateFormat("MMddyyyy");
        String headerDate = df.format(new Date()); 
  
		StringWriter writer = new StringWriter();
		dstoCheckFileheaderCallback.writeHeader(writer);
		
		assertThat(writer.getBuffer().toString()).hasSize(53);
		assertThat(writer.getBuffer().toString().trim()).contains("010  Boston Finance                          "+headerDate);

	}
	

	
	
	

}
