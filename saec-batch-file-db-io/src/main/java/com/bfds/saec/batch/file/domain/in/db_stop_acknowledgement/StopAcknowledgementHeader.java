package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;

import com.bfds.saec.batch.annotations.DateFormat;
import com.bfds.saec.batch.annotations.Group;
import com.bfds.saec.batch.annotations.Range;
import com.bfds.saec.batch.annotations.Ranges;
import com.bfds.saec.batch.file.domain.FileRecord;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;

import javax.persistence.Column;

/**
 * A DB stop ack flat file record.
 *
 */
@RooJpaActiveRecord(table="saec_batch_stop_ack_header", persistenceUnit = "batchFilesEntityManagerFactory")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
@RooConfigurable

@Ranges({@Range(property= FileRecord.UNWANTED_TRAILER_HOLDER, value="30-80")})
@Group(StopAcknowledgementRec.class)
public class StopAcknowledgementHeader extends FileRecord {
    /**
     * Always H.
     * TODO: Get rid of this.
     */
    @Range("1")
    private Character recordType;

    @Range("2-9")
    @DateFormat("MMDDYYYY")
    private Date fileDate;

    @Range("10-17")
    private String userId;

    /**
     * Possible values
     * Successful
     * Unsuccessful
     * TODO: create enum
     */
    @Range("18-29")
    private String status;
    
    //(nullable=false)
    private String dda;
}
