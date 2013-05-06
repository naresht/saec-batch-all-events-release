package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;


import java.util.Date;
import java.util.Map;

import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;

@ContextConfiguration("classpath:META-INF/spring/saec-batch-test-context.xml")
public class dbStopAcknowledgementFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<StopAcknowledgementRec, StopAcknowledgementHeader, StopAcknowledgementRec> {
    @Override
    protected Map<String, Object[][]> getExpectedResults() {
        Map<String, Object[][]> ret = Maps.newHashMap();

        ret.put(HEADER_RECORD,
                new Object[][]
                        {
                                {"recordType", 'H'},
                                {"fileDate", new Date(111, 8, 8)},
                                {"userId", "USER  ID"},
                                {"status", "Successful"},
                                {"lineNumber", 1},
                                {"rawData","H09082011USER  IDSuccessful                                                     "}

                        });
        ret.put(DATA_RECORD,
                new Object[][]
                        {
                                {"recordType", 'D', 'D', 'D', 'T'},
                                {"count", 10, 10, 10, 3},   // TODO: use different values
                                {"amountCalculated", 55d, 55d, 55d, 165d},  // TODO: use different values, use decimals
                                {"recordId", "DETAIL RECAP", "DETAIL RECAP", "DETAIL RECAP", "Trailer"},  // TODO: use different values
                                {"lineNumber", 2, 3, 5, 6},
                                {"rawData","D00010000000000000005500DETAIL RECAP                                            ",
                                           "D00010000000000000005500DETAIL RECAP                                            ",
                                           "D00010000000000000005500DETAIL RECAP                                            ",
                                           "T00003000000000000016500Trailer                                                 "}

                        });
        ret.put(ERROR_RECORD,   // TODO: Have error records in other phases.
               new Object[][]
                        {
                             {"lineNumber", 4},
                                {"phase", BatchPhase.READ},
                                {"rawData", "DB000001blahblahblah"},
                        });
        return ret;
    }
}
