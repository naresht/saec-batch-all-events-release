package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;

import com.bfds.saec.batch.job.FlatFileToDbJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.FileRecord;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;

/**
 * A DB stop ack flat file record.
 *
 */
@RooJpaActiveRecord(table="saec_batch_stop_ack", persistenceUnit = "batchFilesEntityManagerFactory")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
@RooConfigurable
@Ranges({@Range(property= FileRecord.UNWANTED_TRAILER_HOLDER, value="37-80")})
@Job(processor = FlatFileToDbJobBuilder.class)
public class StopAcknowledgementRec extends FileItem {

    /**
     * D - For record
     * T - For trailer
     *
     */
    @Range("1")
    private Character recordType;

    @Range("2-6")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 5)
    @Column(name = "record_count") // count is an sql keyword
    private Integer count;

    @Range("7-24")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 18)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double amountCalculated;

    /**
     * Possible values
     * if recordType = D then 'DETAIL RECAP'
     * if recordType = T then 'Trailer'
     */
    @Range("25-36")
    private String recordId;
    
    //@Column(nullable=false)
    private String dda;

}
