package com.bfds.saec.batch.file.domain.out.damasco_domestic;

import java.util.List;

public interface TaxProcessDao {

	public List<OutboundDomesticTaxRec> getAllDamascoOutRecs(Boolean processed,
			boolean includeNull);
}
