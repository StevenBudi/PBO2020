public class Keramik {
    private int panjang, lebar, isi, harga;
    private String tipe;

    Keramik(String x) {
        this.tipe = x.toUpperCase();
    }

    private void jenis() {
        switch (this.tipe) {
            case "A":
                panjang = 30;
                lebar = 30;
                isi = 10;
                harga = 54000;
                break;
            case "B":
                panjang = 40;
                lebar = 40;
                isi = 5;
                harga = 65000;
                break;
            case "C":
                panjang = 40;
                lebar = 30;
                isi = 8;
                harga = 60000;
                break;
            default:
                break;

        }
    }

    private float hitungKeramik(){
        jenis();
        int luasTotal = 1000000;
        float totalKeramik = luasTotal/(this.panjang*this.lebar);
        if (totalKeramik - Math.round(totalKeramik) != 0 && totalKeramik - Math.round(totalKeramik) < 0.5){
            return Math.round(totalKeramik) + 1;
        }
        else {
            return Math.round(totalKeramik);
        }
    }

    private float hitungBox(){
        hitungKeramik();
        float totalBox = hitungKeramik()/this.isi;
        if (totalBox - Math.round(totalBox) != 0 && totalBox - Math.round(totalBox) < 0.5){
            return Math.round(totalBox) + 1;
        }
        else {
            return Math.round(totalBox);
        }
    }

    private int hitungHarga(){
        hitungBox();
        return (int) (hitungBox() * this.harga);
    }

    void output(){
        System.out.println("Total harga jika menggunakan keramik tipe " + this.tipe + " adalah " + hitungHarga());
    }
}
