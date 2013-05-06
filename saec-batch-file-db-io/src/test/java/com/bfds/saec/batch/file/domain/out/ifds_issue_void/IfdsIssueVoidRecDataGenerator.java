package com.bfds.saec.batch.file.domain.out.ifds_issue_void;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class IfdsIssueVoidRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag("V").dda("DDA-1").checkNumber("777777").issueDate(new Date(112, 03, 25)).amount(1.2d).offsetchecknumber("000000000000000")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag(" ").dda("DDA-1").checkNumber("12345").issueDate(new Date(112, 03, 25)).amount(1.0d).offsetchecknumber("000000000000000")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag(" ").dda("DDA-1").checkNumber("66666666").issueDate(new Date(112, 03, 25)).amount(1.2d).offsetchecknumber("000000000000000")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag(" ").dda("DDA-1").checkNumber("12346").issueDate(new Date(112, 03, 25)).amount(1.43d).offsetchecknumber("000000000012347")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag("V").dda("DDA-1").checkNumber("55555555").issueDate(new Date(112, 03, 25)).amount(1.0d).offsetchecknumber("000000000000000")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag("VR").dda("DDA-1").checkNumber("12348").issueDate(new Date(112, 03, 25)).amount(1.0d).offsetchecknumber("000000000000000")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());
        entityManager.persist(IfdsIssueVoidRecBuilder.n().flag("VDA").dda("DDA-1").checkNumber("12349").issueDate(new Date(112, 03, 25)).amount(1.0d).offsetchecknumber("000000000000000")
                .payeeLine1("RegistrationName1").payeeLine2("RegistrationName2").get());

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static class IfdsIssueVoidRecBuilder {
        private IfdsIssueVoidRec ret = new IfdsIssueVoidRec();

        public static IfdsIssueVoidRecBuilder n() {
          return new IfdsIssueVoidRecBuilder();
        }

        public IfdsIssueVoidRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }

        public IfdsIssueVoidRecBuilder flag(String param) {
            ret.setFlag(param);
            return this;
        }

        public IfdsIssueVoidRecBuilder checkNumber(String param) {
            ret.setCheckNumber(param);
            return this;
        }

        public IfdsIssueVoidRecBuilder issueDate(Date param) {
            ret.setIssuedate(param);
            return this;
        }

        public IfdsIssueVoidRecBuilder amount(Double param) {
            ret.setAmount(param);
            return this;
        }
        
        public IfdsIssueVoidRecBuilder offsetchecknumber(String param) {
            ret.setOffsetchecknumber(param);
            return this;
        }
        
        public IfdsIssueVoidRecBuilder payeeLine1(String param) {
            ret.setPayeeline1(param);
            return this;
        }

        public IfdsIssueVoidRecBuilder payeeLine2(String param) {
            ret.setPayeeline2(param);
            return this;
        }

        public IfdsIssueVoidRec get() {
            return ret;
        }

      
    }

}
