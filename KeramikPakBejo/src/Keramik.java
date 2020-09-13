public class Keramik {
    int panjang, lebar, isi, harga;
    float totalKeramik, totalBox, totalHarga;

    protected void keramik(String x){
        if (x.equals("A")){
            panjang = 30;
            lebar = 30;
            isi = 10;
            harga = 54000;
        }
        else if (x.equals("B")){
            panjang = 40;
            lebar = 40;
            isi = 5;
            harga = 65000;
        }
        else if (x.equals("C")) {
            panjang = 30;
            lebar = 40;
            isi = 8;
            harga = 60000;
        }
        hitung();
        System.out.println("Total Harga jika Menggunakan Keramik " + x +" adalah "  +(int) totalHarga);
    }

    void hitung(){
        int luasTotal = 1000000;
        totalKeramik = luasTotal/(panjang*lebar);
        if (totalKeramik - Math.round(totalKeramik) != 0 && totalKeramik - Math.round(totalKeramik) < 0.5){
            totalKeramik = Math.round(totalKeramik) + 1;
        }
        else {
            totalKeramik = Math.round(totalKeramik);
        }
        totalBox = totalKeramik/isi;
        if (totalBox - Math.round(totalBox) != 0 && totalBox - Math.round(totalBox) < 0.5){
            totalBox = Math.round(totalBox) + 1;
        }
        else {
            totalBox = Math.round(totalBox);
        }
        totalHarga = totalBox * harga;

    }


}
