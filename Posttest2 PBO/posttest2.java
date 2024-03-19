import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

class Paket {
    private String namaPaket;
    private double harga;

    public Paket(String namaPaket, double harga) {
        this.namaPaket = namaPaket;
        this.harga = harga;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getFormattedHarga() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(harga);
    }
}

public class posttest2 {
    public static void main(String[] args) {
        ArrayList<Paket> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Paket");
            System.out.println("2. Tampilkan Data Paket");
            System.out.println("3. Perbarui Data Paket");
            System.out.println("4. Hapus Data Paket");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addData(data, scanner);
                    break;
                case 2:
                    showData(data);
                    break;
                case 3:
                    updateData(data, scanner);
                    break;
                case 4:
                    deleteData(data, scanner);
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addData(ArrayList<Paket> data, Scanner scanner) {
        System.out.print("Masukkan nama paket baru: ");
        String namaPaket = scanner.next();
        System.out.print("Masukkan harga paket baru: ");
        double harga = scanner.nextDouble();
        Paket paket = new Paket(namaPaket, harga);
        data.add(paket);
        System.out.println("Data paket baru berhasil ditambahkan.");
    }

    private static void showData(ArrayList<Paket> data) {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data paket.");
        } else {
            System.out.println("Data paket:");
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + data.get(i).getNamaPaket() + " - Harga: Rp" + data.get(i).getFormattedHarga());
            }
        }
    }

    private static void updateData(ArrayList<Paket> data, Scanner scanner) {
        showData(data);
        if (!data.isEmpty()) {
            System.out.print("Pilih nomor data paket yang akan diperbarui: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < data.size()) {
                System.out.print("Masukkan nama paket baru: ");
                String namaPaket = scanner.next();
                System.out.print("Masukkan harga paket baru: ");
                double harga = scanner.nextDouble();
                data.get(index).setNamaPaket(namaPaket);
                data.get(index).setHarga(harga);
                System.out.println("Data paket berhasil diperbarui.");
            } else {
                System.out.println("Nomor data paket tidak valid.");
            }
        }
    }

    private static void deleteData(ArrayList<Paket> data, Scanner scanner) {
        showData(data);
        if (!data.isEmpty()) {
            System.out.print("Pilih nomor data paket yang akan dihapus: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < data.size()) {
                data.remove(index);
                System.out.println("Data paket berhasil dihapus.");
            } else {
                System.out.println("Nomor data paket tidak valid.");
            }
        }
    }
}
