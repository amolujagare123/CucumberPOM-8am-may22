package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkskyHomePage;

import java.util.ArrayList;
import java.util.Collections;

import static stepdefinitions.SharedSD.getDriver;

public class DarkskySD {

    DarkskyHomePage darkskyHomePage = new DarkskyHomePage();
    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals("This is not a darksky page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
        getDriver().getTitle());

          }
    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

        String expected = darkskyHomePage.getCurrentTemp();
        String actual = darkskyHomePage.getTimelineTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("both temperatures are not equal",
                expected,actual);

    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {
        ArrayList<Integer> timeList = darkskyHomePage.getTimeList();

        // [10, 12, 2, 4, 6, 8, 10, 12, 2, 4, 6] --> 11
        ArrayList<Integer> timeDiffList = new ArrayList<>();

        for (int i = 0; i < timeList.size()-1; i++) // 11 times
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);

            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2 - time1;

            if(time2<time1)
                timeDiff = (time2+12) - time1;

            timeDiffList.add(timeDiff);
        }

        System.out.println(timeDiffList);

       /* boolean flag = true;

        for (int i=0;i<timeDiffList.size();i++)
        {
            if(timeDiffList.get(i)!=2)
                flag=false;
        }*/

        int size = timeDiffList.size();
        int occurance = Collections.frequency(timeDiffList,2);

        boolean flag = (size == occurance);

        Assert.assertTrue("All differences are not 2",flag);

    }

    @Then("I verify today's lowest and highest temp is displayed correctly")
    public void iVerifyTodaySLowestAndHighestTempIsDisplayedCorrectly() {

        ArrayList<String> expected = darkskyHomePage.getCurrentTempList();

        ArrayList<String> actual = darkskyHomePage.getTodaysTempList();

        Assert.assertEquals("temperatures are not the proper values",expected,actual);
    }


}
