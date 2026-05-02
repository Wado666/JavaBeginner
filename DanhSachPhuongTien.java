package Arr_List_DanhSachPhuongTien;

import QuanLyPhuongTien.*;
import java.util.*;

public class DanhSachPhuongTien {

    private ArrayList<Xe> danhSachXe = new ArrayList<>();

    public void init() {
        danhSachXe.add(new XeChoHang("51C-12345", 500000, 2, 5.0, 200));
        danhSachXe.add(new XeChoHang("51C-67890", 600000, 3, 8.5, 200));
        danhSachXe.add(new XeDuLich("51C-23423", 600000, 16, 2, true));
        danhSachXe.add(new XeDuLich("51C-45634", 300000, 23, 4, false));
    }

    public void add(Xe xe) {
        danhSachXe.add(xe);
    }

    public void outXCH() {
        for (Xe xe : danhSachXe) {
            if (xe instanceof XeChoHang) {
                System.out.println(xe.toString());
            }
        }
    }

    public void outXDL() {
        for (Xe xe : danhSachXe) {
            if (xe instanceof XeDuLich) {
                System.out.println(xe.toString());
            }
        }
    }

    public void outAll() {
        System.out.println("\n\n\t\t\t DANH SACH XE CHO HANG:");
        outXCH();
        System.out.println("\n\n\t\t\t DANH SACH XE DU LICH:");
        outXDL();
    }

    public void demSoLuong() {
        int demXeChoHang = 0;
        int demXeDuLich = 0;
        for (Xe xe : danhSachXe) {
            if (xe instanceof XeChoHang) {
                demXeChoHang++;
            } else if (xe instanceof XeDuLich) {
                demXeDuLich++;
            }
        }
        System.out.println("So luong Xe cho hang: " + demXeChoHang);
        System.out.println("So luong Xe du lich: " + demXeDuLich);
    }

    public double tinhTongDoanhThu() {
        double tong = 0;
        for (Xe xe : danhSachXe) {
            tong += xe.tinhDoanhThu();
        }
        return tong;
    }

    public void sapXepTangDanTheoDoanhThu() {
        int n = danhSachXe.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (danhSachXe.get(i).tinhDoanhThu() > danhSachXe.get(j).tinhDoanhThu()) {
                    Xe temp = danhSachXe.get(i);
                    danhSachXe.set(i, danhSachXe.get(j));
                    danhSachXe.set(j, temp);
                }
            }
        }
    }

    public void timVaXuat(String bienSo) {
        for (Xe xe : danhSachXe) {
            if (xe.getBienSoXe().equalsIgnoreCase(bienSo)) {
                System.out.println("Tim thay:");
                xe.output();
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }

    public void timVaXoa(String bienSo) {
        for (Xe xe : danhSachXe) {
            if (xe.getBienSoXe().equalsIgnoreCase(bienSo)) {
                danhSachXe.remove(xe);
                System.out.println("Da xoa xe: " + bienSo);
                return;
            }
        }
        System.out.println("Khong the xoa!");
    }
}
