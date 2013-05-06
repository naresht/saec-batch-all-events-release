package com.bfds.saec.batch.file.domain.out;

import com.bfds.saec.batch.file.domain.FileRecord;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public abstract class AbstractFlatFileExportFromJPAIntegrationTest<R extends FileRecord> extends AbstractFileExportFromJPAIntegrationTest<R> {

    public  void assertEquals(File actual, File expected) throws IOException {
        List outputValue = FileUtils.readLines((actual), null);
        List expectedValue = FileUtils.readLines(expected, null);
        assertThat(outputValue.size()).isEqualTo(expectedValue.size());
        assertThat(outputValue).contains(expectedValue.toArray());
    }
}
