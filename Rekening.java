// L0325034 - Tyasastri Hning Kurniasih
// Praktikum 3 PBO

package Praktikum3.Tugas;

public class Rekening {
    // Attributes
    private String nomorRekening;
    private String namaNasabah;
    private double saldo;
    
    // Constructors
    public Rekening(String nomorRekening, String namaNasabah, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaNasabah = namaNasabah;
        this.saldo = saldo;
    }
    
    // Method tarikTunai(double jumlah)
    public void tarikTunai(double jumlah) throws SaldoTidakMencukupiException {
        if (jumlah > this.saldo) {
            // Output struk tidak valid, duit kurang
            System.out.println("--- PENARIKAN GAGAL ---");
            System.out.println("Nasabah: " + this.namaNasabah);
            System.out.println("No. Rekening: " + maskingNomorRekening());
            System.out.printf("Jumlah Tarik: Rp%,.2f\n", jumlah);
            System.out.printf("Sisa Saldo  : Rp%,.2f\n", this.saldo);
            
            throw new SaldoTidakMencukupiException("Tidak bisa menarik tunai. Saldo tidak mencukupi!");
        }
        this.saldo -= jumlah;
        
        // Output struk penarikan valid /berhasil
        System.out.println("--- STRUK PENARIKAN TUNAI ---");
        System.out.println("Nasabah: " + this.namaNasabah);
        System.out.println("No. Rekening: " + maskingNomorRekening());
        System.out.printf("Jumlah Tarik: Rp%,.2f\n", jumlah);
        System.out.printf("Sisa Saldo  : Rp%,.2f\n", this.saldo);
        System.out.println("=============================");
    }
    
    // Method maskingNomorRekening()
    public String maskingNomorRekening() {
        if(this.nomorRekening == null || this.nomorRekening.length() <= 5) {
            return this.nomorRekening; // kembalikan jika terlalu pendek
        }
        int panjangMasking = this.nomorRekening.length() - 5;
        StringBuilder sb = new StringBuilder();
        
        /// Ambil 5 karakter pertama
        sb.append(this.nomorRekening.substring(0, 5));
        
        // Tambahkan karakter '*' sebanyak sisa panjangnya
        for (int i = 0; i < panjangMasking; i++) {
            sb.append("*");
        }

        return sb.toString();
    }

    // Getter verifikasi saldo
    public double getSaldo() {
        return saldo;
    }
}
