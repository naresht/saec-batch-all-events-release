// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import com.bfds.saec.batch.file.domain.out.db_stop_payment.DbStopPaymentRec;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

privileged aspect DbStopPaymentRec_Roo_ToString {
    
    public String DbStopPaymentRec.toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("id", "version").toString();
    }
    
}
