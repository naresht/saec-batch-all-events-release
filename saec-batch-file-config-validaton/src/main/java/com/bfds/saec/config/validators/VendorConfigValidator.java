package com.bfds.saec.config.validators;

import com.bfds.saec.batch.file.domain.VendorConfig;
import com.bfds.scheduling.domain.JobConfig;
import com.bfds.validation.Validator;
import com.bfds.validation.message.ValidationMessageContext;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

import static com.bfds.saec.config.validators.ValidationUtil.*;

@Component
public class VendorConfigValidator implements Validator {

	@Override
	public void validate(ValidationMessageContext messageContext) {

        final List<VendorConfig> vendorConfigList =  VendorConfig.findAllVendorConfigs();

        if(vendorConfigList.size() != 1) {
            messageContext.error("There must be exactly one entry in VendorConfig. Found %s", vendorConfigList.size());
            return;
        }

        final VendorConfig vendorConfig = vendorConfigList.get(0);

        if(!StringUtils.hasText(vendorConfig.getBankNameOnDstoFile())) {
            messageContext.error("'BankNameOnDstoFile' filed must be set in VendorConfig");
        }

        if(!StringUtils.hasText(vendorConfig.getDeutscheBankUserId())) {
            messageContext.error("'DeutscheBankUserId' filed must be set in VendorConfig");
        }


    }



}
