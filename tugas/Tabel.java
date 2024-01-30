package tugas;

import tugas.tugas.User;
import tugas.tugas.UserToko;
import tugas.tugas.Rekapitulasi;

public class Tabel {
    // format tabel data userDatabase
    public static void printResponsiveTable(Iterable<User> userDatabase) {
        int numColumns = 7; // Jumlah kolom sesuai dengan data User
        StringBuilder tableRow = new StringBuilder();

        printTableSeparator(tableRow, numColumns);
        printTableRow(tableRow, "PrimaryKey", "Jenis Kain", "Warna", "Panjang", "Tanggal Masuk", "Jumlah", "Harga");
        printTableSeparator(tableRow, numColumns);

        for (User user : userDatabase) {
            printTableRow(tableRow, user.GetPrimaryKey(), user.getJenisKain(), user.getWarna(), user.getPanjang(),
                    user.getTglMasuk(), user.getJumlah(), user.GetHarga());
        }

        printTableSeparator(tableRow, numColumns);
    }

    public static void printTableRow(StringBuilder tableRow, Object... cells) {

        tableRow.setLength(0);

        tableRow.append("|");

        for (Object cell : cells) {

            String cellContent = String.valueOf(cell);

            int remainingWidth = 16 - cellContent.length();

            tableRow.append(" ").append(cellContent);

            for (int i = 0; i < remainingWidth; i++) {

                tableRow.append(" ");

            }

            tableRow.append(" |");

        }

        System.out.println(tableRow.toString());

    }

    public static void printTableSeparator(StringBuilder tableRow, int numColumns) {
        tableRow.setLength(0);
        tableRow.append("+");
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < 18; j++) {
                tableRow.append("-");
            }
            tableRow.append("+");
        }
        System.out.println(tableRow.toString());
    }

    // format tabel data userToko
    public static void printResponsiveTable2(Iterable<UserToko> userToko) {
        int numColumns = 4; // Jumlah kolom sesuai dengan data User
        StringBuilder tableRow = new StringBuilder();

        printTableSeparator2(tableRow, numColumns);
        printTableRow2(tableRow,  "Jenis Kain", "Warna", "Panjang", "Harga");
        printTableSeparator2(tableRow, numColumns);

        for (UserToko toko : userToko) {
            printTableRow2(tableRow,  toko.getJenisKain(), toko.getWarna(), toko.getPanjang(),
                    toko.getHarga());
        }

        printTableSeparator2(tableRow, numColumns);
    }

    public static void printTableRow2(StringBuilder tableRow, Object... cells) {

        tableRow.setLength(0);

        tableRow.append("|");

        for (Object cell : cells) {

            String cellContent = String.valueOf(cell);

            int remainingWidth = 16 - cellContent.length();

            tableRow.append(" ").append(cellContent);

            for (int i = 0; i < remainingWidth; i++) {

                tableRow.append(" ");

            }

            tableRow.append(" |");

        }

        System.out.println(tableRow.toString());

    }

    public static void printTableSeparator2(StringBuilder tableRow, int numColumns) {
        tableRow.setLength(0);
        tableRow.append("+");
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < 18; j++) {
                tableRow.append("-");
            }
            tableRow.append("+");
        }
        System.out.println(tableRow.toString());
    }
    // format tabel data userRekap
    public static void printResponsiveTable3(Iterable<Rekapitulasi> userRekap) {
        int numColumns = 4; // Jumlah kolom sesuai dengan data User
        StringBuilder tableRow = new StringBuilder();

        printTableSeparator2(tableRow, numColumns);
        printTableRow2(tableRow,  "Jenis Kain", "Warna", "Panjang", "Harga");
        printTableSeparator2(tableRow, numColumns);

        for (Rekapitulasi toko : userRekap) {
            printTableRow2(tableRow,  toko.GetKain(), toko.GetWarna(), toko.GetPanjang(),
                    toko.Getharga());
        }

        printTableSeparator2(tableRow, numColumns);
    }

    public static void printTableRow3(StringBuilder tableRow, Object... cells) {

        tableRow.setLength(0);

        tableRow.append("|");

        for (Object cell : cells) {

            String cellContent = String.valueOf(cell);

            int remainingWidth = 16 - cellContent.length();

            tableRow.append(" ").append(cellContent);

            for (int i = 0; i < remainingWidth; i++) {

                tableRow.append(" ");

            }

            tableRow.append(" |");

        }

        System.out.println(tableRow.toString());

    }

    public static void printTableSeparator3(StringBuilder tableRow, int numColumns) {
        tableRow.setLength(0);
        tableRow.append("+");
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < 18; j++) {
                tableRow.append("-");
            }
            tableRow.append("+");
        }
        System.out.println(tableRow.toString());
    }
}
