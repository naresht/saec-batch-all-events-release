package com.bfds.saec.batch.file.domain.in.db_cashed_check;

import java.util.Map;

import javax.mail.MessagingException;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.bfds.saec.batch.integration.NotificationHandler;
import com.bfds.saec.util.IMailSender;
import com.bfds.saec.util.IMailingList;
import com.google.common.base.Preconditions;

@RooJavaBean(settersByDefault = false)
public abstract class AbstractJobNotificationHandler implements NotificationHandler {

    public static final String MAIL_SUBJECT = "mailSubject";
    public static final String MAILING_LIST = "mailingList";
    public static final String MAIL_ATTACHMENT_NAME = "mailAttachmentName";
    public static final String MAIL_ATTACHMENT = "mailAttachment";

    @Autowired
    private IMailSender mailSender;
    @Autowired
    private VelocityEngine  velocityEngine;
    
    final Logger log = LoggerFactory.getLogger(AbstractJobNotificationHandler.class);

    @Override
    public void onJobCompleted(JobExecution jobExecution) {
    	if(hasRecords(jobExecution)) {
    		processNofication(jobExecution);
    	} else {
    		processNoficationForNoRecords(jobExecution);
    	}
    }

    
	private boolean hasRecords(JobExecution jobExecution) {
		
		for(StepExecution stepExecution : jobExecution.getStepExecutions()) {
			if(stepExecution.getWriteCount() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is being called when the job processes certain number of records  
	 * from staging to file or file to staging.
	 */
	protected void processNofication(JobExecution jobExecution) {
		Map<String, Object> model = getNotificationModel(jobExecution);
        String template = getVelocityTemplate(jobExecution);;
        String mailContent = getMailContent(template, model);
        try {
        	sendMail(mailContent, model);        	
        } catch (Exception e) {
            log.error(String.format("Error sending notification mail for for job id:%s with execution id:%s.", jobExecution.getJobId(), jobExecution.getId())); 	
        }
	}
	
	/**
	 * This method is being called when the job processes zero records  
	 * from staging to file or file to staging.
	 */
	protected void processNoficationForNoRecords(JobExecution jobExecution) { 
		Map<String, Object> model = getNotificationModel(jobExecution);
		mailSender.send((IMailingList)model.get(MAILING_LIST), (String) model.get(MAIL_SUBJECT), mailContentforNoRecordsProcessed(jobExecution.getJobInstance().getJobName()));
	}

    protected abstract Map<String, Object> getNotificationModel(JobExecution jobExecution);

    protected abstract String getVelocityTemplate(JobExecution jobExecution);

    protected String getMailContent(String template, Map<String, Object> model) {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, model);
    }

    protected void sendMail(String mailContent, Map<String, Object> model) throws MessagingException {
    	Preconditions.checkArgument(model != null, "model is null.");
    	Preconditions.checkArgument(model.get(MAIL_SUBJECT) instanceof String || model.get(MAIL_SUBJECT) == null  , "MAIL_SUBJECT must be of type %s", String.class.getName());
    	if (model.get(MAILING_LIST) != null && model.get(MAILING_LIST) instanceof IMailingList){
    		if(model.get(MAIL_ATTACHMENT)!= null ){
    			mailSender.send((IMailingList)model.get(MAILING_LIST), (String) model.get(MAIL_SUBJECT), mailContent,
    					model.get(MAIL_ATTACHMENT_NAME).toString(), (InputStreamSource)model.get(MAIL_ATTACHMENT));
    		}else{
    			mailSender.send((IMailingList)model.get(MAILING_LIST), (String) model.get(MAIL_SUBJECT), mailContent);
    		}
    	}else {
    		if(model.get(MAILING_LIST) == null) {
    			log.warn(String.format("%s is null.", MAILING_LIST));
            }
            else if(!(model.get(MAILING_LIST) instanceof IMailingList)) {
    			log.warn(String.format("%s must be of type %s and not %s", MAILING_LIST, IMailingList.class.getName()));
            }
    	}                   
    }    
    
    /**
     *This method will return a string giving info that no records were being  
     *processed at a particular job instance.
     */
    private String mailContentforNoRecordsProcessed(String jobName) {
    	return String.format("No records have been processed for job : %s", jobName);
    }
    
}
