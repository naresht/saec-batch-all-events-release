package com.bfds.saec.batch.file;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bfds.saec.batch.file.domain.in.damasco_domestic.DamascoInRec;
import com.bfds.saec.batch.file.domain.in.db_cashed_check.CashedCheckRec;
import com.bfds.saec.batch.file.domain.in.db_stop_acknowledgement.StopAcknowledgementRec;
import com.bfds.saec.batch.file.domain.in.db_stop_confirmation.StopConfirmationRec;
import com.bfds.saec.batch.file.domain.in.infoage_corporate.CorporateAddressResearch;
import com.bfds.saec.batch.file.domain.in.infoage_individual.IndividualAddressResearch;
import com.bfds.saec.batch.file.domain.in.ncoa_link_record.NCOALinkRec;
import com.bfds.saec.batch.file.domain.in.ss_bottom_line.SsBottomLineInRec;
import com.bfds.saec.batch.file.domain.in.ss_cashed_check.SsCashedCheckRec;
import com.bfds.saec.batch.file.domain.out.damasco_domestic.OutboundDomesticTaxRec;
import com.bfds.saec.batch.file.domain.out.db_issue_void.DbIssueVoidRec;
import com.bfds.saec.batch.file.domain.out.db_stop_payment.DbStopPaymentRec;
import com.bfds.saec.batch.file.domain.out.dsto.DstoRec;
import com.bfds.saec.batch.file.domain.out.ifds_check_status.IfdsCheckStatusRec;
import com.bfds.saec.batch.file.domain.out.ifds_issue_void.IfdsIssueVoidRec;
import com.bfds.saec.batch.file.domain.out.infoage_corporate.OutboundCorporateAddressResearch;
import com.bfds.saec.batch.file.domain.out.infoage_individual.OutboundIndividualAddressResearch;
import com.bfds.saec.batch.file.domain.out.ncoa_outbound.NCOAOutboundRec;
import com.bfds.saec.batch.file.domain.out.ss_bottomline.SsBottomLineOutRec;
import com.bfds.saec.batch.file.domain.out.ss_issue_void.SsIssueVoidRec;
import com.bfds.saec.batch.file.domain.out.ss_stop_payment.SsStopPaymentRec;
import com.bfds.saec.batch.scheduling.JobConfigFactory;
import com.bfds.saec.util.SubstitutionVars;
import com.bfds.scheduling.domain.JobConfig;
import com.bfds.scheduling.service.SchedulingService;

public class JobConfigRepositoryInitializer {
		
	@Autowired
	@Qualifier("schedulingServiceImpl")
	private SchedulingService schedulingService;

