// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.ss_bottom_line;

import com.bfds.saec.batch.file.domain.in.ss_bottom_line.SsBottomLineInRecJobNotificationVo;
import java.math.BigDecimal;
import java.util.Date;

privileged aspect SsBottomLineInRecJobNotificationVo_Roo_JavaBean {
    
    public String SsBottomLineInRecJobNotificationVo.getDda() {
        return this.dda;
    }
    
    public void SsBottomLineInRecJobNotificationVo.setDda(String dda) {
        this.dda = dda;
    }
    
    public Date SsBottomLineInRecJobNotificationVo.getFileDate() {
        return this.fileDate;
    }
    
    public void SsBottomLineInRecJobNotificationVo.setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }
    
    public BigDecimal SsBottomLineInRecJobNotificationVo.getAccountTotalAmount() {
        return this.accountTotalAmount;
    }
    
    public void SsBottomLineInRecJobNotificationVo.setAccountTotalAmount(BigDecimal accountTotalAmount) {
        this.accountTotalAmount = accountTotalAmount;
    }
    
    public int SsBottomLineInRecJobNotificationVo.getAccountTotalItems() {
        return this.accountTotalItems;
    }
    
    public void SsBottomLineInRecJobNotificationVo.setAccountTotalItems(int accountTotalItems) {
        this.accountTotalItems = accountTotalItems;
    }
    
}
