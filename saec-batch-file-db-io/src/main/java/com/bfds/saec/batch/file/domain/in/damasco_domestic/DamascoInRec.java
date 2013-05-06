package com.bfds.saec.batch.file.domain.in.damasco_domestic;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.file.domain.FileItem;
/**
 * 
 * A Damasco excel file record.
 * 
 * This class is used to read data from Damasco In bound excel file.
 * 
 * 
 * @author Raghavender B
 *
 */
@RooJpaEntity(table="saec_batch_damasco")
@RooJavaBean
@RooToString(excludeFields = {"id", "version"})
public class DamascoInRec extends FileItem{
	
	/**
     * The DDA of the event to which this record belongs to.
     */
	private String dda;
	
	/**
	 * This field is provided by Damasco in the In bound file.
	 */
	private String status;
	
	/**
	 *  Account Cross Reference Number(i.e saec Ref #)
	 */
	private String referenceNo;
	
	/**
	 * 
	 *  vendor name of Tax calculation and this value is provided by vendor 
	 *  ex: Damasco.
	 *  
	 */
	private String taxEntity;
	
	/**
	 *  Check Number
	 */
	@Column(nullable = false)
	private String checkNumber;
	
	/**
	 * The batch number should be assigned when generating out bound file.
	 */
	private Integer batchNumber;
	
	/**
	 * This is just a unique id within the out bound file (kind of like a sequence i.e Row Id).
	 */
	private Integer itemNumber;
	
	/**
	 * Original Account Type
	 */
	private String originalAccountType;
	
	/**
	 * Registration Line 1.
	 * 
	 */
	@Column(length=55)
	private String name1;
	
	/**
	 * Registration Line 2. 
	 * 
	 */
	@Column(length=55)
	private String name2;
	
	/**
	 * Registration Line 3.
	 * 
	 */
	@Column(length=55)
	private String name3;
	
	/**
	 * Registration Line 4.
	 * 
	 */
	@Column(length=55)
	private String name4;
	
	/**
	 * Registration Line 5.
	 * 
	 */
	@Column(length=55)
	private String name5;
	
	/**
	 * Registration Line 6.
	 * 
	 */
	@Column(length=55)
	private String name6;
	
	/**
	 *  Address Line 1
	 */
	private String addressLine1;
	
	/**
	 *  Address Line 2
	 */
	private String addressLine2;
	
	/**
	 *  Address Line 3
	 */
	private String addressLine3;
	
	/**
	 *  Address Line 4
	 */
	private String addressLine4;
	
	/**
	 *  Address Line 5
	 */
	private String addressLine5;
	
	/**
	 *  Address Line 6
	 */
	private String addressLine6;
		
	/**
	 *  City Name
	 */
	private String city;
	
	/**
	 * State Name
	 */
	private String state;
	
	/**
	 *  Zip code of city 
	 */
	private String zip;
	
	/**
	 *  Claimant's Date of Birth.
	 */
	private Date dateOfBirth;
	
	/**
	 *  claimant US Citizen or Not  
	 */
	private Boolean usCitizen;
	
	/**
	 *  Tax ID
	 */
	private String tin;
	
	/**
	 *  w9 Tax form received or not.
	 */
	private String w9Recived;

	/**
	 * w8 Tax form received or not.  
	 */
	private String w8Recived;
	
	/**
	 *  w8 Tax form type.
	 */
	private String w8FormType;
	
	/**
	 *  W8 Form Part 2 completed or not.  
	 */
	private String part2Completed;
	
	/**
	 *  Country Of Tax Residency.
	 */
	private String countryOfTaxResidency;
	
	/**
	 *  Claimant has decease .
	 */
	
	private Boolean deceasedFlag;
	
	/**
	 *  Withholding Request
	 */
	private String withHoldingRequest;
	
	/**
	 *  Federal With  Holding.	
	 */
	private BigDecimal federalWithHolding;
	
	/**
	 *  Reissue Date
	 */
	private Date reissueDate;
	
	/**
	 *  Total Payment Amount
	 */
	private BigDecimal totalPayment;
	
	/**
	 *  Settlement Amount.
	 */
	private BigDecimal paymentComp1;
	
