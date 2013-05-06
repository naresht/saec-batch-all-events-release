package com.bfds.saec.batch.file.domain.in.db_stop_confirmation;

import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.file.domain.in.AbstractFixedLengthLineMapperTest;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;


@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
public class DbStopConfirmationLineMapperTest extends AbstractFixedLengthLineMapperTest {

	@Autowired
	private LineMapper<StopConfirmationRec> StopConfirmationRecLineMapper;

	@Test
	public void mapItem() throws Exception {
        final FileItem dto = StopConfirmationRecLineMapper
				.mapLine(
						"D00000000010488191844420110830M0000000010000   S                                ",
						10);
		assertThat(dto).isInstanceOf(StopConfirmationRec.class);

		final StopConfirmationRec expected = new StopConfirmationRec();

		expected.setRecordType('D');
		expected.setDda("1");
		expected.setCheckNumber("4881918444");
		expected.setEffectiveDate(new Date(111, 07, 30));
		expected.setCheckType('M');
		expected.setStopAmount(100d);
		expected.setRejectCode("");
		expected.setTranType('S');
        assertThat(dto).isEqualTo(expected);
		assertThat(EqualsBuilder.reflectionEquals(dto, expected)).isTrue();

	}

   @Test
    public void mapFooter() throws Exception {
        final FileRecord dto = StopConfirmationRecLineMapper
                .mapLine(
                        "T00002000000000000012525                                                        ",
                        5);
       assertThat(dto).isInstanceOf(StopConfirmationFooter.class);
        assertThat(((StopConfirmationFooter)dto).getRecordCount()).isEqualTo(2);
        assertThat(((StopConfirmationFooter)dto).getTotalAmount()).isEqualTo(125.25d);

    }
}
