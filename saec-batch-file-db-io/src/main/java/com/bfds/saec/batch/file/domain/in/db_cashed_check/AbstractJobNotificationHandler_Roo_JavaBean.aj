// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.db_cashed_check;

import com.bfds.saec.batch.file.domain.in.db_cashed_check.AbstractJobNotificationHandler;
import com.bfds.saec.util.IMailSender;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;

privileged aspect AbstractJobNotificationHandler_Roo_JavaBean {
    
    public IMailSender AbstractJobNotificationHandler.getMailSender() {
        return this.mailSender;
    }
    
    public VelocityEngine AbstractJobNotificationHandler.getVelocityEngine() {
        return this.velocityEngine;
    }
    
    public Logger AbstractJobNotificationHandler.getLog() {
        return this.log;
    }
    
}
