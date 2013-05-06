package com.bfds.saec.batch.file.domain.out.dsto;

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
@Component("DstoRecJobNotificationHandler")
public class DstoRecJobNotificationHandler extends
		AbstractJobNotificationHandler {

	@PersistenceContext(unitName = "batchFilesEntityManagerFactory")
	EntityManager entityManager;

	@Override
	protected Map<String, Object> getNotificationModel(JobExecution jobExecution) {
		final List<Object[]> results = entityManager.createQuery(getQuery())
				.setParameter("jobExecutionId", jobExecution.getId())
				.getResultList();
		Map<String, Object> ret = Maps.newHashMap();
		List<DstoCheckFileRecJobNotificationVo> notificationVoList = Lists
				.newArrayList();
		ret.put("notificationVoList", notificationVoList);
		for (Object[] row : results) {
			DstoCheckFileRecJobNotificationVo vo = new DstoCheckFileRecJobNotificationVo();
			vo.setFileType((String) row[0]);
			vo.setAccountTotalItems(((Long) row[1]).intValue());
			vo.setAccountTotalAmount((BigDecimal) row[2]);
			vo.setFileDate(new Date());
			notificationVoList.add(vo);
		}
		ret.put(MAILING_LIST, MailingList.findByCode("batch.jobs.dsto"));
		ret.put(MAIL_SUBJECT, getDSTOCheckfileMailSubject(jobExecution));
		return ret;
	}

	@Override
	protected String getVelocityTemplate(JobExecution jobExecution) {
		return "vm/DstoCheckFileRecJobNotification.vm";
	}

	private String getQuery() {
		String jpaQl = "select c.dstoFileType, count(c.id),  sum(c.NetAmount1)  "
				+ "from com.bfds.saec.batch.file.domain.out.dsto.DstoRec c "
				+ " where c.jobExecutionId = :jobExecutionId"
				+ " group by c.dstoFileType";
		return jpaQl;
	}

	/**
	 * Since we have 2 batch jobs for DSTO,here we are conditionally changing the mail subject
	 * @param jobExecution
	 * @return string
	 */
	private String getDSTOCheckfileMailSubject(JobExecution jobExecution) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
		String currentMonthDateYear = formatter.format(new Date());
		String subject;
		if(jobExecution.getJobInstance().getJobParameters().getString("queryProviderFilter.dstoFileType").equals("CHECKFILE")){
			subject = "DSTO Check File_" + currentMonthDateYear + "";
		}
		else
		{
			subject = "DSTO Print File_" + currentMonthDateYear + "";
		}
		return subject;
	}
}
