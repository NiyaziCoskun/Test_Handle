package lesson01_handleDDM;

import java.time.Duration;

public class C01_handledm {


    WebDriver driver;

    @Before
    public void setup(){
        WebdriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void iframeTest(){
        // https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");
        // Bir method olusturun: iframeTest
        // "An Iframe containing..." textinin erisilebilir oldugunu test edin ve konsola yazdirin.
        WebElement anIframeYaziElemnti =driver.findElement(By tagName("h3)"));
        Assert.assertTrue(anIframeYaziElemnti.isEnabled());
        //Text Box a "Hello World" yazin.
        System.out.println(anIframeYaziElemnti.getText());

        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo.frame(iframeElementi);

        WebElement yaziAlaniElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziAlaniElementi.clear();
        yaziAlaniElementi.sendkeys("Merhaba Dunya!");

        /*
        Bir iframe'in icerine girdikten sonra asil sayfa ile ilgili bir islem yapmak istedigimizde oncelikle
        icerisine girdigimiz iframe den cikmamiz lazim

        switcTo().defaultContent() ==> ana sayfaya gecer
        switchTo().parentFrame() ==> ic ice birden fazla iframe varsa bulundugu iframen'in iframe'ine cikar
         */


        //TextBox altinda bulunan "Element Selenium"
        //Linkini textinin görünür oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki= driver.findElement(By.LinkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isEnabled());

        System.out.println(elementalSeleniumLinki.getText());
    }


    @After
    public void teardown(){
        driver.close();
    }

}
