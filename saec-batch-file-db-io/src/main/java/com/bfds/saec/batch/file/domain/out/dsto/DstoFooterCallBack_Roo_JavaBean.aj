// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.dsto;

import com.bfds.saec.batch.file.domain.out.dsto.DstoFooterCallBack;
import org.springframework.batch.core.StepExecution;

privileged aspect DstoFooterCallBack_Roo_JavaBean {
    
    public StepExecution DstoFooterCallBack.getStepExecution() {
        return this.stepExecution;
    }
    
    public void DstoFooterCallBack.setStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }
    
    public String DstoFooterCallBack.getRecordType() {
        return this.recordType;
    }
    
    public void DstoFooterCallBack.setRecordType(String recordType) {
        this.recordType = recordType;
    }
    
    public String DstoFooterCallBack.getFiller() {
        return this.filler;
    }
    
    public void DstoFooterCallBack.setFiller(String filler) {
        this.filler = filler;
    }
    
}