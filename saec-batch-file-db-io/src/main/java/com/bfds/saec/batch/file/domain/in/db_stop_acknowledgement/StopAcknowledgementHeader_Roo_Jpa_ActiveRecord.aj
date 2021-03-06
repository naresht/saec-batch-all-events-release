// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;

import com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement.StopAcknowledgementHeader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect StopAcknowledgementHeader_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext(unitName = "batchFilesEntityManagerFactory")
    transient EntityManager StopAcknowledgementHeader.entityManager;
    
    public static final EntityManager StopAcknowledgementHeader.entityManager() {
        EntityManager em = new StopAcknowledgementHeader().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long StopAcknowledgementHeader.countStopAcknowledgementHeaders() {
        return entityManager().createQuery("SELECT COUNT(o) FROM StopAcknowledgementHeader o", Long.class).getSingleResult();
    }
    
    public static List<StopAcknowledgementHeader> StopAcknowledgementHeader.findAllStopAcknowledgementHeaders() {
        return entityManager().createQuery("SELECT o FROM StopAcknowledgementHeader o", StopAcknowledgementHeader.class).getResultList();
    }
    
    public static StopAcknowledgementHeader StopAcknowledgementHeader.findStopAcknowledgementHeader(Long id) {
        if (id == null) return null;
        return entityManager().find(StopAcknowledgementHeader.class, id);
    }
    
    public static List<StopAcknowledgementHeader> StopAcknowledgementHeader.findStopAcknowledgementHeaderEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM StopAcknowledgementHeader o", StopAcknowledgementHeader.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void StopAcknowledgementHeader.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void StopAcknowledgementHeader.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            StopAcknowledgementHeader attached = StopAcknowledgementHeader.findStopAcknowledgementHeader(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void StopAcknowledgementHeader.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void StopAcknowledgementHeader.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public StopAcknowledgementHeader StopAcknowledgementHeader.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        StopAcknowledgementHeader merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
