package com.bfds.saec.batch.file.domain.out.db_stop_payment;


import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;

import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;

@RooJpaEntity(table="saec_batch_db_stop_payment")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})

@Job(processor = DbToFlatFileJobBuilder.class)
public class DbStopPaymentRec  extends FileItem {

    private String recordType = "D";

    private String activityType = "A";

    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 14)
    @Column(nullable = false)
    private String dda;

    //TDOD: padding ?
    private String accountNumber;

    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
    private String serialNumber;

    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
    private String toSerialNumber;

    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 13)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double stopAmount;

    @DateFormat("MMDDYY")
    private Date issueDate;

    @PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 15)
    private String payee;
}
