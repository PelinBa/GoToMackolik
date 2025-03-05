package pb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Mainn {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/pelinbasormanci/Downloads/drivers/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor javascript = (JavascriptExecutor)driver;

        //Go to the site and maximize the page.
        driver.get("https://www.mackolik.com/canli-sonuclar");
        driver.manage().window().maximize();

        //Wait until the page loads and reject the cookie.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.className("widget-gdpr-banner__reject")).click();

        //Click on football from the header on the home page and click on the fixture text from the dropdown that opens.
        driver.findElement(By.id("aSoccer")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[title='Fikstür']")).click();

        //Scroll down a little and wait until the page loads.
        javascript.executeScript("scrollBy(0,500)");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Click to compare the two teams.
        driver.findElement(By.xpath("//a[@data-alt-href='https://www.mackolik.com/mac/be%C5%9Fikta%C5%9F-vs-alanyaspor/karsilastirma/7vw9nvrsy8vvyvkes8t91gd0']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //This line puts the opened windows in order and helps with window switching.
        Set<String> windowAllWindows = driver.getWindowHandles();

        //This loop equalizes each window opened in the loop to window and helps us perform operations there.
        for(String window:windowAllWindows) {
            driver.switchTo().window(window);
        }

        //It holds the information of the second window that opens.
        String secondWindow = driver.getWindowHandle();

        //Click on any team (Beşiktaş) in the second window.
        driver.findElement(By.cssSelector("img[src='https://file.mackolikfeeds.com/teams/2ez9cvam9lp9jyhng3eh3znb4']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Put the opened windows in order.
        Set<String> windowAllWindows2 = driver.getWindowHandles();

        //Equalize each window opened in the loop to window again.
        for(String window:windowAllWindows2) {
            driver.switchTo().window(window);
        }

        //In the third window that opens, click on the P.Status.
        driver.findElement(By.cssSelector("li[data-tab='tables']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Click on the dropdown containing the years just below.
        driver.findElement(By.className("component-dropdown__custom")).click();
        Thread.sleep(1000);

        //Scroll down a little and select the year 2010/2011 from the dropdown that opens.
        javascript.executeScript("scrollBy(0,500)");
        driver.findElement(By.cssSelector("li[data-value='2010/2011']")).click();
        Thread.sleep(1000);

        //Close the third window that opens and switch to the second window.
        driver.close();
        driver.switchTo().window(secondWindow);

        //Click on the match information section in the banner in the second window.
        driver.findElement(By.xpath("//a[@data-item-id='match']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Click on Basketball from the header above and click on the scoreboard from the dropdown that opens.
        driver.findElement(By.id("aBasketball")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@id='liBasketball']//a[contains(text(),'Puan Durumu')]")).click();

        //Again, click on the TV program from the header and select Thursday on the page that appears.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.id("aTvGuide")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("abbr[title='Perşembe']")).click();
        Thread.sleep(1000);

        //Click on the news section from the header again.
        driver.findElement(By.id("aNews")).click();

        //On the page that opens, wait until the home page text becomes clickable and click on it.
        wait.until(ExpectedConditions.elementToBeClickable(By.className("error-panel__button"))).click();

        //Wait until the page loads and reject the cookie on the old home page.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reject-all-btn"))).click();

        //Type Türkiye in the search field on the top right and click on the second suggestion.
        driver.findElement(By.name("txtSearch")).sendKeys("türkiye");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("img[alt='Türkiye U21']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //On the page that opens, click on any news (2nd news) among the u21 news on the bottom right.
        driver.findElement(By.xpath("//a[text()='U21 Milli Takımı kadrosu açıklandı']")).click();
        Thread.sleep(2000);

        //Just go back to the second window.
        driver.switchTo().window(secondWindow);
        Thread.sleep(2000);

        //Click on the text Maçkolik to return to the home page in the second window.
        driver.findElement(By.className("mackolik-logo")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //On the home page, click on the news under football in the header and go to page 3 below and click on any news (sports headlines of the day) there.
        driver.findElement(By.cssSelector("a[href='//arsiv.mackolik.com/futbol-haberleri']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("a[title='Kayıtlar: 41 - 60']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='//arsiv.mackolik.com/Haber/252666/Gunun-spor-mansetleri']")).click();
        Thread.sleep(2000);

        //Just go back to the second window.
        driver.switchTo().window(secondWindow);
        Thread.sleep(2000);

        //In the second window, click on live results under football in the header.
        driver.findElement(By.xpath("//a[@href='//arsiv.mackolik.com/Canli-Sonuclar']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //On the page that opens, click on the data bank in the header and click on the stadiums in the area that opens below it.
        driver.findElement(By.xpath("//a[text()='Bilgi Bankası']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='//arsiv.mackolik.com/Stadiums/Default.aspx']")).click();
        Thread.sleep(1000);

        //On the page that opens, click on the 'click to go to the new site' text in the top middle and close all the windows that open.
        driver.findElement(By.className("widget-legacy-link-banner__link")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}