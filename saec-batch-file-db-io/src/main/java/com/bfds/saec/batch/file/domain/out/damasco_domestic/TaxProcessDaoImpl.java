package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository("taxProcessDao")
public class TaxProcessDaoImpl implements TaxProcessDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "batchFilesEntityManagerFactory")
	EntityManager entityManager;

	@Override
	public List<OutboundDomesticTaxRec> getAllDamascoOutRecs(Boolean processed,
			boolean includeNull) {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<OutboundDomesticTaxRec> cq = cb
				.createQuery(OutboundDomesticTaxRec.class);
		Root<OutboundDomesticTaxRec> check = cq
				.from(OutboundDomesticTaxRec.class);
		cq.select(check);
		if (includeNull) {
			cq.where(cb.or(cb.equal(check.get("processed"), processed),
					cb.isNull(check.get("processed"))));
		} else {
			cq.where(cb.equal(check.get("processed"), processed));
		}
		final List<OutboundDomesticTaxRec> list = this.entityManager
				.createQuery(cq).getResultList();
		return list;
	}
}