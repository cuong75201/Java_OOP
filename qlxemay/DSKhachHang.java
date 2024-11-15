package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSKhachHang {

    private ArrayList<KhachHang> dsKhachHang;
    private static int makhtt;

    public DSKhachHang() {
        dsKhachHang = new ArrayList<>();  // Khởi tạo danh sách khách hàng
    }

    public static int getMakhtt() {
        return makhtt;
    }

    public static void setMakhtt(int makhtt) {
        DSKhachHang.makhtt = makhtt;
    }

    public ArrayList<KhachHang> getdsKhachHang() {
        return dsKhachHang;
    }

    public void setdsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public void xem() {
        if (dsKhachHang != null && !dsKhachHang.isEmpty()) {
            System.out.println("\nTHONG TIN DANH SACH KHACH HANG: ");
            for (KhachHang kh : dsKhachHang) {
                kh.xuat();
            }
            System.out.println("\n");
        } else {
            System.out.println("Danh sach trong.\n");
        }
    }

    public void them() {
        Scanner s = new Scanner(System.in);
        System.out.print("\t NHAP THONG TIN KHACH HANG CAN THEM: \n");
        KhachHang kh = null;
        kh = new KhachHang();
        if (kh != null) {
            System.out.println("Nhap ma Khach hang: ");
            int count;
            do {
                count = 0;
                int makh = s.nextInt();
                if (makh == 0) {
                    return;
                }
                for (KhachHang khg : dsKhachHang) {
                    if (khg.getMakh() == makh) {
                        count++;
                    }
                    if (count == 1) {
                        System.out.println("Ma khach hang da ton tai!");
                        System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                        break;
                    }
                }
                if (count == 0) {
                    kh.setMakh(makh);
                }
            } while (count == 1);
            kh.nhap();
            dsKhachHang.add(kh);

        }
        System.out.println("\n===== DA LUU DU LIEU KHACH HANG THANH CONG ! =====\n");
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> dstam = new ArrayList<>();
        System.out.println("Nhap ten khach hang can sua: ");
        String tensua;
        int look = 0;
        tensua = sc.nextLine();
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTenkh().equals(tensua)) {
                System.out.println("Thong tin khach hang " + tensua);
                dstam.add(kh);
                kh.xuat();
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay thong tin khach hang!");
            return;
        }
        if (look == 1) {
            for (KhachHang kh : dsKhachHang) {
                if (kh.getTenkh().equals(tensua)) {
                    int ma = kh.getMakh();
                    System.out.println("Nhap ma moi cua khach hang: ");
                    int count;
                    do {
                        count = 0;
                        int makh = sc.nextInt();
                        if (makh == 0) {
                            return;
                        }
                        for (KhachHang khg : dsKhachHang) {
                            if (khg.getMakh() == makh) {
                                count++;
                            }
                            if (ma == makh) {
                                count = 0;
                            }
                            if (count == 1) {
                                System.out.println("Ma khach hang da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            kh.setMakh(makh);
                        }
                    } while (count == 1);
                    kh.sua();
                    System.out.println("Sua thanh cong!");
                    return;
                }
            }
        }
        // Kiem tra xem ma kh moi co trung voi ma hang kh co trong danh sach khong
        System.out.println("Nhap ma khach hang muon sua: ");
        int ma = sc.nextInt();
        for (KhachHang kh : dstam) {
            if (kh.getMakh() == ma) {
                System.out.println("Nhap ma moi cua khach hang: ");
                int count;
                do {
                    count = 0;
                    int makh = sc.nextInt();
                    if (makh == 0) {
                        return;
                    }
                    for (KhachHang khg : dsKhachHang) {
                        if (khg.getMakh() == makh) {
                            count++;
                        }
                        if (ma == makh) {
                            count = 0;
                        }
                        if (count == 1) {
                            System.out.println("Ma khach hang da ton tai!");
                            System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                            break;
                        }
                    }
                    if (count == 0) {
                        kh.setMakh(makh);
                    }
                } while (count == 1);
                kh.sua();
                return;
            }
        }
        System.out.printf("Khong ton tai khach hang %s co ma: %d\n", tensua, ma);
    }

    public void xoa() {
        ArrayList<KhachHang> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten khach hang can xoa: ");
        String tenxoa;
        int look = 0;
        tenxoa = sc.nextLine();
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTenkh().equals(tenxoa)) {
                System.out.println("Thong tin khach hang " + tenxoa);
                kh.xuat();
                dstam.add(kh);
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay thong tin khach hang!");
            return;
        }
        if (look == 1) {
            for (KhachHang kh : dsKhachHang) {
                if (kh.getTenkh().equals(tenxoa)) {
                    dsKhachHang.remove(kh);
                    System.out.println("Xoa thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma hang san xuat muon xoa: ");
        int ma = sc.nextInt();
        for (KhachHang kh : dstam) {
            if (kh.getMakh() == ma) {
                dsKhachHang.remove(kh);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.printf("Khong ton tai hang san xuat %s co ma: %d\n", tenxoa, ma);
    }

    public void timkiem() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap ten khach hang can tim kiem: ");
        String find = s.nextLine();
        boolean found = false;
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTenkh().contains(find)) {
                kh.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co ten khach hang can tim kiem!");
        }
    }

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng KhachHang và thêm vào danh sách ds3
                KhachHang kh = parseLineToKhachHang(line);
                if (kh != null) {
                    dsKhachHang.add(kh);  // Thêm vào danh sách dsKhachHang
                }
            }
            System.out.println("Da tai danh sach tu tap tin: " + fileName + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tap tin: " + fileName + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (KhachHang kh : dsKhachHang) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseKhachHangToLine(kh));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng hangSX
    private KhachHang parseLineToKhachHang(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 6) {
            int makh = Integer.parseInt(parts[0]);
            String sdtkh = parts[1];
            String tenkh = parts[2];
            int age = Integer.parseInt(parts[3]);

            String diachikh = parts[4];
            String phaikh = parts[5];
            return new KhachHang(makh, age, sdtkh, tenkh, diachikh, phaikh);
        }
        return null;
    }

    // Hàm chuyển đối tượng HangSX thành dòng văn bản
    private String parseKhachHangToLine(KhachHang kh) {
        return kh.getMakh() + ";" + kh.getSdtkh() + ";" + kh.getTenkh() + ";" + kh.getAge() + ";" + kh.getDiachikh() + ";" + kh.getPhai();
    }

    public KhachHang timKiemKhachHangTheoMa(int maKhachHang) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMakh() == maKhachHang) {
                return kh;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma so: " + maKhachHang);
        return null; // Trả về null nếu không tìm thấy
    }
}
