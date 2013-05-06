package com.bfds.saec.batch.file.domain.in.infoage_individual;

import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.annotations.XmlSchemaLocation;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.in.infoage.AddressResearchUpdate;
import com.bfds.saec.batch.job.XmlFileToDbJobBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CalendarAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
    "partialAddressIndicator",
    "hitIndicator",
    "matchIndicator",
    "ssnMatchTag",
    "invalidOrDeceasedSSNTag",
    "nameChangeTag",
    "matchAnalysisTag",
    "ofacIndicator",
    "userRef",
    "ssn",
    "firstName",
    "middleName",
    "lastName",
    "prefix",
    "suffix",
    "maternalName",
    "dateOfBirth",
    "phoneAreaCode",
    "phone",
    "phoneExt",
    "houseNumber",
    "preDirection",
    "postDirection",
    "thoroughfareName",
    "thoroughfareType",
    "apartmentNumber",
    "city",
    "state",
    "zipCode",
    "addressDateReported"
})
@XmlRootElement(name = "IndividualAddressResearch")
@RooJavaBean
@RooToString
@RooJpaEntity
@XmlSchemaLocation("schema/infoage/individual-address-research.xsd")
@Job(processor = XmlFileToDbJobBuilder.class)
public class IndividualAddressResearch extends FileItem implements AddressResearchUpdate {

	@XmlElement(required = true)
    protected String partialAddressIndicator;
    @XmlElement(required = true)
    protected HitIndicatorType hitIndicator;
    @XmlElement(required = true)
    protected MatchIndicatorType matchIndicator;
    @XmlElement
    protected String ssnMatchTag;
    @XmlElement
    protected String invalidOrDeceasedSSNTag;
    @XmlElement
    protected String nameChangeTag;
    @XmlElement
    protected String matchAnalysisTag;
    @XmlElement(name = "OFACIndicator")
    protected String ofacIndicator;
    @XmlElement(required = true)
    protected String userRef;
    @XmlElement
    protected String ssn;
    @XmlElement
    protected String firstName;
    @XmlElement
    protected String middleName;
    @XmlElement
    protected String lastName;
    @XmlElement
    protected String prefix;
    @XmlElement
    protected String suffix;
    @XmlElement
    protected String maternalName;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "date")
    protected Calendar dateOfBirth;
    @XmlElement
    protected String phoneAreaCode;
    @XmlElement
    protected String phone;
    @XmlElement
    protected String phoneExt;
    @XmlElement
    protected String houseNumber;
    @XmlElement
    protected String preDirection;
    @XmlElement
    protected String postDirection;
    @XmlElement
    protected String thoroughfareName;
    @XmlElement
    protected String thoroughfareType;
    @XmlElement
    protected String apartmentNumber;
    @XmlElement
    protected String city;
    @XmlElement
    protected String state;
    @XmlElement
    protected String zipCode;
    @XmlElement
    protected String addressDateReported;
    
    @XmlTransient
    @Column(nullable=false)
    private String dda;

    @Override
    public Boolean isHit() {
        return HitIndicatorType.Y.equals(this.hitIndicator);
    }

    @Override
    public String getAddress() {
        StringBuilder address = new StringBuilder();
        if (StringUtils.isNotBlank(getHouseNumber())) {
            address.append(getHouseNumber());
            address.append(" ");
        }
        if (StringUtils.isNotBlank(getPreDirection())) {
            address.append(getPreDirection());
            address.append(" ");
        }
        if (StringUtils.isNotBlank(getThoroughfareName())) {
            address.append(getThoroughfareName());
            address.append(" ");
        }
        if (StringUtils.isNotBlank(getPostDirection())) {
            address.append(getPostDirection());
            address.append(" ");
        }
        if (StringUtils.isNotBlank(getThoroughfareType())) {
            address.append(getThoroughfareType());
            address.append(" ");
        }
        if (StringUtils.isNotBlank(getApartmentNumber())) {
            address.append(" Apt# ");
            address.append(getApartmentNumber());
            address.append(" ");
        }

        return address.toString();
    }

}
