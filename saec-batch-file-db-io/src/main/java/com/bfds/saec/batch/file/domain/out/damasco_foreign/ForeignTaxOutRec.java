package com.bfds.saec.batch.file.domain.out.damasco_foreign;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.file.domain.FileItem;

/**
 * 
 * A Damasco Foreing Tax  excel file record.
 * 
 * This class is used to write  data to  Damasco Out bound excel file.
 * 
 * 
 * @author Raghavender B
 */
@RooJpaEntity(table="saec_batch_foreign_tax_out")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})

public class ForeignTaxOutRec extends  FileItem{
	/**
     * The DDA of the event to which this record belongs to.
     */
	private String dda;
	
	/**
	 * File Date From Tax entity.
	 */
	private Date dateReceived; 
	
	/**
	 * Foreign Tax Classification 
	 */
	String foreignTaxClassification;
	
	/**
	 * Fund Account Number.
	 */
	String fundAccount;
	
	/**
	 * 
	 */
	private String bin;
	
	/**
	 * Broker Id
	 */
	private String brokerId;

	/**
	 * 
	 */
	@Column(nullable=false)
	private String parentReferenceNo;
	
	/**
	 *  Tax ID
	 */
	private String tin;
	
	/**
	 * 
	 */
	String electionCode1;
	
	/**
	 *  Settlement Amount.
	 */
	private BigDecimal paymentComp1;
	
	/**
	 * The heading of paymentComp1 excel column
	 */
	private String  paymentComp1Description;
	
	/**
	 * 
	 */
	String electionCode2;
	
	/**
	 *   Fee.
	 */
	private BigDecimal paymentComp2;
	
	/**
	 * The heading of paymentComp2 excel column
	 */
	private String  paymentComp2Description;
	
	/**
	 * 
	 */
	String electionCode3;
	
	/**
	 *  Liquidated dollars(Losses).
	 */
	private BigDecimal paymentComp3;
	
	/**
	 * The heading of paymentComp3 excel column
	 */
	private String  paymentComp3Description;
	
	/**
	 * 
	 */
	String electionCode4;
	
	/**
	 *  Other Monies1.
	 */
	private BigDecimal paymentComp4;
	
	/**
	 * The heading of paymentComp4 excel column
	 */
	private String  paymentComp4Description;
	
	/**
	 * 
	 */
	String electionCode5;
	
	/**
	 *  Other Monies2.
	 */
	private BigDecimal paymentComp5;
	
	/**
	 * The heading of paymentComp5 excel column
	 */
	private String  paymentComp5Description;
	
	/**
	 * 
	 * 
	 */
	@Column(length=55)
	private String parentReg1OrAdd1;
	
	/**
	 * Registration Line 2. 
	 * 
	 */
	@Column(length=55)
	private String parentReg2OrAdd2;
	
	/**
	 * Registration Line 3.
	 * 
	 */
	@Column(length=55)
	private String parentReg3OrAdd3;
	
	/**
	 * Registration Line 4.
	 * 
	 */
	@Column(length=55)
	private String parentReg4OrAdd4;
	
	/**
	 * Registration Line 5.
	 * 
	 */
	@Column(length=55)
	private String parentReg5OrAdd5;
	
	/**
	 * Registration Line 6.
	 * 
	 */
	@Column(length=55)
	private String parentReg6OrAdd6;
	
	
	private String parentReg7OrAdd7;
	
	/**
	 *  City Name
	 */
	private String parentCity;
	
	/**
	 * State Name
	 */
	private String parentState;
	
	
	private String parentZip;
	
	/**
	 *  Zip code of city 
	 */
	private String parentZipCodeExt;
	
	/**
	 * 
	 */
	private String parentCountry;
	
	/**
	 * 
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg1OrAdd1;
	
	/**
	 * Registration Line 2. 
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg2OrAdd2;
	
	/**
	 * Registration Line 3.
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg3OrAdd3;
	
	/**
	 * Registration Line 4.
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg4OrAdd4;
	
	/**
	 * Registration Line 5.
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg5OrAdd5;
	
	/**
	 * Registration Line 6.
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg6OrAdd6;
	
	
	/**
	 * Registration Line 7.
	 * 
	 */
	@Column(length=55)
	private String altPayeeReg7OrAdd7;
	/**
	 *  City Name
	 */
	private String altPayeeCity;
	
	/**
	 * State Name
	 */
	private String altPayeeState;
	
	/**
	 *  Zip code of city 
	 */
	private String altPayeeZip;
	
	/**
	 *  Zip code of city 
	 */
	private String altPayeeZipCodeExt;
	
	
	/**
	 * 
	 */
	private String altPayeeCountry;
	
	/**
	 *  Check Number
	 */
	@Column(nullable = false)
	private String checkNumber;
	
	/**
	 * Date of Original Payment
	 */
	private Date disbursmentDate;
	
	/**
	 * Date Original Payment Made
	 */
	private Date checkDate;
	
	/**
	  * Taxes Based On
	 */
	private String taxesBasedOn;
	
	/**
	 *  Withholding Request
	 */
	private String withHoldingRequest;
	
	/**
	 * The batch number should be assigned when generating out bound file.
	 */
	private Integer batchNumber;
	
	/**
	 * This is just a unique id within the out bound file (kind of like a sequence i.e Row Id).
	 */
	private Integer itemNumber;
	
	/**
	 * 
	 */
	private String rightsFlag;
	
	/**
	 * 
	 */
	private String notesFlag;
	/**
	 * 
	 */
	private String employeeCode;
	
	/**
	 * 
	 */
	private String checkVoid;
	
	/**
	 * 
	 */
	private String futureUse;
	
	/**
	 * 
	 */
	private String groupCode;
	
	/**
	 * 
	 */
	private String restrictedBookShares;
	/**
	 * 
	 */
	private String treassAccount;
	/**
	 * 
	 */
	private String officerCode;
	/**
	 * 
	 */
	private String sensitiveCode;
	
	/**
	 * 
	 */
	private String rightsDollors;
	
	/**
	 * 
	 */
	private String rightsDollors2;
	/**
	 * 
	 */
	private String altPayeeReferenceNo;
	
	/**
	 * 
	 */
	private String disposstion;
	
	/**
	 *  Federal Tax one of with holdings.
	 */
	private BigDecimal federalTax;
	
	/**
	 * Federal Tax Interest, one of with holdings.
	 */
	private BigDecimal federalTaxInterest;



}
