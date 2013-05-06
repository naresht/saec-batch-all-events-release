package com.bfds.saec.batch.file.domain.in.db_cashed_check;

import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.job.FlatFileToDbJobBuilder;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;

/**
 * A DB Cashed Check flat file record.
 * This class is used for both the data and trailer.
 */
@RooJpaEntity(table="saec_batch_cashed_check")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
// TODO: Define composite candidate key with dda and checkNumber

@Ranges({@Range(property= FileRecord.UNWANTED_TRAILER_HOLDER, value = "57-80")})
@Job(processor = FlatFileToDbJobBuilder.class)
public class CashedCheckRec extends FileItem {

    /**
     * The DDA of the event to which this record belongs to.
     */
    @Column(nullable = false)
    @Range(value = "1-8")
    private String dda;

    @Range("22-31")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    private String checkNumber;

    /**
     *   The value of the check
     */
    @Range("32-42")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 11)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double checkAmount;

    /**
     *   The date the check was cashed.
     */
    @Range("43-48")
    @DateFormat("YYMMDD")
    private Date date;

    @Range("49-56")
    private String itemSeqNumber;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CashedCheckRec that = (CashedCheckRec) o;

        if (checkNumber != null ? !checkNumber.equals(that.checkNumber) : that.checkNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return checkNumber != null ? checkNumber.hashCode() : 0;
    }
}
