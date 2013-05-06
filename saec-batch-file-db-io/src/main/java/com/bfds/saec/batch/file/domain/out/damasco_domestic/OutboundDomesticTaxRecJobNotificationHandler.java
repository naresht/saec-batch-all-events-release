package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import com.bfds.saec.batch.file.domain.in.db_cashed_check.AbstractJobNotificationHandler;
import com.bfds.saec.batch.scheduling.SaecJobParametersBuilder;
import com.bfds.scheduling.domain.MailingList;
import com.google.common.collect.Maps;

@Component("OutboundDomesticTaxRecJobNotificationHandler")
public class OutboundDomesticTaxRecJobNotificationHandler extends
		AbstractJobNotificationHandler {

	@PersistenceContext(unitName = "batchFilesEntityManagerFactory")
	EntityManager entityManager;

	final Logger log = LoggerFactory.getLogger(OutboundDomesticTaxRecJobNotificationHandler.class);
	
	@Override
	protected Map<String, Object> getNotificationModel(JobExecution jobExecution) {
		Map<String, Object> ret = Maps.newHashMap();
		ret.put(MAILING_LIST,MailingList.findByCode("batch.jobs.domestic.outbound"));
		ret.put(MAIL_SUBJECT, getOutboundDomesticTaxMailSubject());
		ret.put(MAIL_ATTACHMENT_NAME, "Outbound Domestic Tax File.csv");
		try {
			ret.put(MAIL_ATTACHMENT,new UrlResource(jobExecution.getJobInstance().getJobParameters().getString(SaecJobParametersBuilder.PARAMETER_OUTPUT_RESOURCE)));
		} catch (MalformedURLException e) {
			log.error(String.format("Error attaching Mail Attachment for for job id:%s with execution id:%s.", jobExecution.getJobId(), jobExecution.getId()));
		} 
		return ret;
	}

	
	@Override
    public void onJobCompleted(JobExecution jobExecution) {
        Map<String, Object> model = getNotificationModel(jobExecution);
       try {
        	super.sendMail("", model);        	
        } catch (Exception e) {
            log.error(String.format("Error reading file for job id:%s with execution id:%s.", jobExecution.getJobId(), jobExecution.getId()));
        }
    }
	
	private String getOutboundDomesticTaxMailSubject() {
		String currentMonthDateYear = getCurrentYearMonDateFormat();
		String subject = "Outbound Domestic Tax_" + currentMonthDateYear + "";
		return subject;
	}

	private String getCurrentYearMonDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentMonthDateYear = formatter.format(new Date());
		return currentMonthDateYear;
	}


	@Override
	protected String getVelocityTemplate(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
