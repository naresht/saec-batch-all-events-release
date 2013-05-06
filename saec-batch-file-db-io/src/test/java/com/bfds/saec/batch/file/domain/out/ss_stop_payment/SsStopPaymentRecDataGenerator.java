package com.bfds.saec.batch.file.domain.out.ss_stop_payment;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class SsStopPaymentRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(SsStopPaymentRecBuilder.n().bankNumber("052").dda("DDA-1").tranCode("22").checkSerialNumber("123456").amountOfCheck(1.0d).date(new Date(112, 05, 26)).sequenceNumber("1").get());
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static class SsStopPaymentRecBuilder {
        private SsStopPaymentRec ret = new SsStopPaymentRec();

        public static SsStopPaymentRecBuilder n() {
          return new SsStopPaymentRecBuilder();
        }
        
        public SsStopPaymentRecBuilder bankNumber(String param) {
            ret.setBankNumber(param);
            return this;
        }

        public SsStopPaymentRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }
        
        public SsStopPaymentRecBuilder tranCode(String param) {
            ret.setTranCode(param);
            return this;
        }

        public SsStopPaymentRecBuilder checkSerialNumber(String param) {
            ret.setCheckSerialNumber(param);
            return this;
        }

        public SsStopPaymentRecBuilder amountOfCheck(Double param) {
            ret.setAmountOfCheck(param);
            return this;
        }

        public SsStopPaymentRecBuilder date(Date param) {
            ret.setDate(param);
            return this;
        }

        public SsStopPaymentRecBuilder sequenceNumber(String param) {
            ret.setSequenceNumber(param);
            return this;
        }

        public SsStopPaymentRec get() {
            return ret;
        }
    }

}
