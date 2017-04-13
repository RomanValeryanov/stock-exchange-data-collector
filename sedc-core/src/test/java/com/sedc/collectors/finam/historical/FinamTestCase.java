package com.sedc.collectors.finam.historical;

import com.sedc.core.ListResourceItemReader;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oshulyakov on 4/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/spring/batch/config/test-context.xml",
        "/spring/batch/jobs/finam/finam-historical-load-job.xml"})
public class FinamTestCase {

    @Rule
    public TestName name = new TestName();

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ListResourceItemReader multiResourceReader;

    private List<UrlResource> resources = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        resources.clear();
        multiResourceReader.setResources(resources);

    }

    private JobExecution launchStepFor(String value) throws Exception {
        // write string to temp file
        File f = File.createTempFile(name.getMethodName(), null);
        FileWriter fw = new FileWriter(f);
        fw.write(value);
        fw.close();
        // put temp file in resources
        resources.add(new UrlResource(f.toURI()));

        return jobLauncherTestUtils.launchStep("loadToStage");
    }

    @Test
    public void testCase1() throws Exception {

        JobExecution jobExecution = launchStepFor("GAZP,60,20170224,101500,136.5100000,136.7000000,135.7000000,136.0700000,1063690");
        Assert.assertEquals("Should pass good", ExitStatus.COMPLETED.getExitCode(), jobExecution.getExitStatus().getExitCode());

        Session session = sessionFactory.openSession();
        BigInteger count = (BigInteger) session.createSQLQuery("SELECT count(1) FROM STAGE_FINAM_HISTORICAL WHERE "
                + "SYMBOL = 'GAZP' AND VOLUME = 1063690 AND OPEN = 136.51 AND HIGH = 136.7 AND LOW = 135.7 AND CLOSE = 136.07 "
                + "AND DATE = '2017-02-24' AND TIME = '10:15:00' AND SYM_ID IS NOT NULL").uniqueResult();
        // TODO: Rounded values
        // TODO: Sym_Id is Null
        Query q = session.createSQLQuery("DELETE FROM STAGE_FINAM_HISTORICAL WHERE VOLUME = 1063690");
        q.executeUpdate();
        session.close();
        Assert.assertEquals("Count does not match", 1, count.intValue());
    }

    @Test
    public void testCase2() throws Exception {
        JobExecution jobExecution = launchStepFor("GG,60,20170224,101500,136.5100000,136.7000000,135.7000000,136.0700000,1063690");
        Assert.assertEquals("Wrong SYMBOL, should not pass", ExitStatus.FAILED.getExitCode(), jobExecution.getExitStatus().getExitCode());

        // TODO: Wrong SYMBOL doesn't throws an Exception
        Session session = sessionFactory.openSession();
        Query q = session.createSQLQuery("DELETE FROM STAGE_FINAM_HISTORICAL WHERE SYMBOL = 'GG'");
        q.executeUpdate();
        session.close();
    }

    @Test
    public void testCase3() throws Exception {
        JobExecution jobExecution = launchStepFor("GAZP,60,20170224,101500,aa,136.7000000,135.7000000,136.0700000,1063690");
        Assert.assertEquals("Wrong OPEN, should not pass", ExitStatus.FAILED.getExitCode(), jobExecution.getExitStatus().getExitCode());
    }

    @Test
    public void testCase4() throws Exception {
        JobExecution jobExecution = launchStepFor("GAZP,60,201702224,101500,136.5100000,136.7000000,135.7000000,136.0700000,1063690");
        Assert.assertEquals("Wrong DATE, should not pass", ExitStatus.FAILED.getExitCode(), jobExecution.getExitStatus().getExitCode());
        // TODO: Date format
        Session session = sessionFactory.openSession();
        Query q = session.createSQLQuery("DELETE FROM STAGE_FINAM_HISTORICAL WHERE VOLUME = 1063690");
        q.executeUpdate();
        session.close();
    }

    @Test
    public void testCase5() throws Exception {
        JobExecution jobExecution = launchStepFor("GAZP,60,201000365,101500,136.5100000,136.7000000,1063690");
        Assert.assertEquals("No HIGH, should not pass", ExitStatus.FAILED.getExitCode(), jobExecution.getExitStatus().getExitCode());
    }

    @Test
    public void testCasePeriod() throws Exception {
        JobExecution jobExecution = launchStepFor("GAZP,Z,20170224,101500,136.5100000,136.7000000,135.7000000,136.0700000,1063690");
        Assert.assertEquals("Wrong PER, should not pass", ExitStatus.FAILED.getExitCode(), jobExecution.getExitStatus().getExitCode());

        // TODO: Wrong PER doesn't throws an Exception
        Session session = sessionFactory.openSession();
        Query q = session.createSQLQuery("DELETE FROM STAGE_FINAM_HISTORICAL WHERE VOLUME = 1063690");
        q.executeUpdate();
        session.close();
    }
}
