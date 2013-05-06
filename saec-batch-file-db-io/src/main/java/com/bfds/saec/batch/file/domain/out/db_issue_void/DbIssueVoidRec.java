package com.bfds.saec.batch.file.domain.out.db_issue_void;

import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;
import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.file.domain.FileItem;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;

@RooJpaEntity(table="saec_batch_db_issue_void")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
@Ranges({@Range(property = "fill(1)", value = "1"),
        @Range(property = "fill(1)", value = "3"),
        @Range(property = "fill(5)", value = "12-16"),
        @Range(property = "fill(2)", value = "57-58"),
        @Range(property = "fill(7)", value = "74-80")
         })
@Job(processor = DbToFlatFileJobBuilder.class)
public class DbIssueVoidRec extends FileItem implements BankIssueVoidRec {

    @Range("2-2")
    @PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
    private String voidIndicator;

    @Range("4-11")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 8)
    @Column(nullable = false)
    private String dda;

    @Range("17-26")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 10)
    private String checkNumber;

    @Range("27-32")
    @DateFormat("MMDDYY")
    private Date issueDate;

    @Range("33-43")
    @PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 11)
    @AssumedDecimalNumberFormat(decimalPlaces = 2)
    private Double checkAmount;

    @Range("44-56")
    @PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 13)
    private String subAccount;

    @Range("59-73")
    @PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 15)
    private String additionalData;

    @Range("81-140")
    @PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 60)
    private String payeeLine1;

    @Range("141-200")
    @PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 60)
    private String payeeLine2;
}
