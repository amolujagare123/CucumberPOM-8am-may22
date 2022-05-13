package pages;

import org.openqa.selenium.By;

public class DarkSkyAPI extends  DarkskyHomePage{

    By lnkLogin = By.xpath("//a[@class='button']");

    public void clickLnkLogin()
    {
        clickOn(lnkLogin);
    }
}
