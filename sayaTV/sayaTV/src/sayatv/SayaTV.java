package sayatv;

import java.util.*;
import java.io.*;

public class SayaTV {

    static InputStreamReader scan = new InputStreamReader(System.in);
    final BufferedReader read = new BufferedReader(scan);
    static boolean kondisi = true;
    ArrayList dataUsername = new ArrayList();
    ArrayList dataPassword = new ArrayList();
    ArrayList dataEmail = new ArrayList();
    ArrayList dataAlamat = new ArrayList();
    ArrayList dataNama = new ArrayList();
    static ArrayList dataPaket = new ArrayList();
    static ArrayList dataHarga = new ArrayList();
    static ArrayList dataSaluranTV = new ArrayList();
    static ArrayList dataPaketSaluranTV = new ArrayList();
    ArrayList dataNoHP = new ArrayList();
    ArrayList dataHobi = new ArrayList();
    String paketSaluranTV;
    String saluranTV;
    String harga;
    String nama;
    String username;
    String password;
    String alamat;
    String paket;
    String email;
    String pilihan;
    String hobi;
    long noHP;
    static SayaTV data = new SayaTV();
    static SayaTV input = new SayaTV();
    static SayaTV signIn = new SayaTV();
    static SayaTV signUp = new SayaTV();
    static SayaTV user = new SayaTV();
    static SayaTV admin = new SayaTV();

    static void garisTepi() {
        System.out.println("==========================");
    }

    static void noPilihan() {
        System.out.println("Pilihan tidak tersedia");
    }

    static void form() throws IOException {
        System.out.print("Masukkan nama: ");
        data.nama = input.read.readLine();
        System.out.print("Masukkan alamat: ");
        data.alamat = input.read.readLine();
        System.out.print("Masukkan usename: ");
        data.username = input.read.readLine();
        System.out.print("Mauskkan password: ");
        data.password = input.read.readLine();
        System.out.print("Masukkan email: ");
        data.email = input.read.readLine();
        System.out.print("Masukkan no-HP: ");
        data.noHP = Long.valueOf(input.read.readLine());
        System.out.print("Masukkan hobi: ");
        data.hobi = input.read.readLine();

    }

    static void menuAwal() throws IOException {
        System.out.println("======= Menu Login =======");
        System.out.println("[1]. SignIn");
        System.out.println("[2]. SignUp");
        System.out.println("[3]. Lupa password");
        System.out.println("[4]. Keluar Aplikasi");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        garisTepi();
        System.out.println();
        switch (pilihan) {
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            case 3:
                lupaPassword();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                garisTepi();
                noPilihan();
        }
    }

    static void signUp() throws IOException {
        do {
            System.out.println("========= SignUp =========");
            System.out.print("Daftar sebagai (admin/user) ");
            String pilihan = input.read.readLine();
            garisTepi();
            System.out.println();
            if (pilihan.equalsIgnoreCase("admin")) {
                System.out.println("========= SignUp =========");
                form();
                garisTepi();
                if (!admin.dataUsername.contains(data.username)) {
                    admin.dataNama.add(data.nama);
                    admin.dataAlamat.add(data.alamat);
                    admin.dataEmail.add(data.email);
                    admin.dataNoHP.add(data.noHP);
                    admin.dataUsername.add(data.username);
                    admin.dataPassword.add(data.password);
                    admin.dataHobi.add(data.hobi);
                    kondisi = false;
                    System.out.println();
                    garisTepi();
                    System.out.println("Selamat anda berhasil mendaftar");

                } else {

                    System.out.println();
                    garisTepi();
                    System.out.println("SignUp dibatalkan");
                    System.out.println("Username sudah digunakan");
                    kondisi = false;
                }
            } else if (pilihan.equalsIgnoreCase("user")) {
                System.out.println("========= SignUp =========");
                form();
                if (!user.dataUsername.contains(data.username)) {
                    user.dataNama.add(data.nama);
                    user.dataAlamat.add(data.alamat);
                    user.dataEmail.add(data.email);
                    user.dataNoHP.add(data.noHP);
                    user.dataUsername.add(data.username);
                    user.dataPassword.add(data.password);
                    user.dataHobi.add(data.hobi);
                    kondisi = false;
                    System.out.println("Selamat anda berhasil mendaftar");
                    garisTepi();
                    System.out.println();
                    garisTepi();
                } else {
                    System.out.println();
                    garisTepi();
                    System.out.println("SignUp dibatalkan");
                    System.out.println("Username sudah digunakan");
                    kondisi = false;
                }
            } else {
                garisTepi();
                noPilihan();
                System.out.println("Ulangi lagi");
                garisTepi();
                System.out.println();
            }
        } while (kondisi);

    }

