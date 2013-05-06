package com.bfds.saec.batch.file.domain.out.ss_stop_payment;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bfds.saec.util.ConverterUtils;

@Component("SsStopPaymentRecHeaderCallback")
@Scope("step")
public class SsStopPaymentHeaderCallBack implements FlatFileHeaderCallback {

	private static final String filler1 = ConverterUtils.getFormattedString(" ", 3, " ");
	private static final String zeroes = "0000000000";
	private static final String filler2 = " ";
	private static final String filler3 = ConverterUtils.getFormattedString(" ", 56, " ");
	
    @Value("#{stepExecution}")
    private StepExecution stepExecution;
    
	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write(filler1 + zeroes + filler2 + 
				     ConverterUtils.getFormattedString(getHeaderDate(),"MM/dd/yyyy") + filler3);
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

}
