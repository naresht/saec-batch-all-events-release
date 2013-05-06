package com.bfds.saec.batch.file.domain.out.damasco_foreign;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.math.BigDecimal;
import java.util.Date;



@Service
public class OutboundForeignTaxcDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    public void create() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(OutboundForeignTaxRecBuilder.n().dda("DDA-1").foreignTaxClassification("Entites").fundAccount("1000001").bin("Bin").brokerId("Broker").
        parentReferenceNo("100000001").tin("tin").electionCode1("Code 1").paymentComp1(new BigDecimal(110.00)).paymentComp1Description("LOSESS").
        electionCode2("Code 2").paymentComp2(new BigDecimal(120.00)).paymentComp2Description("ADVISORY FEES").electionCode3("Code 3").
        paymentComp3(new BigDecimal(130.00)). paymentComp3Description("LIQUIDATED DOLLARS").electionCode4("Code 4").paymentComp4(new BigDecimal(140.00)).
        paymentComp4Description("BOA").electionCode5("Code 5").paymentComp5(new BigDecimal(140)).paymentComp5Description("BEAR").parentReg1OrAdd1("Raghavender").
        parentReg2OrAdd2("").parentReg3OrAdd3("Bndar").parentReg4OrAdd4("").parentReg5OrAdd5("Srinivasa Colony").parentReg6OrAdd6("add6").parentReg7OrAdd7("add7").
        parentCity("Hyd").parentState("AP").parentZip("500018").parentZipCodeExt("1221").parentCountry("India").       
        altPayeeReg1OrAdd1("Shivaji").altPayeeReg2OrAdd2("Bandar").altPayeeReg3OrAdd3("SriniVasa").altPayeeReg4OrAdd4("manikonda").altPayeeReg5OrAdd5("").
        altPayeeReg6OrAdd6("adr6").altPayeeReg7OrAdd7("adr7").altPayeeState("MP").altPayeeZip("582145").altPayeeZipCodeExt("7458").altPayeeCountry("US").
        checkNumber("010101010").disbursmentDate(new Date(112, 05, 16)).checkDate(new Date(112, 05, 16)).taxesBasedOn("G").withHoldingRequest("Yes").
        batchNumber(12).itemNumber(1).rightsFlag("Yes").notesFlag("Yes").employeeCode("73510").checkVoid("void").futureUse("yes").groupCode("GC").restrictedBookShares("shares").
        treassAccount("12354").offierCode("OC1").sensitiveCode("SC1").rightsDollors("").rightsDollors2("").disposstion("Ok to reissue with withholding").
        federalTax(new BigDecimal(13.00)).federalTaxInterest(new BigDecimal(3.10)).get());

        entityManager.persist(OutboundForeignTaxRecBuilder.n().dda("DDA-1").foreignTaxClassification("Plans").fundAccount("1000001").bin("Bin").brokerId("Broker").
        parentReferenceNo("100000001").tin("tin").electionCode1("Code 1").paymentComp1(new BigDecimal(110.00)).paymentComp1Description("LOSESS").
        electionCode2("Code 2").paymentComp2(new BigDecimal(120.00)).paymentComp2Description("ADVISORY FEES").electionCode3("Code 3").
        paymentComp3(new BigDecimal(130.00)). paymentComp3Description("LIQUIDATED DOLLARS").electionCode4("Code 4").paymentComp4(new BigDecimal(140.00)).
        paymentComp4Description("BOA").electionCode5("Code 5").paymentComp5(new BigDecimal(140)).paymentComp5Description("BEAR").parentReg1OrAdd1("Raghavender").
        parentReg2OrAdd2("").parentReg3OrAdd3("Bndar").parentReg4OrAdd4("").parentReg5OrAdd5("Srinivasa Colony").parentReg6OrAdd6("add6").parentReg7OrAdd7("add7").
        parentCity("Hyd").parentState("AP").parentZip("500018").parentZipCodeExt("1221").parentCountry("India").       
        altPayeeReg1OrAdd1("Shivaji").altPayeeReg2OrAdd2("Bandar").altPayeeReg3OrAdd3("SriniVasa").altPayeeReg4OrAdd4("manikonda").altPayeeReg5OrAdd5("").
        altPayeeReg6OrAdd6("adr6").altPayeeReg7OrAdd7("adr7").altPayeeState("MP").altPayeeZip("582145").altPayeeZipCodeExt("7458").altPayeeCountry("US").
        checkNumber("010101010").disbursmentDate(new Date(112, 05, 16)).checkDate(new Date(112, 05, 16)).taxesBasedOn("G").withHoldingRequest("Yes").
        batchNumber(12).itemNumber(1).rightsFlag("Yes").notesFlag("Yes").employeeCode("73510").checkVoid("void").futureUse("yes").groupCode("GC").restrictedBookShares("shares").
        treassAccount("12354").offierCode("OC1").sensitiveCode("SC1").rightsDollors("").rightsDollors2("").disposstion("Ok to reissue with withholding").
        federalTax(new BigDecimal(13.00)).federalTaxInterest(new BigDecimal(3.10)).get());

        entityManager.persist(OutboundForeignTaxRecBuilder.n().dda("DDA-1").foreignTaxClassification("Entites").fundAccount("1000001").bin("Bin").brokerId("Broker").
        parentReferenceNo("100000001").tin("tin").electionCode1("Code 1").paymentComp1(new BigDecimal(110.00)).paymentComp1Description("LOSESS").
        electionCode2("Code 2").paymentComp2(new BigDecimal(120.00)).paymentComp2Description("ADVISORY FEES").electionCode3("Code 3").
        paymentComp3(new BigDecimal(130.00)). paymentComp3Description("LIQUIDATED DOLLARS").electionCode4("Code 4").paymentComp4(new BigDecimal(140.00)).
        paymentComp4Description("BOA").electionCode5("Code 5").paymentComp5(new BigDecimal(140)).paymentComp5Description("BEAR").parentReg1OrAdd1("Raghavender").
        parentReg2OrAdd2("").parentReg3OrAdd3("Bndar").parentReg4OrAdd4("").parentReg5OrAdd5("Srinivasa Colony").parentReg6OrAdd6("add6").parentReg7OrAdd7("add7").
        parentCity("Hyd").parentState("AP").parentZip("500018").parentZipCodeExt("1221").parentCountry("India").       
        altPayeeReg1OrAdd1("Shivaji").altPayeeReg2OrAdd2("Bandar").altPayeeReg3OrAdd3("SriniVasa").altPayeeReg4OrAdd4("manikonda").altPayeeReg5OrAdd5("").
        altPayeeReg6OrAdd6("adr6").altPayeeReg7OrAdd7("adr7").altPayeeState("MP").altPayeeZip("582145").altPayeeZipCodeExt("7458").altPayeeCountry("US").
        checkNumber("010101010").disbursmentDate(new Date(112, 05, 16)).checkDate(new Date(112, 05, 16)).taxesBasedOn("G").withHoldingRequest("Yes").
        batchNumber(12).itemNumber(1).rightsFlag("Yes").notesFlag("Yes").employeeCode("73510").checkVoid("void").futureUse("yes").groupCode("GC").restrictedBookShares("shares").
        treassAccount("12354").offierCode("OC1").sensitiveCode("SC1").rightsDollors("").rightsDollors2("").disposstion("Ok to reissue with withholding").
        federalTax(new BigDecimal(13.00)).federalTaxInterest(new BigDecimal(3.10)).get());

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }

    public static class OutboundForeignTaxRecBuilder {
        private ForeignTaxOutRec ret = new ForeignTaxOutRec();

        public static OutboundForeignTaxRecBuilder n() {
          return new OutboundForeignTaxRecBuilder();
        }

        public OutboundForeignTaxRecBuilder dda(String param) {
            ret.setDda(param);
            return this;
        }
       
        public OutboundForeignTaxRecBuilder foreignTaxClassification(String param) {
        	ret.setForeignTaxClassification(param);
            return this;
        }
        
        public OutboundForeignTaxRecBuilder fundAccount(String param) {
        	ret.setFundAccount(param);
            return this;
        }
        
        public OutboundForeignTaxRecBuilder bin(String param) {
        	ret.setBin(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder brokerId(String param) {
        	ret.setBrokerId(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder parentReferenceNo(String param) {
        	ret.setParentReferenceNo(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder tin(String param) {
        	ret.setTin(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder electionCode1(String param) {
        	ret.setElectionCode1(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder paymentComp1(BigDecimal param) {
        	ret.setPaymentComp1(param);
            return this;
        }
        
        public OutboundForeignTaxRecBuilder paymentComp1Description(String param) {
        	ret.setPaymentComp1Description(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder electionCode2(String param) {
        	ret.setElectionCode2(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder paymentComp2(BigDecimal param) {
        	ret.setPaymentComp2(param);
            return this;
        }
        
        public OutboundForeignTaxRecBuilder paymentComp2Description(String param) {
        	ret.setPaymentComp2Description(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder electionCode3(String param) {
        	ret.setElectionCode3(param);
            return this;
        } 
        
        public OutboundForeignTaxRecBuilder paymentComp3(BigDecimal param) {
        	ret.setPaymentComp3(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder paymentComp3Description(String param) {
        	ret.setPaymentComp3Description(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder electionCode4(String param) {
        	ret.setElectionCode4(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder paymentComp4(BigDecimal param) {
        	ret.setPaymentComp4(param);
            return this;
        }  
        public OutboundForeignTaxRecBuilder paymentComp4Description(String param) {
        	ret.setPaymentComp4Description(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder electionCode5(String param) {
        	ret.setElectionCode5(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder paymentComp5(BigDecimal param) {
        	ret.setPaymentComp5(param);
            return this;
        } 
        
        public OutboundForeignTaxRecBuilder paymentComp5Description(String param) {
        	ret.setPaymentComp5Description(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder parentReg1OrAdd1(String param) {
        	ret.setParentReg1OrAdd1(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder parentReg2OrAdd2(String param) {
        	ret.setParentReg2OrAdd2(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder parentReg3OrAdd3(String param) {
        	ret.setParentReg3OrAdd3(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder parentReg4OrAdd4(String param) {
        	ret.setParentReg4OrAdd4(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder parentReg5OrAdd5(String param) {
        	ret.setParentReg5OrAdd5(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder parentReg6OrAdd6(String param) {
        	ret.setParentReg6OrAdd6(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder parentReg7OrAdd7(String param) {
        	ret.setParentReg7OrAdd7(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder parentCity(String param) {
        	ret.setParentCity(param);
            return this;
        }
        
        public OutboundForeignTaxRecBuilder parentState(String param) {
        	ret.setParentState(param);
            return this;
        }  
        
        public OutboundForeignTaxRecBuilder parentZip(String param) {
        	ret.setParentZip(param);
            return this;
        }  
        
        public OutboundForeignTaxRecBuilder parentZipCodeExt(String param) {
        	ret.setParentZipCodeExt(param);
            return this;
        }
        
        public OutboundForeignTaxRecBuilder parentCountry(String param) {
        	ret.setParentCountry(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder altPayeeReg1OrAdd1(String param) {
        	ret.setAltPayeeReg1OrAdd1(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder altPayeeReg2OrAdd2(String param) {
        	ret.setAltPayeeReg2OrAdd2(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder altPayeeReg3OrAdd3(String param) {
        	ret.setAltPayeeReg3OrAdd3(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder altPayeeReg4OrAdd4(String param) {
        	ret.setAltPayeeReg4OrAdd4(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder altPayeeReg5OrAdd5(String param) {
        	ret.setAltPayeeReg5OrAdd5(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder altPayeeReg6OrAdd6(String param) {
        	ret.setAltPayeeReg6OrAdd6(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder altPayeeReg7OrAdd7(String param) {
        	ret.setAltPayeeReg7OrAdd7(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder altPayeeCity(String param) {
        	ret.setAltPayeeCity(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder altPayeeState(String param) {
        	ret.setAltPayeeState(param);
            return this;
        }  
        public OutboundForeignTaxRecBuilder altPayeeZip(String param) {
        	ret.setAltPayeeZip(param);
            return this;
        }  
        public OutboundForeignTaxRecBuilder altPayeeZipCodeExt(String param) {
        	ret.setAltPayeeZipCodeExt(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder altPayeeCountry(String param) {
        	ret.setAltPayeeCountry(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder checkNumber(String param) {
        	ret.setCheckNumber(param);
            return this;
        } 
        public OutboundForeignTaxRecBuilder disbursmentDate(Date  param) {
        	ret.setDisbursmentDate(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder checkDate(Date param) {
        	ret.setCheckDate(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder taxesBasedOn(String param) {
        	ret.setTaxesBasedOn(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder withHoldingRequest(String param) {
        	ret.setWithHoldingRequest(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder batchNumber(Integer param) {
        	ret.setBatchNumber(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder itemNumber(Integer param) {
        	ret.setItemNumber(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder rightsFlag(String param) {
        	ret.setRightsFlag(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder notesFlag(String param) {
        	ret.setNotesFlag(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder employeeCode(String param) {
        	ret.setEmployeeCode(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder checkVoid(String param) {
        	ret.setCheckVoid(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder futureUse(String param) {
        	ret.setFutureUse(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder groupCode(String param) {
        	ret.setGroupCode(param);
            return this;
        }  
        public OutboundForeignTaxRecBuilder restrictedBookShares(String param) {
        	ret.setRestrictedBookShares(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder treassAccount(String param) {
        	ret.setTreassAccount(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder offierCode(String param) {
        	ret.setOfficerCode(param);
            return this;
        }  public OutboundForeignTaxRecBuilder sensitiveCode(String param) {
        	ret.setSensitiveCode(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder rightsDollors(String param) {
        	ret.setRightsDollors(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder rightsDollors2(String param) {
        	ret.setRightsDollors2(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder disposstion(String param) {
        	ret.setDisposstion(param);
            return this;
        }
        public OutboundForeignTaxRecBuilder federalTax(BigDecimal param) {
        	ret.setFederalTax(param);
            return this;
        }  public OutboundForeignTaxRecBuilder federalTaxInterest(BigDecimal param) {
        	ret.setFederalTaxInterest(param);
            return this;
        }
        
        public ForeignTaxOutRec get() {
            return ret;
        }
    }

}
