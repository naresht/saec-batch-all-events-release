package com.bfds.saec.config.validators;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;

import com.bfds.scheduling.domain.FileConfig;
import com.bfds.scheduling.domain.JobConfig;
import com.bfds.validation.message.DefaultValidationMessageContext;
import com.bfds.validation.message.ValidationMessageContext;
import com.google.common.collect.Lists;

@MockStaticEntityMethods
@RunWith(MockitoJUnitRunner.class)
public class JobConfigValidatorTest {
	
	@Before
	public void init() throws Exception {
		(new File("target/X/saec/in")).mkdirs();		
		(new File("target/X/saec/out")).mkdirs();
	}
	
	@After
	public void cleanup() throws IOException {
		FileUtils.forceDelete(new File("target/X/"));
	}
	
	@Test
    public void test() {
        
		JobConfig.findAllJobConfigs();
        AnnotationDrivenStaticEntityMockingControl.expectReturn(getTestJobConfigs());
        AnnotationDrivenStaticEntityMockingControl.playback();

        JobConfigValidator validator = new JobConfigValidator();
        
        ValidationMessageContext messageContext = new DefaultValidationMessageContext();
        validator.validate(messageContext);

        assertThat(messageContext.getAllMessages()).hasSize(4);

    }


    private List<JobConfig> getTestJobConfigs() {
        List<JobConfig> ret = Lists.newArrayList();
        ret.add(newJobConfig("corporateAddressRecevieJob", Boolean.TRUE, "/saec/in/a_<dda>.txt"));
        ret.add(newJobConfig("dbIssueVoidJob", Boolean.FALSE, "/saec/out/b_<dda>.txt"));
        ret.add(newJobConfig("individualAddressReceiveJob", Boolean.TRUE, "/saecX/in/a_<dda>.txt"));
        ret.add(newJobConfig("dbStopPaymentJob", Boolean.FALSE, "/saecX/out/b_<dda>.txt"));

        return ret;
    }

    private JobConfig newJobConfig(String jobId, Boolean incoming, String filePath) {
    	JobConfig ret = new JobConfig();
        ret.setJobId(jobId);
        ret.setIncoming(incoming);
        ret.setFileConfig(new FileConfig());
        ret.getFileConfig().setRootFolder("target/X");
        ret.getFileConfig().setFilePath(filePath);
        return ret;
    }
}