	/**
	 * The heading of paymentComp1 xls column
	 */
	private String  paymentComp1Description;
	
	/**
	 *  Advisory Fee.
	 */
	private BigDecimal paymentComp2;
	
	/**
	 * The heading of paymentComp2 xls column
	 */
	private String  paymentComp2Description;
    
	/**
     * Interest Amount
     */
	private BigDecimal paymentComp3;
	
	/**
	 * The heading of paymentComp3 xls column
	 */
	private String  paymentComp3Description;
	
	/**
	 * Other Money used for Foreign tax file. 
	 */
	private BigDecimal paymentComp4;
	
	/**
	 * The heading of paymentComp4 xls column
	 */
	//@Column(nullable=false)
	//private String  paymentComp4Description;
	
	/**
	 * Other Money used for Foreign tax file. 
	 */
	private BigDecimal paymentComp5;
	
	/**
	 * The heading of paymentComp5 xls column
	 */
	//@Column(nullable=false)
	//private String  paymentComp5Description;
	
	/**
	 * Class Members state of Residency.
	 */
	private String stateOfResidency;

	/**
	  * Taxes Based On
	 */
	private String taxesBasedOn;
	
	/**
	 *  Federal Tax
	 */
	private BigDecimal federalTax;
	
	/**
	 * State Tax.
	 */
	private BigDecimal stateTax;
	
	/**
	 * Interest Federal Tax.
	 */
	private BigDecimal interestFederaltax;
	
	/**
	 * Interest State Tax.
	 */
	private BigDecimal interestStatetax;
	
	/**
	 * Disposition.
	 */
	private String disposition;
	/**
	 * Comment
	 */
	private String comment;
		
	/**
	 *  Error
	 */
	private String error;
	
	/**
	 * Organization Or INdividual
	 */
	private String organizationOrIndividual;
	
	private String taxType;
	
	private String certificationType;
	
	private String certificationStatus;
	
	private String paymentType;

	private Date dateAdded;
	
	
	
	
	

    /**
     * A DamascoInRec is eligible for processing only if  {@link DamascoInRec#disposition} has one of the follwoing values
     *
     * 1. "Ok to reissue with withholding"
     * 2. "Ok to reissue without withholding"
     * @return true if this object can be processed by the target event.
     */
    public boolean canProcess() {
        return "Ok to reissue with withholding".equalsIgnoreCase(this.disposition) ||
               "Ok to reissue without withholding".equalsIgnoreCase(this.disposition);
    }

    public BigDecimal computeGrossAmount() {
            return add(paymentComp1, paymentComp2, paymentComp3, paymentComp4, paymentComp5);
    }

    public BigDecimal computeNettAmount() {
        BigDecimal ret = new BigDecimal(0);
        if(canComputeNettAmout()) {
            BigDecimal grossAmount =  computeGrossAmount();
            ret = add(ret, grossAmount);

            BigDecimal witholdings = add(federalTax, stateTax, interestFederaltax, interestStatetax);
            witholdings = witholdings == null ? new BigDecimal(0) : witholdings;
            ret = ret.subtract(witholdings);
        }else{
        
        	ret =computeGrossAmount();
         }
        
        return ret.equals(new BigDecimal(0)) ? null : ret;
    }


    private boolean canComputeNettAmout() {
        return "G".equalsIgnoreCase(taxesBasedOn) || "I".equalsIgnoreCase(taxesBasedOn) || "A".equalsIgnoreCase(taxesBasedOn);
    }

    private BigDecimal add(BigDecimal... vals) {
        BigDecimal ret = new BigDecimal(0);
        for(BigDecimal val : vals) {
          if(val != null) {
              ret = ret.add(val);
          }
        }
        return ret.equals(new BigDecimal(0)) ? null : ret;
    }

	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DamascoInRec that = (DamascoInRec) o;

        if( (checkNumber != null ? !checkNumber.equals(that.checkNumber) : that.checkNumber != null)
        	&& (dda != null ? !dda.equals(that.dda) : that.dda != null))
        	return false;

        return true;
    }

    @Override
    public int hashCode() {
    	int hash = checkNumber != null ? checkNumber.hashCode() : 0;
    		hash = hash *( dda != null ? dda.hashCode() : 0);
        return hash;
    }

	

}