    static void signIn() throws IOException {
        do {
            System.out.println("========= SignIn =========");
            System.out.print("Masukkan username: ");
            signIn.username = input.read.readLine();
            System.out.print("Masukkan password: ");
            signIn.password = input.read.readLine();
            if (admin.dataUsername.contains(signIn.username) && admin.dataPassword.contains(signIn.password)) {
                showMenuAdmin(0);
            } else if (user.dataUsername.contains(signIn.username) && user.dataPassword.contains(signIn.password)) {
                showMenuUser(0);
            } else {
                System.out.println("Password atau Username SALAH!!!");
            }
        } while (kondisi);

    }

    static void lupaPassword() throws IOException {
        System.out.println("====== Lupa password =====");
        System.out.print("Masukkan username: ");
        String username = input.read.readLine();
        System.out.print("Masukkan hobi: ");
        String hobi = input.read.readLine();
        if ((user.dataUsername.contains(username) && user.dataHobi.contains(hobi)) || (admin.dataUsername.contains(username) && admin.dataHobi.contains(hobi))) {
            int i = user.dataUsername.indexOf(username);
            int j = admin.dataUsername.indexOf(username);
            do {
                System.out.print("Password baru: ");
                String password = input.read.readLine();
                System.out.print("Konfirmasi password: ");
                String confirmPassword = input.read.readLine();
                if (password.equals(confirmPassword)) {
                    if (user.dataUsername.contains(username)) {
                        user.dataPassword.set(i, password);
                    } else if (admin.dataUsername.contains(username)) {
                        admin.dataPassword.set(j, password);
                    }
                    System.out.println("Password berhasil diubah");
                    kondisi = false;
                } else {
                    System.out.println("Ulangi lagi");
                }
            } while (kondisi);
        } else {
            System.out.println("Username tidak ditemukan");
        }
    }

    static void showMenuUser(int i) throws IOException {
        System.out.println("====== Menu Layanan ======");
        System.out.println("[1]. Daftar paket");
        System.out.println("[2]. Beli paket berlangganan");
        System.out.println("[3]. Info paket berlangganan");
        System.out.println("[4]. Berhenti berlangganan");
        System.out.println("[5]. Info akun");
        System.out.println("[6]. Logout");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        garisTepi();
        System.out.println();
        switch (pilihan) {
            case 1:
                daftarPaket("tersedia");
                break;
            case 2:
                beliPaket();
                break;
            case 3:
                infoPaket();
                break;
            case 4:
                berhentiPaket();
                break;
            case 5:
                user.infoAkun(i);
                break;
            case 6:
                menuAwal();
                break;
            default:
                noPilihan();

        }
    }

    static void showMenuAdmin(int i) throws IOException {
        System.out.println("====== Menu Layanan ======");
        System.out.println("[1]. Daftar & Info Pelanggan");
        System.out.println("[2]. Daftar Paket");
        System.out.println("[3]. Daftar Saluran TV");
        System.out.println("[4]. Tambahkan Paket");
        System.out.println("[5]. Tambahkan saluran TV");
        System.out.println("[6]. Info Akun");
        System.out.println("[7]. Logout");
        System.out.print("Pilih: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        switch (pilihan) {
            case 1:
                daftarPelanggan();
                break;
            case 2:
                daftarPaket("ditambahkan");
                break;
            case 3:
                daftarSaluranTV();
                break;
            case 4:
                addPaket();
                break;
            case 5:
                addSaluranTV();
                break;
            case 6:
                admin.infoAkun(i);
                break;
            case 7:
                menuAwal();
                break;
            default:
                noPilihan();
        }

    }

    static void daftarPaket(String keterangan) throws IOException {
        System.out.println("====== Daftar Paket ======");
        if (dataPaket.isEmpty()) {
            System.out.println("Paket belum " + keterangan);
        } else {
            for (int i = 0; i < dataPaket.size(); i++) {
                System.out.format("[d]. Paket %s\n", (i + 1), dataPaket.get(i));
                System.out.println("    Saluran TV : ");
                for (int j = 0; j < dataPaketSaluranTV.size(); j++) {
                    System.out.format("    %d. %s\n", (j + 1), dataPaketSaluranTV.get(j));
                }
                System.out.format("     Harga %s", dataHarga.get(i));
                System.out.println();
            }

        }
    }

