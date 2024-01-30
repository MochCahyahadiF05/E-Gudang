// Package disesuaikan dengan struktur folder Anda
package tugas;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
// import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//untuk format tanggal input yang di case tambah barang
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class tugas {

    public static void main(String[] args) {
        boolean lanjutkan = true;
        String jawaban;
        Scanner userInput = new Scanner(System.in);
        Scanner userInputInt = new Scanner(System.in);
        boolean loop = true;

        Data data = new Data();

        while (loop) {
            System.out.println();
            System.out.println("\t\t\t  Aplikasi Pergudangan\n");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                               Main Menu                              |");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("|                          1.Cek Gudang                                |");
            System.out.println("|                          2.Barang Masuk                              |");
            System.out.println("|                          3.Barang Keluar                             |");
            System.out.println("|                          4.Inventori Toko                            |");
            System.out.println("|                          5.Cari Barang                               |");
            System.out.println("|                          6.Rekap Penjualan                           |");
            System.out.println("|                          0.Keluar Dari Aplikasi                      |");
            System.out.println("+----------------------------------------------------------------------+");

            System.out.print("\nPilih Menu = ");
            jawaban = userInput.next();

            switch (jawaban) {
                case "1":
                    System.out.println(
                            "+------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println(
                            "|                                                        Data Barang                                                                 |");
                    Tabel.printResponsiveTable(data.userDatabase);
                    break;

                case "2":
                    String jenisKain, warna, panjang, tglMasuk = "", jumlah;
                    int Harga = 0;
                    boolean lanjutkan2 = true;

                    while (lanjutkan2) {
                        System.out.println("\t\tTambah Data Barang\n");
                        System.out.println("Masukkan Data Barang Baru\n");

                        System.out.print("Jenis Kain    = ");
                        jenisKain = userInput.next();
                        System.out.print("Warna         = ");
                        warna = userInput.next();

                        // Menghandle input untuk panjang
                        int intPanjang = 0;
                        boolean validPanjangInput = false;
                        while (!validPanjangInput) {
                            try {
                                System.out.print("Panjang        = ");
                                panjang = userInput.next();
                                intPanjang = Integer.parseInt(panjang);
                                validPanjangInput = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Silakan masukkan bilangan bulat yang valid untuk Panjang.");
                            }
                        }

                        System.out.println("Contoh Format Tanggal Masuk 4 Desember 2023 = 4-12-2023");
                        // untuk menghandle input tanggal masuk barang
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        dateFormat.setLenient(false);
                        boolean isValidTglInput = false;
                        while (!isValidTglInput) {
                            try {
                                System.out.print("Tanggal Masuk = ");
                                tglMasuk = userInput.next();
                                // untuk mengcek apakah tgl itu benar sesuai format
                                Date date = dateFormat.parse(tglMasuk);
                                // jika pengecekan berhasil maka
                                isValidTglInput = true;
                            } catch (Exception e) {
                                System.out.println(
                                        "Error: Format tanggal tidak sesuai. Masukkan tanggal dalam format 4-12-2023.");
                            }
                        }

                        // Menghandle input untuk jumlah
                        int intJumlah = 0;
                        boolean validJumlahInput = false;
                        while (!validJumlahInput) {
                            try {
                                System.out.print("Jumlah        = ");
                                jumlah = userInput.next();
                                intJumlah = Integer.parseInt(jumlah);
                                validJumlahInput = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Silakan masukkan bilangan bulat yang valid untuk Jumlah.");
                            }
                        }

                        // Menghandle input untuk Harga
                        boolean validHargaInput = false;
                        while (!validHargaInput) {
                            try {
                                System.out.print("Masukkan Harga = ");
                                Harga = userInput.nextInt();
                                validHargaInput = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Silakan masukkan bilangan bulat yang valid untuk Harga.");
                                userInput.next();
                            }
                        }

                        System.out.println("     Data Yang Anda Masukkan     ");
                        System.out.println("--------------------------------");
                        System.out.println("Jenis Kain      = " + jenisKain);
                        System.out.println("Panjang Kain    = " + intPanjang);
                        System.out.println("Warna Kain      = " + warna);
                        System.out.println("Tanggal Masuk   = " + tglMasuk);
                        System.out.println("Jumlah Barang   = " + intJumlah);
                        System.out.println("Harga Barang    = " + Harga);
                        System.out.println("--------------------------------");

                        boolean isTambah = getYesOrNo("Apakah Anda Ingin Menambah data tersebut");

                        if (isTambah) {
                            data.userDatabase.add(new User(jenisKain, warna, tglMasuk, intJumlah, intPanjang, Harga));
                        }
                        lanjutkan2 = getYesOrNo("Apakah Anda Ingin Menambah barang Kembali?");
                    }
                    break;

                case "3":

                    String jenisBarang;
                    boolean lanjutkan3 = true;
                    while (lanjutkan3) {
                        System.out.print("Jenis Barang Yang Anda Ambil = ");
                        jenisBarang = userInput.next();
                        System.out.print("Warna = ");
                        String Warna = userInput.next();

                        System.out.println("Barang Yang Anda Ambil");

                        Iterator<User> iterator = data.userDatabase.iterator();

                        List<User> hasilPencarian = new ArrayList<>();
                        while (iterator.hasNext()) {
                            User case3 = iterator.next();
                            if (case3.getJenisKain().equalsIgnoreCase(jenisBarang)
                                    && case3.getWarna().equalsIgnoreCase(Warna)) {
                                hasilPencarian.add(case3);
                                System.out.println(
                                        "+------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println(
                                        "|                                                        Data Barang                                                                 |");
                                Tabel.printResponsiveTable(hasilPencarian);
                                data.userToko.add(new UserToko(case3.getJenisKain(), case3.getWarna(), case3.GetHarga(),
                                        case3.getPanjang()));
                                iterator.remove();
                                getYesOrNo("Apakah Anda Ingin Mengambil Barang Tersebut");
                                System.out.println("Barang Keluar");
                            }
                        }
                        lanjutkan3 = getYesOrNo("Apakah Anda Ingin Mengambil Barang Lain");
                    }
                    break;

                case "4":

                    int jual;
                    String barangToko;
                    boolean lanjutkan4 = true;
                    while (lanjutkan4) {
                        System.out.println("\t\tInventori Toko");
                        System.out.print("Barang Toko = ");
                        barangToko = userInput.next();
                        System.out.print("Warna = ");
                        String Colour = userInput.next();
                        List<UserToko> hasilPencarian = new ArrayList<>();
                        for (UserToko case4 : data.userToko) {

                            if (case4.getJenisKain().equalsIgnoreCase(barangToko)
                                    && case4.getWarna().equalsIgnoreCase(Colour)) {
                                hasilPencarian.add(case4);

                            }
                        }
                        if (!hasilPencarian.isEmpty()) {
                            System.out.println(
                                    "+---------------------------------------------------------------------------+");
                            System.out.println(
                                    "|                            Inventori Barang                               |");
                            Tabel.printResponsiveTable2(hasilPencarian);

                            System.out.print("\nDi Jual Berapa Meter?");
                            jual = userInput.nextInt();

                            // Melakukan penyesuaian data UserToko dan mencetak ulang tabel
                            for (UserToko case4 : hasilPencarian) {
                                int penjualan = case4.getPanjang() - jual;
                                case4.GantiPanjang(penjualan);
                            }

                            System.out.println(
                                    "+----------------------------------------------------------------------------------------------+");
                            System.out.println(
                                    "|                                    Inventori Barang                                          |");
                            Tabel.printResponsiveTable2(hasilPencarian);

                            // Menambahkan data ke userRekap setelah dijual
                            for (UserToko case4 : hasilPencarian) {
                                data.userRekap.add(new Rekapitulasi(case4.getJenisKain(), case4.getWarna(), jual,
                                        case4.getHarga()));
                            }
                        }

                        lanjutkan4 = getYesOrNo("apakah Anda Ingin Melakukan Penjualan Lagi");
                    }

                    break;

                case "5":

                    String cariBarang;
                    boolean lanjutkan5 = true;
                    boolean isCariBarang = false;
                    while (lanjutkan5) {
                        System.out.println("\t\tCari Barang");
                        System.out.print(
                                "Ketik Merek, warna atau Tanggal Masuk Barang Ke Gudang(format = dd-mm-yyyy) Untuk Mencari = ");
                        cariBarang = userInput.next();
                        List<User> hasilPencarian = new ArrayList<>();
                        for (User element : data.userDatabase) {
                            if (element.getJenisKain().toLowerCase().contains(cariBarang.toLowerCase())
                                    || element.getWarna().equalsIgnoreCase(cariBarang)
                                    || element.getTglMasuk().equalsIgnoreCase(cariBarang)) {
                                isCariBarang = true;
                                hasilPencarian.add(element);
                            }
                        }
                        if (!hasilPencarian.isEmpty()) {

                            System.out.println(
                                    "+------------------------------------------------------------------------------------------------------------------------------------+");
                            System.out.println(
                                    "|                                                        Data Barang                                                                 |");
                            Tabel.printResponsiveTable(hasilPencarian);
                        } else {
                            System.out.println("Data tidak ditemukan.");
                        }

                        if (!isCariBarang) {
                            System.out.println("Barang Yang Anda Cari Tidak Ada");
                        }
                        lanjutkan5 = getYesOrNo("Apakah Anda Ingin Mencari Barang Yang Lain");
                    }
                    break;

                case "6":
                    System.out.println("Rekap Penjualan Hari Ini");
                    LocalDate tanggalSekarang = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String tanggalDalamFormat = tanggalSekarang.format(formatter);
                    System.out.println("Rekap Penjualan Tanggal : " + tanggalDalamFormat);
                    Tabel.printResponsiveTable3(data.userRekap);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    PrintStream oldOut = System.out;
                    System.setOut(ps);

                    Tabel.printResponsiveTable3(data.userRekap);

                    System.out.flush();
                    System.setOut(oldOut);

                    String tableString = baos.toString();

                    // System.out.println("------------------------------------------------------");
                    // System.out.println("| Rekapan |");
                    // System.out.println("------------------------------------------------------");
                    // System.out.println("|\tJenis Kain\t|\tWarna\t|\tPanjang\t|");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Rekapitulasi.txt"))) {
                        writer.write("Penjualan Tanggal : " + tanggalDalamFormat + "\n");
                        // writer.write("---------------------------------------------------------\n");
                        // writer.write("| Rekapan |\n");
                        // writer.write("---------------------------------------------------------\n");
                        // writer.write("|\tJenis Kain\t|\tWarna\t|\tPanjang\t|\n");
                        // writer.write("---------------------------------------------------------\n");
                        writer.write(tableString);
                        System.out.println("Rekap Penjualan telah ditulis ke file 'Rekapitulasi.txt'.");

                        // writer.write(Tabel.printResponsiveTable3(data.userRekap));
                    } catch (IOException e) {
                    }

                    // try (BufferedWriter writer = new BufferedWriter(new FileWriter("Rekapitulasi.txt", true))) {
                    //     for (Rekapitulasi hari : data.userRekap) {
                            // System.out.printf("|\t%10s\t", hari.GetKain());
                            // System.out.printf("|\t%5s\t", hari.GetWarna());
                            // System.out.printf("|\t%7s\t|", hari.GetPanjang());
                            // System.out.printf("|\t%7s\t|", hari.Getharga());
                            // System.out.println("");

                            // Menulis ke file di setiap iterasi
                            // writer.write("Penjualan Tanggal : " + tanggalDalamFormat + "\n");
                            // writer.write("---------------------------------------------------------\n");
                            // writer.write("| Rekapan |\n");
                            // writer.write("---------------------------------------------------------\n");
                            // writer.write("|\tJenis Kain\t|\tWarna\t|\tPanjang\t|\n");
                            // writer.write("---------------------------------------------------------\n");
                            // writer.write(String.format("|\t%10s\t", hari.GetKain()));
                            // writer.write(String.format("|\t%5s\t", hari.GetWarna()));
                            // writer.write(String.format("|\t%7s\t|\n", hari.GetPanjang()));
                        // }
                        // System.out.println("Rekap Penjualan telah ditulis ke file 'Rekapitulasi.txt'.");
                    // } catch (IOException e) {
                    //     e.printStackTrace();
                    // }

                    break;
                case "0":
                    System.out.println("Anda Keluar Dari Aplikasi");
                    loop = false; // Keluar dari loop utama
                    break;

                default:
                    System.err.println(
                            "Pilihan Anda Tidak Ada Di Main Menu. Silahkan Pilih Sesuai Dengan Yang Ada Di Atas");
            }

            // loop = getYesOrNo("Apakah Anda Ingin Melanjutkan");
            if (!jawaban.equals("0")) {
                loop = getYesOrNo("Apakah Anda Ingin Melanjutkan");
            }
            // loop = getYesOrNo("Apakah Anda Ingin Melanjutkan");
        }

        userInput.close();
    }

    private static boolean getYesOrNo(String pesan) {
        Scanner userInput = new Scanner(System.in);
        String jawaban;
        System.out.println("\n" + pesan + " y/n");
        jawaban = userInput.next();

        while (!jawaban.equalsIgnoreCase("y") && !jawaban.equalsIgnoreCase("n")) {
            System.err.println("Pilihan Anda bukan Y/N");
            System.out.println("\n" + pesan + "y/n");
            jawaban = userInput.next();
        }

        return jawaban.equalsIgnoreCase("y");
    }

    static class User {
        private String jenisKain;
        private String warna;
        private String tglMasuk;
        private int jumlah;
        private int panjang;
        private int Harga;
        private String PrimaryKey;

        public User(String jenisKain, String warna, String tglMasuk, int jumlah, int panjang, int Harga) {
            this.jenisKain = jenisKain;
            this.warna = warna;
            this.tglMasuk = tglMasuk;
            this.jumlah = jumlah;
            this.panjang = panjang;
            this.Harga = Harga;
            this.PrimaryKey = GeneratePrimaryKey();
        }

        private String GeneratePrimaryKey() {
            return jenisKain.substring(0, 3).toUpperCase() + warna.substring(0, 1).toUpperCase()
                    + tglMasuk.substring(0, 2) + tglMasuk.substring(3, 5);
        }

        public String getJenisKain() {
            return jenisKain;
        }

        public String getTglMasuk() {
            return tglMasuk;
        }

        public int getPanjang() {
            return panjang;
        }

        public int getJumlah() {
            return jumlah;
        }

        public String getWarna() {
            return warna;
        }

        public String GetPrimaryKey() {
            return PrimaryKey;
        }

        public int GetHarga() {
            return Harga;
        }
    }

    static class UserToko {

        private String jenisKain;
        private String warna;
        private int harga;
        private int panjang;
        private String primaryKey;

        public UserToko(String jenisKain, String warna, int harga, int panjang) {
            this.jenisKain = jenisKain;
            this.warna = warna;
            this.harga = harga;
            this.panjang = panjang;
            this.primaryKey = primaryKey;
        }

        public String getJenisKain() {
            return jenisKain;
        }

        public int getPanjang() {
            return panjang;
        }

        public int getHarga() {
            return harga;
        }

        public String getWarna() {
            return warna;
        }

        public String GetPrimaryKey() {
            return primaryKey;
        }

        public void GantiPanjang(int GantiPanjang) {
            this.panjang = GantiPanjang;
        }
    }

    static class Rekapitulasi {
        private String JenisKain;
        private String Warna;
        private int Panjang;
        private int Harga;

        public Rekapitulasi(String JenisKain, String Warna, int Panjang, int Harga) {
            this.JenisKain = JenisKain;
            this.Panjang = Panjang;
            this.Warna = Warna;
            this.Harga = Harga;
        }

        public String GetKain() {
            return JenisKain;
        }

        public String GetWarna() {
            return Warna;

        }

        public int GetPanjang() {
            return Panjang;
        }

        public int Getharga() {
            return Harga;
        }
    }

}