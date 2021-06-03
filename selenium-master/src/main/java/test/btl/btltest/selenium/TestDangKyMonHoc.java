package test.btl.btltest.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestDangKyMonHoc {
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

    }

    @After
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
//        this.driver.quit();
    }

    @Test
    public void TestChucNangDangXuat() throws InterruptedException {
        WebElement btnLogo = this.driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/form/p/a/button"));
        btnLogo.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/login", url);
    }

    @Test
    public void TestLogo() throws InterruptedException {
        WebElement btnLogo = this.driver.findElement(By.xpath("/html/body/nav/a/span"));
        btnLogo.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/home", url);
    }

    @Test
    public void TestChucNangXemThoiKhoaBieu() throws InterruptedException {
        WebElement xemtkb = this.driver.findElement(By.xpath("/html/body/nav/li[2]/a/b"));
        xemtkb.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/schedule", url);
    }

    @Test
    public void TestTimKiemDeTrong() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

//        txtTimkiem.sendKeys("");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/h6/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Mã môn học không đúng hoặc bạn không có quyền tìm kiếm môn học này", tb);

    }

    @Test
    public void TestTimKiemSaiMaMonHoc() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("khanh");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/h6/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Mã môn học không đúng hoặc bạn không có quyền tìm kiếm môn học này", tb);

    }

    @Test
    public void TestTimKiemKhoangTrang() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("     ");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/h6/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Mã môn học không đúng hoặc bạn không có quyền tìm kiếm môn học này", tb);

    }

    @Test
    public void TestTimKiemDungMaMonHoc() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT3028");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement checktrongdanhsachdangky = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[3]"));
        String tb = checktrongdanhsachdangky.getText();

        Assert.assertEquals("INT3028", tb);

    }

    @Test
    public void TestTimKiemDungVaLuuVaoDanhSachMonHocDangKy() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT3028");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMonHoc.click();

        Thread.sleep(1000);

        WebElement themvaoDS = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        themvaoDS.click();

        Thread.sleep(1000);

        WebElement checkmamonhoctrongdanhsachdangky = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[2]"));
        String tb = checkmamonhoctrongdanhsachdangky.getText();

        Assert.assertEquals("INT3028", tb);

        WebElement XoamH = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[8]/form/input[2]"));
        XoamH.click();

    }

    @Test
    public void TestTimKiemDungVaKhongChonMonHocTrongDanhSachHocPhanVaThemVaoDanhSachDangKy() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT1314");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/registersub", url);

    }

    @Test
    public void TestTimKiemDungVaLuuVaoDanhSachMonHocDangKyVaChonNhieuHonMotHocPhan() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT1314");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc1 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr[1]/td[2]/div/input"));
        btnChonMonHoc1.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc2 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr[3]/td[2]/div/input"));
        btnChonMonHoc2.click();

        Thread.sleep(1000);

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/h7/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Lưu ý: Nếu như bạn chọn nhiều slot trong cùng 1 môn, hệ thống sẽ chọn slot đầu tiên tính theo thứ tự sắp xếp từ trên xuống", tb);

    }

    @Test
    public void TestTimKiemDungVaLuuVaoDanhSachMonHocDangKyVaChonNhieuHonMotHocPhanVaLuuVaoDanhSachMonHocHocPhanDauTien() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT1314");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc1 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr[1]/td[2]/div/input"));
        btnChonMonHoc1.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc2 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr[3]/td[2]/div/input"));
        btnChonMonHoc2.click();

        Thread.sleep(1000);

        WebElement btnThemVaoDanhSachDangKy = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy.click();

        Thread.sleep(1000);

        WebElement checkTTH = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr[1]/td[7]"));
        String ht = checkTTH.getText();

        Assert.assertEquals("1", ht);
    }

    @Test
    public void TestHetSlotHocPhan() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT3312");

        Thread.sleep(2000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(2000);

        WebElement btnChonMH = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMH.click();

        Thread.sleep(2000);

        WebElement themvaoDS = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        themvaoDS.click();

        Thread.sleep(2000);

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/form[4]/h7/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Môn học INT3028 đã hết slot! Vui lòng thử lại", tb);

        Thread.sleep(1000);

        WebElement Xoa = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[8]/form/input[2]"));
        Xoa.click();

    }

    @Test
    public void TestXoaMonHocTrongDanhSachDangKy() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT3312");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMonHoc.click();

        Thread.sleep(1000);

        WebElement btnThemVaoDanhSachDangKy = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy.click();

        Thread.sleep(1000);

        WebElement hocphimonhocxoa = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[7]"));
        String hocphi = hocphimonhocxoa.getText();

        WebElement tonghocphitruockhixoa = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/p/b/span"));
        String giatritonghocphitruockhixoa = tonghocphitruockhixoa.getText();

        Thread.sleep(300);

        WebElement btnXoa = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[8]/form/input[2]"));
        btnXoa.click();

        Thread.sleep(1000);

        WebElement tonghocphisaukhixoa = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/p/b/span"));
        String sau = tonghocphisaukhixoa.getText();

        int giatriconlai = Integer.parseInt(giatritonghocphitruockhixoa) - Integer.parseInt(hocphi);

        Assert.assertEquals(giatriconlai, Integer.parseInt(sau));


    }

    @Test
    public void TestLuuVaoCSDLKhiChuaDu12Tin() throws InterruptedException {
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT3312");

        Thread.sleep(1000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(1000);

        WebElement btnChonMonHoc = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMonHoc.click();

        Thread.sleep(1000);

        WebElement btnThemVaoDanhSachDangKy = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy.click();

        Thread.sleep(1000);

        WebElement btnLuuCSDL = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/form[1]/input"));
        btnLuuCSDL.click();

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/form[3]/h7/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Tổng số tín chỉ đăng kí phải lớn hơn 12", tb);

        WebElement XoaMh = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[8]/form/input[2]"));
        XoaMh.click();
    }
    @Test
    public void TestLuuVaoCSDLKhiDeTrong() throws InterruptedException {

        WebElement btnLuuCSDL = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/form[1]/input"));
        btnLuuCSDL.click();

        WebElement thongbao = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/form[3]/h7/div"));
        String tb = thongbao.getText();

        Assert.assertEquals("Tổng số tín chỉ đăng kí phải lớn hơn 12", tb);
    }

    @Test
    public void TestLuuVaoCSDLKhiLonHonHoacBang12Tin() throws InterruptedException {

        //Mon 1
        WebElement txtTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem.sendKeys("INT3312");

        Thread.sleep(2000);

        WebElement btnTimkiem = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem.click();

        Thread.sleep(2000);

        WebElement btnChonMonHoc = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMonHoc.click();

        Thread.sleep(2000);

        WebElement btnThemVaoDanhSachDangKy = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy.click();

        Thread.sleep(2000);

        WebElement hocphimonhoc1 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[1]/td[7]"));
        String hocphi1 = hocphimonhoc1.getText();

        Thread.sleep(2000);

        //mon2
        WebElement txtTimkiem2 = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem2.sendKeys("INT1314");

        Thread.sleep(2000);

        WebElement btnTimkiem2 = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem2.click();

        Thread.sleep(2000);

        WebElement btnChonMonHoc2 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr[1]/td[2]/div/input"));
        btnChonMonHoc2.click();

        Thread.sleep(2000);

        WebElement btnThemVaoDanhSachDangKy2 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy2.click();

        Thread.sleep(2000);

        WebElement hocphimonhoc2 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[2]/td[7]"));
        String hocphi2 = hocphimonhoc2.getText();

        Thread.sleep(2000);


        //mon3
        WebElement txtTimkiem3 = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem3.sendKeys("INT3028");

        Thread.sleep(2000);

        WebElement btnTimkiem3 = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem3.click();

        Thread.sleep(2000);

        WebElement btnChonMonHoc3 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMonHoc3.click();

        Thread.sleep(2000);

        WebElement btnThemVaoDanhSachDangKy3 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy3.click();

        Thread.sleep(2000);

        WebElement hocphimonhoc3 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[3]/td[7]"));
        String hocphi3 = hocphimonhoc3.getText();

        Thread.sleep(2000);


        //mon4
        WebElement txtTimkiem4 = this.driver.findElement(By.xpath("/html/body/main/form/input[1]"));

        txtTimkiem4.sendKeys("INT5678");

        Thread.sleep(2000);

        WebElement btnTimkiem4 = this.driver.findElement(By.xpath("/html/body/main/form/input[2]"));
        btnTimkiem4.click();


        Thread.sleep(2000);

        WebElement btnChonMonHoc4 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/table/tbody/tr/td[2]/div/input"));
        btnChonMonHoc4.click();

        Thread.sleep(2000);

        WebElement btnThemVaoDanhSachDangKy4 = this.driver.findElement(By.xpath("//*[@id=\"classes_list\"]/form/input"));
        btnThemVaoDanhSachDangKy4.click();

        Thread.sleep(2000);

        WebElement btnLuuCSDL = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/form[1]/input"));
        btnLuuCSDL.click();

        Thread.sleep(2000);

        WebElement hocphimonhoc4 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[4]/td[7]"));
        String hocphi4 = hocphimonhoc4.getText();

        Thread.sleep(2000);

        WebElement hocphimonhocsaukhiluu = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/p/b/span"));
        String tonghocphi = hocphimonhocsaukhiluu.getText();

        Thread.sleep(2000);

        int tong = Integer.parseInt(hocphi1) + Integer.parseInt(hocphi2) + Integer.parseInt(hocphi3) + Integer.parseInt(hocphi4);

        Assert.assertEquals(tong,Integer.parseInt(tonghocphi));

        WebElement Xoa1 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[1]/td[8]/form/input[2]"));
        Xoa1.click();
        Thread.sleep(2000);

        WebElement Xoa2 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[2]/td[8]/form/input[2]"));
        Xoa2.click();
        Thread.sleep(2000);

        WebElement Xoa3 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr[1]/td[8]/form/input[2]"));
        Xoa3.click();
        Thread.sleep(2000);

        WebElement Xoa4 = this.driver.findElement(By.xpath("//*[@id=\"registered_classes\"]/table/tbody/tr/td[8]/form/input[2]"));
        Xoa4.click();
        Thread.sleep(2000);

    }
}
