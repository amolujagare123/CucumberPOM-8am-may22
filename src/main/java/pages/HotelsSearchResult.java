package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.driver;
import static stepdefinitions.SharedSD.getDriver;

public class HotelsSearchResult extends Base {

    By ratingBlock = By.xpath("//div[@data-testid='rating-stars']");
    By individualStars = By.xpath("//div[@data-testid='rating-stars']/span");
    By hotelsList = By.xpath("//div[@data-testid='title']");
    By priceList = By.xpath("//div[@data-testid='price-and-discounted-price']//span[contains(@class,'fcab3ed991')]");

    public ArrayList<Integer> getPriceList()
    {
       ArrayList<String> pListRaw = getElementTextList(priceList);
        System.out.println(pListRaw); // ₹ 10,080

        ArrayList<Integer> priceList = new ArrayList<>();

        for (int i=0;i<pListRaw.size();i++)
        {
            String priceWithoutRupeeSymbol = pListRaw.get(i).substring(2); // 10,080
            String priceStr="";

            for (int j=0;j<priceWithoutRupeeSymbol.length();j++)
            {
                if (priceWithoutRupeeSymbol.charAt(j)!=',')
                    priceStr = priceStr + priceWithoutRupeeSymbol.charAt(j);  // "10080"
            }

            int price = Integer.parseInt(priceStr);

            priceList.add(price);

        }

        return priceList;
    }


    public ArrayList<String> getHotelsList()
    {
        return getElementTextList(hotelsList);
    }


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
