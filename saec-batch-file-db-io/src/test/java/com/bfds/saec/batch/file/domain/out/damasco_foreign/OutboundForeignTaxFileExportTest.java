package com.bfds.saec.batch.file.domain.out.damasco_foreign;


import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.TestSupport;
import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;


@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class OutboundForeignTaxFileExportTest extends AbstractFlatFileExportFromJPAIntegrationTest<ForeignTaxOutRec> {

    @Autowired
    private OutboundForeignTaxcDataGenerator outboundForeignTaxcDataGenerator;
    @Override
    protected void createTestData() {
        outboundForeignTaxcDataGenerator.create();
    }
    
    protected String getOutputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "file:target/" + file + ".xls";
    }

    protected String getExpectedOutputResource() {
        String file = TestSupport.getParametrisedTypeClass(this, 0).getName().replaceAll("\\.", "/");
        return "/" + file + ".xls";
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public  void assertEquals(File actual, File expected) throws IOException {
		List<String> outputValue = readExcel(actual);
        List<String> expectedValue = readExcel(expected);
        assertThat(outputValue.size()).isEqualTo(expectedValue.size());
        assertThat(outputValue).contains(expectedValue.toArray());
    }
    
    
    
    private List<String> readExcel(File expected)
    {
    	List<String> list  = new ArrayList<String>();
    	try {
    			FileInputStream file = new FileInputStream(expected);
    			String line="";
    			//Get the workbook instance for XLS file 
    			HSSFWorkbook workbook = new HSSFWorkbook(file);
    			int numberofSheets =workbook.getNumberOfSheets();
    			for(int i=0;i<numberofSheets ;i++){
	    			//Get first sheet from the workbook
	    			HSSFSheet sheet = workbook.getSheetAt(i);
	    			//Iterate through each rows from first sheet
	    			Iterator<Row> rowIterator = sheet.iterator();
	    			while(rowIterator.hasNext()) {
	    				Row row = rowIterator.next();
	    				//For each row, iterate through each columns
	    				Iterator<Cell> cellIterator = row.cellIterator();
	    				while(cellIterator.hasNext()) {
	    					Cell cell = cellIterator.next();
	    					switch(cell.getCellType()) {
	    					case Cell.CELL_TYPE_BOOLEAN:
	    						line.concat(cell.getBooleanCellValue()+",");
	    						break;
	    					case Cell.CELL_TYPE_NUMERIC:
	    						line.concat(cell.getNumericCellValue()+",");
	    						break;
	    					case Cell.CELL_TYPE_STRING:
	    						line.concat(cell.getStringCellValue()+",");
	    						break;
	    					}
	    				}
		    		list.add(line);
		    		}
    		}
    			
    			file.close();
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	return list;
    }
    
}
