import java.util.ArrayList;
import java.util.Scanner;

class Buku {
    String judul;
    String pengarang;
    boolean dipinjam;

    public Buku(String judul, String pengarang) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.dipinjam = false;
    }
}

class Perpustakaan {
    ArrayList<Buku> koleksiBuku = new ArrayList<>();

    public void tambahBuku(String judul, String pengarang) {
        Buku bukuBaru = new Buku(judul, pengarang);
        koleksiBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan ke perpustakaan.");
    }

    public void pinjamBuku(String judul) {
        for (Buku buku : koleksiBuku) {
            if (buku.judul.equals(judul) && !buku.dipinjam) {
                buku.dipinjam = true;
                System.out.println("Buku berhasil dipinjam.");
                return;
            }
        }
        System.out.println("Buku tidak tersedia untuk dipinjam.");
    }

    public void kembalikanBuku(String judul) {
        for (Buku buku : koleksiBuku) {
            if (buku.judul.equals(judul) && buku.dipinjam) {
                buku.dipinjam = false;
                System.out.println("Buku berhasil dikembalikan.");
                return;
            }
        }
        System.out.println("Buku tidak dapat dikembalikan karena tidak dipinjam atau tidak tersedia.");
    }

    public void tampilkanKoleksiBuku() {
        System.out.println("Daftar Buku dalam Perpustakaan:");
        for (Buku buku : koleksiBuku) {
            System.out.println("Judul: " + buku.judul + ", Pengarang: " + buku.pengarang + ", Status: " + (buku.dipinjam ? "Dipinjam" : "Tersedia"));
        }
    }
}


class ProgramPerpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();

        while (true) {
            System.out.println("\nMenu Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Tampilkan Koleksi Buku");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama pengarang: ");
                    String pengarang = scanner.nextLine();
                    perpustakaan.tambahBuku(judul, pengarang);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String judulPinjam = scanner.nextLine();
                    perpustakaan.pinjamBuku(judulPinjam);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    String judulKembali = scanner.nextLine();
                    perpustakaan.kembalikanBuku(judulKembali);
                    break;
                case 4:
                    perpustakaan.tampilkanKoleksiBuku();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program perpustakaan. Sampai jumpa!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan pilihan yang benar.");
            }
        }
    }
}

