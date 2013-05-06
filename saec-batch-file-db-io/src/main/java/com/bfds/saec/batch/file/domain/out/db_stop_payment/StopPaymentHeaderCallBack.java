package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import com.bfds.saec.batch.file.domain.VendorConfig;
import com.bfds.saec.util.ConverterUtils;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

@Component("DbStopPaymentRecHeaderCallback")
@Scope("step")
public class StopPaymentHeaderCallBack implements FlatFileHeaderCallback {

    private static final String recordType = "H";

    private static final String filler = ConverterUtils.getFormattedString1(
            " ", 63, " ");

    @Value("#{stepExecution}")
    private StepExecution stepExecution;

    @Override
    public void writeHeader(Writer writer) throws IOException {

        writer.write(StopPaymentHeaderCallBack.recordType
                + ConverterUtils.getFormattedString(getHeaderDate(), "MM/dd/yy")
                + ConverterUtils.getFormattedString1(getDeutscheBankUserId(), 8," ")
                + StopPaymentHeaderCallBack.filler);
    }

    protected Date getHeaderDate() {
      Date date = getExecutionDate();
       return date != null ? date : stepExecution.getJobExecution().getStartTime();
    }

    private Date getExecutionDate() {
        try {
        return stepExecution.getJobParameters().getDate("date");
        }catch(Exception e) {
            //noop
        }
        return null;
    }

    protected String getDeutscheBankUserId() {
        return VendorConfig.getVendorProperties().getDeutscheBankUserId();
    }
}
