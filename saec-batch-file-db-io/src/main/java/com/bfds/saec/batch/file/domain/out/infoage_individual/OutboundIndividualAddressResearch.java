package com.bfds.saec.batch.file.domain.out.infoage_individual;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.bfds.saec.batch.file.domain.out.infoage.AddressResearchOut;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.bfds.saec.batch.annotations.Job;
import com.bfds.saec.batch.file.domain.FileRecord;
import com.bfds.saec.batch.job.DbToXmlFileJobBuilder;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="IndividualAddressResearch")
@XmlType(name = "", propOrder = {
    "inputRecord",
    "userRef",
    "ssn",
    "firstName",
    "middleName",
    "lastName",
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
@Job(processor = DbToXmlFileJobBuilder.class, xmlRootTagName = "OutboundIndividualAddressResearches", xmlRootTagNamespace = "http://saec.bfds.com/schema/infoage")
public class OutboundIndividualAddressResearch extends FileRecord implements AddressResearchOut {

	@XmlElement(required = true)
    protected String inputRecord;
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
