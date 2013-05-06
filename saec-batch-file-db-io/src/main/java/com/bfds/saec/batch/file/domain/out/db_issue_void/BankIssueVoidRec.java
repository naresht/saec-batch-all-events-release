package com.bfds.saec.batch.file.domain.out.db_issue_void;

import com.bfds.saec.batch.annotations.*;
import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;
import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.util.Date;

/**
 * Interfaces to be implemented by all Bank Issue/Void file records.
 * @see DbIssueVoidRec
 * @see com.bfds.saec.batch.file.domain.out.ss_issue_void.SsIssueVoidRec
 */
public interface BankIssueVoidRec  {

    public void setVoidIndicator(String voidIndicator);

    public void setDda(String dda);

    public void setCheckNumber(String checkNumber);

    public void setIssueDate(Date issueDate);

    public void setCheckAmount(Double checkAmount);

    public void setSubAccount(String subAccount);

    public void setAdditionalData(String additionalData);

    public void setPayeeLine1(String payeeLine1);

    public void setPayeeLine2(String payeeLine2);
}
