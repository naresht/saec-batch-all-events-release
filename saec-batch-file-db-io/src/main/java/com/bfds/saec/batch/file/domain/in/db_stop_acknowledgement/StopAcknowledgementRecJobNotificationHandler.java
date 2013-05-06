package com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.batch.core.JobExecution;
import org.springframework.stereotype.Component;

import com.bfds.saec.batch.file.domain.in.db_cashed_check.AbstractJobNotificationHandler;
import com.bfds.scheduling.domain.MailingList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component("StopAcknowledgementRecJobNotificationHandler")
public class StopAcknowledgementRecJobNotificationHandler extends AbstractJobNotificationHandler {

    @PersistenceContext(unitName = "batchFilesEntityManagerFactory")
    EntityManager entityManager;

    @Override
    protected Map<String, Object> getNotificationModel(JobExecution jobExecution) {
        final List<Object[]> results = entityManager.createQuery(getQuery()).setParameter("jobExecutionId", jobExecution.getId()).getResultList();
        final String headerStatus = getHeaderStatus(jobExecution.getId());
        Map<String, Object> ret = Maps.newHashMap();
        List<StopAcknowledgementRecJobNotificationVo> notificationVoList = Lists.newArrayList();
        ret.put("notificationVoList", notificationVoList);
        for(Object[] row : results) {
            StopAcknowledgementRecJobNotificationVo vo = new StopAcknowledgementRecJobNotificationVo();
            vo.setStatus(headerStatus);
            vo.setDda((String) row[0]);
            vo.setAccountTotalItems(((Long) row[1]).intValue());
            vo.setAccountTotalAmount(new BigDecimal((Double)row[2]).setScale(2, BigDecimal.ROUND_HALF_EVEN));
            vo.setFileDate(new Date());
            notificationVoList.add(vo);
        }
        
        ret.put(MAILING_LIST,MailingList.findByCode("batch.jobs.deutschebank"));
        ret.put(MAIL_SUBJECT, getSSInboundPaidCheckMailSubject());
        
        return ret;
    }

    @Override
    protected String getVelocityTemplate(JobExecution jobExecution) {
        return "vm/DbStopAcknowledgementRecJobNotification.vm";
    }

    private String getQuery() {
        String jpaQl =
                "select c.dda, count(c.id),  sum(c.amountCalculated)  " +
                "from com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement.StopAcknowledgementRec c " +
                " where c.jobExecutionId = :jobExecutionId AND c.recordType != 'T'"+
                " group by c.dda";
        return jpaQl;
    }
    
    private String getHeaderStatus(Long jobExecutionId) {   	    	
        String jpaQl =
                "select c.status " +
                "from com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement.StopAcknowledgementHeader c " +
                " where c.jobExecutionId = :jobExecutionId ";
        
        return entityManager.createQuery(jpaQl, String.class).setParameter("jobExecutionId", jobExecutionId).getSingleResult();

    }
	private String getSSInboundPaidCheckMailSubject() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
		String currentMonthDateYear = formatter.format(new Date());
		String subject = "DB Stop transmission confirm_" + currentMonthDateYear + "";
		return subject;
	}
	
	
}
