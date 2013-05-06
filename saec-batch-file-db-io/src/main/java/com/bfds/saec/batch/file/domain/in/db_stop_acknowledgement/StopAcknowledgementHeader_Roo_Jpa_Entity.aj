// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;

import com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement.StopAcknowledgementHeader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect StopAcknowledgementHeader_Roo_Jpa_Entity {
    
    declare @type: StopAcknowledgementHeader: @Entity;
    
    declare @type: StopAcknowledgementHeader: @Table(name = "saec_batch_stop_ack_header");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long StopAcknowledgementHeader.id;
    
    @Version
    @Column(name = "version")
    private Integer StopAcknowledgementHeader.version;
    
    public Long StopAcknowledgementHeader.getId() {
        return this.id;
    }
    
    public void StopAcknowledgementHeader.setId(Long id) {
        this.id = id;
    }
    
    public Integer StopAcknowledgementHeader.getVersion() {
        return this.version;
    }
    
    public void StopAcknowledgementHeader.setVersion(Integer version) {
        this.version = version;
    }
    
}
