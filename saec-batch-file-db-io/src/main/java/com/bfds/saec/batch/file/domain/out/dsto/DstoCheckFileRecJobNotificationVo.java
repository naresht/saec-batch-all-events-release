package com.bfds.saec.batch.file.domain.out.dsto;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
public class DstoCheckFileRecJobNotificationVo {

    private String fileType;
    private Date fileDate;
    private BigDecimal accountTotalAmount = new BigDecimal(0.0);
    private int accountTotalItems;
}
