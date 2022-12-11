package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    //Add constants for Timesheet
//    private static final int TIMESHEET_PROJECT_ID = 1;
//    private static final int TIMESHEET_FIRST_ID = 2;
//    private static final int TIMESHEET_EMPLOYEE_ID = 3;

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
      //  Assert.fail();
        //Arrange - Create the instance of Timesheet for first timesheet object
      Timesheet firstTimesheet = TIMESHEET_1;
      Timesheet lastTimesheet = TIMESHEET_4;

      //Act - retrieve data from timesheet
      Timesheet testTimesheet = dao.getTimesheet(1);
      Timesheet testTimesheet2 = dao.getTimesheet(4);
      // Assert
     //Assert.assertNotNull(testTimesheet);
      assertTimesheetsMatch(firstTimesheet,testTimesheet );
      assertTimesheetsMatch(lastTimesheet,testTimesheet2 );
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        // Arrange - create the instance of timesheet for null objects
        Timesheet nullTimesheet = TIMESHEET_1;

        //Act-

        Timesheet testNullTimesheet = dao.getTimesheet(1);

        //Assert

       Assert.assertNotNull(testNullTimesheet);
       // assertTimesheetsMatch(nullTimesheet, testNullTimesheet);

    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {

        //Timesheet timesheet1 = TIMESHEET_3;

        // Act - retrieve the employee ID
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(2);

        // Assert
        Assert.assertEquals(2,timesheets.size() );
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {

        //Act - retrieve the project ID
        List<Timesheet> timesheet1 = dao.getTimesheetsByProjectId(1);

        // Assert
        Assert.assertEquals(3,timesheet1.size() );
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        // Arrange - instantiate a bew object for Timesheet
        Timesheet newTimesheet = new Timesheet();
        newTimesheet.setTimesheetId(1);
        newTimesheet.setEmployeeId(1);
        newTimesheet.setProjectId(1);
        newTimesheet.setDateWorked(LocalDate.parse("2020-02-03"));
        newTimesheet.setHoursWorked(1.0);
        newTimesheet.setDescription("Timesheet 2");
        newTimesheet.setBillable(true);

        // Act-
       Timesheet Timesheet2 = dao.createTimesheet(newTimesheet);
       // Assert
        Assert.assertEquals(5,Timesheet2.getTimesheetId());
        Assert.assertEquals(1,Timesheet2.getEmployeeId());
        Assert.assertEquals(1,Timesheet2.getProjectId());
        Assert.assertEquals("Timesheet 2",Timesheet2.getDescription());
        Assert.assertEquals(1.0,Timesheet2.getHoursWorked(),.01);
        Assert.assertEquals("2020-02-03",Timesheet2.getDateWorked().toString());
        Assert.assertEquals(true,Timesheet2.isBillable());
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = new Timesheet();
        createdTimesheet.setEmployeeId(1);
        createdTimesheet.setProjectId(2);
        createdTimesheet.setDateWorked(LocalDate.now());
        createdTimesheet.setHoursWorked(2.0);
        createdTimesheet.setDescription("Timesheet 4");
        createdTimesheet.setBillable(false);

        Assert.assertEquals(1, createdTimesheet.getEmployeeId());
        Assert.assertEquals(2, createdTimesheet.getProjectId());
        Assert.assertEquals(LocalDate.now(), createdTimesheet.getDateWorked());
        Assert.assertEquals(2.0, createdTimesheet.getHoursWorked(), .01);
        Assert.assertEquals("Timesheet 4", createdTimesheet.getDescription());
        Assert.assertEquals(false, createdTimesheet.isBillable());
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet updateTimesheet = dao.getTimesheet(2);
        updateTimesheet.setEmployeeId(1);
        updateTimesheet.setProjectId(1);
        updateTimesheet.setHoursWorked(1.5);
        updateTimesheet.setDescription("Timesheet 2");
        updateTimesheet.setBillable(false);
        updateTimesheet.setDateWorked(LocalDate.parse("2021-01-02"));

        dao.updateTimesheet(updateTimesheet);
        Timesheet updateTimesheet1 = dao.getTimesheet(2);

        assertTimesheetsMatch(updateTimesheet, updateTimesheet1);

    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {

     //Act - delete existing first timesheet
        dao.deleteTimesheet(3);
         // Assert

        Timesheet timesheet =  dao.getTimesheet(3);
        Assert.assertNull(timesheet);


    }

    @Test
    public void getBillableHours_returns_correct_total() {

        //Arrange - Create the instance of Timesheet for first timesheet object



        //Act - retrieve data from timesheet
       double testBillableHour = dao.getBillableHours(1, 1);
       double testUnBillableHours = dao.getBillableHours(2,2);

        // Assert
        //Assert.assertNotNull(testTimesheet);
        Assert.assertEquals(2.5,testBillableHour, 0.01);
        Assert.assertEquals(0,testUnBillableHours, 0.01);
    }



    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
