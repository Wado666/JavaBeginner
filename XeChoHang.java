package QuanLyPhuongTien;
import Libary.InputException;
import java.util.Scanner;

public class XeChoHang extends XeDichVu{
    private double trongTai;
    private double soKmVanChuyen;

    public XeChoHang() {
        super();
    }
    public XeChoHang(String bienSoXe, double donGiaCoBan, int soChoNgoi, double trongTai, double soKmVanChuyen ) {
        super(bienSoXe, donGiaCoBan,  soChoNgoi);
        this.trongTai = trongTai;
        this.soKmVanChuyen = soKmVanChuyen;
    }

    public XeChoHang(XeChoHang obj) {
        super(obj);
        this.trongTai = obj.trongTai;
        this.soKmVanChuyen = obj.soKmVanChuyen;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    public double getSoKmVanChuyen() {
        return soKmVanChuyen;
    }

    public void setSoKmVanChuyen(double soKmVanChuyen) {
        this.soKmVanChuyen = soKmVanChuyen;
    }
    public double tinhDoanhThu(){
        return donGiaCoBan + (soKmVanChuyen*trongTai*5000);
    }
    public void input(){
    super.input();
    trongTai = InputException.inputDoublePositive("Nhap so tai trong: ");
    soKmVanChuyen = InputException.inputDoublePositive("Nhap KM: ");
}
    public void output(){
        System.out.print(this);
    }
    public String toString() {
        return "Xe cho hang: " + super.toString() + ", Tai trong: " + trongTai + ", So KM: " + soKmVanChuyen + ", Doanh thu: " + tinhDoanhThu();
    }
}
