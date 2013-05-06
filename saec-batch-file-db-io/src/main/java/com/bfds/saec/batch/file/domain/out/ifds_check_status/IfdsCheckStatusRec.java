package com.bfds.saec.batch.file.domain.out.ifds_check_status;

import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;

import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;

@RooJpaEntity(table="saec_batch_ifds_check_status")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})

@Job(processor = DbToFlatFileJobBuilder.class)
public class IfdsCheckStatusRec extends FileItem {

    @Range("1-10")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    private String bankRouting;

    @Range("11-20")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    @Column(nullable = false)
    private String dda;

    @Range("21-28")
    @DateFormat("MMDDYYYY")
    private Date statusChangeDate;

    @Range("29-39")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 11)
    //TODO: truncate also.
    private String accountNumber;

    @Range("40-48")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 9)
    //TODO: truncate also.
    private String checkNumber;

    @Range("49-63")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double netAmount;

    @Range("64-66")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = ' ', size = 3)
    private String checkStatus;

    @Range("67-68")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = ' ', size = 2)
    private String wireStatus;
}
