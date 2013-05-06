package com.bfds.saec.batch.file.domain.out.db_stop_payment;


import com.bfds.saec.batch.file.domain.VendorConfig;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class DbStopPaymentRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {
        DbStopPaymentRecDataGenerator.createVendorProperties();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(DbStopPaymentRecBuilder.n().dda("DDA-1").serialNumber("000000001234567").stopAmount(10.23).issueDate(new Date(112, 05, 15)).payee("RegistrationNam").get());
        entityManager.persist(DbStopPaymentRecBuilder.n().dda("DDA-1").serialNumber("000000000123456").stopAmount(100.26).issueDate(new Date(112, 05, 15)).payee("RegistrationNam").get());
        entityManager.persist(DbStopPaymentRecBuilder.n().dda("DDA-1").serialNumber("000000000012345").stopAmount(1050d).issueDate(new Date(112, 05, 15)).payee("RegistrationNam1111").get());

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void createVendorProperties() {
        VendorConfig p =   new VendorConfig();
        p.setDeutscheBankUserId("USER-123");
        p.persist();
        p.flush();
        p.clear();
    }


    public static class DbStopPaymentRecBuilder {
        private DbStopPaymentRec ret = new DbStopPaymentRec();

        public static DbStopPaymentRecBuilder n() {
          return new DbStopPaymentRecBuilder();
        }

        public DbStopPaymentRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }

        public DbStopPaymentRecBuilder serialNumber(String param) {
            ret.setSerialNumber(param);
            ret.setToSerialNumber(param);
            return this;
        }

        public DbStopPaymentRecBuilder stopAmount(Double param) {
            ret.setStopAmount(param);
            return this;
        }

        public DbStopPaymentRecBuilder issueDate(Date param) {
            ret.setIssueDate(param);
            return this;
        }

        public DbStopPaymentRecBuilder payee(String param) {
            ret.setPayee(param);
            return this;
        }

        public DbStopPaymentRec get() {
            return ret;
        }
    }

}
