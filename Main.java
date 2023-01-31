import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class Main {
    public static <JavasciptExecutor> void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chrome driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://neverland.freshprints.com/dashboard/login/");
        driver.manage().window().maximize();
        driver.findElement(By.id("form-email")).sendKeys("interns2022@freshprints.com");
        driver.findElement(By.id("form-password")).sendKeys("interns2022");
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.className("icon-users4")).click();
        System.out.println("successfully completed freshprints login\n");
        //search box is clickable or not
        // driver.get("https://v4-qa.freshprints.com/dashboard/users?login=$2a$10$rpJpCaW/G93yf735hB5zSuty6rRwIZ7jeabPgVZ9pTBhlxTbpzOri");
        //driver.get("https://v4-qa.freshprints.com/dashboard/users\n");
        Thread.sleep(2000);
        String expURL = "https://v4-qa.freshprints.com/dashboard/users";
        driver.get(expURL);
        String expWindow = driver.getWindowHandle();
        System.out.println(expWindow);
        Thread.sleep(5000);
        Set<String> allwindows = driver.getWindowHandles();
        for (String eachWindow : allwindows) {
            System.out.println(eachWindow);
            if (eachWindow.equalsIgnoreCase(expWindow)) {
                driver.switchTo().window(eachWindow);
            }
        }
    // counting number of pills
        List<WebElement> pills=driver.findElements(By.cssSelector(".tabs__tab.cursor-pointer "));
        System.out.println("Number of pills in users modele --> "+pills.size());
        
        
        //searchbox
        WebElement swa = driver.findElement(By.xpath("(//input[@placeholder='Search by name, org, email etc'])[1]"));
        /*//*[@id='sticky-search-filter']/app-search-filter/div[1]/div/div/label/input*/
        swa.click();
        Thread.sleep(3000);
        swa.sendKeys("swapna");
        System.out.println("successfully clicking and entering details on searchbox");
        
        
        //Clicking on filter icon
        driver.findElement(By.cssSelector("  #desktop-filter-button > a > label")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#desktop-filter-button > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#desktop-filter-button > ul > li.filter-submenu.ng-star-inserted.show.dropdown > ul > li > div > app-select > div > ng-select > div > div > div.ng-input > input[type=text]")).sendKeys("Abil");
       
        System.out.println("Successfully clicking on filter icon and entering details");
        Thread.sleep(10000);

        //all active data in lexiographic order
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ngx-datatable-basic\"]/div/datatable-header/div/div[2]/datatable-header-cell[1]/div/span[2]")).click();
        System.out.println("all data in lexiographic orderby name ");

        //counting filter icon list
        driver.findElement(By.cssSelector("  #desktop-filter-button > a > label")).click();
        Thread.sleep(2000);
        List<WebElement> items=driver.findElements(By.cssSelector(".dropdown-toggle.dropdown-item.ng-star-inserted"));
        System.out.println("number of list items in a filters icon "+items.size());

        //navigating to proofs
         Thread.sleep(5000);
         driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/div/a[1]/div")).click();
        if(driver.getPageSource().contains("Proof Details")) {
            System.out.println("navigated to proof page");
            driver.findElement(By.xpath("/html/body/app-half-overlay/div/div/app-create-proof-wizard/div/div[1]/div/i")).click();
        }

        else
            System.out.println("error");


       // driver.findElement(By.xpath("/html/body/app-half-overlay/div/div/app-create-proof-wizard/div/div[1]/div/i")).click();
   
        //+ button
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"sticky-search-filter\"]/div[2]/app-button[2]/button")).click();
        // new admin creation
        driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/app-wizard-create-select/div/div[1]")).click();
       Thread.sleep(5000);
        WebElement name=driver.findElement(By.xpath("//*[@id=\"null\" and @placeholder=\"e.g. Abram Pattrick\"]"));
        name.click();
        name.sendKeys("Jaswanth Krishna");
        Thread.sleep(3000);
        WebElement name2=driver.findElement(By.xpath("//*[@id=\"null\" and @placeholder=\"e.g. +1(917)720-7465\"]"));
        name2.click();
        name2.sendKeys("9121725985");
        Thread.sleep(3000);
        WebElement name3=driver.findElement(By.xpath("//*[@id=\"null\" and @placeholder=\"e.g. abram@gmail.com\"]"));
        name3.click();
        name3.sendKeys("Jasah@gmail.com");
        /*  WebElement name4=driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div/app-campus-manager/div/div/aw-wizard/div/aw-wizard-step[1]/div/div[3]/div/div[2]/app-manager-mapping/div/app-select/div[1]/ng-select/div/div/div[2]/input"));
        name4.click();
        name4.sendKeys("S");*/

        //driver.findElement(By.xpath("//*[@id=\"aa0b31b7d0e4-0\"]/span")).click();
        driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div[1]/app-admin/div/div/aw-wizard/div/aw-wizard-step[1]/div/div[3]/app-button/button")).click();

        // driver.findElement(By.cssSelector("body > app-custom-overlay > div > div > div.user-creation-wizard-steps.ng-tns-c140-3.ng-invalid.ng-star-inserted.ng-dirty.ng-touched > div > app-campus-manager > div > div > aw-wizard > div > aw-wizard-step:nth-child(1) > div > div.contact-info-form.mx-auto.ng-star-inserted > app-button > button > span")).click();
       Thread.sleep(3000);
        WebElement pass=driver.findElement(By.xpath("//*[@id=\"null\" and @placeholder=\"Enter password\"] "));
        pass.click();
        pass.sendKeys("Jassu");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div[1]/app-admin/div/div/aw-wizard/div/aw-wizard-step[2]/div/div[2]/div/div[3]/app-set-password/div/div[1]/div[2]/i[1]")).click();
        WebElement pass2=driver.findElement(By.xpath("//*[@id=\"null\" and @placeholder=\"Confirm password\"] "));
        pass2.click();
        pass2.sendKeys("Jassu");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[2]/div[1]/app-admin/div/div/aw-wizard/div/aw-wizard-step[2]/div/div[2]/div/div[3]/app-button/button/span")).click();
        Thread.sleep(2000);
        //boolean x=driver.findElement(By.xpath("body > app-custom-overlay > div > div > div.edit-user__header.center-inner-div.ng-tns-c140-3 > div:nth-child(2) > div"));
        if(driver.getPageSource().contains("Account Created!"))
            System.out.println("user created");
        else
            System.out.println("user existed");

        Thread.sleep(5000);
        //driver.findElement(By.xpath("/html/body/app-custom-overlay/div/div/div[1]/i")).click();
        ///html/body/ngb-modal-window/div/div/div[3]/button[2]
        System.out.println("successfully checking the admin creation");
        driver.navigate().back();
        Thread.sleep(5000);


        //navigation to order page
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/div/a[2]/div")).click();
        Thread.sleep(3000);
        if(driver.getPageSource().contains("What type of order are you placing?")) {
            System.out.println("navigated to order page");
            List<WebElement> count=driver.findElements(By.xpath("/html/body/app-custom-overlay/div/div/app-create-order/div/div[2]/a"));
            System.out.println("type of orders count-->"+count.size());
        }
        else
            System.out.println("error");
        driver.navigate().back();


        // click on logout
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"userdropdown-info\" and text()=\"Fp Interns\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"userDropdownMenu\"]/a/div/span")).click();
        String eurl="https://neverland.freshprints.com/dashboard/login";
        Thread.sleep(5000);
        String strurl= driver.getCurrentUrl();
        if(eurl.equals(strurl))
        {
            System.out.println("successfully-> log out");
        }

        /*Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div/div/app-users-list/div/div[3]/div[1]/div/app-data-table/div/fieldset/div/label/app-select/div/ng-select/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"a56741d6f31a-1\"]")).click();*/





    }



}