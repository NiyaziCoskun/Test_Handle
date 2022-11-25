package lesson01_handleDDM;

import java.time.Duration;




public class TestBase extends utulities.TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
}