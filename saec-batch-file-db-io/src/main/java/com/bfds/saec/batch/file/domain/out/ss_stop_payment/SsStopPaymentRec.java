package com.bfds.saec.batch.file.domain.out.ss_stop_payment;


import java.util.Date;


import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.annotations.AssumedDecimalNumberFormat;
import com.bfds.saec.batch.annotations.DateFormat;
import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.annotations.PaddedStringFormat;
import com.bfds.saec.batch.annotations.Padding;
import com.bfds.saec.batch.annotations.Range;
import com.bfds.saec.batch.annotations.Ranges;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;

import javax.persistence.Column;

@RooJpaEntity(table="saec_batch_ss_stop_payment")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})

@Ranges({
	   @Range(property="fill(21)", value="60-80")
})
@Job(processor = DbToFlatFileJobBuilder.class)
public class SsStopPaymentRec  extends FileItem {

	private static final String TRANCODE = "22";
	private static final String BANK_NUMBER = "052";

	@Range("1-3")
	private String bankNumber;
	
	@Range("4-13")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    @Column(nullable = false)
	private String dda;

	@Range("14-15")
	private String tranCode;

	@Range("16-28")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 13)
	private String checkSerialNumber;

	@Range("29-43")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
	private Double amountOfCheck;

	@Range("44-51")
	@DateFormat("YYYYMMDD")
	private Date date;

	@Range("52-59")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 8)
	private String sequenceNumber;

	public SsStopPaymentRec() {
		tranCode = TRANCODE;
		bankNumber = BANK_NUMBER;
	}
	
	
}
