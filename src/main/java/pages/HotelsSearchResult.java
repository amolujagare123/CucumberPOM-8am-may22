package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static stepdefinitions.SharedSD.driver;
import static stepdefinitions.SharedSD.getDriver;

public class HotelsSearchResult extends Base {

    By ratingBlock = By.xpath("//div[@data-testid='rating-stars']");
    By individualStars = By.xpath("//div[@data-testid='rating-stars']/span");


    public void clickStarRating(String star)
    {
        By rating = By.xpath("//div[@data-filters-group='class']//input[@name='class="+star+"']");
       //clickOn(rating);

       JavascriptExecutor js = (JavascriptExecutor) getDriver();
       js.executeScript("arguments[0].click()",webAction(rating));

    }


    public int getStarRating()
    {
        getDriver().navigate().refresh();
        int allStars = driver.findElements(individualStars).size();
        System.out.println("allStars="+allStars);
        int allRatings = driver.findElements(ratingBlock).size();
        System.out.println("allRatings="+allRatings);
        return  allStars/allRatings;
    }
}
