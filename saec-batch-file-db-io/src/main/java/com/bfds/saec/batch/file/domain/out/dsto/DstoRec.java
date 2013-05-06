package com.bfds.saec.batch.file.domain.out.dsto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.annotations.AssumedDecimalNumberFormat;
import com.bfds.saec.batch.annotations.DateFormat;
import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.annotations.PaddedStringFormat;
import com.bfds.saec.batch.annotations.Padding;
import com.bfds.saec.batch.annotations.Range;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;

@RooJpaEntity(table = "saec_batch_dsto")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })
@Job(processor = DbToFlatFileJobBuilder.class)
public class DstoRec extends FileItem {

	/**
	 * To differentiate data for DSTOPrintFile And DSTOChecjFile job. 
	 * For dstoFileType : field type has changed from enum to String and  @Enumerated(EnumType.STRING) has been commented because type enum type
	 * can't be compared in the generated JPQL with its equivalent String type value.
	 */
	//@Enumerated(EnumType.STRING)
	private String dstoFileType;


	@Range("1-3")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String recordType = "100";
	
	@Range("4")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String chkStatus;

	@Range("5-14")
	@PaddedStringFormat(padding = Padding.RPAD, size = 10, paddingChar = ' ')
	private String fromLibID;
 // Event Level - Each event will house a unique
	@Range("15-23")
	@PaddedStringFormat(padding = Padding.LPAD, size = 9, paddingChar = '0')
	private String chkPrintRunNum = "0";
 // EIN of the state when populated on SAEC
	@Range("24-32")
	@PaddedStringFormat(padding = Padding.LPAD, size = 9, paddingChar = '0')
	private String jobRunNum = "0";

	@Range("33-37")
	@PaddedStringFormat(padding = Padding.RPAD, size = 5, paddingChar = ' ')
	private String chkType = "MIX01";

	@Range("38-47")
	@PaddedStringFormat(padding = Padding.LPAD, size = 10, paddingChar = '0')
	private String bankRouting;
 // Event Level � bank ABA
	@Range("48-57")
	@Column(nullable=false)
	@PaddedStringFormat(padding = Padding.LPAD, size = 10, paddingChar = '0')
	private String dda;
 // Event Level � bank DDA
	@Range("58-66")
	@PaddedStringFormat(padding = Padding.LPAD, size = 9, paddingChar = '0')
	private String chkNum;
 // Payment Object � Ck#
	@Range("67-72")
	@PaddedStringFormat(padding = Padding.LPAD, size = 6, paddingChar = '0')
	private String batchNum;
 // SAEC assigned during batch
	@Range("73-75")
	@PaddedStringFormat(padding = Padding.LPAD, size = 3, paddingChar = '0')
	private String itemNum;
 // SAEC assigned during batch
	@Range("76")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String paymentType;

	@Range("77-87")
	@PaddedStringFormat(padding = Padding.LPAD, size = 11, paddingChar = '0')
	private String fromAccount;
 // SAEC reference number
	@Range("88-107")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String extAccountID;
 // Fund account # if available
	@Range("108-116")
	@PaddedStringFormat(padding = Padding.LPAD, size = 9, paddingChar = '0')
	private String taxID;
 // SSN -Account Level

	/*
	 * Populate with the data from registration lines in SAEC system up to reg.
	 * line 5 or reg .lines are null, whichever occurs first. Once reg. lines
	 * are null or query reaches reg. line 5, begin populating address lines and
	 * continue sequentially with address line data in SAEC
	 */
	@Range("117-156")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg1OrAdd1;

	@Range("157-196")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg2OrAdd2;

	@Range("197-236")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg3OrAdd3;

	@Range("237-276")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg4OrAdd4;

	@Range("277-316")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg5OrAdd5;

	@Range("317-356")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg6OrAdd6;

	@Range("357-396")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String reg7OrAdd7;

	@Range("397-436")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String city;
 // City field at Acct level. If null on SAEC system �
	@Range("437-438")
	@PaddedStringFormat(padding = Padding.RPAD, size = 2, paddingChar = ' ')
	private String state;
 // State field at Acct level. If null on SAEC system �
	@Range("439-443")
	@PaddedStringFormat(padding = Padding.LPAD, size = 5, paddingChar = '0')
	private String postalCode;
 // Zip field at Acct level. If null on SAEC
	@Range("444-447")
	@PaddedStringFormat(padding = Padding.RPAD, size = 4, paddingChar = ' ')
	private String postalCodeExt;
 // Zip ext field at Acct level. If null on
 // SAEC system � leave position empty (null)
	@Range("448-450")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String country;
 // Country � Acct Level

	@Range("451")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String altPayeeCode;

	@Range("452-491")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg1OrAdd1;

	@Range("492-531")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg2OrAdd2;

