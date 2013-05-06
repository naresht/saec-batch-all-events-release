package com.bfds.saec.batch.file.domain.in.db_stop_confirmation;

import com.bfds.saec.batch.job.FlatFileToDbJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.FileRecord;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;


/**
 * A DB stop confirmation flat file record.
 *
 */
@RooJpaEntity(table="saec_batch_stop_confirmation")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
// TODO: Define composite candidate key with dda and checkNumber
@Ranges({@Range(property= FileRecord.UNWANTED_TRAILER_HOLDER, value = "25-80")})
@Job(processor = FlatFileToDbJobBuilder.class)
public class StopConfirmationRec extends FileItem {

	private static final long serialVersionUID = 1L;
    /**
     * Possible values are
     * C - Header record
     * D - Detail record
     * T - Trailer record
     * @deprecated - TODO: Will create separate FileItem for header and footer.
     */
    @Range("1")
	private Character recordType;

    /**
     * The DDA of the event to which this record belongs to.
     */
    @Column(nullable = false)
    @Range(value = "2-11")
    @PaddedStringFormat(padding = Padding.LPAD.LPAD, paddingChar = '0', size = 10)
    private String dda;


    @Range("12-22")
    @PaddedStringFormat(padding = Padding.LPAD.LPAD, paddingChar = '0', size = 11)
	private String checkNumber;

    /**
     * The date the Check was stopped by bank.
     */
    @Range("23-30")
    @DateFormat("YYYYMMDD")
	private Date effectiveDate;

    /**
     * Possible values
     * M - Manual
     * S - Systematic
     *
     * TODO: Convert to Enum
     */
    @Range("31")
	private Character checkType;

    @Range("32-44")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 13)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
	private Double stopAmount;
    /**
     * Possible values
     * blank string - Stop confirmed
     * Numeric value > 0 - Stop reject
     * TODO: What if value is zero
     */
    @Range("45-47")
	private String rejectCode;
    /**
     * Possible values
     * S - Stop
     * R - Reversal
     *
     * TODO: Convert to Enum
     */
    @Range("48")
	private Character tranType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StopConfirmationRec that = (StopConfirmationRec) o;

        if (checkNumber != null ? !checkNumber.equals(that.checkNumber) : that.checkNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return checkNumber != null ? checkNumber.hashCode() : 0;
    }
}
