package Arr_List_DanhSachPhuongTien;

import QuanLyPhuongTien.Xe;
import QuanLyPhuongTien.XeChoHang;
import QuanLyPhuongTien.XeDuLich;
import java.util.*;
import Libary.InputException;

public class Demo_DanhSachPhuongTien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachPhuongTien ArrList = new DanhSachPhuongTien();
        Xe h = null;
        int chon;
        ArrList.init();
        ArrList.outAll();

        do {
            System.out.println("\n============MENU==============");
            System.out.println("1. Them mot xe cho hang");
            System.out.println("2. Them mot xe du lich");
            System.out.println("3. Dem so luong Xe Cho Hang va Xe Du Lich");
            System.out.println("4. Tong doanh thu tat ca cac phuong tien");
            System.out.println("5. Xuat danh sach Xe Cho Hang");
            System.out.println("6. Xuat danh sach Xe Du Lich");
            System.out.println("7. Sap xep tang dan theo doanh thu");
            System.out.println("8. Tim va xuat thong tin xe theo bien so");
            System.out.println("9. Tim va xoa xe theo bien so");
            System.out.println("0. Thoat");
            System.out.println("==============================");
            
           
            chon = InputException.inputIntRange("Chon chuc nang: ", 0, 9);

            switch (chon) {
                case 1:
                    System.out.println("Nhap thong tin xe cho hang:");
                    h = new XeChoHang();
                    h.input();
                    ArrList.add(h);
                    break;
                case 2:
                    System.out.println("Nhap thong tin xe du lich:");
                    h = new XeDuLich();
                    h.input();
                    ArrList.add(h);
                    break;
                case 3:
                    System.out.println("Dem so luong cac san pham Xe Cho Hang va Xe Du Lich:");
                    ArrList.demSoLuong();
                    break;
                case 4:
                    System.out.println("Tong doanh thu: " + ArrList.tinhTongDoanhThu());
                    break;
                case 5:
                    System.out.println("Danh sach Xe Cho Hang:");
                    ArrList.outXCH();
                    break;
                case 6:
                    System.out.println("Danh sach Xe Du Lich:");
                    ArrList.outXDL();
                    break;
                case 7:
                    System.out.println("Danh sach sau khi sap xep tang dan theo doanh thu:");
                    ArrList.sapXepTangDanTheoDoanhThu();
                    ArrList.outAll();
                    break;
                case 8:
                    System.out.print("Nhap bien so xe can tim: ");
                    sc.nextLine(); 
                    String bienSoTim = sc.nextLine().trim();
                    ArrList.timVaXuat(bienSoTim);
                    break;

                case 9:
                    System.out.print("Nhap bien so xe can xoa: ");
                    sc.nextLine(); 
                    String bienSoXoa = sc.nextLine().trim();
                    ArrList.timVaXoa(bienSoXoa);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (chon != 0);

        sc.close();
    }
}
