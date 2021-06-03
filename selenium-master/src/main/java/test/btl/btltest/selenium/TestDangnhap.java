package test.btl.btltest.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestDangnhap {
    WebDriver driver;
    //C:\Users\_DELL_\Desktop\edgedriver_win64
    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\_DELL_\\Desktop\\edgedriver_win64\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://localhost:8080/login");
        Thread.sleep(1000);

    }

    @After
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }
    @Test
    public void TestDangNhapVoiTKDungVaMKSai() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("khanh");
        txtMatkhau.sendKeys("1234");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Tài khoản hoặc mật khẩu không đúng! Xin thử lại!",tb);

    }
    @Test
    public void TestDangNhapVoiTKSaiVaMKDung() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("khanh1");
        txtMatkhau.sendKeys("123");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Tài khoản hoặc mật khẩu không đúng! Xin thử lại!",tb);
    }
    @Test
    public void TestDangNhapVoiTKDungVaMKDung() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("khanh");
        txtMatkhau.sendKeys("123");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/home",url);

    }
    @Test
    public void TestDangNhapVoiTKSaiVaMKSai() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("khanh1");
        txtMatkhau.sendKeys("1234");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Tài khoản hoặc mật khẩu không đúng! Xin thử lại!",tb);
    }
    @Test
    public void TestDangNhapVoiTKBoTrong() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtMatkhau.sendKeys("123");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Không được để trống tên tài khoản hoặc mật khẩu!",tb);
    }
    @Test
    public void TestDangNhapVoiMKBoTrong() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("khanh");
//        txtMatkhau.sendKeys("1234");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Không được để trống tên tài khoản hoặc mật khẩu!",tb);
    }
    @Test
    public void TestDangNhapVoiMatKhauBoTrongVaTaiKhoanBoTrong() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

//        txtTaikhoan.sendKeys("khanh");
//        txtMatkhau.sendKeys("1234");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Không được để trống tên tài khoản hoặc mật khẩu!",tb);
    }
    @Test
    public void TestDangNhapVoiTaiKhoanNhapKhoangTrang() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("    ");
        txtMatkhau.sendKeys("123");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Không được để trống tên tài khoản hoặc mật khẩu!",tb);
    }
    @Test
    public void TestDangNhapVoiMatKhauNhapKhoangTrang() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("admin");
        txtMatkhau.sendKeys("   ");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Không được để trống tên tài khoản hoặc mật khẩu!",tb);
    }
    @Test
    public void TestDangNhapVoiMatKhauNhapKhoangTrangVaTaiKhoanKhoangTrang() throws InterruptedException {
        WebElement txtTaikhoan = this.driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement txtMatkhau = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));

        txtTaikhoan.sendKeys("admin    ");
        txtMatkhau.sendKeys("   ");

        Thread.sleep(1000);

        WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/input"));
        btnDangnhap.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("/html/body/main/div/div[2]"));
        String tb = thongbao.getText();

        Assert.assertEquals("Không được để trống tên tài khoản hoặc mật khẩu!",tb);
    }

}
