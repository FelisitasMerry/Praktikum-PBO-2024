import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

interface PaketInterface {
    void hitungBiaya();
    void printInfo();
}

abstract class Paket implements PaketInterface {
    protected final String namaPaket;
    protected final double harga;

    public Paket(String namaPaket, double harga) {
        this.namaPaket = namaPaket;
        this.harga = harga;
    }

    public final String getNamaPaket() {
        return namaPaket;
    }

    public final double getHarga() {
        return harga;
    }

    public abstract String getFormattedHarga();
}

class PaketReguler extends Paket {
    public PaketReguler(String namaPaket, double harga) {
        super(namaPaket, harga);
    }

    @Override
    public String getFormattedHarga() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(harga) + " (Reguler)";
    }

    @Override
    public void hitungBiaya() {
    }

    @Override
    public void printInfo() {
    }
}

class PaketPremium extends Paket {
    public PaketPremium(String namaPaket, double harga) {
        super(namaPaket, harga);
    }

    @Override
    public String getFormattedHarga() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(harga) + " (Premium)";
    }

    @Override
    public void hitungBiaya() {
    }

    @Override
    public void printInfo() {
    }
}

public class posttest {
    private static int jumlahPaket = 0;

    public static void main(String[] args) {
        ArrayList<Paket> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Paket Reguler");
            System.out.println("2. Tambah Data Paket Premium");
            System.out.println("3. Tampilkan Data Paket");
            System.out.println("4. Perbarui Data Paket");
            System.out.println("5. Hapus Data Paket");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addData(data, scanner, false);
                    break;
                case 2:
                    addData(data, scanner, true);
                    break;
                case 3:
                    showData(data);
                    break;
                case 4:
                    updateData(data, scanner);
                    break;
                case 5:
                    deleteData(data, scanner);
                    break;
                case 6:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-6.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void addData(ArrayList<Paket> data, Scanner scanner, boolean isPremium) {
        System.out.print("Masukkan nama paket " + (isPremium ? "premium" : "reguler") + " baru: ");
        String namaPaket = scanner.next();
        System.out.print("Masukkan harga paket " + (isPremium ? "premium" : "reguler") + " baru: ");
        double harga = scanner.nextDouble();

        if (isPremium) {
            PaketPremium paket = new PaketPremium(namaPaket, harga);
            data.add(paket);
        } else {
            PaketReguler paket = new PaketReguler(namaPaket, harga);
            data.add(paket);
        }
        System.out.println("Data paket " + (isPremium ? "premium" : "reguler") + " baru berhasil ditambahkan.");
        jumlahPaket++;
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
                jumlahPaket--;
            } else {
                System.out.println("Nomor data paket tidak valid.");
            }
        }
    }
}
