package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import com.bfds.saec.util.ConverterUtils;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;


@RooJavaBean
@Component("DbStopPaymentRecFooterCallback")
@Scope("step")
public class StopPaymentFooterCallBack implements FlatFileFooterCallback {

    private static final String recordType = "T";
    private static final String filler = ConverterUtils.getFormattedString1(" ", 56, " ");

    @Value("#{stepExecution}")
    private StepExecution stepExecution;

    @Override
    public void writeFooter(Writer writer) throws IOException {
        final BigDecimal totalAmount = (BigDecimal) stepExecution
                .getExecutionContext().get("totalAmount");
        if (totalAmount != null) {
            writer.write(this.recordType
                    + ConverterUtils.getFormattedString(
                    String.valueOf(stepExecution.getWriteCount()), 5,
                    "0")
                    + ConverterUtils.getFormattedString(totalAmount, 18, "0",
                    true) + this.filler);
        } else {
            writer.write(this.recordType + "00000" + "000000000000000000"
                    + this.filler);
        }
    }

}