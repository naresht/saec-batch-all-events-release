package com.bfds.saec.batch.file.domain.out.db_issue_void;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class DbIssueVoidRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(DbIssueVoidRecBuilder.n().voidIndicator("V").dda("DDA-1").checkNumber("1234591").issueDate(new Date(112, 05, 16)).checkAmount(30.50d).subAccount(null)
                .additionalData(null).payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(DbIssueVoidRecBuilder.n().voidIndicator("V").dda("DDA-1").checkNumber("1234561").issueDate(new Date(112, 05, 16)).checkAmount(1d).subAccount(null)
                .additionalData(null).payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(DbIssueVoidRecBuilder.n().dda("DDA-1").checkNumber("1234571").issueDate(new Date(112, 05, 16)).checkAmount(2d).subAccount(null)
                .additionalData(null).payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(DbIssueVoidRecBuilder.n().dda("DDA-2").checkNumber("1234570").issueDate(new Date(112, 05, 16)).checkAmount(2d).subAccount(null)
                .additionalData(null).payeeLine1("RegistrationName9").payeeLine2("RegistrationName8").get());
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static class DbIssueVoidRecBuilder {
        private DbIssueVoidRec ret = new DbIssueVoidRec();

        public static DbIssueVoidRecBuilder n() {
          return new DbIssueVoidRecBuilder();
        }

        public DbIssueVoidRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }

        public DbIssueVoidRecBuilder voidIndicator(String param) {
            ret.setVoidIndicator(param);
            return this;
        }

        public DbIssueVoidRecBuilder checkNumber(String param) {
            ret.setCheckNumber(param);
            return this;
        }

        public DbIssueVoidRecBuilder issueDate(Date param) {
            ret.setIssueDate(param);
            return this;
        }

        public DbIssueVoidRecBuilder checkAmount(Double param) {
            ret.setCheckAmount(param);
            return this;
        }

        public DbIssueVoidRecBuilder subAccount(String param) {
            ret.setSubAccount(param);
            return this;
        }

        public DbIssueVoidRecBuilder additionalData(String param) {
            ret.setAdditionalData(param);
            return this;
        }

        public DbIssueVoidRecBuilder payeeLine1(String param) {
            ret.setPayeeLine1(param);
            return this;
        }

        public DbIssueVoidRecBuilder payeeLine2(String param) {
            ret.setPayeeLine2(param);
            return this;
        }

        public DbIssueVoidRec get() {
            return ret;
        }
    }

}
