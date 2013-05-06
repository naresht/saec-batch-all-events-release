package com.bfds.saec.batch.file.domain.out.dsto;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:META-INF/spring/saec-batch-test-context.xml",
		"classpath:META-INF/spring/batch-file-common.xml" })
@TestExecutionListeners({ StepScopeTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
public class DstoFooterCallBackTest {
	@Autowired
	@Qualifier("DstoRecFooterCallback")
	private FlatFileFooterCallback dstoCheckFileFooterCallback;

	public StepExecution getStepExection() {
		StepExecution execution = MetaDataInstanceFactory.createStepExecution();
		execution.setWriteCount(2);
		execution.getExecutionContext().put("totalAmount",new BigDecimal(445.75));
		execution.getExecutionContext().put("totalGross",new BigDecimal(1500.00));
		return execution;
	}

	@Test
	public void testFooter() throws IOException {
		StringWriter writer = new StringWriter();
		dstoCheckFileFooterCallback.writeFooter(writer);

		assertThat(writer.getBuffer().toString()).hasSize(63);
		assertThat(writer.getBuffer().toString().trim()).isEqualTo("999  0000000002000000044575000000150000000000000000000000000000");
	}
}
