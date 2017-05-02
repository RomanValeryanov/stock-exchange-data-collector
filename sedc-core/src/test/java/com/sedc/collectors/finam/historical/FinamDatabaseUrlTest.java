package com.sedc.collectors.finam.historical;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/batch/jobs/finam-database-url-test.xml")
public class FinamDatabaseUrlTest {

    private static final Logger LOG = Logger.getLogger(FinamDatabaseUrlTest.class);

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    public FinamDatabaseUrlTest() {
    }

    @Test
    public void testUrl() throws Exception {

        JobExecution execution = jobLauncher.run(job, new JobParameters());
        LOG.info("Exit Status : " + execution.getStatus());
    }
}
