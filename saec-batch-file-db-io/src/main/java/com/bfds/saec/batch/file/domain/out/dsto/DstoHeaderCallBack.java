package com.bfds.saec.batch.file.domain.out.dsto;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bfds.saec.batch.file.domain.VendorConfig;
import com.bfds.saec.util.ConverterUtils;

@Component("DstoRecHeaderCallback")
@Scope("step")
public class DstoHeaderCallBack implements FlatFileHeaderCallback {

	@Value("#{stepExecution}")
	private StepExecution stepExecution;

	private String recordType = ConverterUtils.getFormattedString1("010", 3," ");
	private String bankName;
	private String filler = ConverterUtils.getFormattedString1(" ", 2, " ");

	@Override
	public void writeHeader(Writer writer) throws IOException {
		
		bankName = ConverterUtils.getFormattedString1(getBankNameOnDstoFile(), 40, " ");
		writer.write(this.recordType + this.filler + bankName + ConverterUtils.getFormattedString(getExecutionDate(), "MMddyyyy"));
	}
	
	 protected String getBankNameOnDstoFile() {
	        return VendorConfig.getVendorProperties().getBankNameOnDstoFile();
	    }
	 


	    private Date getExecutionDate() {
	        try {
	        return stepExecution.getJobParameters().getDate("date");
	        }catch(Exception e) {
	            //noop
	        }
	        return new Date();
	    }


}