/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.batch.item.database.orm.JpaQueryProvider;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("DomesticTaxRecHeaderCallback")
@Scope("step")
public class DomesticTaxRecHeaderCallback implements FlatFileHeaderCallback {

	@PersistenceContext(unitName = "batchFilesEntityManagerFactory")
	EntityManager entityManager;

	private JpaQueryProvider queryProvider;

	/**
	 * @param queryProvider
	 *            JPA query provider
	 */
	public void setQueryProvider(JpaQueryProvider queryProvider) {
		this.queryProvider = queryProvider;
	}

	public void writeHeader(Writer writer) throws IOException {
		OutboundDomesticTaxRec rec = getFirstRecord();
		if (rec != null) {
			String header = "STATUS,REFERENCE NO,TAX ENTITY,CHECK NUMBER,BATCH NUMBER,ITEM NUMBER,ORIGINAL ACCOUNT TYPE,"
					+ "REGISTRATION LINE 1,REGISTRATION LINE 2,REGISTRATION LINE 3,REGISTRATION LINE 4,"
					+ "ADDRESS LINE1,ADDRESS LINE2,ADDRESS LINE3,"
					+ "CITY,STATE,ZIP,COUNTRY OF RESIDENCY,DATE OF BIRTH,US CITIZEN,TAX ID,W9 RECEIVED,W8 RECEIVED,W-8 Type,"
					+ "W-8 PART II COMPLETE,DECEASED FLAG,WITH HOLDING REQUEST,FEDERAL WITHHOLDING,REISSUE DATE,PAYMENT AMOUNT,"
					+ rec.getPaymentComp1Description()
					+ ","
					+ rec.getPaymentComp2Description()
					+ ","
					+ rec.getPaymentComp3Description()
					+ ",STATE OF RESIDENCY,TAXES BASED ON,FEDERAL TAX, STATE TAX,INTEREST FEDERAL TAX,INTEREST STATE TAX,DISPOSITION,"
					+ "COMMENT,ERROR,ORGANIZATION/INDIVIDUAL FLAG";
			writer.write(header);
		}
	}

	private OutboundDomesticTaxRec getFirstRecord() {
		OutboundDomesticTaxRec rec = null;
		queryProvider.setEntityManager(entityManager);
		Query query = queryProvider.createQuery()
				.setMaxResults(1);
		List<?> resultList = query.getResultList();
		if (resultList.size() > 0) {
			rec = (OutboundDomesticTaxRec) resultList.get(0);
		}
		return rec;

	}

}
