// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.ss_cashed_check;

import com.bfds.saec.batch.file.domain.in.ss_cashed_check.SsCashedCheckRec;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

privileged aspect SsCashedCheckRec_Roo_ToString {
    
    public String SsCashedCheckRec.toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("id", "version").toString();
    }
    
}
