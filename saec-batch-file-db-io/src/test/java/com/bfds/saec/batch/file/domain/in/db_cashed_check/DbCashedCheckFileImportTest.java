package com.bfds.saec.batch.file.domain.in.db_cashed_check;


import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class DbCashedCheckFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<CashedCheckRec, CashedCheckRec, CashedCheckRec> {
    @Override
    protected Map<String, Object[][]> getExpectedResults() {
        Map<String, Object[][]> ret = Maps.newHashMap();

        ret.put(DATA_RECORD,
                new Object[][]
                        {
                                {"dda", "DB000001", "DB000001", "DB000001"},  //TODO: Use different DDA
                                {"checkNumber", "4881918444", "3608287156", "9999999999"},
                                {"checkAmount", 100d, 25d, 55d}, // TODO: Have decimal numbers
                                {"date", new Date(111, 07, 30), new Date(111, 07, 30), new Date(111, 07, 30)}, //TODO: Use different dates
                                {"itemSeqNumber", "ABCD1001", "ABCD1002", "00000010"},
                                {"lineNumber", 1, 2, 4},
                                {"rawData","DB000001             488191844400000010000110830ABCD1001                        ",
                                           "DB000001             360828715600000002500110830ABCD1002                        ",
                                           "DB000001             99999999990000000550011083000000010                        "}

                        });
        ret.put(ERROR_RECORD,   // TODO: Have error records in other phases.
                new Object[][]
                        {
                                {"lineNumber", 3},
                                {"phase", BatchPhase.READ},
                                {"rawData", "DB000001blahblahblah"},
                        });
        return ret;
    }

}
