package com.bfds.saec.batch.file.domain.in.ss_bottom_line;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class SsBottomLineInRecJobNotificationVo {

    private String dda;
    private Date fileDate;
    private BigDecimal accountTotalAmount = new BigDecimal(0.0);
    private int accountTotalItems;
}
