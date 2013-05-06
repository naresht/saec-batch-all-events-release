package com.bfds.saec.batch.file.domain.in.ss_cashed_check;

import com.bfds.saec.batch.job.FlatFileToDbJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.FileRecord;
import org.hibernate.annotations.*;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Parameter;
import javax.persistence.Table;
import java.util.Date;

/**
 * A DB Cashed Check flat file record.
 *
 */
@RooJpaEntity(table = "saec_batch_ss_cashed_check")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
// TODO: Define composite candidate key with dda and checkNumber

@Ranges({@Range(property= FileRecord.UNWANTED_TRAILER_HOLDER, value = "99-200")})
@Job(processor = FlatFileToDbJobBuilder.class)
public class SsCashedCheckRec extends FileItem {

    /**
     * The DDA of the event to which this record belongs to.
     */
    @Column(nullable = false)
    @Range(value = "1-10")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    private String dda;

    @Range("11-20")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    private String checkNumber;

    @Range("21-30")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double checkAmount;

    @Range("31-38")
    @DateFormat("YYYYMMDD")
    private Date transactionDate;

    @Range("39-53")
    private String additionalData1;

    @Range("54-98")
    private String additionalData2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsCashedCheckRec that = (SsCashedCheckRec) o;

        if (checkNumber != null ? !checkNumber.equals(that.checkNumber) : that.checkNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return checkNumber != null ? checkNumber.hashCode() : 0;
    }
}
