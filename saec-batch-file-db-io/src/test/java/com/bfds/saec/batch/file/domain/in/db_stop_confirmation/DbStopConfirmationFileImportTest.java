/**
 * 
 */
package com.bfds.saec.batch.file.domain.in.db_stop_confirmation;

import java.util.Date;
import java.util.Map;

import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.BatchPhase;
import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;

@ContextConfiguration("classpath:META-INF/spring/saec-batch-test-context.xml")
public class DbStopConfirmationFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<StopConfirmationRec, StopConfirmationRec, StopConfirmationFooter> {

    @Override
    protected Map<String, Object[][]> getExpectedResults() {
        Map<String, Object[][]> ret = Maps.newHashMap();

        ret.put(DATA_RECORD,
         new Object[][]
                {
                        {"checkNumber", "4881918444", "3608287156"},
                        {"dda", "1", "1"},
                        {"effectiveDate", new Date(111, 7, 30), new Date(111, 7, 30)}, // TODO: Give different dates in file
                        {"checkType", 'M', 'S'},
                        {"stopAmount", 100d, 25.25d},
                        {"rejectCode", "000", "143"}, //TODO: Is 000 equivalent to blanks ?
                        {"tranType", 'S', 'S'}, // TODO: Give different values in file
                        {"lineNumber", 2, 3},
                        {"rawData","D00000000010488191844420110830M0000000010000000S                                ",
                                   "D00000000010360828715620110830S0000000002525143S                                "}

                });
        ret.put(FOOTER_RECORD,
                new Object[][]
                        {
                                {"recordCount", 2},
                                {"totalAmount", 125.25d},
                                {"lineNumber", 5},
                                {"rawData", "T00002000000000000012525                                                        "},
                        });
        ret.put(ERROR_RECORD, // TODO: Have error records in other phases.
                new Object[][]
                        {
                                {"lineNumber", 4},
                                {"phase", BatchPhase.READ},
                                {"rawData", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"},
                        });
        return ret;
    }

}
