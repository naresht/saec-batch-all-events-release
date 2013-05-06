package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.util.SaecDateUtils;
import com.bfds.saec.util.SaecStringUtils;

@RooJpaEntity(table = "saec_batch_outbound_domestic_tax")//, finders = "findOutboundDomesticTaxRecsByPaymentId")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })

public class OutboundDomesticTaxRec extends FileItem implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String dda;

	@Column(nullable = false)
	private Long paymentId;

	private String userType;

	@Column(nullable = false)
	private String referenceNo;
	// Pulled from the Event Config if we enable this functionality. Otherwise
	// default to Damasco.
	private String taxEntity;

	private String name_1;

	private String name_2;

	private String name_3;

	private String name_4;

	private String name_5;

	private String name_6;

	private String address_1;

	private String address_2;

	private String address_3;

	private String address_4;

	private String address_5;

	private String address_6;

	private String city;
	// Class Members address
	private String state;

	private String zip;

	private String checkNumber;

	private String paymentType;

	private BigDecimal totalPaymentAmount;

	private BigDecimal paymentComp1;

	private BigDecimal paymentComp2;

	private BigDecimal paymentComp3;

	private BigDecimal paymentComp4;

	private BigDecimal paymentComp5;

	/**
	 * The description of paymentComp1 that should be the heading of the xls
	 * column
	 */
	@Column(nullable = false)
	private String paymentComp1Description;
	/**
	 * The description of paymentComp2 that should be the heading of the xls
	 * column
	 */
	@Column(nullable = false)
	private String paymentComp2Description;
	/**
	 * The description of paymentComp3 that should be the heading of the xls
	 * column
	 */
	@Column(nullable = false)
	private String paymentComp3Description;
	/**
	 * The description of paymentComp4 that should be the heading of the xls
	 * column
	 */
	@Column(nullable = false)
	private String paymentComp4Description;
	/**
	 * The description of paymentComp5 that should be the heading of the xls
	 * column
	 */
	@Column(nullable = false)
	private String paymentComp5Description;

	private String tin;

	private String certificationStatus;

	private Date certificationDate;

	private String w9Received;

	private String w8Received;

	private String part2Completed;

	private String countryOfResidency;

	private Boolean usCitizen;

	private String certificationType;

	private String taxType;

	private String w8FormType;

	private String stateOfResidency;

	private BigDecimal federalWithholding;

	private Date dob;

	private String organizationOrIndividual;

	private Boolean deceasedFlag;

	private String originalAccountType;

	private Date dateAdded;

	private Date dateSent;

	private Integer itemNumber;

	private String withholdingRequest;

	/**
	 * Each out bound tax record should create a activity record in Account
	 * activity table i.e while sending tax record to tax entity . 
	 * This field is used to check whether the activity record created 
	 * or not
	 * //TODO: hack
	 */
	private Boolean createdActivity;

	public String getError() {
		return null;
	}

	public String getComment() {
		return null;
	}

	public String getInterestStateTax() {
		return null;
	}

	public String getInterestFederalTax() {
		return null;
	}

	public String getStateTax() {
		return null;
	}

	public String getFederalTax() {
		return null;
	}

	public String getTaxesBasedOn() {
		return null;
	}

	public String getDisposition() {
		return null;
	}

	public String getStatus() {
		return null;
	}

	public String getDobasString() {
		if (dob == null) {
			return null;
		}
		return SaecDateUtils.getFormattedDate(dob, "MM/dd/yyyy");
	}

	public String getDateSentasString() {
		return SaecDateUtils.getFormattedDate(dateSent, "MM/dd/yyyy");
	}

	public static OutboundDomesticTaxRec getRecord(Long paymentId) {
        throw new UnsupportedOperationException("getRecord() not supported");
	}

	public String getName() {

		return SaecStringUtils
				.getArrayString(new String[] { this.name_1, this.name_2,
						this.name_3, this.name_4, this.name_5, this.name_6 });
	}

	public String getAddress() {
		return SaecStringUtils.getArrayString(new String[] { this.address_1,
				this.address_2, this.address_3, this.address_4, this.address_5,
				this.address_6 });
	}

	public Boolean getCreatedActivity() {
		return createdActivity;
	}

	public void setCreatedActivity(Boolean createdActivity) {
		this.createdActivity = createdActivity;
	}
}
