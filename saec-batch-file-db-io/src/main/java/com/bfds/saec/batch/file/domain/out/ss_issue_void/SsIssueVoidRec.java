package com.bfds.saec.batch.file.domain.out.ss_issue_void;

import com.bfds.saec.batch.file.domain.out.db_issue_void.BankIssueVoidRec;
import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;

import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;

@RooJpaEntity(table="saec_batch_ss_issue_void")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})

@Job(processor = DbToFlatFileJobBuilder.class)
public class SsIssueVoidRec extends FileItem implements BankIssueVoidRec {

	@Range("1-10")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    @Column(nullable = false)
	private String dda;

	@Range("11-20")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
	private String checkNumber;
	
	
	@Range("21-30")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private Double checkAmount;
	//20120625    
	@Range("31-38")
	@DateFormat("YYYYMMDD")
	private Date issueDate;

	@Range("39-199")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 161)
	private String additionalData;
	    
	@Range("200")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String voidIndicator;

    public void setSubAccount(String subAccount) {
       // no op
    }


    public void setPayeeLine1(String payeeLine1) {
        // no op
    }


    public void setPayeeLine2(String payeeLine2) {
       // no op
    }
}