    static void beliPaket() throws IOException {
        daftarPaket("tersedia");
        System.out.print("Pilih paket: ");
        int pilihan = Integer.valueOf(input.read.readLine());
        if (pilihan <= dataPaket.size() && pilihan > 0) {
            System.out.println("Mode pembayaran: ");
            System.out.println("[1]. Bayar langsung ke tempat");
            System.out.println("[2]. Via ATM");
            int i = Integer.valueOf(input.read.readLine());
            switch (i) {
                case 1:
                    System.out.println("Pembayaran di");
                    break;
                case 2:
                    System.out.println("Pembayaran dikirim ke nomer");
                    System.out.println("Setelah selesai silahkan upload foto bukti pembayaran ke nomor");
                    System.out.println("guna memvalidasi pembayaran");
                    break;
                default:
                    noPilihan();
            }
        }

    }

    static void infoPaket() {

    }

    static void berhentiPaket() {

    }

    static void daftarPelanggan() {
        System.out.println("=== Daftar & Info Pelanggan ===");
        if (user.dataUsername.isEmpty()) {
            System.out.println("Belum ada pelanggan");

        }

    }

    static void daftarSaluranTV() {
        System.out.println("==== Daftar Saluran TV ===");
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Saluran TV belum ditambahkan");
        } else {
            for (int i = 0; i < dataSaluranTV.size(); i++) {
                System.out.format("[d]. %s. ", (i + 1), dataSaluranTV.get(i));
                System.out.println();
            }
        }
    }

    static void addPaket() throws IOException {
        System.out.println("===== Tambahkan Paket ====");
        if (dataSaluranTV.isEmpty()) {
            System.out.println("Saluran TV belum ditambahkan");
        } else {
            daftarSaluranTV();
            do {
                System.out.print("Pilih saluran TV: ");
                int i = Integer.valueOf(input.read.readLine());
                data.paketSaluranTV = String.valueOf(dataSaluranTV.get(i - 1));
                dataPaketSaluranTV.add(data.paketSaluranTV);
                boolean kondisi1 = true;
                do {
                    System.out.print("Pilih lagi?(Y/N) ");
                    String pilihan = input.read.readLine();
                    if (pilihan.equalsIgnoreCase("y")) {
                        kondisi1 = false;
                    } else if (pilihan.equalsIgnoreCase("n")) {
                        kondisi1 = false;
                        kondisi = false;
                    }
                } while (kondisi1);
            } while (kondisi);
            System.out.print("Nama paket: ");
            data.paket = input.read.readLine();
            System.out.print("Harga paket: ");
            data.harga = input.read.readLine();
            int j = dataPaket.size();
            dataPaket.add(data.paket);
            dataHarga.add(data.harga);
            garisTepi();
            System.out.println();
            garisTepi();
            System.out.format("Paket ke-%d telah tersimpan", j + 1);
        }
    }

    static void addSaluranTV() throws IOException {
        System.out.println("== Tambahkan Saluran TV ==");
        System.out.print("Masukkan saluran TV: ");
        data.saluranTV = input.read.readLine();
        int i = dataSaluranTV.size();
        dataSaluranTV.add(data.saluranTV);
        garisTepi();
        System.out.println();
        garisTepi();
        System.out.format("Saluran ke-%d telah tersimpan", i + 1);
    }

    void infoAkun(int i) throws IOException {

    }

    public static void main(String[] args) throws IOException {
        do {
            menuAwal();
            garisTepi();
            boolean kondisi1 = true;
            do {
                System.out.println();
                if (user.dataUsername.contains(signIn.username) && user.dataPassword.contains(signIn.password)) {
                    System.out.println("sukses");
                }
                garisTepi();
                System.out.print("Kembali Tampilan awal (Y/N) ");
                String pilihan = input.read.readLine();
                if (pilihan.equalsIgnoreCase("y")) {
                    kondisi1 = false;
                } else if (pilihan.equalsIgnoreCase("n")) {
                    kondisi1 = false;
                    garisTepi();
                } else {
                    garisTepi();
                    System.out.println("Inputan Salah");
                }
                kondisi = true;
                garisTepi();
            } while (kondisi1);
        } while (kondisi);
    }

}
