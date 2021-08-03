package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.pages.Search;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.text.ParseException;

public class SearchTest extends Base {
    Search search;

    @Severity(SeverityLevel.CRITICAL)
    @Description("setting the input in the search bar of the application")
    @Test(priority = 1)
    public void getSearch() throws InterruptedException, AWTException {
        search = new Search(driver);
        search.setInput();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Property for Sale in London - Buy Properties in London - Zoopla");
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("To get the list of properties available in the page")
    @Test(priority = 2)
    public void getProperties() throws InterruptedException, ParseException {
        search = new Search(driver);
        search.getValues();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Property for Sale in London - Buy Properties in London - Zoopla");
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("To click on the 5th property and get into the page")
    @Test(priority = 3)
    public void getIntoPage() throws InterruptedException {
        search = new Search(driver);
        search.getPage();
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("To get the link of the agents page and get into that page")
    @Test(priority = 4)
    public void getLink() throws InterruptedException {
        search = new Search(driver);
        search.clickOnTheLink();
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("To get all the properties present in the agents page and check all the properties belong to the same agent")
    @Test(priority = 5)
    public void getAgentsName() {
        search = new Search(driver);
        search.checkAgentProperties();
        boolean bool = search.checkAgentProperties();
        Assert.assertTrue(bool);
    }
}
