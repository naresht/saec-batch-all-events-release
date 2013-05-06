package com.bfds.saec.batch.file.domain.in.ss_bottom_line;

import java.util.Date;
import java.util.Map;

import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;

@ContextConfiguration({ "classpath:META-INF/spring/saec-batch-test-context.xml" })
public class SsBottomlineInboundFileImportTest
		extends
		FlatFileImportToJPAIntegrationTemplateTest<SsBottomLineInRec, SsBottomLineInRec, SsBottomLineInRec> {
	@Override
	protected Map<String, Object[][]> getExpectedResults() {
		Map<String, Object[][]> ret = Maps.newHashMap();

		ret.put(DATA_RECORD, new Object[][] { { "fundNumber", "10045" , "10045"},
				{ "checkTypeCode", "M" , "M"}, 
				{ "checkPayeeCode", "P", "P" },
				{ "checkIssueDate", new Date(112, 10, 03), new Date(112, 10, 03) },
				{ "checkAmount", 100d, 200d },
				{ "registrationLine1", "REGISTRATIO11", "REGISTRATIO21" },
				{ "registrationLine2", "REGISTRATIO12" , "REGISTRATIO22"},
				{ "registrationLine5", "REGISTRATIO15" , "REGISTRATIO25"},
				{ "registrationLine7", "REGISTRATIO17" , "REGISTRATIO27"} ,
				{ "rawData","010000000001111111100000010000010010045A001000000110000000         11032012MP   020000000001111111100000010000010010045A000000000010000                         030000000001111111100000010000010010045A000000000000000000000000000000          040000000001111111100000010000010010045AREGISTRATIO11                           050000000001111111100000010000010010045AREGISTRATIO12                           060000000001111111100000010000010010045AREGISTRATIO13                           070000000001111111100000010000010010045AREGISTRATIO14                           080000000001111111100000010000010010045AREGISTRATIO15                           090000000001111111100000010000010010045AREGISTRATIO16                           100000000001111111100000010000010010045AREGISTRATIO17                           ",
							"010000000001111111100000010000010010045A001000000110000000         11032012MP   020000000001111111100000010000010010045A000000000020000                         030000000001111111100000010000010010045A000000000000000000000000000000          040000000001111111100000010000010010045AREGISTRATIO21                           050000000001111111100000010000010010045AREGISTRATIO22                           060000000001111111100000010000010010045AREGISTRATIO23                           070000000001111111100000010000010010045AREGISTRATIO24                           080000000001111111100000010000010010045AREGISTRATIO25                           090000000001111111100000010000010010045AREGISTRATIO26                           100000000001111111100000010000010010045AREGISTRATIO27                           "}});
		
		
		ret.put(ERROR_RECORD,   // TODO: Have error records in other phases.
                new Object[][]
                        {                               
                                {"phase", BatchPhase.READ},
                                {"rawData", "010000000001111111100000010000010010045A001000000120000000         11032012MP   020000000001111111100000010000010010045A000000000030000                         030000000001111111100000010000010010045A000000000000000          040000000001111111100000010000AREGISTRATIO21                           050000000001111111100000010000TIO22                           060000000001111111100000010000010010045AREGISTRATIO23                        070000000001111111100000010000010010045AREGI                           080000000001111111100000010000010010045AREGI                           090000000001111111100000010000010010045AREGISTRATIO26                           100000000001111111100000010000010010045AREGISTRATIO27                           "},
                        });
        return ret;
	}
}
