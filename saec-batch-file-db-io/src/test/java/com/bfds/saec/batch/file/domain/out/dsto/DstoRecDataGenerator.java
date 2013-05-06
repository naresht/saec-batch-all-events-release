package com.bfds.saec.batch.file.domain.out.dsto;

import java.math.BigDecimal;
import java.util.Date;

import com.bfds.saec.batch.file.domain.VendorConfig;
import com.bfds.saec.batch.file.domain.out.dsto.DstoRec.DstoFileType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@Service
public class DstoRecDataGenerator {

    @PersistenceUnit(unitName = "batchFilesEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

	public void createDSTOData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
		
		DstoRec ret = new DstoRec();
		DstoRecDataGenerator.createVendorProperties();
		ret.setFromLibID("Library1");
		ret.setBankRouting("0000002234");
		ret.setDda("0000034512");
		ret.setChkNum("123456144");	
		ret.setFromAccount("00100000001");
		//ret.setGrossAmount1("000000000010075");
		ret.setReg1OrAdd1("RegistrationName1");
		ret.setReg2OrAdd2("RegistrationName2");
		ret.setReg3OrAdd3("RegistrationName3");
		ret.setReg4OrAdd4("RegistrationName4");
		ret.setTaxID("112233445");
		ret.setBrokerNum("0005578");
		ret.setExtAccountID("66666");
		//Verify
		ret.setReg5OrAdd5("address 1");
		ret.setCity("NEWYORK");
		ret.setState("NY");
		ret.setCountry("USA");
		ret.setPostalCode("23456");
		ret.setPostalCodeExt("4455");
		ret.setChkDate(new Date(112,5,29));
		ret.setChkDisbursementDate(new Date(112,5,29));
		ret.setPrintCode("samp");
		ret.setMsgOrLetterNum(" c1");
		ret.setAuditCheckFlag("A");// this is hardcoded in the service. Make it a constant.
		ret.setCheckForm("Y");// this is hardcoded in the service. Make it a constant.
		ret.setBrokerNum("0005578");
		ret.setGrossAmount1(new BigDecimal(11075));
		ret.setNetAmount1(new BigDecimal(10075));
		ret.setPayeeRegistration1("RegistrationName1");
		ret.setPayeeRegistration2("RegistrationName2");
		ret.setPayeeRegistration3("RegistrationName3");
		ret.setPayeeRegistration4("RegistrationName4");
		ret.setClientOrProductIndicator("sampleEven");
		ret.setSentDate(new Date(112,5,28));
		//ret.setSentTime(new Date(112,5,28, 11,24,11));
		ret.setTotProceeds(new BigDecimal(445));
		ret.setTotGross(new BigDecimal(75000));
		ret.setTotFees(new BigDecimal(45750));
		ret.setTotTaxes(new BigDecimal(0));
		ret.setDstoFileType(DstoFileType.CHECKFILE.toString());

        entityManager.persist(ret);
		
		//
		ret = new DstoRec();
		ret.setFromLibID("Library2  ");
		ret.setBankRouting("0000002234");		
		ret.setDda("0000034512");		
		ret.setChkNum("123456155");		
		ret.setFromAccount("00100000001");		
		ret.setGrossAmount1(new BigDecimal(34500));
		ret.setReg1OrAdd1("RegistrationName1");
		ret.setReg2OrAdd2("RegistrationName2");
		ret.setReg3OrAdd3("RegistrationName3");
		ret.setReg4OrAdd4("RegistrationName4");
		ret.setTaxID("112233445");
		ret.setBrokerNum("0005578");
		ret.setExtAccountID("66666");
		//Verify
		ret.setReg5OrAdd5("address 1");
		ret.setCity("NEWYORK");
		ret.setState("NY");
		ret.setCountry("USA");
		ret.setPostalCode("23456");
		ret.setPostalCodeExt("4455");
		ret.setChkDate(new Date(112,05,29));
		ret.setChkDisbursementDate(new Date(112,05,29));
		ret.setPrintCode("samp");
		ret.setMsgOrLetterNum(" c2");
		ret.setAuditCheckFlag("A");// this is hardcoded in the service. Make it a constant.
		ret.setCheckForm("Y");// this is hardcoded in the service. Make it a constant.
		ret.setBrokerNum("0005578");
		//ret.setGrossAmount1("000000000010075");//DBLE
		ret.setGrossAmount1(new BigDecimal(35500));
		ret.setNetAmount1(new BigDecimal(34500));
		ret.setPayeeRegistration1("RegistrationName1");
		ret.setPayeeRegistration2("RegistrationName2");
		ret.setPayeeRegistration3("RegistrationName3");
		ret.setPayeeRegistration4("RegistrationName4");
		ret.setClientOrProductIndicator("sampleEven");
		ret.setSentDate(new Date(112,5,29));
		//ret.setSentTime(new Date(112,5,28, 11,24,11));
		//ret.setSentTime(new Date());
		ret.setTotProceeds(new BigDecimal(445));
		ret.setTotGross(new BigDecimal(75000));
		ret.setTotFees(new BigDecimal(45750));
		ret.setDstoFileType(DstoFileType.CHECKFILE.toString());
        entityManager.persist(ret);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}
	
	public static void createVendorProperties() {
        VendorConfig p =   new VendorConfig();
        p.setBankNameOnDstoFile("Boston Finance");
        p.persist();
        p.flush();
        p.clear();
    }
}
