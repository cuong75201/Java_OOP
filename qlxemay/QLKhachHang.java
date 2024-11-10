package qlxemay;

import java.util.Scanner;

class QLKhachHang {
	private DSKhachHang dskh;
    Scanner s = new Scanner(System.in);
    String fileName = "input_KhachHang.txt";
    public QLKhachHang() {
        dskh = new DSKhachHang();
    }

    public void menu() {
        int select;
        do {
            System.out.println("[=======================]");
			System.out.println("\tKHACH HANG");
			System.out.println("[=======================]");
            System.out.println("1. Them khach hang");
            System.out.println("2. Sua thong tin khach hang");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("5. Xem thong tin danh sach khach hang");
            System.out.println("6. Tai danh sach khach hang tu file");
            System.out.println("7. Xuat danh sach khach hang vao file");
            System.out.println("8. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");

            select = s.nextInt();
            s.nextLine(); 

            switch (select) {
            	case 1:
	                dskh.them();
	                break;
                case 2:
                	dskh.sua();
                    break;
                case 3:
                	dskh.xoa();
                    break;
                case 4:
                	dskh.timkiem();
                    break;
                case 5:
                	dskh.xem();
                    break;
                case 6:
                    dskh.taiDanhSachTuFile(fileName);
                    break;
                case 7:     
                    System.out.println("Da cap nhat danh sach vao tap tin: " + fileName);
                    dskh.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    dskh.xuatDanhSachRaFile(fileName);
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai. \n");
                    continue;
            }
            // Hỏi người dùng có muốn tiếp tục chọn không
            if(select != 8){
                System.out.print("tiep tuc lua chon Menu ? (y/n): ");
                String choice = s.nextLine().trim().toLowerCase();
                if (!choice.equals("y") && !choice.equals("yes") && !choice.equals("1")) {
                    dskh.xuatDanhSachRaFile(fileName);
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                    break;  
                }
            }
        } while (true);
    }
}
