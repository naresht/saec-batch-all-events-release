// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.out.db_issue_void;

import com.bfds.saec.batch.file.domain.out.db_issue_void.DbIssueVoidRec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect DbIssueVoidRec_Roo_Jpa_Entity {
    
    declare @type: DbIssueVoidRec: @Entity;
    
    declare @type: DbIssueVoidRec: @Table(name = "saec_batch_db_issue_void");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long DbIssueVoidRec.id;
    
    @Version
    @Column(name = "version")
    private Integer DbIssueVoidRec.version;
    
    public Long DbIssueVoidRec.getId() {
        return this.id;
    }
    
    public void DbIssueVoidRec.setId(Long id) {
        this.id = id;
    }
    
    public Integer DbIssueVoidRec.getVersion() {
        return this.version;
    }
    
    public void DbIssueVoidRec.setVersion(Integer version) {
        this.version = version;
    }
    
}
