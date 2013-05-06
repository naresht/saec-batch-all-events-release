package com.bfds.saec.batch.file.domain.out.infoage_corporate;

import com.bfds.saec.batch.file.domain.out.infoage.AddressResearchOut;
import com.bfds.saec.batch.job.DbToXmlFileJobBuilder;
import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.file.domain.FileRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="CorporateAddressResearch")
@XmlType(name = "", propOrder = {
        "inputRecord",
        "userRef",
        "fein",
        "companyName",
        "streetAddress",
        "city",
        "state",
        "zipCode"
})
@RooJavaBean
@RooToString
@RooJpaEntity
//TODO: Fix me: schema does not work.
//@XmlSchemaLocation("schema/infoage/corporate-address-research-outbound.xsd")
@Job(processor = DbToXmlFileJobBuilder.class, xmlRootTagName = "OutboundCorporateAddressResearches", xmlRootTagNamespace = "http://saec.bfds.com/schema/infoage")
public class OutboundCorporateAddressResearch extends FileRecord implements AddressResearchOut {

    @XmlElement(required = true)
    protected String inputRecord;
    @XmlElement(required = true)
    protected String userRef;
    @XmlElement(name = "FEIN")
    protected String fein;
    @XmlElement(required = true)
    protected String companyName;
    @XmlElement
    protected String streetAddress;
    @XmlElement
    protected String city;
    @XmlElement
    protected String state;
    @XmlElement
    protected String zipCode;
    
    @XmlTransient
    @Column(nullable=false)
    private String dda;
}
