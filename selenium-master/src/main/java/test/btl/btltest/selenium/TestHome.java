package test.btl.btltest.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestHome {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\_DELL_\\Desktop\\edgedriver_win64\\msedgedriver.exe");
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

    }

    @After
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }
    @Test
    public void TestClickLogo() throws InterruptedException{
        WebElement btnLogo = this.driver.findElement(By.xpath("/html/body/nav/a/span"));
        btnLogo.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/home",url);
    }
    @Test
    public void TestChucNangDangKyMonHoc() throws InterruptedException{


        Thread.sleep(1000);WebElement btnLogo = this.driver.findElement(By.xpath("/html/body/nav/li[1]/a/b"));
        btnLogo.click();

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/registersub",url);
    }
    @Test
    public void TestChucNangXemThoiKhoaBieu() throws InterruptedException{
        WebElement btnLogo = this.driver.findElement(By.xpath("/html/body/nav/li[2]/a/b"));
        btnLogo.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/schedule",url);
    }
    @Test
    public void TestChucNangDangXuat() throws InterruptedException{
        WebElement btnLogo = this.driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/form/p/a/button"));
        btnLogo.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/login",url);
    }
}
