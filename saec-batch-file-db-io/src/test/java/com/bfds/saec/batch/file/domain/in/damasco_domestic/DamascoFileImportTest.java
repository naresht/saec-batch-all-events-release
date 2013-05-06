package com.bfds.saec.batch.file.domain.in.damasco_domestic;

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
public class DamascoFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<DamascoInRec, DamascoInRec, DamascoInRec> {
	
	 @Override
	    protected Map<String, Object[][]> getExpectedResults() {
	        Map<String, Object[][]> ret = Maps.newHashMap();

	        ret.put(DATA_RECORD,
	                new Object[][]
	                        {
	        					{"status", "pass"},
	        					{"referenceNo", "1000001"},  
	        					{"taxEntity", "Damasco"},
	        					{"checkNumber", "1000001"},
	        					{"originalAccountType", "SA"},
	        					{"name1", "Raghavender"},
	        					{"name2", "Bandar"},  
	        					{"name3", "name 3"},
	        					{"name4", "name 4"},
	        					{"addressLine1", "Srinivasa Heights"},  
	        					{"addressLine2", "Srinivasa colony"},
	        					{"addressLine3", "Manikonda"},
	        					{"city", "Hyderabad"},  
	        					{"state", "AP"},
	        					{"zip", "12345"},
	        					{"usCitizen", true},
	        					{"tin", "TIN"},
	        					{"w9Recived", "Y"},  
	        					{"w8Recived","Y"},
	        					{"w8FormType", "8FormType"},
	        					{"part2Completed","Y"},  
	        					{"countryOfTaxResidency", "US"},
	        					{"deceasedFlag",false},
	        					{"dateOfBirth",new Date(112, 05, 16)},
	        					{"withHoldingRequest","withHoldingRequest"},  
	        					{"federalWithHolding",new BigDecimal("10.25")},
	        					{"reissueDate", new Date(112, 8, 21)},
	        					{"totalPayment", new BigDecimal("200.00")},  
	        					{"paymentComp1", new BigDecimal("100.00")},
	        					{"paymentComp1Description", "SETTLEMTN AMOUNT"},
	        					{"paymentComp2", new BigDecimal("12.00")},  
	        					{"paymentComp2Description", "ADVISORY FEE"},
	        					{"paymentComp3", new BigDecimal("11.00")},
	        					{"paymentComp3Description", "INTEREST AMOUNT"},  
	        					{"stateOfResidency", "US"},
	        					{"taxesBasedOn", "G"},
	        					{"federalTax", new BigDecimal("10.00")},  
	        					{"stateTax", new BigDecimal("5.00")},
	        					{"interestFederaltax", new BigDecimal("20.00")},
	        					{"interestStatetax",new BigDecimal("22.00")},  
	        					{"disposition", "disposition"},
	        					{"comment", "COMMENT"},
	        					{"error", "error"},  
	        					{"organizationOrIndividual", "O"},
	        					{"dda","Damasco"}
	        					
	        					
	        					
	        					

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
        return "classpath:" + file + ".csv";
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
