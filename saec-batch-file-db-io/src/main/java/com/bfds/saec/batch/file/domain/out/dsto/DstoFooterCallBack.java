package com.bfds.saec.batch.file.domain.out.dsto;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Component;

import com.bfds.saec.util.ConverterUtils;

@RooJavaBean
@Component("DstoRecFooterCallback")
@Scope("step")
public class DstoFooterCallBack implements FlatFileFooterCallback {
	@Value("#{stepExecution}")
	private StepExecution stepExecution;

	private String recordType = "999";
	private String filler = ConverterUtils.getFormattedString1(" ", 2, " ");

	@Override
	public void writeFooter(Writer writer) throws IOException {
		BigDecimal totalAmount = (BigDecimal) ((BigDecimal) stepExecution
				.getExecutionContext().get("totalAmount") == null ? new BigDecimal(
				0) : stepExecution.getExecutionContext().get("totalAmount"));
		BigDecimal totalGross = (BigDecimal) ((BigDecimal) stepExecution
				.getExecutionContext().get("totalGross") == null ? new BigDecimal(
				0) : stepExecution.getExecutionContext().get("totalGross"));
		BigDecimal totalFees = (BigDecimal) ((BigDecimal) stepExecution
				.getExecutionContext().get("totalFees") == null ? new BigDecimal(
				0) : stepExecution.getExecutionContext().get("totalFees"));
		BigDecimal totalTaxes = (BigDecimal) ((BigDecimal) stepExecution
				.getExecutionContext().get("totalTaxes") == null ? new BigDecimal(
				0) : stepExecution.getExecutionContext().get("totalTaxes"));

		 
			writer.write(this.recordType
					+ this.filler
					+ ConverterUtils.getFormattedString(
							String.valueOf(stepExecution.getWriteCount()), 10,
							"0")
					+ ConverterUtils.getFormattedString(totalAmount, 12, "0",
							true)
					+ ConverterUtils.getFormattedString(totalGross, 12, "0",
							true)
					+ ConverterUtils.getFormattedString(totalFees, 12, "0",
							true)

					+ ConverterUtils.getFormattedString(totalTaxes, 12, "0",
							true));
		 
	}

}