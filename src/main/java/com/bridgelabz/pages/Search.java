package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Search extends Base {

    @FindBy(xpath = "//*[@id=\"header-location\"]")
    public WebElement search;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button")
    public WebElement searchButton;

    @FindBy(xpath = "//p[@class = 'css-1o565rw-Text eczcs4p0']")
    public List<WebElement> properties;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div[7]/div/section/div/div[1]/p/a")
    public WebElement contactOfAgent;

    @FindBy(xpath = "//div[@class='clearfix']/div[1]/h1/a")
    public WebElement agentName;

    @FindBy(xpath = "//p[@class='top-half listing-results-marketed']/span")
    public List<WebElement> propertiesAgentsName;

    public Search(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void setInput() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Actions actions = new Actions(driver);
        search.click();
        search.sendKeys("London");
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        actions.moveToElement(searchButton).click().build().perform();
        Thread.sleep(2000);
    }
    public void getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < properties.size(); i++) {
            String all_properties = properties.get(i).getText();
            int pricesOfProperties = (int) Double.parseDouble(all_properties.replaceAll("[^(0-9)]+", ""));
            list.add(pricesOfProperties);
            System.out.println("Before Sorting :" +pricesOfProperties);
        }
            Comparator c = Collections.reverseOrder();
            Collections.sort(list, c);
            for (int properties: list) {
                System.out.println("After Sorting :" +properties);
            }
    }
    public void getPage() throws InterruptedException {
        properties.get(4).click();
        Thread.sleep(5000);
    }
    public void clickOnTheLink() throws InterruptedException {
        contactOfAgent.click();
        Thread.sleep(5000);
    }
    public boolean checkAgentProperties(){
        boolean flag = true;
        System.out.println(propertiesAgentsName.size());

        for (WebElement agent: propertiesAgentsName) {
            String[] agent_name = agent.getText().split(",") ;
            System.out.println(agentName.getText());
            System.out.println("agent Name: "+agent_name[0]);
            if (!agent_name[0].equals(agentName.getText())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}

