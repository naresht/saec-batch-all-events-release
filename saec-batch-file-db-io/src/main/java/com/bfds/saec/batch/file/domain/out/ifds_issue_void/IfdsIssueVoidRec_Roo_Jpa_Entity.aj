// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.ifds_issue_void;

import com.bfds.saec.batch.file.domain.out.ifds_issue_void.IfdsIssueVoidRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect IfdsIssueVoidRec_Roo_Jpa_Entity {
    
    declare @type: IfdsIssueVoidRec: @Entity;
    
    declare @type: IfdsIssueVoidRec: @Table(name = "saec_batch_ifds_issue_void");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long IfdsIssueVoidRec.id;
    
    @Version
    @Column(name = "version")
    private Integer IfdsIssueVoidRec.version;
    
    public Long IfdsIssueVoidRec.getId() {
        return this.id;
    }
    
    public void IfdsIssueVoidRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer IfdsIssueVoidRec.getVersion() {
        return this.version;
    }
    
    public void IfdsIssueVoidRec.setVersion(Integer version) {
        this.version = version;
    }
    
}