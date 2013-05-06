package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
public class StopAcknowledgementRecJobNotificationVo {

    private String dda;
    private Date fileDate;
    private BigDecimal accountTotalAmount = new BigDecimal(0.0);
    private int accountTotalItems;
    private String status;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
