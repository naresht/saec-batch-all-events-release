package com.bfds.saec.batch.file.domain.out.db_stop_payment;


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
import com.bfds.saec.batch.file.domain.in.ss_cashed_check.SsCashedCheckRecJobNotificationVo;
import com.bfds.scheduling.domain.MailingList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component("DBStopPaymentRecJobNotificationHandler")
public class DBStopPaymentRecJobNotificationHandler extends AbstractJobNotificationHandler {

    @PersistenceContext(unitName = "batchFilesEntityManagerFactory")
    EntityManager entityManager;

    @Override
    protected Map<String, Object> getNotificationModel(JobExecution jobExecution) {
        final List<Object[]> results = entityManager.createQuery(getQuery()).setParameter("jobExecutionId", jobExecution.getId()).getResultList();
        Map<String, Object> ret = Maps.newHashMap();
        List<SsCashedCheckRecJobNotificationVo> notificationVoList = Lists.newArrayList();
        ret.put("notificationVoList", notificationVoList);
        for(Object[] row : results) {
            SsCashedCheckRecJobNotificationVo vo = new SsCashedCheckRecJobNotificationVo();
            vo.setDda((String) row[0]);
            vo.setAccountTotalItems(((Long) row[1]).intValue());
            vo.setAccountTotalAmount(new BigDecimal((Double)row[2]).setScale(2, BigDecimal.ROUND_HALF_EVEN));
            vo.setFileDate(new Date());
            notificationVoList.add(vo);
        }
        ret.put(MAILING_LIST,MailingList.findByCode("batch.jobs.deutschebank"));
        ret.put(MAIL_SUBJECT, getDBStopPaymentMailSubject());
        
        return ret;
    }

    @Override
    protected String getVelocityTemplate(JobExecution jobExecution) {
        return "vm/CashedCheckRecJobNotification.vm";
    }

    private String getQuery() {
        String jpaQl =
                "select c.dda, count(c.id),  sum(c.checkAmount)  " +
                "from com.bfds.saec.batch.file.domain.out.db_stop_paymen.DbStopPaymentRec c " +
                " where c.jobExecutionId = :jobExecutionId "+
                " group by c.dda";
        return jpaQl;
    }
	
	private String getDBStopPaymentMailSubject() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
		String currentMonthDateYear = formatter.format(new Date());
		String subject = "DB Stoppayment_" + currentMonthDateYear + "";
		return subject;
	}
}
