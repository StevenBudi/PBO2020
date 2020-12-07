import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database{
    private ArrayList<String> db_nim= new ArrayList<>();
    private ArrayList<String> db_nama = new ArrayList<>();
    private ArrayList<Date> db_lahir = new ArrayList<>();
    private ArrayList<Integer> db_gender = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    File file = new File("data.txt");
    Database(){
        if (!file.exists()){
            File file = new File("data.txt");
        }
        else{
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader("data.txt"));
                String line = br.readLine();
                while (line != null){
                    String[] array = line.split("\\|");
                    db_nim.add(array[0]);
                    db_nama.add(array[1]);
                    db_lahir.add(new SimpleDateFormat("dd-MM-yyyy").parse(array[2]));
                    db_gender.add(Integer.parseInt(array[3]));
                    line = br.readLine();
                }
                br.close();
            }catch (Exception e){
                System.out.println("error");
            }
        }
    }

    void menu(){
        int menuPilihan;
        while (true){
            try{
                System.out.println("----------------------------------");
                System.out.println("Menu");
                System.out.println("1. Tambah Data");
                System.out.println("2. Hapus Data (berdasarkan NIM)");
                System.out.println("3. Cari Data");
                System.out.println("4. Tampilkan Data");
                System.out.println("5. Keluar");
                System.out.println("----------------------------------");
                System.out.print("Pilih Menu  : ");
                menuPilihan = Integer.parseInt(input.nextLine());
                if (menuPilihan ==1){
                    setData();
                }
                else if (menuPilihan == 2){
                    try {
                        //Belum menghapus data yg ada di data.txt
                        //Jika program di restart ulang file yg di data.txt akan terbaca lagi
                        System.out.print("Masukkan NIM dari data yang ingin dihapus : ");
                        String delNim = input.nextLine().toUpperCase();
                        int delIndex = db_nim.indexOf(delNim);
                        db_nim.remove(delIndex);
                        db_nama.remove(delIndex);
                        db_lahir.remove(delIndex);
                        db_gender.remove(delIndex);
                        System.out.println("Data " + delNim + " berhasil dihapus dari database.\n");
                    }catch (Exception ex){
                        System.out.println("Maaf data yang masukkan cari tidak ditemukan.\n");
                    }
                }
                else if(menuPilihan==3){
                    System.out.println("Berdasarkan         :");
                    System.out.println("a. Gender");
                    System.out.println("b. NIM");
                    System.out.print("Masukkan Pilihan Anda : ");
                    char subMenu = input.nextLine().toLowerCase().charAt(0);
                    if (subMenu == 'a'){
                        System.out.print("Masukkan gender dari data yang ingin dicari(perempuan/laki-laki) : ");
                        String genderLookup = input.nextLine().toLowerCase();
                        int lookup = 0;
                        if (genderLookup.equals("perempuan")){
                            lookup += 1;
                        }
                        else if (genderLookup.substring(0,4).equals("laki")){
                            ;
                        }
                        else {
                            System.out.println("Jenis kelamin yang anda masukkan tidak dikenal.\n");
                            continue;
                        }
                        String status = (lookup == 1) ? "Perempuan" : "Laki - laki";
                        System.out.println("----------------------------------");
                        System.out.println("Data Mahasiswa "+ status + " : ");
                        for (int i = 0; i < db_gender.size(); i++) {
                            if (db_gender.get(i) == lookup){

                                System.out.print("- ");
                                System.out.println(db_nim.get(i));
                            }
                        }
                        System.out.println("----------------------------------");

                    }
                    else if (subMenu=='b'){
                        System.out.print("Masukkan NIM dari data yang ingin Anda cari : ");
                        String nimLookup = input.nextLine().toUpperCase();
                        int indexLookup = db_nim.indexOf(nimLookup);
                        if (indexLookup<0){
                            System.out.println("Maaf, NIM yang anda cari tidak ada dalam database.");
                            continue;
                        }
                        String gender = (db_gender.get(indexLookup) == 1)? "Perempuan" : "Laki - laki";
                        System.out.println("Data Mahasiswa - "+ nimLookup);
                        System.out.println("----------------------------------");
                        System.out.println("NIM             : "+ db_nim.get(indexLookup));
                        System.out.println("Nama            : "+ db_nama.get(indexLookup));
                        System.out.println("Tanggal Lahir   : "+ db_lahir.get(indexLookup));
                        System.out.println("Gender          : "+ gender);
                    }
                    else {
                        System.out.println("Pilihan yang anda masukkan tidak tepat.\n");
                    }
                }
                else  if(menuPilihan==4){
                    getData();
                }
                else if (menuPilihan==5){
                    break;

                }
                else {
                    System.out.println("Pilihan yang anda masukkan tidak benar.\n");
                    continue;
                }
            }catch (Exception ex){
                System.out.println("Pilihan yang anda masukkan tidak benar.\n");
            }
        }
    }
    private void setData(){
        while (true){
            System.out.print("Masukkan NIM Anda                         : ");
            String nim = input.nextLine().toUpperCase();
            Pattern p = Pattern.compile("^(?:[a-zA-Z][0-9]{7}$)");
            Matcher m = p.matcher(nim);
            if (!m.find()){
                System.out.println("Format data yang anda masukkan tidak tepat.");
                System.out.println("Contoh Format yang tepat : K3519076.\n");
                continue;
            }
            if (db_nim.contains(nim)){
                System.out.println("Maaf data sudah ada didalam database.");
                continue;
            }
            db_nim.add(nim);
            System.out.print("Masukkan Nama Anda                        : ");
            String nama = input.nextLine();
            nama = nama.substring(0, 1).toUpperCase()+ nama.substring(1).toLowerCase();
            db_nama.add(nama);
            String tglLahir;
            while (true){
                System.out.print("Masukkan Tanggal Lahir Anda(dd-mm-yyyy)   : ");
                tglLahir = input.nextLine();
                Pattern date = Pattern.compile("^(?:[0-3][0-9]-[0-1][0-9]-[1-2][0,9][0-9]{2}$)");
                Matcher matcher = date.matcher(tglLahir);
                if (!(matcher.find())){
                    System.out.println("Format data yang anda masukkan tidak tepat.");
                    System.out.println("Contoh Format yang tepat : 31-12-2020.\n");
                }
                else {
                    try {
                        Date tgl = new SimpleDateFormat("dd-MM-yyyy").parse(tglLahir);
                        db_lahir.add(tgl);
                    }catch (Exception e){
                        System.out.println("error.\n");
                        continue;
                    }
                    break;
                }
            }
            System.out.print("Masukkan Gender Anda (perempuan/laki-laki): ");
            String Gender = input.nextLine().toLowerCase();
            int gender = 0;
            while (true){
                if (Gender.equals("perempuan")){
                    gender +=1;
                    break;
                }
                else if(Gender.substring(0,4).equals("laki")){
                    break;
                }
                else {
                    System.out.println("Jenis Kelamin yang anda masukkan tidak valid.\n");
                }
            }

            db_gender.add(gender);
            writeData(nim);
            writeData("|");
            writeData(nama);
            writeData("|");
            writeData(tglLahir);
            writeData("|");
            writeData(Integer.toString(gender));
            writeData("|");
            writeData("\n");

            System.out.print("Tambah Data ? (y/n)                       : ");
            char opsi = input.nextLine().toLowerCase().charAt(0);
            if (opsi == 'n'){
                break;
            }

        }
        clearData();
    }

    private void clearData(){ //Membersihkan data yang tidak lengkap
        for (int i = 0; i < db_nim.size(); i++) {
            if ((db_nim.get(i) == null) & (db_nama.get(i) == null) & (db_lahir.get(i) == null) & (db_gender.get(i) == null)){
                db_nim.remove(db_nim.get(i));
                db_nama.remove(db_nama.get(i));
                db_lahir.remove(db_lahir.get(i));
                db_gender.remove(db_gender.get(i));
            }

        }
    }

    private void getData(){
        for (int i = 0; i <db_nim.size(); i++) {
            System.out.println("Data Mahasiswa");
            System.out.println("----------------------------------");
            System.out.println("Nim             : " + db_nim.get(i));
            System.out.println("Nama            : " + db_nama.get(i));
            System.out.println("Tanggal Lahir   : "+ db_lahir.get(i));
            String outGender = (db_gender.get(i) == 0) ? "Laki - laki" : "Perempuan";
            System.out.println("Gender          : " + outGender);
            System.out.println("----------------------------------");

        }
        System.out.println("Jumlah Mahasiswa: "+ db_nim.size() + "\n");
    }

    private void writeData(String x){
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(x);
            bw.close();
        }catch (Exception e){
            System.out.println("error.\n");
        }
    }

}
