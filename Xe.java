// Nguyen Minh Tung - 24820100059
package QuanLyPhuongTien;
import Libary.InputException;
import java.util.*;

public abstract class Xe {

    protected String bienSoXe;
    protected double donGiaCoBan;

    public abstract double tinhDoanhThu();
    public Xe() {
    }

    public Xe(String bienSoXe, double donGiaCoBan) {
        this.bienSoXe = bienSoXe;
        this.donGiaCoBan = donGiaCoBan;
    }

    public Xe(Xe obj) {
        this.bienSoXe = obj.bienSoXe;
        this.donGiaCoBan = obj.donGiaCoBan;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public double getDonGiaCoBan() {
        return donGiaCoBan;
    }

    public void setDonGiaCoBan(double donGiaCoBan) {
        this.donGiaCoBan = donGiaCoBan;
    }

 
    
public void input(){
    bienSoXe = InputException.inputString("Nhap bien so xe", 10);
    donGiaCoBan = InputException.inputDoublePositive("Nhap don gia: ");
}
public void output(){
        System.out.print(this);
    }
    public String toString() {
        return "Bien so: " + bienSoXe + ", Don gia co ban: " + donGiaCoBan;
    }

}
