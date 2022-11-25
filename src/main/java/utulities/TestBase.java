package utulities;

import java.time.Duration;

public class C04_TestBaseIlkTest {

    procted WebDriver driver;
    @Before
    public void setup(){
        WebdriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }




    @After
    public void teardown(){
        driver.quit();
    }
}

