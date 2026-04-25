// Nguyen Minh Tung - 24820100059
package QuanLyPhuongTien;
import Libary.InputException;
import java.util.Scanner;

public abstract class XeDichVu extends Xe {
    private int soChoNgoi;

    public XeDichVu() {
        super();
    }
    public XeDichVu(String bienSoXe, double donGiaCoBan, int soChoNgoi) {
        super(bienSoXe, donGiaCoBan);
        this.soChoNgoi = soChoNgoi;
    }

    public XeDichVu(Xe obj) {
        super(obj);
    }
public void input(){
    super.input();
    soChoNgoi = InputException.inputIntPositive("Nhap so cho ngoi:");
}
public void output(){
        System.out.print(this);
    }
    public String toString(){
        return super.toString() + ", So cho ngoi: " + soChoNgoi;
    }
}
