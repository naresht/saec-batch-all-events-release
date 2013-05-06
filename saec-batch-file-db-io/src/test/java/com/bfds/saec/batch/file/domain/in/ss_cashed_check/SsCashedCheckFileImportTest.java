package com.bfds.saec.batch.file.domain.in.ss_cashed_check;

import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.Map;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class SsCashedCheckFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<SsCashedCheckRec, SsCashedCheckRec, SsCashedCheckRec> {
    @Override
    protected Map<String, Object[][]> getExpectedResults() {
        Map<String, Object[][]> ret = Maps.newHashMap();

        ret.put(DATA_RECORD,
                new Object[][]
                        {
                                {"dda", "1", "2"},
                                {"checkNumber", "1", "2"},
                                {"checkAmount", 1d, 2d}, // TODO: Have decimal numbers
                                {"transactionDate", new Date(111, 8, 2), new Date(111, 8, 2)}, //TODO: Use different dates
                                {"additionalData1", "AddtionalData11", "AddtionalData12"},
                                {"additionalData2", "Addtional Data21 for StateStreet Inbound", "Addtional Data22 for StateStreet Inbound"},
                                {"lineNumber", 1, 3},
                                {"rawData","00000000010000000001000000010020110902AddtionalData11Addtional Data21 for StateStreet Inbound                                                                                                           ",
                                           "00000000020000000002000000020020110902AddtionalData12Addtional Data22 for StateStreet Inbound                                                                                                           "
                                 }

                        });
        ret.put(ERROR_RECORD,   // TODO: Have error records in other phases.
                new Object[][]
                        {
                                {"lineNumber", 2},
                                {"phase", BatchPhase.READ},
                                {"rawData", "0000 1110   blah blah"},
                        });
        return ret;
    }
}
