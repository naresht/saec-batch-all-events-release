package com.bfds.saec.batch.file.domain.in.ss_bottom_line;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
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
import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.job.FlatFileToDbJobBuilder;

/**
 * A DB Cashed Check flat file record.
 * 
 */
@RooJpaEntity(table = "saec_batch_ss_bottom_line_in")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })
@Ranges({ @Range(property = FileRecord.UNWANTED_TRAILER_HOLDER, value = "796-800") })
@Job(processor = FlatFileToDbJobBuilder.class)
public class SsBottomLineInRec extends FileItem {

	/**
	 * The DDA of the event to which this record belongs to.
	 */
	@Column(nullable = false)
	@Range(value = "3-19")
	private String dda;

	@Range("20-32")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 13)
	private String checkNumber;

	@Range("33-39")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 7)
	private String fundNumber;

	@Range("40")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 1)
	private String transactionType;

	@Range("41-51")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 11)
	private String accountNumber;

	@Range("52-58")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 7)
	private String dealerNumber;

	@Range("59-67")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = ' ', size = 9)
	private String dealerBranch;

	@Range("68-75")
	@DateFormat("MMDDYYYY")
	private Date checkIssueDate;

	@Range("76")
	private String checkTypeCode = "M";

	@Range("77")
	private String checkPayeeCode = "P";

	@Range("78-79")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = ' ', size = 2)
	private String stateCode;

	@Range("121-135")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private Double checkAmount;

	@Range("201-230")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 30)
	private String filler;

	@Range("281-315")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine1;

	@Range("361-395")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine2;

	@Range("441-475")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine3;

	@Range("521-555")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine4;

	@Range("601-635")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine5;

	@Range("681-715")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine6;

	@Range("761-795")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String registrationLine7;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result
				+ ((fundNumber == null) ? 0 : fundNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SsBottomLineInRec other = (SsBottomLineInRec) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (fundNumber == null) {
			if (other.fundNumber != null)
				return false;
		} else if (!fundNumber.equals(other.fundNumber))
			return false;
		return true;
	}

}
