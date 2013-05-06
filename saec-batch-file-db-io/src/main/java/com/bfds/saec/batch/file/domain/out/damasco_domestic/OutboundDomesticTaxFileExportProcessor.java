package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import java.util.Date;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Scope("step")
public class OutboundDomesticTaxFileExportProcessor  implements  ItemProcessor<OutboundDomesticTaxRec,OutboundDomesticTaxRec> {

	
	@Value("#{stepExecution}")
	private StepExecution stepExecution;
	
	private int itemCount;
	
	
	@Override
	public OutboundDomesticTaxRec process(OutboundDomesticTaxRec item)
			throws Exception {
			item.setProcessed(Boolean.TRUE);
			item.setJobExecutionId(stepExecution.getJobExecutionId());
			item.setDateSent( getExecutionDate() );
			item.setItemNumber(++itemCount);
		return item;
	}
	
    private Date getExecutionDate() {
        try {
        return stepExecution.getJobParameters().getDate("date"); //the "date" jobParameter exists only to simplify testing.
        }catch(Exception e) {
            //noop
        }
        return new Date();
    }

}
