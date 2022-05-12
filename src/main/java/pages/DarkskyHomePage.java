package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHomePage extends Base {

    By currentTemp = By.xpath("//span[@class='summary swap']");
    By timelineTemp = By.xpath("//span[@class='first']//span");
    By timeListRaw = By.xpath("//span[@class='hour']/span");

    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timeListStr = getElementTextList(timeListRaw);
        System.out.println(timeListStr);

        ArrayList<Integer> timeList= new ArrayList<>();

        for (int i=0;i<timeListStr.size();i++)
        {
           String rawTimeStr = timeListStr.get(i);  // 10am 0r 2pm
            int l = rawTimeStr.length();

            String timeStr = rawTimeStr.substring(0, l - 2); // 10 or 2

            int time = Integer.parseInt(timeStr);

            timeList.add(time);
        }
        System.out.println(timeList);

        return timeList;
    }

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