	@Range("532-571")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg3OrAdd3;

	@Range("572-611")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg4OrAdd4;

	@Range("612-651")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg5OrAdd5;

	@Range("652-691")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg6OrAdd6;

	@Range("692-731")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeReg7OrAdd7;

	@Range("732-771")
	@PaddedStringFormat(padding = Padding.RPAD, size = 40, paddingChar = ' ')
	private String altPayeeCity;

	@Range("772-773")
	@PaddedStringFormat(padding = Padding.RPAD, size = 2, paddingChar = ' ')
	private String altPayeeState;

	@Range("774-778")
	@PaddedStringFormat(padding = Padding.RPAD, size = 5, paddingChar = ' ')
	private String altPayeePostalCode;

	@Range("779-782")
	@PaddedStringFormat(padding = Padding.RPAD, size = 4, paddingChar = ' ')
	private String altPayeePostalExt;

	@Range("783-785")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String altPayeeCountry;


	@Range("786-795")
	@DateFormat("yyyyMMdd")
	private Date chkDate;
 // yyyy-mm-dd format
	@Range("796-805")
	@DateFormat("yyyyMMdd")
	private Date chkDisbursementDate;

	/*
	 * Field to determine what prints (check, tax form, letter (insert)). set at
	 * the event level �ODC� will be populated for 1099r
	 */
	@Range("806-809")
	@PaddedStringFormat(padding = Padding.RPAD, size = 4, paddingChar = ' ')
	private String printCode;

	@Range("810-812")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String chkPayCode;


	/*
	 * Field at account level - Job will be run to apply check type to each acct
	 * � drives messaging on the check stub
	 */
	@Range("813-815")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String msgOrLetterNum;

	@Range("816")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String chkVoid;


	/*
	 * Blank or value of �A� Value of �A� if payment object is flagged as audit
	 */
	@Range("817")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String auditCheckFlag;


	@Range("818-820")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String whoPrintsChecks;


	/*
	 * populate this with unique values to group checks together for mailing
	 * (house holding) or place �SPL� as the value for those checks that need to
	 * be pulled for special handling
	 */
	@Range("821-823")
	@PaddedStringFormat(padding = Padding.RPAD, size = 3, paddingChar = ' ')
	private String groupOrSpecHandle;


