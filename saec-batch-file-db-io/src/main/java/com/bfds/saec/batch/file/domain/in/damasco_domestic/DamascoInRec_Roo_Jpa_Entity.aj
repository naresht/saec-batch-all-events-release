// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.damasco_domestic;

import com.bfds.saec.batch.file.domain.in.damasco_domestic.DamascoInRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect DamascoInRec_Roo_Jpa_Entity {
    
    declare @type: DamascoInRec: @Entity;
    
    declare @type: DamascoInRec: @Table(name = "saec_batch_damasco");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long DamascoInRec.id;
    
    @Version
    @Column(name = "version")
    private Integer DamascoInRec.version;
    
    public Long DamascoInRec.getId() {
        return this.id;
    }
    
    public void DamascoInRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer DamascoInRec.getVersion() {
        return this.version;
    }
    
    public void DamascoInRec.setVersion(Integer version) {
        this.version = version;
    }
    
}