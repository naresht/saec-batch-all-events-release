// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import com.bfds.saec.batch.file.domain.out.damasco_domestic.OutboundDomesticTaxRec;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

privileged aspect OutboundDomesticTaxRec_Roo_ToString {
    
    public String OutboundDomesticTaxRec.toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("id", "version").toString();
    }
    
}
