package com.bfds.saec.batch.file.domain.in;

import com.bfds.saec.batch.file.domain.FileItemError;
import com.bfds.saec.batch.file.domain.FileRecord;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Template method for all file import tests.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class FlatFileImportToJPAIntegrationTemplateTest<R extends FileRecord, H extends FileRecord, F extends FileRecord > extends AbstractFlatFileImportToJPAIntegrationTest<R, H, F> {

    protected static final String DATA_RECORD = "DATA";
    protected static final String HEADER_RECORD = "HEADER";
    protected static final String FOOTER_RECORD = "FOOTER";
    protected static final String ERROR_RECORD = "ERROR";
    /**
     *
     * @param recordList  - The record list(excluding headers and footers) that have to be validated for correctness.
     */
    protected void validateRecordData(List<R> recordList) {
        if(getRecordsComparator() != null) {
            Collections.sort(recordList, getRecordsComparator());
        }
        Object[][] data =  getExpectedResults().get(DATA_RECORD);
        Preconditions.checkNotNull(data != null, "record data to verify is null. Override getExpectedResults() or validateRecordData(List<R> recordList)");
        verifyData(recordList, data);
    }

    /**
     *
     * @return A Comparator that will be used to sort list data befor validation.
     */
    protected Comparator<R> getRecordsComparator() {
        return getDefaultFileRecordComparator();
    }

    private Comparator<R> getDefaultFileRecordComparator() {
        return new Comparator<R>() {
            @Override
            public int compare(R o1, R o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }


    protected void validateHeaderData(H header) {
        Object[][] data =  getExpectedResults().get(HEADER_RECORD);
        Preconditions.checkNotNull(data != null, "header data to verify is null. Override getExpectedHeaderData() or validateHeaderData(H footer)");
        verifyData(Lists.newArrayList(header), data);
    }

    /**
     *
     * @param footer - The footer that must be validated for correctness.
     */
    protected void validateFooterData(F footer) {
        Object[][] data =  getExpectedResults().get(FOOTER_RECORD);
        Preconditions.checkNotNull(data != null, "footer data to verify is null. Override getExpectedFooterData() or validateFooterData(F footer)");
        verifyData(Lists.newArrayList(footer), data);
    }

    @Override
    protected void validateErrorRecordData(List<FileItemError> recordList) {
        if(getErrorRecordsComparator() != null) {
            Collections.sort(recordList, getErrorRecordsComparator());
        }
        Object[][] data =  getExpectedResults().get(ERROR_RECORD);
        if(recordList.size() > 0 && data == null) {
            throw new IllegalStateException("Error data exists but is not expected. Override getExpectedErrorData() verifyErrorRecordData(List<FileItemError> recordList).");
        }
        if(data != null) {
            verifyData(recordList, data);
        }
    }

    /**
     *
     * @return A Comparator that will be used to sort list data befor validation.
     */
    protected Comparator<FileItemError> getErrorRecordsComparator() {
        return new Comparator<FileItemError>() {
            @Override
            public int compare(FileItemError o1, FileItemError o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }


    protected Map<String, Object[][]> getExpectedResults() {
        return new HashMap<String, Object[][]>();
    }

    /**
     *
     * @param list  - The list that must match the dataArray from index 1 to end of array.
     * @param dataArray - An Object[][] where each Object[] has the property name in index 0 and the data in the other indexes.
     */
    protected void verifyData(List<?> list, Object[][] dataArray) {
        for(Object[] dataRec : dataArray) {
            String propertyName =  (String) dataRec[0];
            Object[] data = new Object[dataRec.length - 1];
            System.arraycopy(dataRec, 1, data, 0, data.length);
            assertThat(list).onProperty(propertyName).containsSequence(data);
        }
    }
}
