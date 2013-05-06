package com.bfds.saec.batch.file.domain.out;

import com.bfds.saec.batch.file.domain.FileRecord;
import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.ElementNameAndTextQualifier;
import org.custommonkey.xmlunit.XMLUnit;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;

public abstract class AbstractXmlFileExportFromJPAIntegrationTest<R extends FileRecord> extends AbstractFileExportFromJPAIntegrationTest<R> {

    public  void assertEquals(File actual, File expected) throws Exception {

        String expectedStr = FileUtils.readFileToString(expected);
        String actualStr = FileUtils.readFileToString(actual);
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);

        Diff diff = new Diff(expectedStr, actualStr);
        diff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertThat(diff.similar()).isTrue();
    }
}
