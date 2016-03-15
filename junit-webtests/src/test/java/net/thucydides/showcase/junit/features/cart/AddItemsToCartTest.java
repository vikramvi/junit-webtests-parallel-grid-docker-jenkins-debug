package net.thucydides.showcase.junit.features.cart;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.showcase.junit.model.ListingItem;
import net.thucydides.showcase.junit.steps.serenity.BuyerSteps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(SerenityRunner.class)
public class AddItemsToCartTest {
    @Managed
    WebDriver driver;

    @Steps
    BuyerSteps buyer;

    @Test
    public void add_item_to_cart() {
        // GIVEN
        buyer.opens_home_page();
        buyer.searches_by_keyword("docking station");
        buyer.filters_by_local_region();

        // WHEN
        ListingItem selectedItem = buyer.selects_listing(2);
        buyer.adds_current_listing_to_cart();

        // THEN
        buyer.should_see_item_in_cart(selectedItem);
        buyer.should_see_total_including_shipping_for(selectedItem);
    }
    
    @Test
    public void google_test(){
    	try{
	    	WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://www.google.com");
	        WebElement element = driver.findElement(By.name("q"));
	        element.sendKeys("ChromeDriver");
	        element.submit();
	        driver.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}

