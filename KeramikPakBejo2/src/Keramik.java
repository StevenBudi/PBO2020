public class Keramik {
    int panjang, lebar, isi, harga;
    private String tipe;

    Keramik(String x) {
        this.tipe = x.toUpperCase();
    }

    private void jenis() {
        switch (this.tipe) {
            case "A":
                this.panjang = 30;
                this.lebar = 30;
                this.isi = 10;
                this.harga = 54000;
                break;
            case "B":
                this.panjang = 40;
                this.lebar = 40;
                this.isi = 5;
                this.harga = 65000;
                break;
            case "C":
                this.panjang = 40;
                this.lebar = 30;
                this.isi = 8;
                this.harga = 60000;
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
