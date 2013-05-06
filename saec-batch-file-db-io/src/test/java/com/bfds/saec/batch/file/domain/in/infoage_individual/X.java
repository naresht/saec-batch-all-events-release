package com.bfds.saec.batch.file.domain.in.infoage_individual;


import java.io.File;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bfds.saec.batch.file.domain.out.infoage_individual.OutboundIndividualAddressResearch;


public class X {

    @Test
    public void testInCorporateAddressResearchGood() {
        Resource resource = new ClassPathResource("schema/infoage/individual-address-research.xsd");
        try {
            JAXBContext jc = JAXBContext.newInstance(IndividualAddressResearch.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File schema = resource.getFile();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            unmarshaller.setSchema(sf.newSchema(schema));

            Resource xml = new ClassPathResource("com/bfds/saec/batch/file/domain/in/infoage_individual/IndividualAddressResearch.txt");
            IndividualAddressResearch addresses = (IndividualAddressResearch) unmarshaller
                    .unmarshal(xml.getInputStream());
            Assert.assertNotNull(addresses);

            junit.framework.Assert.assertEquals("userRef not matched", addresses.getUserRef(), "10000001");
        } catch (Exception e) {
            e.printStackTrace();
            assert (false);
        }
    }

    @Autowired
    private StaxEventItemWriter writer;

    //@Test
    public void testOutCorporateAddressResearchBad() throws Exception{
        Resource resource = new ClassPathResource("schema/infoage/individual-address-research.xsd");

            JAXBContext jc = JAXBContext.newInstance(OutboundIndividualAddressResearch.class);
            Marshaller marshaller = jc.createMarshaller();
            File schema = resource.getFile();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            OutboundIndividualAddressResearch r = new OutboundIndividualAddressResearch();
            r.setUserRef("123456");
            marshaller.setSchema(sf.newSchema(schema));

            StringWriter writer = new StringWriter();
            marshaller.marshal(r, writer);
            System.out.print(writer.getBuffer());



    }


}
