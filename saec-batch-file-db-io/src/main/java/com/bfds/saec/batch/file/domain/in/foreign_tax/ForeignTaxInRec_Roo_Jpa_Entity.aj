// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.foreign_tax;

import com.bfds.saec.batch.file.domain.in.foreign_tax.ForeignTaxInRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect ForeignTaxInRec_Roo_Jpa_Entity {
    
    declare @type: ForeignTaxInRec: @Entity;
    
    declare @type: ForeignTaxInRec: @Table(name = "saec_batch_foreign_tax_in");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ForeignTaxInRec.id;
    
    @Version
    @Column(name = "version")
    private Integer ForeignTaxInRec.version;
    
    public Long ForeignTaxInRec.getId() {
        return this.id;
    }
    
    public void ForeignTaxInRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer ForeignTaxInRec.getVersion() {
        return this.version;
    }
    
    public void ForeignTaxInRec.setVersion(Integer version) {
        this.version = version;
    }
    
}
