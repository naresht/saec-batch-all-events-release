// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.damasco_foreign;

import com.bfds.saec.batch.file.domain.out.damasco_foreign.ForeignTaxOutRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect ForeignTaxOutRec_Roo_Jpa_Entity {
    
    declare @type: ForeignTaxOutRec: @Entity;
    
    declare @type: ForeignTaxOutRec: @Table(name = "saec_batch_foreign_tax_out");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ForeignTaxOutRec.id;
    
    @Version
    @Column(name = "version")
    private Integer ForeignTaxOutRec.version;
    
    public Long ForeignTaxOutRec.getId() {
        return this.id;
    }
    
    public void ForeignTaxOutRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer ForeignTaxOutRec.getVersion() {
        return this.version;
    }
    
    public void ForeignTaxOutRec.setVersion(Integer version) {
        this.version = version;
    }
    
}
