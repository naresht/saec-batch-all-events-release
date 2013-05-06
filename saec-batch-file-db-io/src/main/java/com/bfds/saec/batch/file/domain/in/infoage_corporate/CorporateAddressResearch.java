package com.bfds.saec.batch.file.domain.in.infoage_corporate;

import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.annotations.XmlSchemaLocation;
import com.bfds.saec.batch.file.domain.FileItem;
import com.bfds.saec.batch.file.domain.in.infoage.AddressResearchUpdate;
import com.bfds.saec.batch.job.XmlFileToDbJobBuilder;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
        "ofacIndicator",
        "hitIndicator",
        "partialAddressIndicator",
        "matchAnalysisTag",
        "userRef",
        "companyName",
        "fein",
        "phoneAreaCode",
        "phone",
        "phoneExt",
        "address",
        "city",
        "state",
        "zipCode",
        "addressDateReported"
})
@XmlRootElement(name = "CorporateAddressResearch")
@RooJavaBean
@RooToString
@RooJpaEntity
@XmlSchemaLocation("schema/infoage/corporate-address-research.xsd")
@Job(processor = XmlFileToDbJobBuilder.class)
public class CorporateAddressResearch extends FileItem implements AddressResearchUpdate {
    @XmlElement(name = "OFACIndicator")
    protected String ofacIndicator;
    @XmlElement(required = true)
    protected HitIndicatorCorpType hitIndicator;
    @XmlElement(required = true)
    protected String partialAddressIndicator;
    @XmlElement
    protected String matchAnalysisTag;
    @XmlElement(required = true)
    protected String userRef;
    @XmlElement(required = true)
    protected String companyName;
    @XmlElement(name = "FEIN")
    protected String fein;
    @XmlElement
    protected String phoneAreaCode;
    @XmlElement
    protected String phone;
    @XmlElement
    protected String phoneExt;
    @XmlElement
    protected String address;
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

    public Boolean isHit() {
        return HitIndicatorCorpType.Y.equals(this.hitIndicator);
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Partial Address Indicator: ").append(this.getPartialAddressIndicator()).append("\n");
        sb.append("Match Analysis Tag: ").append(this.getMatchAnalysisTag()).append("\n");
        sb.append("Company Name: ").append(getCompanyName()).append("\n");       
        sb.append("FEIN: ").append(getFein()).append("\n");
        sb.append("Phone Area Code: ").append(getPhoneAreaCode()).append("\n");
        sb.append("Phone: ").append(getPhone()).append("\n");
        sb.append("Phone Ext: ").append(getPhoneExt()).append("\n");
        sb.append("Address: ").append(getAddress()).append("\n");
        sb.append("City: ").append(getCity()).append("\n");
        sb.append("State: ").append(getState()).append("\n");
        sb.append("Zip: ").append(getZipCode()).append("\n");
        sb.append("Address Date Reported: ").append(getAddressDateReported()).append("\n");
        return sb.toString();
     }
}