	/*
	 * When CKCHKTYP value is �ODC�, populate with value = 9 if CKCHKTP is not
	 * ODC, value
	 */
	@Range("824")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = '9')
	private String checkForm;

	@Range("825-831")
	@PaddedStringFormat(padding = Padding.LPAD, size = 7, paddingChar = '0')
	private String brokerNum;
 // Broker # - Account

	@Range("832")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String paymentType1;
 // Object Code value for �Settlement Amount�
									// field on payment object
	/*
	 * Blank in this field will indicate � no tax form If not blank, the value
	 * in this field will determine the tax form type to print
	 */
	@Range("833")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String printTaxForm1 = "9";

	@Range("834")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String correctedTaxForm1;
 // Blank or �C� � Event Level
	@Range("835")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String distributionCode1;
 // If available, this will populate and
	// print in box 7 of the 1099R, - Event
	// Level
	/*
	 * Where State field has a value, populate with associated EIN stored in the
	 * State EIN table within the SAEC system
	 */
	@Range("836-855")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String stateEIN1;

	@Range("856-870")
	@PaddedStringFormat(padding = Padding.LPAD, size = 15, paddingChar = '0')
    @AssumedDecimalNumberFormat(decimalPlaces = 4)
	private BigDecimal  valueToPayOn1;

	@Range("871-885")
	@PaddedStringFormat(padding = Padding.LPAD, size = 15, paddingChar = '0')
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  paymentRate1;

	@Range("886-900")
	@PaddedStringFormat(padding = Padding.LPAD, size = 15, paddingChar = '0')
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  grossAmount1;
 // Dollar value in the gross amount for the
	// payment object
	@Range("901-915")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  surityAmount1;

	@Range("916-930")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  brokerAmount1;

	@Range("931-945")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  BUWAmount1;
 // Dollar value in the BUW field on the payment
	// object
	@Range("946-960")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NRAAmount1;
 // Dollar value in the NRA field on the payment
	// object
	@Range("961-975")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ADRAmount1;
 // Dollar value in the ADR field on the payment
	// object
	@Range("976-990")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  DEPAmount1;

	@Range("991-1005")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  CONRECAmount1;

	@Range("1006-1020")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ESCROWAmount1;

	@Range("1021-1035")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NetAmount1;
 // Dollar value in the NET amount of the payment
	// object

	@Range("1036")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String paymentType2;

	@Range("1037")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String printTaxForm2 = "9";

	@Range("1038")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String correctedTaxForm2;

	@Range("1039")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String distributionCode2;


	@Range("1040-1059")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String stateEIN2;


	@Range("1060-1075")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 4)
	private BigDecimal  valueToPayOn2;


	@Range("1076-1089")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  paymentRate2;

	@Range("1090-1104")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  grossAmount2;

	@Range("1105-1119")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  surityAmount2;

	@Range("1120-1134")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  brokerAmount2;

	@Range("1135-1149")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  BUWAmount2;

	@Range("1150-1164")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NRAAmount2;

	@Range("1165-1179")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ADRAmount2;

	@Range("1180-1194")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  DEPAmount2;

	@Range("1195-1209")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  CONRECAmount2;

	@Range("1210-1224")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ESCROWAmount2;

	@Range("1225-1239")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NetAmount2;


	@Range("1240")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String paymentType3;

	@Range("1241")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String printTaxForm3 = "9";


	@Range("1242")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String correctedTaxForm3;

	@Range("1243")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String distributionCode3;

	@Range("1244-1263")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String stateEIN3;

	@Range("1264-1278")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 4)
	private BigDecimal  valueToPayOn3;


	@Range("1279-1293")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  paymentRate3;

	@Range("1294-1308")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  grossAmount3;

	@Range("1309-1323")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  surityAmount3;

	@Range("1324-1338")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  brokerAmount3;

	@Range("1339-1353")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  BUWAmount3;

	@Range("1354-1368")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NRAAmount3;

	@Range("1369-1383")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ADRAmount3;

	@Range("1384-1398")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  DEPAmount3;

	@Range("1399-1413")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  CONRECAmount3;

	@Range("1414-1428")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ESCROWAmount3;

	@Range("1429-1443")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NetAmount3;


	@Range("1444")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String paymentType4;


	@Range("1445")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String printTaxForm4 = "9";


	@Range("1446")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String correctedTaxForm4;


	@Range("1447")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String distributionCode4;

	@Range("1448-1467")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String stateEIN4;


	@Range("1468-1482")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 4)
	private BigDecimal  valueToPayOn4;

	@Range("1483-1497")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  paymentRate4;

	@Range("1498-1512")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  grossAmount4;

	@Range("1513-1527")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  surityAmount4;

	@Range("1528-1542")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  brokerAmount4;

	@Range("1543-1557")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  BUWAmount4;

	@Range("1558-1572")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NRAAmount4;

	@Range("1573-1587")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ADRAmount4;

	@Range("1588-1602")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  DEPAmount4;

	@Range("1603-1617")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  CONRECAmount4;

	@Range("1618-1632")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ESCROWAmount4;

	@Range("1633-1647")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NetAmount4;


	@Range("1648")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String paymentType5;

	@Range("1649")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String printTaxForm5 = "9";

	@Range("1650")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String correctedTaxForm5;


	@Range("1651")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String distributionCode5 = null;

	@Range("1652-1671")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String stateEIN5 = null;

	@Range("1672-1686")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 4)
	private BigDecimal  valueToPayOn5;

	@Range("1687-1701")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  paymentRate5;

	@Range("1702-1716")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  grossAmount5;

	@Range("1717-1731")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  surityAmount5;

	@Range("1732-1746")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  brokerAmount5;

	@Range("1747-1761")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  BUWAmount5;

	@Range("1762-1776")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NRAAmount5;

	@Range("1777-1791")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ADRAmount5;

	@Range("1792-1806")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  DEPAmount5;

	@Range("1807-1821")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  CONRECAmount5;

	@Range("1822-1836")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ESCROWAmount5;

	@Range("1837-1851")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NetAmount5;


	@Range("1852")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String paymentType6;

	@Range("1853")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String printTaxForm6 = "9";

	@Range("1854")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String correctedTaxForm6;


	@Range("1855")
	@PaddedStringFormat(padding = Padding.RPAD, size = 1, paddingChar = ' ')
	private String distributionCode6;

	@Range("1856-1875")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String stateEIN6;

	@Range("1876-1890")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 4)
	private BigDecimal  valueToPayOn6;

	@Range("1891-1905")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  paymentRate6;

	@Range("1906-1920")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  grossAmount6;

	@Range("1921-1935")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  surityAmount6;

	@Range("1936-1950")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  brokerAmount6;

	@Range("1951-1965")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  BUWAmount6;

	@Range("1966-1980")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NRAAmount6;

	@Range("1981-1995")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ADRAmount6;

	@Range("1996-2010")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  DEPAmount6;

	@Range("2011-2025")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  CONRECAmount6;

	@Range("2026-2040")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  ESCROWAmount6;

	@Range("2041-2055")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal  NetAmount6;

	@Range("2056-2072")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 10)
	private BigDecimal  foreignExchRate;

	@Range("2073-2089")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 6)
	private BigDecimal  foreignExchNet;


	@Range("2090-2104")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 15)
	private String foreignCurrency;

	@Range("2105-2114")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String checkFileName = "          ";


	@Range("2115-2154")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String payeeRegistration1;
 // Registration Line 1
	@Range("2155-2194")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String payeeRegistration2;
 // Registration Line 2 or null if no
										// value on system
	@Range("2195-2234")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String payeeRegistration3;
 // Registration Line 3 or null if no
										// value on system
	@Range("2235-2274")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String payeeRegistration4;
 // Registration Line 4 or null if no
										// value on system
	@Range("2275-2294")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 20)
	private String stateAccountID;

	@Range("2295")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String signature1 = "C";


	@Range("2296")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String signature2;


	@Range("2297-2300")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String futureUse3;

	@Range("2301-2304")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String futureUse4;


	@Range("2305-2309")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 5)
	private String futureUse5;

	@Range("2310-2314")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 5)
	private String futureUse6;

	@Range("2315-2324")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String clientOrProductIndicator;
