package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("DbStopPaymentRecItemProcessor")
@Scope("step")
public class DbStopPaymentItemProcessor implements ItemProcessor<DbStopPaymentRec, DbStopPaymentRec> {

    private StepExecution stepExecution;

    @Override
    public DbStopPaymentRec process(DbStopPaymentRec item) throws Exception {
        Double val = item.getStopAmount();
        updateTotalAmount(new BigDecimal(val));
        return item;
    }

    private void updateTotalAmount(final BigDecimal paymentAmount) {
        BigDecimal totalAmount = (BigDecimal) stepExecution.getExecutionContext().get("totalAmount");
        if (totalAmount == null) {
            totalAmount = paymentAmount;
        } else {
            totalAmount = totalAmount.add(paymentAmount);
        }
        stepExecution.getExecutionContext().put("totalAmount", totalAmount);
    }

    @Value("#{stepExecution}")
    public void setStepExecution(final StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }
}
