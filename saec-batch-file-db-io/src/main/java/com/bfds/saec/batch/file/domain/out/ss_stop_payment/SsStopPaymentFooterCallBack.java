package com.bfds.saec.batch.file.domain.out.ss_stop_payment;

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
@Component("SsStopPaymentRecFooterCallback")
@Scope("step")
public class SsStopPaymentFooterCallBack implements FlatFileFooterCallback {

	private String filler1 = "  ";
	private String zeroes1 = "00";
	private String nines = "99999999";
	private String eights = "88888888";
	private String filler2 = "  ";
	private String filler3 = ConverterUtils.getFormattedString1(" ", 34, " ");

    @Value("#{stepExecution}")
    private StepExecution stepExecution;

    @Override
	public void writeFooter(Writer writer) throws IOException {

		BigDecimal totalAmount = (BigDecimal) stepExecution.getExecutionContext().get("totalAmount");
		if (totalAmount != null) {

			writer.write(this.filler1
					+ this.zeroes1
					+ this.nines
					+ this.eights
					+ this.filler2
					+ ConverterUtils.getFormattedString(
							String.valueOf(stepExecution.getWriteCount()), 12,
							"0")
					+ ConverterUtils.getFormattedString(totalAmount, 12, "0",
							true) + this.filler3);
		} else {
			writer.write(this.filler1 + this.zeroes1 + this.nines + this.eights
					+ this.filler2 + "000000000000" + "000000000000"
					+ this.filler3);
		}

	}
    
    
}