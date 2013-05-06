package com.bfds.saec.batch.file.domain.in.foreign_tax;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.TestSupport;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class ForeignTaxFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<ForeignTaxInRec, ForeignTaxInRec, ForeignTaxInRec> {
	
	 @Override
	    protected Map<String, Object[][]> getExpectedResults() {
	        Map<String, Object[][]> ret = Maps.newHashMap();

	        ret.put(DATA_RECORD,
	                new Object[][]
	                        {
	        					{"foreignTaxClassification", "Plans","Entites"},
	        					{"fundAccount", "1000001","1000002"},  
	        					{"bin", "1234","1024"},
	        					{"brokerId", "123456789"},
	        					{"parentReferenceNo", "10000011"},  
	        					{"tin", "SA"},
	        					{"electionCode1", "S"},
	        					{"paymentComp1", new BigDecimal("250.00")},  
	        					{"paymentComp1Description", "LOSSES"},
	        					{"electionCode2", "Y"},
	        					{"paymentComp2", new BigDecimal("100.00")},  
	        					{"paymentComp2Description", "ADVISORY FEES"},
	        					{"electionCode3", "I"},
	        					{"paymentComp3", new BigDecimal("120.00")},  
	        					{"paymentComp3Description", "LIQUIDATED DOLLORS"},
	        					{"electionCode4", "1"},
	        					{"paymentComp4", new BigDecimal("10.00")},  
	        					{"paymentComp4Description", "BOA"},
	        					{"electionCode5", "2"},
	        					{"paymentComp5", new BigDecimal("50.00")},  
	        					{"paymentComp5Description", "BEAR"},
	        					{"parentReg1OrAdd1", "Raghavender"},
	        					{"parentReg2OrAdd2", "Bandar"},
	        					{"parentReg3OrAdd3", "Line3"},
	        					{"parentReg4OrAdd4", "Line4"},
	        					{"parentReg5OrAdd5", "Line5"},
	        					{"parentReg6OrAdd6", "Line6"},
	        					{"parentCity", "Hyd"},
	        					{"parentState", "AP"},
	        					{"parentZip", "500089"},
	        					{"parentZipCodeExt", "123"},
	        					{"parentCountry", "India"},
	        					{"altPayeeReg1OrAdd1", "Shivaji"},
	        					{"altPayeeReg2OrAdd2", "Bandar"},
	        					{"altPayeeReg3OrAdd3", "Line3"},
	        					{"altPayeeReg4OrAdd4", "Line4"},
	        					{"altPayeeReg5OrAdd5", "Line5"},
	        					{"altPayeeReg6OrAdd6", "Line6"},
	        					{"altPayeeCity", "Hyd"},
	        					{"altPayeeState", "MP"},
	        					{"altPayeeZip", "2356"},
	        					{"altPayeeZipCodeExt", "25"},
	        					{"altPayeeCountry", "India"},
	        					{"rightsFlag", "Yes"},
	        					{"notesFlag", "Yes"},
	        					{"emplyeeCode", "73510"},
	        					{"checkNumber", "12456789"},
	        					{"disbursmentDate", new Date(111,9, 26)},
	        					{"futureUse", "emplStock"},
	        					{"checkVoid", "Yes"},
	        					{"checkDate", new Date(111,9, 26)},
	        					{"groupCode", "GC1"},
	        					{"restrictedBookShares", "BookShares"},
	        					{"treassAccnt", "TreasAcc"},
	        					{"offierCode", "OC1"},
	        					{"sensitiveCode", "SC"},
	        					{"rightsDollors", "RD"},
	        					{"rightsDollors2", "RD2"},
	        					{"altPayeeReferenceNo", "10000012"},
	        					{"taxesBasedOn", "G"},
	        					{"withHoldingRequest", "yes"},
	        					{"disposstion", "Ok to reissue with withholding"},
	        					
	        					
	        					

	                        });
	        ret.put(ERROR_RECORD,   
	                new Object[][]
	                        {
	                                {"lineNumber", 3},
	                                {"phase", BatchPhase.READ},
	                                {"rawData", "DB000001blahblahblah"},
	                        });
	        return ret;
	    }
	
	    @Override
    protected String getInputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "classpath:" + file + ".xls";
    }
	    
	protected  JobParameters getJobParameters() {
	        JobParameters jobParameters = new JobParametersBuilder()
	                .addString("inputResource", getInputResource())
	                .addString("fileRecordClass", TestSupport.getParametrisedTypeClass(this, 0).getName())
	                .addString("dda", "Damasco")
	                .toJobParameters();
	        return jobParameters;
	    }

}
