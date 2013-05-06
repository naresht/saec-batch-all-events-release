package com.bfds.saec.batch.file.domain.in.damasco_domestic;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.beans.factory.annotation.Value;

public class HeaderCallBackHandler implements LineCallbackHandler {

	 @Value("#{stepExecution}")
	 private StepExecution stepExecution;
	
	
	
	
	@Override
	public void handleLine(String line) {
		stepExecution.getExecutionContext().put("header", line);
	}


}
