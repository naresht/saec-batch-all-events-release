// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.ss_cashed_check;

import com.bfds.saec.batch.file.domain.in.ss_cashed_check.SsCashedCheckRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect SsCashedCheckRec_Roo_Jpa_Entity {
    
    declare @type: SsCashedCheckRec: @Entity;
    
    declare @type: SsCashedCheckRec: @Table(name = "saec_batch_ss_cashed_check");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long SsCashedCheckRec.id;
    
    @Version
    @Column(name = "version")
    private Integer SsCashedCheckRec.version;
    
    public Long SsCashedCheckRec.getId() {
        return this.id;
    }
    
    public void SsCashedCheckRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer SsCashedCheckRec.getVersion() {
        return this.version;
    }
    
    public void SsCashedCheckRec.setVersion(Integer version) {
        this.version = version;
    }
    
}
