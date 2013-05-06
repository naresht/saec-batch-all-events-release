package com.bfds.saec.batch.file.domain.out.ncoa_outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.bfds.saec.batch.file.domain.out.AbstractFlatFileExportFromJPAIntegrationTest;

@ContextConfiguration({ "classpath:META-INF/spring/saec-batch-test-context.xml" })
public class NCOAOutboundFileExportTest extends
		AbstractFlatFileExportFromJPAIntegrationTest<NCOAOutboundRec> {
    @Autowired
    private NCOAOutboundRecDataGenerator ncoaOutboundRecDataGenerator;

	@Override
	protected void createTestData() {
        ncoaOutboundRecDataGenerator.create();
	}
}
