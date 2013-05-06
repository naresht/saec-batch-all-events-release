package com.bfds.saec.batch.file.domain.in;


import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
//TODO : we need to include the two contexts to allow spring to register RangeArrayPropertyEditor.
@ContextConfiguration({"classpath:META-INF/spring/saec-batch-test-context.xml"})
@TestExecutionListeners({StepScopeTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class AbstractFixedLengthLineMapperTest {

    public StepExecution getStepExecution() {
        return MetaDataInstanceFactory.createStepExecution();
    }

}
