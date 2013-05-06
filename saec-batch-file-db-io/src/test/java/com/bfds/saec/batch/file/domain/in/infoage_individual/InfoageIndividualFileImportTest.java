package com.bfds.saec.batch.file.domain.in.infoage_individual;

import java.util.Map;

import org.springframework.test.context.ContextConfiguration;

import com.bfds.saec.batch.file.domain.in.FlatFileImportToJPAIntegrationTemplateTest;
import com.google.common.collect.Maps;


@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class InfoageIndividualFileImportTest  extends FlatFileImportToJPAIntegrationTemplateTest<IndividualAddressResearch, IndividualAddressResearch, IndividualAddressResearch> {
    @Override
    protected Map<String, Object[][]> getExpectedResults() {
        Map<String, Object[][]> ret = Maps.newHashMap();
        //TO DO: Need to compare field "dateOfBirth" as well.
        ret.put(DATA_RECORD,
                new Object[][]
                        {
                                {"hitIndicator",HitIndicatorType.N},
                                {"matchIndicator",MatchIndicatorType.H}
                                ,{"ssnMatchTag","S"}
                                ,{"invalidOrDeceasedSSNTag","D"}
                                ,{"nameChangeTag","N"}
                                ,{"matchAnalysisTag","A"}
                                ,{"ofacIndicator","O"}
                                ,{"userRef","10000001"}
                                ,{"ssn","123412341"}
                                ,{"firstName","Bob"}
                                ,{"middleName","A"}
                                ,{"lastName","Sheldon"}
                                ,{"prefix","Mr"}
                                ,{"suffix","Jr"}
                                ,{"maternalName","Bob"}
                               /* ,{"dateOfBirth",new CalendarAdapter().unmarshal("2018-11-01")}*/
                                ,{"phoneAreaCode","617"}
                                ,{"phone","1231234"}
                                ,{"phoneExt","123"}
                                ,{"houseNumber","10"}
                                ,{"preDirection","a"}
                                ,{"postDirection","a"}
                                ,{"thoroughfareName","Throughfare"}
                                ,{"thoroughfareType","xy"}
                                ,{"apartmentNumber","5"}
                                ,{"city","Quincy"}
                                ,{"state","MA"}
                                ,{"zipCode","02139"}
                                ,{"addressDateReported","201101--"}
                        });
        return ret;

    }

}