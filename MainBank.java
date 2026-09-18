// L0325034 - Tyasastri Hning Kurniasih
// Praktikum 3 PBO

package Praktikum3.Tugas;

public class MainBank {
    public static void main(String[] args) {
        Rekening akun = new Rekening("7358471584", "Tyasastri", 5000000);

        try {
            // Penarikan valid
            akun.tarikTunai(3000000);

            // Penarikan melebihi saldo, penerapan exception
            akun.tarikTunai(4000000);
        } catch (SaldoTidakMencukupiException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\nTransaksi selesai diproses untuk no. rekening: " + akun.maskingNomorRekening());
        }
    }
}
