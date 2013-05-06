package com.bfds.saec.batch.file.domain.out.infoage_individual;

import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.out.AbstractXmlFileExportFromJPAIntegrationTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class InfoageIndividualFileExportTest
		extends
		AbstractXmlFileExportFromJPAIntegrationTest<OutboundIndividualAddressResearch> {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

	@Override
	protected void createTestData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

		OutboundIndividualAddressResearch r = new OutboundIndividualAddressResearch();
		r.setInputRecord("test");
		r.setUserRef("10000001");
		r.setDda("1234");
		r.setSsn("123412341");
		r.setFirstName("Bob");
		r.setMiddleName("A");
		r.setLastName("Sheldon");
		r.setStreetAddress("university");
		r.setCity("boston");
		r.setState("MA");
		r.setZipCode("02139");
        entityManager.persist(r);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

	}

}
