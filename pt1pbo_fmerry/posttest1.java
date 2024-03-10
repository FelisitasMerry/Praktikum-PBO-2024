import java.util.ArrayList;
import java.util.Scanner;

class posttest1 {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
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

    private static void addData(ArrayList<String> data, Scanner scanner) {
        System.out.print("Masukkan data paket baru: ");
        String newData = scanner.next();
        data.add(newData);
        System.out.println("Data paket baru berhasil ditambahkan.");
    }

    private static void showData(ArrayList<String> data) {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data paket.");
        } else {
            System.out.println("Data paket:");
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + data.get(i));
            }
        }
    }

    private static void updateData(ArrayList<String> data, Scanner scanner) {
        showData(data);
        if (!data.isEmpty()) {
            System.out.print("Pilih nomor data paket yang akan diperbarui: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < data.size()) {
                System.out.print("Masukkan data paket baru: ");
                String newData = scanner.next();
                data.set(index, newData);
                System.out.println("Data paket berhasil diperbarui.");
            } else {
                System.out.println("Nomor data paket tidak valid.");
            }
        }
    }

    private static void deleteData(ArrayList<String> data, Scanner scanner) {
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
