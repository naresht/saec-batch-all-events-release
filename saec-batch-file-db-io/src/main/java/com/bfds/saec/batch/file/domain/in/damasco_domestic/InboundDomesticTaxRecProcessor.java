package com.bfds.saec.batch.file.domain.in.damasco_domestic;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

public class InboundDomesticTaxRecProcessor  implements  ItemProcessor<DamascoInRec,DamascoInRec> {

	@Value("#{stepExecution}")
	private StepExecution stepExecution;
	@Override

	
	public DamascoInRec process(DamascoInRec item) throws Exception {
		
		
		
		if(stepExecution.getExecutionContext().containsKey("header"))
		{
			String[] headerStringArray= StringUtils.tokenizeToStringArray(stepExecution.getExecutionContext().getString("header"),",");
			item.setPaymentComp1Description(headerStringArray[30]);
			item.setPaymentComp2Description(headerStringArray[31]);
			item.setPaymentComp3Description(headerStringArray[32]);
			item.setDda(stepExecution.getJobParameters().getString("dda"));
			item.setJobExecutionId(stepExecution.getJobExecutionId());
		}
		
		return item;
	}

}
