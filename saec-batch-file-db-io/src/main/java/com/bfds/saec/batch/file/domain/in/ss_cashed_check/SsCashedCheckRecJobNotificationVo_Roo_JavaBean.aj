// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.ss_cashed_check;

import com.bfds.saec.batch.file.domain.in.ss_cashed_check.SsCashedCheckRecJobNotificationVo;
import java.math.BigDecimal;
import java.util.Date;

privileged aspect SsCashedCheckRecJobNotificationVo_Roo_JavaBean {
    
    public String SsCashedCheckRecJobNotificationVo.getDda() {
        return this.dda;
    }
    
    public void SsCashedCheckRecJobNotificationVo.setDda(String dda) {
        this.dda = dda;
    }
    
    public Date SsCashedCheckRecJobNotificationVo.getFileDate() {
        return this.fileDate;
    }
    
    public void SsCashedCheckRecJobNotificationVo.setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }
    
    public BigDecimal SsCashedCheckRecJobNotificationVo.getAccountTotalAmount() {
        return this.accountTotalAmount;
    }
    
    public void SsCashedCheckRecJobNotificationVo.setAccountTotalAmount(BigDecimal accountTotalAmount) {
        this.accountTotalAmount = accountTotalAmount;
    }
    
    public int SsCashedCheckRecJobNotificationVo.getAccountTotalItems() {
        return this.accountTotalItems;
    }
    
    public void SsCashedCheckRecJobNotificationVo.setAccountTotalItems(int accountTotalItems) {
        this.accountTotalItems = accountTotalItems;
    }
    
}