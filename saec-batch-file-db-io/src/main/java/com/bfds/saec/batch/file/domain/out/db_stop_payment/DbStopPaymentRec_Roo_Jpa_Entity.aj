// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.db_stop_payment;

import com.bfds.saec.batch.file.domain.out.db_stop_payment.DbStopPaymentRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect DbStopPaymentRec_Roo_Jpa_Entity {
    
    declare @type: DbStopPaymentRec: @Entity;
    
    declare @type: DbStopPaymentRec: @Table(name = "saec_batch_db_stop_payment");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long DbStopPaymentRec.id;
    
    @Version
    @Column(name = "version")
    private Integer DbStopPaymentRec.version;
    
    public Long DbStopPaymentRec.getId() {
        return this.id;
    }
    
    public void DbStopPaymentRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer DbStopPaymentRec.getVersion() {
        return this.version;
    }
    
    public void DbStopPaymentRec.setVersion(Integer version) {
        this.version = version;
    }
    
}
