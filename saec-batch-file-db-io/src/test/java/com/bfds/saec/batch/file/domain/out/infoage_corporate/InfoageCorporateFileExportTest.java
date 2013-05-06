package com.bfds.saec.batch.file.domain.out.infoage_corporate;


import com.bfds.saec.batch.file.domain.out.AbstractXmlFileExportFromJPAIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class InfoageCorporateFileExportTest extends AbstractXmlFileExportFromJPAIntegrationTest<OutboundCorporateAddressResearch> {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void createTestData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        OutboundCorporateAddressResearch r = new OutboundCorporateAddressResearch();
        r.setCompanyName("aaaaaaaaabbbbbbbb");
        r.setDda("1234");
        r.setUserRef("100000001");
        r.setStreetAddress("2000 crown colony dr--1");
        r.setCity("Quincy--1");
        r.setState("MA");
        entityManager.persist(r);
        r = new OutboundCorporateAddressResearch();
        r.setCompanyName("aaaaaaaaabbbbbbbb");
        r.setUserRef("10000002");
        r.setDda("1234");
        r.setStreetAddress("2000 crown colony dr--1");
        r.setCity("Quincy--1");
        r.setState("MA");
        entityManager.persist(r);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
