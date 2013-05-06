package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;

import com.bfds.saec.batch.file.domain.in.AbstractFixedLengthLineMapperTest;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration("classpath:META-INF/spring/saec-batch-test-context.xml")
public class dbStopAcknowledgementLineMapperTest extends AbstractFixedLengthLineMapperTest {

    @Autowired
    private LineMapper<?> StopAcknowledgementRecLineMapper;

    @Test
    public void mapHeaderLine() throws Exception {

        StopAcknowledgementHeader dto = (StopAcknowledgementHeader)StopAcknowledgementRecLineMapper
                .mapLine(
                        "H03282012GSPONLI SUCCESSFUL                                                     ",
                        0);
        assertThat(dto).isNotNull();

        StopAcknowledgementHeader expected = new StopAcknowledgementHeader();
        expected.setStatus("SUCCESSFUL");
        expected.setFileDate(new Date(112, 2, 28));
        expected.setUserId("GSPONLI");
        expected.setRecordType('H');

        assertThat(EqualsBuilder.reflectionEquals(dto, expected)).isTrue();
    }

    @Test
    public void mapRecordLine() throws Exception {
        StopAcknowledgementRec dto = (StopAcknowledgementRec)StopAcknowledgementRecLineMapper
                .mapLine(
                        "D00001000000000000000100DETAIL RECAP                                            ",
                        0);
        assertThat(dto).isNotNull();

        StopAcknowledgementRec expected = new StopAcknowledgementRec();
        expected.setAmountCalculated(1d);
        expected.setCount(1);
        expected.setRecordId("DETAIL RECAP");
        expected.setRecordType('D');

        assertThat(EqualsBuilder.reflectionEquals(dto, expected)).isTrue();

    }
}
