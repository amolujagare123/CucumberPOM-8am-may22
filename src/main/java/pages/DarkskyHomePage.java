package pages;

import org.openqa.selenium.By;

public class DarkskyHomePage extends Base {

    By currentTemp = By.xpath("//span[@class='summary swap']");
    By timelineTemp = By.xpath("//span[@class='first']//span");

    public String getTimelineTemp()
    {
        String rawTemp = getTextFromElement(timelineTemp); // 91°-> {"91"}
        System.out.println(rawTemp);
        return rawTemp.split("°")[0];
    }
    
    public String getCurrentTemp()
    {
        String rawTemp = getTextFromElement(currentTemp); // 91˚ Clear.-> {"91"," Clear."}
        System.out.println(rawTemp);
        return rawTemp.split("˚")[0];
    }


}
