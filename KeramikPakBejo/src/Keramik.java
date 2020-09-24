public class Keramik {
    int panjang, lebar, isi, harga;
    float totalKeramik, totalBox, totalHarga;

    protected void keramik(String x){
        if (x.equals("A")){
            this.panjang = 30;
            this.lebar = 30;
            this.isi = 10;
            this.harga = 54000;
        }
        else if (x.equals("B")){
            this.panjang = 40;
            this.lebar = 40;
            this.isi = 5;
            this.harga = 65000;
        }
        else if (x.equals("C")) {
            this.panjang = 30;
            this.lebar = 40;
            this.isi = 8;
            this.harga = 60000;
        }
        hitung();
        System.out.println("Total Harga jika Menggunakan Keramik " + x +" adalah "  +(int) totalHarga);
    }

    void hitung(){
        int luasTotal = 1000000;
        totalKeramik = luasTotal/(this.panjang*this.lebar);
        if (totalKeramik - Math.round(totalKeramik) != 0 && totalKeramik - Math.round(totalKeramik) < 0.5){
            totalKeramik = Math.round(totalKeramik) + 1;
        }
        else {
            totalKeramik = Math.round(totalKeramik);
        }
        totalBox = totalKeramik/this.isi;
        if (totalBox - Math.round(totalBox) != 0 && totalBox - Math.round(totalBox) < 0.5){
            totalBox = Math.round(totalBox) + 1;
        }
        else {
            totalBox = Math.round(totalBox);
        }
        totalHarga = totalBox * this.harga;

    }


}
