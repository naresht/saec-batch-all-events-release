package com.bfds.saec.batch.file.domain.out.dsto;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("DstoRecItemProcessor")
@Scope("step")
public class DstoCheckFileItemProcessor implements
		ItemProcessor<DstoRec, DstoRec> {

	@Value("#{stepExecution}")
	private StepExecution stepExecution;

	@Override
	public DstoRec process(DstoRec item) throws Exception {
		if (item != null) {
            addToIntegerInExecutionContext("recordNumber", 1, stepExecution.getExecutionContext());
			updateAmounts(item);
		}
		item.setBatchNum(stepExecution.getJobExecutionId().toString());
		return item;
	}

	private void updateAmounts(DstoRec item) {
        addToBigDecimalInExecutionContext("totalAmount", item.getNetAmount1(), stepExecution.getExecutionContext());
        addToBigDecimalInExecutionContext("totalGross", item.getGrossAmount1(), stepExecution.getExecutionContext());
        addToBigDecimalInExecutionContext("totalFees", item.getTotFees(), stepExecution.getExecutionContext());
        addToBigDecimalInExecutionContext("totalTaxes", item.getTotTaxes(), stepExecution.getExecutionContext());
	}

    private void addToBigDecimalInExecutionContext(String key, BigDecimal val, ExecutionContext ec) {
        if(val == null) {
            return;
        }
        BigDecimal oldVal = (BigDecimal) ec.get(key);
        BigDecimal newVal = oldVal == null ? val : oldVal.add(val);
        ec.put(key, newVal);
    }

    private void addToIntegerInExecutionContext(String key, Integer val, ExecutionContext ec) {
        if(val == null) {
            return;
        }
        Integer oldVal = (Integer) ec.get(key);
        Integer newVal = oldVal == null ? val : oldVal + val;
        ec.put(key, newVal);
    }
}