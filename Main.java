import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data Mahasiswa
        Mahasiswa m1 = new Mahasiswa("22001", "Ali Rahman", "Informatika");
        Mahasiswa m2 = new Mahasiswa("22002", "Budi Santoso", "Informatika");
        Mahasiswa m3 = new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

        // Data Mata Kuliah
        MataKuliah mk1 = new MataKuliah("MK001", "Struktur Data", 3);
        MataKuliah mk2 = new MataKuliah("MK002", "Basis Data", 3);
        MataKuliah mk3 = new MataKuliah("MK003", "Desain Web", 3);

        // Data Penilaian
        ArrayList<Penilaian> penilaianList = new ArrayList<>();
        penilaianList.add(new Penilaian(m1, mk1, 80, 85, 90));
        penilaianList.add(new Penilaian(m1, mk2, 60, 75, 70));
        penilaianList.add(new Penilaian(m2, mk1, 75, 70, 80));
        penilaianList.add(new Penilaian(m3, mk2, 85, 90, 95));
        penilaianList.add(new Penilaian(m3, mk3, 80, 90, 65));

        int menu;
        do {
            System.out.println("\n=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt(); sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    m1.tampilMahasiswa();
                    m2.tampilMahasiswa();
                    m3.tampilMahasiswa();
                    break;

                case 2:
                    System.out.println("\nDaftar Mata Kuliah:");
                    mk1.tampilMatakuliah();
                    mk2.tampilMatakuliah();
                    mk3.tampilMatakuliah();
                    break;

                case 3:
                    System.out.println("\nData Penilaian:");
                    for (Penilaian p : penilaianList) {
                        p.tampilPenilaian();
                    }
                    break;

                case 4:
                    System.out.println("\nData Penilaian (Diurutkan):");
                    penilaianList.sort((a, b) -> Double.compare(b.getNilaiAkhir(), a.getNilaiAkhir()));
                    for (Penilaian p : penilaianList) {
                        p.tampilPenilaian();
                    }
                    break;

                case 5:
                    System.out.print("Masukkan NIM mahasiswa yang dicari: ");
                    String cariNIM = sc.nextLine();
                    boolean found = false;
                    for (Mahasiswa m : Arrays.asList(m1, m2, m3)) {
                        if (m.NIM.equals(cariNIM)) {
                            System.out.println("Mahasiswa Ditemukan: NIM: " + m.NIM + " | Nama: " + m.nama + " | Prodi: " + m.prodi);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Mahasiswa tidak ditemukan.");
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (menu != 0);
        sc.close();
    }
}

