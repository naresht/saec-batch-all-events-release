package com.bfds.saec.batch.file.domain.out.ss_issue_void;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class SsIssueVoidRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(SsIssueVoidRecBuilder.n().dda("DDA-1").checkNumber("12346").checkAmount(3.05).issueDate(new Date(112, 5, 25))
                .additionalData("RegistrationName1RegistrationName2RegistrationName3RegistrationName4").voidIndicator("V").get());

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
   
    }

    public static class SsIssueVoidRecBuilder {
        private SsIssueVoidRec ret = new SsIssueVoidRec();

        public static SsIssueVoidRecBuilder n() {
          return new SsIssueVoidRecBuilder();
        }

        public SsIssueVoidRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }


        public SsIssueVoidRecBuilder checkNumber(String param) {
            ret.setCheckNumber(param);
            return this;
        }

        public SsIssueVoidRecBuilder issueDate(Date param) {
            ret.setIssueDate(param);
            return this;
        }

        public SsIssueVoidRecBuilder checkAmount(Double param) {
            ret.setCheckAmount(param);
            return this;
        }


        public SsIssueVoidRecBuilder additionalData(String param) {
            ret.setAdditionalData(param);
            return this;
        }
        public SsIssueVoidRecBuilder voidIndicator(String param) {
            ret.setVoidIndicator(param);
            return this;
        }

        public SsIssueVoidRec get() {
            return ret;
        }
    }

}
