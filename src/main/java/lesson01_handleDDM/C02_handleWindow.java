package lesson01_handleDDM;

import java.time.Duration;

public class C02_handleWindow {
    WebDriver driver;

    @Before
    public void setup(){
        WebdriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void windowTest(){


        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkSayfaWindowHandDegeri = driver.getWindowHandle();

        driver.findElement(By.LinkText("Elemental Selenium")).click();

        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikinciSayfaninWinHandDegeri ="";

        for (String eachHandleDeger: windowHandlesSeti
             ) {

            if (!eachHandleDeger.equals(ilkSayfaWindowHandDegeri)){
                ikinciSayfaninWinHandDegeri =eachHandleDeger;
            }
        }

        driver.switchTo().window(ikinciSayfaninWinHandDegeri);


        WebElement baslikElementi = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(baslikEelmenti.isDisplayed());
        String expectedYazi = "Elemental Selenium";
        String actualYazi = baslikElementi.getText();
        Assert.assertEqulas(expectedYazi, actualYazi);

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
