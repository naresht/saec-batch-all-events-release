/**
 * 
 */
package com.bfds.saec.batch.file.domain.out.ifds_issue_void;

import java.util.Date;


import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.util.StringUtils;

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

/**
 * @author dt83019
 * 
 */
@RooJpaEntity(table = "saec_batch_ifds_issue_void")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })

@Ranges({@Range(property = "fill(1)", value = "1"),
    @Range(property = "fill(5)", value = "12-16"),
    @Range(property = "fill(15)", value = "44-58"),
    @Range(property = "fill(7)", value = "74-80")
     })
@Job(processor = DbToFlatFileJobBuilder.class)
public class IfdsIssueVoidRec extends FileItem {
	
	@Range("2-3")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String flag;

	@Range("4-11")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 8)
    @Column(nullable = false)
	private String dda;

	@Range("17-26")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
	private String checkNumber;

	@Range("27-32")
    @DateFormat("MMDDYY")
	private Date issuedate;

	@Range("33-43")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 11)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
	private Double amount;

	@Range("59-73")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = ' ', size = 15)
	private String offsetchecknumber;

	@Range("81-140")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 60)
	private String payeeline1;

	@Range("141-200")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 60)
	private String payeeline2;
	
	
	  /*
	   * Verifying the void codes, flag should be space or one of the void codes.If it is a void code then will will place "V" in the 
	   * file layout,if it is not a void code we are throwing an exception.
	   */
    public String getFlag() {
    	if(StringUtils.hasText(this.flag) && this.flag.length()>=2)
    	{		
    		if(this.flag.equals("VR")){
    			return "V";
    		}
    			return this.flag.substring(0, 2);
    	}
    	else if(StringUtils.hasText(this.flag) && this.flag.length()<2)
    	{
    			return this.flag.substring(0, 1);
    	}
    	else 
    			return this.flag;
    }
    
}
