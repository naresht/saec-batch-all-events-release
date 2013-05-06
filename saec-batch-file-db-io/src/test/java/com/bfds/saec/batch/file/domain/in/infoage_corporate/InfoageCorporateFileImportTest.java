package com.bfds.saec.batch.file.domain.in.infoage_corporate;


import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class InfoageCorporateFileImportTest extends FlatFileImportToJPAIntegrationTemplateTest<CorporateAddressResearch, CorporateAddressResearch, CorporateAddressResearch> {
    @Override
    protected Map<String, Object[][]> getExpectedResults() {
        Map<String, Object[][]> ret = Maps.newHashMap();

        ret.put(DATA_RECORD,
                new Object[][]
                        {
                                {"hitIndicator", HitIndicatorCorpType.Y},
                                {"partialAddressIndicator","P"},
                                {"userRef","10000001" },
                                {"companyName","Boston Financial"},
                                {"fein", "9"},
                                {"phoneAreaCode","617" },
                                {"phone","1231234" },
                                {"phoneExt","123"},
                                {"address", "Crown Colony Dr"},
                                {"city","Quincy"},
                                {"state","MA"},
                                {"zipCode","02139" },
                                {"addressDateReported","201101--"}                                
                        });
        return ret;

    }

}