// Event Short Name � event level
	@Range("2325-2334")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String futureUse8;

	@Range("2335-2344")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String sentUser = "BFDS";
 // System ID
	@Range("2345-2354")
	@DateFormat("yyyyMMdd")
	private Date sentDate;
 // Transmission Date
	@Range("2355-2362")//
	@PaddedStringFormat(padding = Padding.LPAD, size = 8, paddingChar = '0')
	@DateFormat("HHmmss")
	private Date sentTime;
 // Transmission Time
	@Range("2363-2412")
	@PaddedStringFormat(padding = Padding.RPAD, size = 50, paddingChar = ' ')
	private String fundName1;

	@Range("2413-2432")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String fundAccount1;


	@Range("2433-2447")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal fundGrossAmount1;

	@Range("2448-2497")
	@PaddedStringFormat(padding = Padding.RPAD, size = 50, paddingChar = ' ')
	private String fundName2;

	@Range("2498-2517")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String fundAccount2;


	@Range("2518-2532")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal fundGrossAmount2;


	@Range("2533-2582")
	@PaddedStringFormat(padding = Padding.RPAD, size = 50, paddingChar = ' ')
	private String fundName3;

	@Range("2583-2602")
	@PaddedStringFormat(padding = Padding.RPAD, size = 20, paddingChar = ' ')
	private String fundAccount3;


	@Range("2603-2617")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 15)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal fundGrossAmount3;


	@Range("2618")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String domestic;


	@Range("2619-2648")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String bankName;


	@Range("2649")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String runType;


	/*
	 * These fields will be used when the multiple payment component detail is
	 * passed for each record. For now these fields should be blank - Filler
	 */
	/**
	 * Note:- In the below fields range mapping there is a difference between: The
	 * range we have defined (with a difference of 15) and the size given=17.To
	 * support the current batch XML mapping for the DSTO batch job. Later we
	 * need to change the @Range value with difference of 17 or as required.
	 */
	
	@Range("2650-2664")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal totGross;

	@Range("2665-2679")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal totTaxes;

	@Range("2680-2694")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal totFees;

	@Range("2695-2709")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal totProceeds;

	@Range("2710-2724")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal tot1099B;

	@Range("2725-2739")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal tot1099Div;

	@Range("2740-2754")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal tot1099Int;

	@Range("2755-2769")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal tot1099Mis;

	@Range("2770-2784")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal TOTTAXES5;

	@Range("2785-2800")
	@PaddedStringFormat(padding = Padding.LPAD, paddingChar = '0', size = 17)
	@AssumedDecimalNumberFormat(decimalPlaces = 2)
	private BigDecimal TOTTAXES6;
	
	@Range("2801-2830")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String eventNameAddress1;
	
	@Range("2831-2860")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String eventNameAddress2;
	
	@Range("2861-2890")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String eventNameAddress3;
	
	@Range("2891-2920")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String eventNameAddress4;
	
	@Range("2921-2950")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String eventNameAddress5;
	
	@Range("2951-2980")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String eventNameAddress6;
	
	@Range("2981-3180")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 200)
	private String variableVerbiage;
	
	@Range("3181-3210")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String bankInfo1;
	
	@Range("3211-3240")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String bankInfo2;
	
	@Range("3241-3270")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 30)
	private String bankInfo3;
	
	@Range("3271-3370")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 100)
	private String distributionText;
	
	@Range("3371-3434")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 63)
	private String barCode;
	
	@Range("3435-3454")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 20)
	private String futureUse09;
	
	@Range("3455-3464")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String abaTop;
	
	@Range("3465-3474") // 3492 in file layout
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String abaBottom;
	
	
	public static enum DstoFileType {
		CHECKFILE, PRINTFILE;
	}
}
