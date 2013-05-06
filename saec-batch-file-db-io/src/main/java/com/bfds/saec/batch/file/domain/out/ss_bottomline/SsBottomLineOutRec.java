package com.bfds.saec.batch.file.domain.out.ss_bottomline;

import java.util.Date;

import javax.persistence.Column;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
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

@RooJpaEntity(table = "saec_batch_ss_bottom_line_out")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })
@Ranges({ @Range(property = "fill(106)", value = "288-393"),
		  @Range(property = "fill(13)", value = "414-426")})

@Job(processor = DbToFlatFileJobBuilder.class)
public class SsBottomLineOutRec extends FileItem {

	private String dda;
	
	@Range("1-7")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 7)
	private String fundCode;

	@Range("8-18")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 11)
	private String accountNumber;
	
	@Range("19")
	private String checkType = "M";

	@Range("20-34")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private Double checkAmount;

	@Range("35-42")
	@DateFormat("YYYYMMDD")
	private Date payableDate;

	@Range("43-77")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration1;

	@Range("78-112")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration2;

	@Range("113-147")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration3;

	@Range("148-182")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration4;

	@Range("183-217")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration5;

	@Range("218-252")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration6;

	@Range("253-287")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registration7;
	
	@Range("394-396")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 3)
	private String system;
	
	@Range("397-413")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 17)
	private String offsettingDda;

	@Range("427-464")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 38)
	private String checkName;	
	
}
