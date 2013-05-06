/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bfds.saec.batch.file.domain.out.damasco_foreign;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bfds.saec.batch.item.excel.ExcelHeaderCallback;

@Component("ForeignTaxRecHeaderCallback")
@Scope("step")
public class ForeignTaxRecHeaderCallback implements ExcelHeaderCallback {
	
	@Value("#{stepExecution}")
	private StepExecution stepExecution;


	
	@Override
	public void writeHeader(Row row) {
		String[] names =getHeader().split(",");
		for(int i=0;i<names.length;i++){
			Cell cell = row.createCell(i);
			cell.setCellValue(names[i]);
		}
	}
	
	private String getHeader() {
		String header="";
		if(stepExecution.getExecutionContext().containsKey("paymentComponents")){
			String paymentComponents =(String) stepExecution.getExecutionContext().get("paymentComponents");
			header="FUND ACCOUNT,BIN,BASE BROKER#,SAS REFERENCE #,TIN,"+paymentComponents+",REGISTRATION /ADDRESS1,REGISTRATION /ADDRESS2,REGISTRATION /ADDRESS3," +
					"REGISTRATION /ADDRESS4,REGISTRATION /ADDRESS5,REGISTRATION /ADDRESS6,REGISTRATION /ADDRESS7," +
					"CITY,STATE,POSTAL CODE,POSTAL CODE EXTEN,COUNTRY,ALT PAYEE REG/ADR 1,ALT PAYEE REG/ADR 2," +
					"ALT PAYEE REG/ADR 3,ALT PAYEE REG/ADR 4,ALT PAYEE REG/ADR 5,ALT PAYEE REG/ADR 6,ALT PAYEE REG/ADR 7," +
					"ALT PAYEE CITY,ALT PAYEE STATE,ALT PAYEE POSTAL CODE,ALT PAYEE POSTAL EXT,ALT PAYEE CNTRY,RIGHTS FLAG," +
					"NOTES FLAG,EMPLOYEE CODE,CHECK NUMBER,DISBURSEMENT DATE,CHECK VOID,FUTURE USE: EMPL STOCK,CHECK DATE," +
					"GROUP CODE,RESTRICTED BOOK SHARES,TREAS ACCNT,OFFICER CODE,SENSITIVE CODE,RIGHTS DOLLARS,RIGHTS DOLLARS2," +
					"BATCH NUM,ITEM NUM,SAS REFERENCE #,TAXES BASED ON,WITHHOLDING,DISPOSITION,FEDERAL TAX,INTEREST FEDERAL TAX";
			
		}
		return header;
	}
	

}
