package com.bfds.saec.batch.file.domain.in.ncoa_link_record;

import javax.persistence.Column;

import org.springframework.roo.addon.configurable.RooConfigurable;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.util.StringUtils;

import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.annotations.PaddedStringFormat;
import com.bfds.saec.batch.annotations.Padding;
import com.bfds.saec.batch.annotations.Range;
import com.bfds.saec.batch.annotations.Ranges;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.job.FlatFileToDbJobBuilder;

/**
 * A NCOA Link flat file record.
 */

@RooJpaEntity(table = "saec_batch_ncoa_link")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })
@Ranges({ @Range(property = FileRecord.UNWANTED_TRAILER_HOLDER, value = "743-1200") })
@Job(processor = FlatFileToDbJobBuilder.class)
public class NCOALinkRec extends FileItem {
	@Range("1-98")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 98)
	private String clientSpecificData;

	@Range("99")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String businessNameIndicator;

	@Range("100")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String businessNameLocation;

	@Range("101-140")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String name;

	@Range("141-180")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String originalPrimaryAddress;

	@Range("181-220")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String originalSecondaryAddress;

	@Range("221-239")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 19)
	private String city;

	@Range("240-241")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String state;

	@Range("242-246")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 5)
	private String zipCode;

	@Range("247-250")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String zipExtn;

	@Range("251-290")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String oldStandardPrimaryAddress;

	@Range("291-330")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String oldStandardSecondaryAddress;

	@Range("331-349")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 19)
	private String oldStandardCity;

	@Range("350-351")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String oldStandardState;

	@Range("352-356")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 5)
	private String oldStandardZipCode;

	@Range("357")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String oldStandardhyphen ;

	@Range("358-361")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String oldStandardZipExtn;

	@Range("362-365")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String oldStandardCarrierRouteCode;

	@Range("366-368")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 3)
	private String oldStandardCdeliveryPointBarCode;

	@Range("369")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String zipCorrectionReasonCode;

	@Range("370")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String zipCorrectionActionCode;

	@Range("371")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String overallProbableCorrectness;

	@Range("372")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String zipExtnReasonCode;

	@Range("373")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String addressProbableCorrectnessCode;

	@Range("374")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String carrierRouteReasonCode;

	@Range("375")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String alternateAddressSchemeIndicator;

	@Range("376")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String cityOrStateReturnCode;

	@Range("377")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String droppedInformationCode;

	@Range("378")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String aliasReturnCode;

	@Range("379")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String addressMatchReturnCode;

	@Range("380")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String apartmentReturnCode;

	@Range("381")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String fileNameReturnCode;

	@Range("382-396")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 15)
	private String newStandardFirstName;

	@Range("397-411")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 15)
	private String newStandardMiddleName;

	@Range("412-431")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 20)
	private String newStandardSurName;

	@Range("432-471")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String newStandardPrimaryAddress;

	@Range("472-511")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 40)
	private String newStandardSecondaryAddress;

	@Range("512-530")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 19)
	private String newStandardCity;

	@Range("531-532")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String newStandardState;

	@Range("533-537")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 5)
	private String newStandardZipCode;

	@Range("538")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String newStandardHyphen;

	@Range("539-542")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String newStandardZipExtn;

	@Range("543-546")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String newStandardCarrierRouteCode;

	@Range("547-549")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 3)
	private String newStandardDeliveryPointBarCode;

	@Range("551")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String typeOfMove;

	@Range("552")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String reserved;

	@Range("553")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String newAddressLevelOfMatch;

	@Range("554-559")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 6)
	private String effectiveMoveDate;

	@Range("560-609")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 50)
	private String previousNIXIECodes;

	@Range("610-611")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String matchReturnCode;
	
	@Range("619-622")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 4)
	private String lotName;	
	
	@Range("623")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String lotAlphabet;

	@Range("624-625")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String lotAlternateSequenceNumber;

	@Range("626")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String lotAlternateHEXSequenceNumber;

	@Range("627-654")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 28)
	private String inputUrbanizationName;

	@Range("655-682")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 28)
	private String oldStandardUrbanizationName;

	@Range("683-710")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 28)
	private String newStandardUrbanizationName;

	@Range("711")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String dmaSuppressionFlag;

	@Range("712")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String dpvReturnCode;

	@Range("713")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String dpvCommercialMailReceivingFlag;

	@Range("714")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 1)
	private String dpvFalseOrPositiveFlag;

	@Range("715-742")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 28)
	private String dpvFootnoteCodeArray;
	
	 @Column(nullable=false)
	 private String dda;


	public String getClaimantRefNumber() {
		String claimantRefNum = getClientSpecificData();
		if (StringUtils.hasText(claimantRefNum)) {
			claimantRefNum = claimantRefNum.substring(8, 17);
		}
		return claimantRefNum;
	 }	
}
