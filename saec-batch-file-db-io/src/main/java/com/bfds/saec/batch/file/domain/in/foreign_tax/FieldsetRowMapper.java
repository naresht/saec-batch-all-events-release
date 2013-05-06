package com.bfds.saec.batch.file.domain.in.foreign_tax;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.bfds.saec.batch.item.excel.RowMapper;
import com.bfds.saec.batch.item.excel.Sheet;

/**
 * Row Mapper to convert each row of  excel to corresponding  Object.
 *  
 * @author B Raghavender
 *
 * @param <T>
 */

public class FieldsetRowMapper<T> implements RowMapper<ForeignTaxInRec>{

	public ForeignTaxInRec mapRow(Sheet sheet, String[] row, int rowNum,String dda) throws Exception {
		ForeignTaxInRec ob = new ForeignTaxInRec();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String[] labels  = sheet.getHeader();
		ob.setDda(dda);
		ob.setFundAccount(row[0]);
		ob.setBin(row[1]);
		ob.setBrokerId(row[2]);
		ob.setParentReferenceNo(row[3]);
		ob.setTin(row[4]);
		ob.setElectionCode1(row[5]);
		ob.setPaymentComp1(toBigDecimal(row[6]));
		ob.setPaymentComp1Description(labels[6]);
		ob.setElectionCode2(row[7]);
		ob.setPaymentComp2(toBigDecimal(row[8]));
		ob.setPaymentComp2Description(labels[8]);
		ob.setElectionCode3(row[9]);
		ob.setPaymentComp3(toBigDecimal(row[10]));
		ob.setPaymentComp3Description(labels[10]);
		ob.setElectionCode4(row[11]);
		ob.setPaymentComp4(toBigDecimal(row[12]));
		ob.setPaymentComp4Description(labels[12]);
		ob.setElectionCode5(row[13]);
		ob.setPaymentComp5(toBigDecimal(row[14]));
		ob.setPaymentComp5Description(labels[14]);
		ob.setParentReg1OrAdd1(row[15]);
		ob.setParentReg2OrAdd2(row[16]);
		ob.setParentReg3OrAdd3(row[17]);
		ob.setParentReg4OrAdd4(row[18]);
		ob.setParentReg5OrAdd5(row[19]);
		ob.setParentReg6OrAdd6(row[20]);
		ob.setParentCity(row[22]);
		ob.setParentState(row[23]);
		ob.setParentZip(row[24]);
		ob.setParentZipCodeExt(row[25]);
		ob.setParentCountry(row[26]);
		ob.setAltPayeeReg1OrAdd1(row[27]);
		ob.setAltPayeeReg2OrAdd2(row[28]);
		ob.setAltPayeeReg3OrAdd3(row[29]);
		ob.setAltPayeeReg4OrAdd4(row[30]);
		ob.setAltPayeeReg5OrAdd5(row[31]);
		ob.setAltPayeeReg6OrAdd6(row[32]);
		ob.setAltPayeeCity(row[34]);
		ob.setAltPayeeState(row[35]);
		ob.setAltPayeeZip(row[36]);
		ob.setAltPayeeZipCodeExt(row[37]);
		ob.setAltPayeeCountry(row[38]);
		ob.setRightsFlag(row[39]);
		ob.setNotesFlag(row[40]);
		ob.setEmplyeeCode(row[41]);
		ob.setCheckNumber(row[42]);
		ob.setDisbursmentDate(toDate(row[43], dateFormat));
		ob.setCheckVoid(row[44]);
		ob.setFutureUse(row[45]);
		ob.setCheckDate(toDate(row[46], dateFormat));
		ob.setGroupCode(row[47]);
		ob.setRestrictedBookShares(row[48]);
		ob.setTreassAccnt(row[49]);
		ob.setOffierCode(row[50]);
		ob.setSensitiveCode(row[51]);
		ob.setRightsDollors(row[52]);
		ob.setRightsDollors2(row[53]);
		ob.setBatchNumber(toInteger(row[54]));
		ob.setBatchNumber(toInteger(row[55]));
		ob.setAltPayeeReferenceNo(row[56]);
		ob.setTaxesBasedOn(row[57]);
		ob.setWithHoldingRequest(row[58]);
		ob.setForeignTaxClassification(sheet.getName());
		ob.setDisposstion(row[59]);
		ob.setFederalTax(toBigDecimal(row[60]));
		ob.setInterestFederaltax(toBigDecimal(row[61]));
		return ob;
	}
	
	private BigDecimal toBigDecimal(String str) {
		return StringUtils.hasText(str) ? new BigDecimal(str) : null;
	}
	
	private Date toDate(String str, DateFormat format) throws ParseException {
		return StringUtils.hasText(str) ? format.parse(str) : null;
	}
	
	private Integer toInteger(String str) throws ParseException {
		return StringUtils.hasText(str) ? new Integer((int) Double.parseDouble(str)) : null;
	}

}


