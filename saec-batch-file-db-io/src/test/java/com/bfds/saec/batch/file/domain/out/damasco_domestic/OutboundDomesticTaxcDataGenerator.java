package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.math.BigDecimal;
import java.util.Date;


@Service
public class OutboundDomesticTaxcDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(OutboundDomesticTaxtRecBuilder.n().dda("DDA-1").paymentId((long) 15).referenceNo("1000001").
                name_1("Raghavender").name_2("Bandar").name_3("name 3").name_4("name 4").
                address_1("Srinivasa Heights").address_2("Srinivasa colony").address_3("Manikonda").city("Hyderabad").
                state("AP").zip("12345").checkNumber("1000001").totalPaymentAmount(new BigDecimal(200.00)).
                paymentComp1(new BigDecimal(100)).paymentComp2(new BigDecimal(12)).paymentComp3(new BigDecimal(11)).
                paymentComp4(null).paymentComp5(null).paymentComp1Description("SETTLEMTN AMOUNT").paymentComp2Description("ADVISORY FEE").
                paymentComp3Description("INTEREST AMOUNT").paymentComp4Description("PAYMENT 4").paymentComp5Description("PAYMENT 5").tin("TIN").certificationStatus("certificationStatu").certificationDate(new Date(112, 05, 16)).w9Received("Y").w8Received("Y").
                part2Completed("Y").countryOfResidency("US").usCitizen(true).certificationType("certificationType").taxType("Damastic").w8FormType("8FormType").stateOfResidency("US").
                federalWithholding(new BigDecimal(10)).dob(new Date(112, 05, 16)).organizationOrIndividual("O").deceasedFlag(new Boolean(false)).
                originalAccountType("SA").dateAdded(new Date(112, 05, 16)).dateSent(new Date(112, 05, 16)).get());

        entityManager.persist(OutboundDomesticTaxtRecBuilder.n().dda("DDA-1").paymentId((long) 15).referenceNo("1000001").
                name_1("Raghavender").name_2("Bandar").name_3("name 3").name_4("name 4").
                address_1("Srinivasa Heights").address_2("Srinivasa colony").address_3("Manikonda").city("Hyderabad").
                state("AP").zip("12345").checkNumber("1000001").totalPaymentAmount(new BigDecimal(200.00)).
                paymentComp1(new BigDecimal(100)).paymentComp2(new BigDecimal(12)).paymentComp3(new BigDecimal(11)).
                paymentComp4(null).paymentComp5(null).paymentComp1Description("SETTLEMTN AMOUNT").paymentComp2Description("ADVISORY FEE").
                paymentComp3Description("INTEREST AMOUNT").paymentComp4Description("PAYMENT 4").paymentComp5Description("PAYMENT 5").tin("TIN").certificationStatus("certificationStatu").certificationDate(new Date(112, 05, 16)).w9Received("Y").w8Received("Y").
                part2Completed("Y").countryOfResidency("US").usCitizen(true).certificationType("certificationType").taxType("Damastic").w8FormType("8FormType").stateOfResidency("US").
                federalWithholding(new BigDecimal(10)).dob(new Date(112, 05, 16)).organizationOrIndividual("O").deceasedFlag(new Boolean(false)).
                originalAccountType("SA").dateAdded(new Date(112, 05, 16)).dateSent(new Date(112, 05, 16)).get());

        entityManager.persist(OutboundDomesticTaxtRecBuilder.n().dda("DDA-1").paymentId((long) 15).referenceNo("1000001").
                name_1("Raghavender").name_2("Bandar").name_3("name 3").name_4("name 4").
                address_1("Srinivasa Heights").address_2("Srinivasa colony").address_3("Manikonda").city("Hyderabad").
                state("AP").zip("12345").checkNumber("1000001").totalPaymentAmount(new BigDecimal(200.00)).
                paymentComp1(new BigDecimal(100)).paymentComp2(new BigDecimal(12)).paymentComp3(new BigDecimal(11)).
                paymentComp4(null).paymentComp5(null).paymentComp1Description("SETTLEMTN AMOUNT").paymentComp2Description("ADVISORY FEE").
                paymentComp3Description("INTEREST AMOUNT").paymentComp4Description("PAYMENT 4").paymentComp5Description("PAYMENT 5").tin("TIN").certificationStatus("certificationStatu").certificationDate(new Date(112, 05, 16)).w9Received("Y").w8Received("Y").
                part2Completed("Y").countryOfResidency("US").usCitizen(true).certificationType("certificationType").taxType("Damastic").w8FormType("8FormType").stateOfResidency("US").
                federalWithholding(new BigDecimal(10)).dob(new Date(112, 05, 16)).organizationOrIndividual("O").deceasedFlag(new Boolean(false)).
                originalAccountType("SA").dateAdded(new Date(112, 05, 16)).dateSent(new Date(112, 05, 16)).get());

        entityManager.persist(OutboundDomesticTaxtRecBuilder.n().dda("DDA-1").paymentId((long) 15).referenceNo("1000001").
                name_1("Raghavender").name_2("Bandar").name_3("name 3").name_4("name 4").
                address_1("Srinivasa Heights").address_2("Srinivasa colony").address_3("Manikonda").city("Hyderabad").
                state("AP").zip("12345").checkNumber("1000001").totalPaymentAmount(new BigDecimal(200.00)).
                paymentComp1(new BigDecimal(100)).paymentComp2(new BigDecimal(12)).paymentComp3(new BigDecimal(11)).
                paymentComp4(null).paymentComp5(null).paymentComp1Description("SETTLEMTN AMOUNT").paymentComp2Description("ADVISORY FEE").
                paymentComp3Description("INTEREST AMOUNT").paymentComp4Description("PAYMENT 4").paymentComp5Description("PAYMENT 5").tin("TIN").certificationStatus("certificationStatu").certificationDate(new Date(112, 05, 16)).w9Received("Y").w8Received("Y").
                part2Completed("Y").countryOfResidency("US").usCitizen(true).certificationType("certificationType").taxType("Damastic").w8FormType("8FormType").stateOfResidency("US").
                federalWithholding(new BigDecimal(10)).dob(new Date(112, 05, 16)).organizationOrIndividual("O").deceasedFlag(new Boolean(false)).
                originalAccountType("SA").dateAdded(new Date(112, 05, 16)).dateSent(new Date(112, 05, 16)).get());

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static class OutboundDomesticTaxtRecBuilder {
        private OutboundDomesticTaxRec ret = new OutboundDomesticTaxRec();

        public static OutboundDomesticTaxtRecBuilder n() {
          return new OutboundDomesticTaxtRecBuilder();
        }

        public OutboundDomesticTaxtRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }

        public OutboundDomesticTaxtRecBuilder paymentId(Long param) {
            ret.setPaymentId(param);
            return this;
        }
        
        public OutboundDomesticTaxtRecBuilder userType(String param) {
        	ret.setUserType(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder referenceNo(String param) {
        	ret.setReferenceNo(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder Tax_Entity(String param) {
        	ret.setTaxEntity(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder name_1(String param) {
        	ret.setName_1(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder name_2(String param) {
        	ret.setName_2(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder name_3(String param) {
        	ret.setName_3(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder name_4(String param) {
        	ret.setName_4(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder name_5(String param) {
        	ret.setName_5(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder name_6(String param) {
        	ret.setName_6(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder address_1(String param) {
        	ret.setAddress_1(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder address_2(String param) {
        	ret.setAddress_2(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder address_3(String param) {
        	ret.setAddress_3(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder address_4(String param) {
        	ret.setAddress_4(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder address_5(String param) {
        	ret.setAddress_5(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder address_6(String param) {
        	ret.setAddress_6(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder city(String param) {
        	ret.setCity(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder state(String param) {
        	ret.setState(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder zip(String param) {
        	ret.setZip(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder checkNumber(String param) {
        	ret.setCheckNumber(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentType(String param) {
        	ret.setPaymentType(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder totalPaymentAmount(BigDecimal param) {
        	ret.setTotalPaymentAmount(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp1(BigDecimal param) {
        	ret.setPaymentComp1(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp2(BigDecimal param) {
        	ret.setPaymentComp2(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp3(BigDecimal param) {
        	ret.setPaymentComp3(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp4(BigDecimal param) {
        	ret.setPaymentComp4(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp5(BigDecimal param) {
        	ret.setPaymentComp5(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp1Description(String param) {
        	ret.setPaymentComp1Description(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp2Description(String param) {
        	ret.setPaymentComp2Description(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp3Description(String param) {
        	ret.setPaymentComp3Description(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp4Description(String param) {
        	ret.setPaymentComp4Description(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder paymentComp5Description(String param) {
        	ret.setPaymentComp5Description(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder tin(String param) {
        	ret.setTin(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder certificationStatus(String param) {
        	ret.setCertificationStatus(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder certificationDate(Date param) {
        	ret.setCertificationDate(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder w9Received(String param) {
        	ret.setW9Received(param);
            return this;
        }
        
        public OutboundDomesticTaxtRecBuilder w8Received(String param) {
            ret.setW8Received(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder part2Completed(String param) {
        	ret.setPart2Completed(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder countryOfResidency(String param) {
        	ret.setCountryOfResidency(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder usCitizen(Boolean param) {
        	ret.setUsCitizen(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder certificationType(String param) {
        	ret.setCertificationType(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder taxType(String param) {
        	ret.setTaxType(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder w8FormType(String param) {
        	ret.setW8FormType(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder stateOfResidency(String param) {
        	ret.setStateOfResidency(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder federalWithholding(BigDecimal param) {
        	ret.setFederalWithholding(param);
            return this;
        }
        
        public OutboundDomesticTaxtRecBuilder dob(Date param) {
        	ret.setDob(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder organizationOrIndividual(String param) {
        	ret.setOrganizationOrIndividual(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder deceasedFlag(Boolean param) {
        	ret.setDeceasedFlag(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder originalAccountType(String param) {
        	ret.setOriginalAccountType(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder dateAdded(Date param) {
        	ret.setDateAdded(param);
            return this;
        }
        public OutboundDomesticTaxtRecBuilder dateSent(Date param) {
        	ret.setDateSent(param);
            return this;
        }
        
        public OutboundDomesticTaxRec get() {
            return ret;
        }
    }

}
