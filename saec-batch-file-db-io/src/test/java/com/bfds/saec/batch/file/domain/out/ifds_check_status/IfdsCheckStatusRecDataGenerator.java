package com.bfds.saec.batch.file.domain.out.ifds_check_status;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class IfdsCheckStatusRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(IfdsCheckStatusRecBuilder.n().bankRouting("2234").dda("DDA-1").statusChangeDate(new Date(112, 05, 16)).accountNumber("100000001")
                                     .checkNumber("1011").netAmount(5.50d).checkStatus("   ").wireStatus("WA").get());
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static class IfdsCheckStatusRecBuilder {
        private IfdsCheckStatusRec ret = new IfdsCheckStatusRec();

        public static IfdsCheckStatusRecBuilder n() {
          return new IfdsCheckStatusRecBuilder();
        }

        public IfdsCheckStatusRecBuilder bankRouting(String param) {
            ret.setBankRouting(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder statusChangeDate(Date param) {
            ret.setStatusChangeDate(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder accountNumber(String param) {
            ret.setAccountNumber(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder checkNumber(String param) {
            ret.setCheckNumber(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder netAmount(Double param) {
            ret.setNetAmount(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder checkStatus(String param) {
            ret.setCheckStatus(param);
            return this;
        }

        public IfdsCheckStatusRecBuilder wireStatus(String param) {
            ret.setWireStatus(param);
            return this;
        }

        public IfdsCheckStatusRec get() {
            return ret;
        }
    }

}
