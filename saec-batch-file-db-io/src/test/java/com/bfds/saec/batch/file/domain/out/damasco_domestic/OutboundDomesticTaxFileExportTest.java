package com.bfds.saec.batch.file.domain.out.damasco_domestic;


import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.TestSupport;
import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;


@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})

public class OutboundDomesticTaxFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<OutboundDomesticTaxRec> {

    @Autowired
    private OutboundDomesticTaxcDataGenerator outboundDomesticTaxcDataGenerator;
    @Override
    protected void createTestData() {
        outboundDomesticTaxcDataGenerator.create();
    }
    
    protected String getOutputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "file:target/" + file + ".csv";
    }

    protected String getExpectedOutputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "/" + file + ".csv";
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public  void assertEquals(File actual, File expected) throws IOException {
		List<String> outputValue = FileUtils.readLines((actual), null);
        List<String> expectedValue = FileUtils.readLines(expected, null);
        assertThat(outputValue.size()).isEqualTo(expectedValue.size());
        outputValue =skipBatchNumber(outputValue);
        expectedValue =skipBatchNumber(expectedValue);
        assertThat(outputValue).contains(expectedValue.toArray());
    }
    
    /**
     * As the batch number is not consistency  Skipping The Batch number for comparison.  
     * @param  list
     * @return list
     */
    private List<String> skipBatchNumber(List<String> list)
    {
    	
    	List<String> modifiedList = new ArrayList<String>();
    	for(String str : list)
    	{
    		String[] splits =str.split(",");
    		splits[4]="";
    		str = Arrays.toString(splits);
    		modifiedList.add(str);
    	}
    	return modifiedList;
    }
    
}
