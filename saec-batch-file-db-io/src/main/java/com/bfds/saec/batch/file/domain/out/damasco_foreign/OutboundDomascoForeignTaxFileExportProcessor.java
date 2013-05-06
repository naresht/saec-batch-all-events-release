package com.bfds.saec.batch.file.domain.out.damasco_foreign;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Scope("step")
public class OutboundDomascoForeignTaxFileExportProcessor  implements  ItemProcessor<ForeignTaxOutRec,ForeignTaxOutRec> {

	
	@PersistenceContext(unitName = "batchFilesEntityManagerFactory")
	EntityManager entityManager;
	
	@Value("#{stepExecution}")
	private StepExecution stepExecution;

	
	private int itemCount;
	
	
	@Override
	public ForeignTaxOutRec process(ForeignTaxOutRec item)
			throws Exception {
			if(!stepExecution.getExecutionContext().containsKey("paymentComponents")){
				stepExecution.getExecutionContext().put("paymentComponents", getPaymentComponents(item));
			}
			item.setProcessed(Boolean.TRUE);
			item.setJobExecutionId(stepExecution.getJobExecutionId());
			item.setItemNumber(++itemCount);
        entityManager.merge(item);
		return item;
	}
	
	private String getPaymentComponents(ForeignTaxOutRec item) {
		String paymentComponents="";
			paymentComponents =	"ELECTION CODE,"+item.getPaymentComp1Description()+",ELECTION CODE,"+
					item.getPaymentComp2Description()+",ELECTION CODE,"+
					item.getPaymentComp3Description()+",ELECTION CODE,"+
					item.getPaymentComp4Description()+",ELECTION CODE,"+
					item.getPaymentComp5Description();
		return paymentComponents;
	}
    

}
