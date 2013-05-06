package com.bfds.saec.batch.file.domain.in.infoage;

import java.util.Calendar;

/**
 * The result of perfroming an address research on a given address of a class member.
 * This is currently used only for info age.
 *
 * @see com.bfds.saec.batch.file.domain.in.infoage_corporate.CorporateAddressResearch
 * @see com.bfds.saec.batch.file.domain.in.infoage_individual.IndividualAddressResearch
 */
public interface AddressResearchUpdate {
    public String getUserRef();
    public String getAddress();
    public String getCity();
    public String getState();
    public String getZipCode();
    public String getPhoneAreaCode();
    public String getPhone();
    public String getPhoneExt();
    public Boolean isHit();
    public String getAddressDateReported();
}
