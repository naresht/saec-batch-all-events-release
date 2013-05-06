package com.bfds.saec.batch.file.domain.out.ss_bottomline;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Date;

@Service
public class SsBottomLineOutRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

	public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
		entityManager.persist(SsBottomLineOutRecBuilder.n().fundCode("0000005")
				.accountNumber("100000001").checkType("M").checkAmount(100.00)
				.payableDate(new Date(112, 10, 03)).registration1("aaaaaaaaa")
				.registration2("bbbbbbbb").registration3("Residence Inn")
				.registration4("6 Cambridge Center")
				.registration5("CambridgeMA02142").registration6("state")
				.registration7("US").system("TES").offsettingDda("DDA-1").checkName("100001").get());
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
	}

	public static class SsBottomLineOutRecBuilder {

		private SsBottomLineOutRec ret = new SsBottomLineOutRec();

		public static SsBottomLineOutRecBuilder n() {
			return new SsBottomLineOutRecBuilder();
		}

		public SsBottomLineOutRecBuilder fundCode(String param) {
			ret.setFundCode(param);
			return this;
		}

		public SsBottomLineOutRecBuilder accountNumber(String param) {
			ret.setAccountNumber(param);
			return this;
		}

		public SsBottomLineOutRecBuilder checkType(String param) {
			ret.setCheckType(param);
			return this;
		}

		public SsBottomLineOutRecBuilder checkAmount(Double param) {
			ret.setCheckAmount(param);
			return this;
		}

		public SsBottomLineOutRecBuilder payableDate(Date param) {
			ret.setPayableDate(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration1(String param) {
			ret.setRegistration1(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration2(String param) {
			ret.setRegistration2(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration3(String param) {
			ret.setRegistration3(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration4(String param) {
			ret.setRegistration4(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration5(String param) {
			ret.setRegistration5(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration6(String param) {
			ret.setRegistration6(param);
			return this;
		}

		public SsBottomLineOutRecBuilder registration7(String param) {
			ret.setRegistration7(param);
			return this;
		}
		
		public SsBottomLineOutRecBuilder system(String param) {
			ret.setSystem(param);
			return this;
		}
		
		public SsBottomLineOutRecBuilder offsettingDda(String param) {
			ret.setOffsettingDda(param);
			return this;
		}

		public SsBottomLineOutRecBuilder checkName(String param) {
			ret.setCheckName(param);
			return this;
		}

		public SsBottomLineOutRec get() {
			return ret;
		}
	}

}
