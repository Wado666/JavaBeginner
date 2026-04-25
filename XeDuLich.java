package QuanLyPhuongTien;

import Libary.InputException;

public class XeDuLich extends XeDichVu{
   private int soNgayThue;
   private boolean tourTronGoi;

    public XeDuLich() {
        super();
    }
   
    public XeDuLich(String bienSoXe, double donGiaCoBan, int soChoNgoi, int soNgayThue, boolean tourTronGoi) {
        super(bienSoXe, donGiaCoBan,  soChoNgoi);
        this.soNgayThue = soNgayThue;
        this.tourTronGoi = tourTronGoi;
    }

    public XeDuLich(XeDuLich obj) {
        super(obj);
        this.soNgayThue = obj.soNgayThue;
        this.tourTronGoi = obj.tourTronGoi;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public boolean isTourTronGoi() {
        return tourTronGoi;
    }

    public void setTourTronGoi(boolean tourTronGoi) {
        this.tourTronGoi = tourTronGoi;
    }
   public  double tinhDoanhThu(){
       if(tourTronGoi){
           return getDonGiaCoBan() * soNgayThue * 1.3;
       } else {
           return getDonGiaCoBan() * soNgayThue;
       }
   }
   public void input(){
    super.input();
    soNgayThue = InputException.inputIntPositive("Nhap so ngay thue: ");
    tourTronGoi = InputException.inputBoolean("Nhap tour tron goi: ");
    
}
   public void output(){
        System.out.print(this);
    }
   public String toString() {
       return "Xe Du Lich; " + super.toString() + ", So ngay thue: " + soNgayThue + ", Tour Tron goi: " + tourTronGoi + ", Doanh thu: " + tinhDoanhThu();
   }
}