	@Value("${event_admin_enableRepositoryInitializer}")
	private boolean enabled;

	
	@PostConstruct
	@Transactional
	public void initialize() {
		if (!enabled) {
			return;
		}
		loadOutJobConfig();
		loadInJobConfig();
		
		schedulingService.registerHolidays();
		schedulingService.loadJobsAndTriggersConfiguratoin();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void loadOutJobConfig() {
		
		loadDbIssueVoidJobConfig("/Deutsche/Outbound/Deutsche_BankIssuevoidcancel_"+ SubstitutionVars.DDMMYYYYHHmm);
		loadDbStopPaymentJobConfig("/Deutsche/Outbound/Deutsche_Bankstoppayment_"+ SubstitutionVars.DDMMYYYYHHmm);
		loadOutCorpAddressJobConfig("/Infoage/Outbound/InfoAge_corporate_" + SubstitutionVars.DDA + "_" + SubstitutionVars.DDMMYYYYHHMM + "_out.xml");
		loadOutIndividualAddressJobConfig("/Infoage/Outbound/InfoAge_individual_" + SubstitutionVars.DDA + "_" + SubstitutionVars.DDMMYYYYHHMM + "_out.xml");
		loadDstoCheckFileJobConfig("/DSTO/Outbound/dsto_check_"+ SubstitutionVars.DDMMYYYYHHmm);
		loadDstoPrintFileJobConfig("/DSTO/Outbound/dsto_print_"+ SubstitutionVars.DDMMYYYYHHmm);
		loadIfdsCheckStatusJobConfig("/IFDS/Outbound/Frontier_CheckStatus_"+ SubstitutionVars.DDA + "_" + SubstitutionVars.DDMMYYYYHHMM+ "_out");
		loadIfdsIssueVoidJobConfig("/IFDS/Outbound/Frontier_Issuevoid_"+ SubstitutionVars.DDA + "_" + SubstitutionVars.DDMMYYYYHHMM+ "_out");
		loadSsIssueVoidJobConfig("/SSB/Outbound/SSC_ISSUEVOIDCANCEL.txt");
		loadSSstopPaymentJobConfig("/SSB/StopCheck/SSC_STOPPAYMENT.txt");
		loadSsBottomLineOutJobConfig("/SSB/BottomLine/Out/BottomLinefile_"+SubstitutionVars.MMDDYYYY);
		loadNcoaOutJobConfig("/Ncoa/Outbound/NCOA_"+SubstitutionVars.DDMMYYYYHHMM + "_Out_Prc.txt");
		loadDamascoDomesticOutJobConfig("/Damasco/Outbound/Damasco_" + SubstitutionVars.DDA + "_"+"Domestic_"+SubstitutionVars.yyyyMMdd + "_Out.csv");
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void loadInJobConfig() {
		loadDbCashedCheckJobConfig("/Deutsche/Inbound/SAEC_DBPDCK_"+ SubstitutionVars.DDMMYYYYHH24MISSFF3);
		loadDbStopAcknowledgementJobConfig("/Deutsche/Inbound/SAEC_DBStopAck_"+ SubstitutionVars.DDMMYYYYHH24MISSFF3);
		loadDbStopConfirmationJobConfig("/Deutsche/Inbound/SAEC_DBstopconfirm_"+ SubstitutionVars.DDMMYYYYHH24MISSFF3);
		loadSsCashedCheckJobConfig("/SSB/Inbound/SSC_PAIDCHECK.txt");
		loadSsBottomlineInJobConfig("/SSB/Inbound/Bottomline/BottomLinefileupdated.txt");
		//+SubstitutionVars.MMDDYYYY);
		loadInCorpAddressJobConfig("/Infoage/Inbound/InfoAge_corporate_all_" + SubstitutionVars.DDMMYYYYHHMM+ "_in.xml");
		loadInIndividualAddressJobConfig("/Infoage/Inbound/InfoAge_individual_all_"+ SubstitutionVars.DDMMYYYYHHMM+ "_in.xml");
		loadNcoaInJobConfig("/Ncoa/Inbound/NCOA_"+SubstitutionVars.DDMMYYYYHHMM +"_Out_Prc.txt");
		loadDamascoDomesticInJobConfig("/Damasco/Inbound/Damasco_" + SubstitutionVars.DDA + "_"+"Domestic_"+SubstitutionVars.yyyyMMdd + "_In.csv");
		
	}

	private void loadDbIssueVoidJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("DbIssueVoidRecJob", "DB Issue Void", false);	
		jc.getJobParameters().put("fileRecordClass", DbIssueVoidRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Deutsche Bank");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
		jc.flush();
	}

	private void loadDbStopPaymentJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("DbStopPaymentRecJob", "DB Stop Payment",false);
		jc.getJobParameters().put("fileRecordClass", DbStopPaymentRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Deutsche Bank");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getScheduleConfig().setCyclicFlag(Boolean.FALSE);
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}

	private void loadOutCorpAddressJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("OutboundCorporateAddressResearchJob","OutCorporate Address Research", false);
		jc.getJobParameters().put("fileRecordClass", OutboundCorporateAddressResearch.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("InfoAge");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
		
		schedulingService.scheduleJob(jc.merge());
	}
	

	private void loadOutIndividualAddressJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("OutboundIndividualAddressResearchJob","OutIndividual Address Research", false);
		jc.getJobParameters().put("fileRecordClass", OutboundIndividualAddressResearch.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("InfoAge");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

		schedulingService.scheduleJob(jc.merge());
	}
	
	
	private void loadDstoCheckFileJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("DstoRecJob", "DSTO Check File", false);
		jc.getJobParameters().put("fileRecordClass", DstoRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("DSTO");
		jc.getScheduleConfig().setCronExpression("0 0 17-18 * * ?");
		jc.getJobParameters().put("queryProviderFilter.dstoFileType", DstoRec.DstoFileType.CHECKFILE.toString());
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	private void loadDstoPrintFileJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("DstoRecJob", "DSTO Print File", false);
		jc.getJobParameters().put("fileRecordClass", DstoRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("DSTO");
		jc.getScheduleConfig().setCronExpression("0 0 17-18 * * ?");
		jc.getJobParameters().put("queryProviderFilter.dstoFileType", DstoRec.DstoFileType.PRINTFILE.toString());
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	private void loadIfdsCheckStatusJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("IfdsCheckStatusRecJob","IFDS Check Status", false);
		jc.getJobParameters().put("fileRecordClass", IfdsCheckStatusRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("IFDS");
		jc.getScheduleConfig().setCronExpression("0 0 17 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	private void loadIfdsIssueVoidJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("IfdsIssueVoidRecJob", "IFDS Issue Void",false);
		jc.getJobParameters().put("fileRecordClass", IfdsIssueVoidRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("IFDS");
		jc.getScheduleConfig().setCronExpression("0 0 17 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	private void loadSsIssueVoidJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("SsIssueVoidRecJob", "SS Issue Void", false);
		jc.getJobParameters().put("fileRecordClass", SsIssueVoidRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("State Street Bank");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	private void loadSSstopPaymentJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("SsStopPaymentRecJob", "SS Stop Payment",false);
		jc.getJobParameters().put("fileRecordClass", SsStopPaymentRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("State Street Bank");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}
	
	private void loadSsBottomLineOutJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("SsBottomLineOutRecJob", "SS BottomLine Out",false);
		jc.getJobParameters().put("fileRecordClass", SsBottomLineOutRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("State Street Bank");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}
	
	private void loadNcoaOutJobConfig(String fileName) {

		JobConfig jc = JobConfigFactory.newJobConfig("NCOAOutboundRecJob","NCOA Address Send", false);
		jc.getJobParameters().put("fileRecordClass",NCOAOutboundRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("NCOA");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}
	private void loadDamascoDomesticOutJobConfig(String fileName) {

		JobConfig jc = JobConfigFactory.newJobConfig("OutboundDomesticTaxRecJob","Damasco Domestic Outbound", false);
		jc.getJobParameters().put("fileRecordClass",OutboundDomesticTaxRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Damasco");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	
	private void loadDbCashedCheckJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("CashedCheckRecJob", "DB Cashed Check",true);
		jc.getJobParameters().put("fileRecordClass", CashedCheckRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Deutsche Bank");
		jc.getScheduleConfig().setCronExpression("0 0/5 * * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}

	private void loadDbStopConfirmationJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("StopConfirmationRecJob","DB Stop Confirmation", true);
		jc.getJobParameters().put("fileRecordClass", StopConfirmationRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Deutsche Bank");
		jc.getScheduleConfig().setCronExpression("0 0/5 * * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}

	private void loadDbStopAcknowledgementJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("StopAcknowledgementRecJob","DB Stop Acknowledgement", true);
		jc.getJobParameters().put("fileRecordClass", StopAcknowledgementRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Deutsche Bank");
		jc.getScheduleConfig().setCronExpression("0 0/5 * * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}

	private void loadInCorpAddressJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("CorporateAddressResearchJob","Corporate Address Research", true);
		jc.getJobParameters().put("fileRecordClass", CorporateAddressResearch.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("InfoAgo");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

		schedulingService.scheduleJob(jc.merge());

	}

	private void loadInIndividualAddressJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("IndividualAddressResearchJob","Individual Address Research", true);
		jc.getJobParameters().put("fileRecordClass", IndividualAddressResearch.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("InfoAge");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

		schedulingService.scheduleJob(jc.merge());
	}

	private void loadNcoaInJobConfig(String fileName){
		JobConfig jc = JobConfigFactory.newJobConfig("NCOALinkRecJob","NCOA Address Research", true);
		jc.getJobParameters().put("fileRecordClass", NCOALinkRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("NCOA");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

		schedulingService.scheduleJob(jc.merge());
	}
	
	private void loadDamascoDomesticInJobConfig(String fileName){
		JobConfig jc = JobConfigFactory.newJobConfig("DamascoInRecJob","Damasco Domestic Inbound", true);
		jc.getJobParameters().put("fileRecordClass", DamascoInRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("Damasco");
		jc.getScheduleConfig().setCronExpression("0 0 18 * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();
	}


	private void loadSsCashedCheckJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("SsCashedCheckRecJob", "SS Cashed Check",true);
		jc.getJobParameters().put("fileRecordClass", SsCashedCheckRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("State Street Bank");
		jc.getScheduleConfig().setCronExpression("0 0/5 * * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}
	
	private void loadSsBottomlineInJobConfig(String fileName) {
		JobConfig jc = JobConfigFactory.newJobConfig("SsBottomLineInRecJob", "SS BottomLine In",true);
		jc.getJobParameters().put("fileRecordClass", SsBottomLineInRec.class.getName());
		jc.getJobParameters().put("dda", "all");
		jc.setVendorName("State Street Bank");
		jc.getScheduleConfig().setCronExpression("0 0/5 * * * ?");
		jc.getFileConfig().setFilePath(fileName);
		jc.persist();

	}

}
