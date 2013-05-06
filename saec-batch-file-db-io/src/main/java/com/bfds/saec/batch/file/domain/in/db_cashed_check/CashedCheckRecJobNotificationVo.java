package com.bfds.saec.batch.file.domain.in.db_cashed_check;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
public class CashedCheckRecJobNotificationVo {

    private String dda;
    private Date paidDate;
    private BigDecimal accountTotalAmount = new BigDecimal(0.0);
    private int accountTotalItems;
}
