package com.bfds.saec.batch.file.domain.out.ss_stop_payment;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("SsStopPaymentRecItemProcessor")
@Scope("step")
public class SsStopPaymentItemProcessor implements ItemProcessor<SsStopPaymentRec, SsStopPaymentRec> {

	@Value("#{stepExecution}")
    private StepExecution stepExecution;

    @Override
    public SsStopPaymentRec process(SsStopPaymentRec item) throws Exception {
    	Integer recordCount = getRecordCount() == null ? 0 : getRecordCount() + 1;    	
		setRecordCount(recordCount);
        updateTotalAmount(new BigDecimal(item.getAmountOfCheck()));
        return item;
    }

	private void updateTotalAmount(BigDecimal paymentAmount) {
		BigDecimal totalAmount = getTotalAmount() == null ? paymentAmount : getTotalAmount().add(paymentAmount);
		setTotalAmount(totalAmount);
	}

	private void setRecordCount(Integer recordCount) {
		stepExecution.getExecutionContext().put("recordNumber", recordCount);
	}

    private Integer getRecordCount() {
		return (Integer)stepExecution.getExecutionContext().get("recordNumber");
	}
    
	private void setTotalAmount(BigDecimal totalAmount) {
		stepExecution.getExecutionContext().put("totalAmount", totalAmount);
	}

	private BigDecimal getTotalAmount() {
		return (BigDecimal) stepExecution
				.getExecutionContext().get("totalAmount");
	}
}
