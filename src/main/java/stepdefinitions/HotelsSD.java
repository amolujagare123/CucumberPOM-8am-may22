package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

public class HotelsSD {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

    }

    @When("^I select option for stars as (.+)$") // 5 stars
    public void i_select_option_for_stars_as(String stars)
             {

              hotelsSearchResult.clickStarRating(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$") // 5 stars
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

        int expectedStarRating = Integer.parseInt(stars.split(" ")[0]); // 5
        int actual = hotelsSearchResult.getStarRating();

        System.out.println("expectedStarRating="+expectedStarRating);
        System.out.println("actual="+actual);

        Assert.assertEquals("ratings does not match",expectedStarRating,actual);
    }

    @Then("I verify {string} is within search result")
    public void iVerifyIsWithinSearchResult(String hotelName) {

        ArrayList<String> hotelsList = hotelsSearchResult.getHotelsList();
        boolean flag = false;
        for (int i=0;i<hotelsList.size();i++)
        {
            System.out.println(hotelsList.get(i));

            if (hotelName.equalsIgnoreCase(hotelsList.get(i)))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(hotelName+":the hotel is not in the search result",flag);
    }

    @Then("I verify system displays all hotels within the cost {string}")
    public void iVerifySystemDisplaysAllHotelsWithinTheCost(String minimumCostStr) {

        ArrayList<Integer> priceList = hotelsSearchResult.getPriceList();
        System.out.println(priceList);

        int minimumCost = Integer.parseInt(minimumCostStr);
        boolean flag = true;

        ArrayList<Integer> maxCostList = new ArrayList<>();
        for (int i=0;i<priceList.size();i++)
        {
            if (priceList.get(i)>minimumCost)
            {
                flag = false;
                maxCostList.add(priceList.get(i));
            }
        }

        Assert.assertTrue("some prices are higher below is the list:\n"+maxCostList,flag);
    }
}
