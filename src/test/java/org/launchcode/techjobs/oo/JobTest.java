package org.launchcode.techjobs.oo;


import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job test_Job = new Job();
        Job test_Job2 = new Job();
        assertNotEquals(test_Job, test_Job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String s= System.lineSeparator();
        System.out.println(testJob.toString());
        assertEquals(testJob.toString().indexOf(s),0);
        assertEquals(testJob.toString().lastIndexOf(s), testJob.toString().length() - 2);
        //-2 because line separator appears to be two in length? Internet says it is basically \r\n in Windows, so one for the 0 index vs length, and another for the two part index? Not entirely sure.
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.toString().contains("Product tester"));
        assertTrue(testJob.toString().contains("ACME"));
        assertTrue(testJob.toString().contains("Desert"));
        assertTrue(testJob.toString().contains("Quality control"));
        assertTrue(testJob.toString().contains("Persistence"));
        assertTrue(testJob.toString().contains("ID:"));
        assertTrue(testJob.toString().contains("Name:"));
        assertTrue(testJob.toString().contains("Employer:"));
        assertTrue(testJob.toString().contains("Position Type"));
        assertTrue(testJob.toString().contains("Core Competency"));
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String text = testJob.toString();
        assertTrue(text.contains("Data not available"));
    }

    @Test
    public void testToStringHandlesAllEmptyFields(){
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String text = testJob.toString();
        assertTrue(text.contains("OOPS! This job does not seem to exist."));
    }
}
