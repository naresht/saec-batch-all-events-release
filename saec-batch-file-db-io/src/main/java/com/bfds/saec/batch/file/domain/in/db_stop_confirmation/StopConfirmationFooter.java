package com.bfds.saec.batch.file.domain.in.db_stop_confirmation;

import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileRecord;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;

/**
 * A DB stop confirmation flat file summary.
 *
 */
@RooJpaEntity(table="saec_batch_stop_confirmation_summary")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})

@Ranges({@Range(property= FileRecord.UNWANTED_TRAILER_HOLDER, value = "25-80")})
@Group(StopConfirmationRec.class)
public class StopConfirmationFooter extends FileRecord {

    /**
     * The total record count of the file. This is a filed in the file trailer record.
     */
    @Column(nullable = false)
    @Range("2-6")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 5)
    private Integer recordCount;

    /**
     * The total $ value for all records in the file. This is a filed in the file trailer record.
     */
    @Column(nullable = false)
    @Range("7-24")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 18)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double totalAmount;
    
    //@Column(nullable=false)
    private String dda;

}
