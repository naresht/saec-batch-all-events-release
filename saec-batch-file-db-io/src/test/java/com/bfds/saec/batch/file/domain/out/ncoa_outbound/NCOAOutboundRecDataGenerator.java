package com.bfds.saec.batch.file.domain.out.ncoa_outbound;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Service
public class NCOAOutboundRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

	public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(NCOAOutboundRecBuilder.n().dda("12345").referenceInformation("DDA-11000000001")
				.name("GiridharSirigiri")
				.address("36/238,Near MalariaOffice,Chinnachowk")
				.city("Kadapa").state("AP").zip("516002").get());
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
	}

	public static class NCOAOutboundRecBuilder {
		private NCOAOutboundRec ret = new NCOAOutboundRec();

		public static NCOAOutboundRecBuilder n() {
			return new NCOAOutboundRecBuilder();
		}

		public NCOAOutboundRecBuilder referenceInformation(String param) {
			ret.setReferenceInformation(param);
			return this;
		}

		public NCOAOutboundRecBuilder name(String param) {
			ret.setName(param);
			return this;
		}

		public NCOAOutboundRecBuilder address(String param) {
			ret.setAddress(param);
			return this;
		}

		public NCOAOutboundRecBuilder city(String param) {
			ret.setCity(param);
			return this;
		}

		public NCOAOutboundRecBuilder state(String param) {
			ret.setState(param);
			return this;
		}

		public NCOAOutboundRecBuilder zip(String param) {
			ret.setZip(param);
			return this;
		}
		
		public NCOAOutboundRecBuilder dda(String param) {
			ret.setDda(param);
			return this;
		}
		
		public NCOAOutboundRec get()
		{
			return ret;
		}
		
	}

}
