package com.bfds.saec.batch.file.domain.out.ncoa_outbound;

import javax.persistence.Column;


import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.annotations.PaddedStringFormat;
import com.bfds.saec.batch.annotations.Padding;
import com.bfds.saec.batch.annotations.Range;
import com.bfds.saec.batch.annotations.Ranges;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.job.DbToFlatFileJobBuilder;

@RooJpaEntity(table = "saec_batch_ncoa_outbound")
@RooJavaBean
@RooToString(excludeFields = { "id", "version" })

@Ranges({ @Range(property = "fill(35)", value = "93-127"),
		@Range(property = "fill(3)", value = "340-342"),
		@Range(property = "fill(88)", value = "353-440") })
@Job(processor = DbToFlatFileJobBuilder.class)
public class NCOAOutboundRec extends FileItem {

	@Range("1-57")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 57)
	@Column(nullable = false)
	private String referenceInformation;

	@Range("58-92")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String name;

	@Range("128-302")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 175)
	private String address;

	@Range("303-337")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 35)
	private String city;
	
	@Range("338-339")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 2)
	private String state;

	@Range("343-352")
	@PaddedStringFormat(padding = Padding.RPAD, paddingChar = ' ', size = 10)
	private String zip;
	
    @Column(nullable=false)
    private String dda;

}
