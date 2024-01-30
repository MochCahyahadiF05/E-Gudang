package tugas;

import java.util.ArrayList;

import tugas.tugas.Rekapitulasi;
import tugas.tugas.User;
import tugas.tugas.UserToko;

public class Data {
    ArrayList<User> userDatabase = new ArrayList<>();
    ArrayList<UserToko> userToko = new ArrayList<>();
    ArrayList<Rekapitulasi> userRekap = new ArrayList<>();

    public Data() {
        initUserDatabase();
        initUserToko();
        initUserRekap();
    }
    private void initUserDatabase() {
        // for(int i=0; i<10;i++){
        //     userDatabase.add(new User("Sutra", "Ungu", "12-02-2023", 1, 100, 300000));
        //     userDatabase.add(new User("123456789012345", "Merah", "12-08-2023", 1, 100, 123456789));
        // }
        userDatabase.add(new User("Sutra", "Ungu", "12-02-2023", 1, 100, 300000));
        userDatabase.add(new User("Sutra", "Hijau", "12-02-2023", 1, 100, 300000));
        userDatabase.add(new User("Sutra", "Merah", "12-02-2023", 1, 100, 300000));
    }
    private void initUserToko() {
        userToko.add(new UserToko("Sutra", "Merah", 20000, 73));
    }
    private void initUserRekap() {
        userRekap.add(new Rekapitulasi("Sutra", "Merah", 73, 20000));
        userRekap.add(new Rekapitulasi("Susadasdastra", "Merah", 73, 20000));
        
    }
}
