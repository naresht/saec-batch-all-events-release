package com.bfds.saec.batch.file.domain.in.ncoa_link_record;

import java.util.Map;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;

@ContextConfiguration({ "classpath:META-INF/spring/saec-batch-test-context.xml" })
// @Ignore
public class NCOALinkFileImportTest
		extends
		FlatFileImportToJPAIntegrationTemplateTest<NCOALinkRec, NCOALinkRec, NCOALinkRec> {
	@Override
	protected Map<String, Object[][]> getExpectedResults() {
		Map<String, Object[][]> ret = Maps.newHashMap();

		ret.put(DATA_RECORD,
				new Object[][] {
						{ "clientSpecificData", "Sample Client Specific Data" },
						{ "businessNameIndicator", "B" },
						{ "businessNameLocation", "N" },
						{ "name", "Giridhar Sirigiri" },
						{ "originalPrimaryAddress", "Chinnachowk" },
						{ "originalSecondaryAddress", "NGOColony" },
						{ "city", "Kadapa" },
						{ "state", "AP" },
						{ "zipCode", "51600" },
						{ "zipExtn", "2" },
						{ "oldStandardPrimaryAddress", "NGOClony kadapa 516002" },
						{ "oldStandardSecondaryAddress", "Chinnachowk Nellore 500123" },
						{ "oldStandardCity", "Hyderabad" },
						{ "oldStandardState", "AP" },
						{ "oldStandardZipCode", "50003" },
						{ "oldStandardhyphen", "-" },
						{ "oldStandardZipExtn", "2123" },
						{ "oldStandardCarrierRouteCode", "OC" },
						{ "oldStandardCdeliveryPointBarCode", "D" },
						{ "zipCorrectionReasonCode", "A" },
						{ "zipCorrectionActionCode", "A" },
						{ "overallProbableCorrectness", "1" },
						{ "zipExtnReasonCode", "A" },
						{ "addressProbableCorrectnessCode", "0" },
						{ "carrierRouteReasonCode", "A" },
						{ "alternateAddressSchemeIndicator", "U" },
						{ "cityOrStateReturnCode", "A" },
						{ "droppedInformationCode", "W" },
						{ "aliasReturnCode", "R" },
						{ "addressMatchReturnCode", "A" },
						{ "apartmentReturnCode", "A" },
						{ "fileNameReturnCode", "A" },
						{ "newStandardFirstName", "Giridhar" },
						{ "newStandardSurName", "Sirigiri" },
						{ "newStandardPrimaryAddress", "Test Primary Address" },
						{ "newStandardSecondaryAddress", "TestSecondary Address" },
						{ "newStandardCity", "TestCity" },
						{ "newStandardState", "TS" },
						{ "newStandardZipCode", "21453" },
						{ "newStandardHyphen", "-" },
						{ "newStandardZipExtn", "44" },
						{ "newStandardCarrierRouteCode", "ABCD" },
						{ "newStandardDeliveryPointBarCode", "123" },
						{ "typeOfMove", "B" },
						{ "reserved", "F" },
						{ "newAddressLevelOfMatch", "U" },
						{ "effectiveMoveDate", "201206" },
						{ "previousNIXIECodes", "PreviouslyNIXIECodes" },
						{ "matchReturnCode", "01" },
						{ "lotName", "abcd" },
						{ "lotAlphabet", "A" },
						{ "lotAlternateSequenceNumber", "12" },
						{ "lotAlternateHEXSequenceNumber", "3" },
						{ "inputUrbanizationName", "Input Urbanization Name" },
						{ "oldStandardUrbanizationName", "Old Standardized Urbanizatio" },
						{ "newStandardUrbanizationName", "New Standardized Urbanizatio" },
						{ "dmaSuppressionFlag", "Y" },
						{ "dpvReturnCode", "D" },
						{ "dpvCommercialMailReceivingFlag", "Y" },
						{ "dpvFalseOrPositiveFlag", "Y" },
						{ "dpvFootnoteCodeArray", "AA  BB      N1    RR      U1" },
						{ "lineNumber", 1 },
						{"rawData", "Sample Client Specific Data                                                                       BNGiridhar Sirigiri                       Chinnachowk                             NGOColony                               Kadapa             AP516002   NGOClony kadapa 516002                  Chinnachowk Nellore 500123              Hyderabad          AP50003-2123OC  D  AA1A0AUAWRAAAGiridhar                      Sirigiri            Test Primary Address                    TestSecondary Address                   TestCity           TS21453-44  ABCD123 BFU201206PreviouslyNIXIECodes                              01       abcdA123Input Urbanization Name     Old Standardized UrbanizatioNew Standardized UrbanizatioYDYYAA  BB      N1    RR      U1                                                                                                                                                                                                                                                                                                                                                                                                                                                                          " } });

		ret.put(ERROR_RECORD, // TODO: Have error records in other phases.
				new Object[][] {
						{ "lineNumber", 2 },
						{ "phase", BatchPhase.READ },
						{"rawData", "blah blah blahblah blah blahblah blah blahblah blah blahblah blah blahblah blah blahblah blah blah                            " } });

		return ret;
	}

}
