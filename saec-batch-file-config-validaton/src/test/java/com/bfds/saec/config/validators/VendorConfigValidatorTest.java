package com.bfds.saec.config.validators;


import com.bfds.saec.batch.file.domain.VendorConfig;
import com.bfds.scheduling.domain.FileConfig;
import com.bfds.scheduling.domain.JobConfig;
import com.bfds.validation.message.DefaultValidationMessageContext;
import com.bfds.validation.message.ValidationMessageContext;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@MockStaticEntityMethods
@RunWith(MockitoJUnitRunner.class)
public class VendorConfigValidatorTest {

    @Test
    public void test() {
        VendorConfig.findAllVendorConfigs();
        AnnotationDrivenStaticEntityMockingControl.expectReturn(getTestVendorConfigs());
        AnnotationDrivenStaticEntityMockingControl.playback();

        VendorConfigValidator validator = new VendorConfigValidator();

        ValidationMessageContext messageContext = new DefaultValidationMessageContext();
        validator.validate(messageContext);

        assertThat(messageContext.getAllMessages()).hasSize(2);
    }

    private List<VendorConfig> getTestVendorConfigs() {
        List<VendorConfig> ret = Lists.newArrayList();
        ret.add(newVendorConfig(null, null));

        return ret;
    }

    private VendorConfig newVendorConfig(String deutscheBankUserId, String bankNameOnDstoFile) {
        VendorConfig ret = new VendorConfig();
        ret.setDeutscheBankUserId(deutscheBankUserId);
        ret.setBankNameOnDstoFile(bankNameOnDstoFile);
        return ret;
    }

}
