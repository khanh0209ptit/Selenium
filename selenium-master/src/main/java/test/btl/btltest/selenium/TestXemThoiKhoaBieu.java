package test.btl.btltest.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestXemThoiKhoaBieu {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\_DELL_\\Desktop\\edgedriver_win64\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://localhost:8080/login");
        Thread.sleep(1000);
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("khanh");
        txtMatkhau.sendKeys("123");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement btnClickDangKyMonHoc = this.driver.findElement(By.xpath("/html/body/nav/li[1]/a/b"));
        btnClickDangKyMonHoc.click();

        Thread.sleep(1000);

        WebElement btnXemThoiKHoaBieu = this.driver.findElement(By.xpath("/html/body/nav/li[2]/a/b"));
        btnXemThoiKHoaBieu.click();

        Thread.sleep(1000);
    }
    @After
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }
    @Test
    public void TuanDangXem() throws InterruptedException{
        Actions actions = new Actions(this.driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"select_subject\"]"))).perform();

        Thread.sleep(1000);

        WebElement txtthoigian = this.driver.findElement(By.xpath("//*[@id=\"select_subject\"]/option[2]"));
        txtthoigian.click();
        String time = txtthoigian.getText();

        Thread.sleep(1000);

        WebElement btnLoc = this.driver.findElement(By.xpath("//*[@id=\"select_panel\"]/input"));
        btnLoc.click();

        Thread.sleep(1000);

        WebElement txttuandangxem = this.driver.findElement(By.xpath("//*[@id=\"select_panel\"]/h6/b/span"));
        String tuandangxem = txttuandangxem.getText();

        Assert.assertEquals(time, tuandangxem);
    }
}
