package com.bfds.saec.batch.file.domain.out.infoage;


/**
 * The interface to be implemented by an address research request class.
 * Currently used only for info age
 *
 * @see com.bfds.saec.batch.file.domain.out.infoage_corporate.OutboundCorporateAddressResearch
 * @see com.bfds.saec.batch.file.domain.out.infoage_individual.OutboundIndividualAddressResearch
 */
public interface AddressResearchOut {

    public void setInputRecord(String inputRecord);

    public void setUserRef(String inputRecord);

    public void setStreetAddress(String streetAddress);

    public void setCity(String city);

    public void setState(String state);

    public void setZipCode(String zipCode);
}
