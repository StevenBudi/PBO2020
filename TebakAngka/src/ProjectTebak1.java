import java.util.Random;
import java.util.Scanner;

public class ProjectTebak1 {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    int bil1 = rand.nextInt(101);
    int bil2 = -1;

    void tebak(){
        System.out.println("Hai.. nama saya Mr. Lappie, saya telah memilih sebuah bilangan bulat secara acak antara 0 s/d 100. Silakan tebak ya!!!");
        while(bil1 != bil2){
            System.out.print("Tebakan Anda : ");
            bil2 = input.nextInt();
            if (bil2 > bil1){
                System.out.println("Hehehe.... Tebakan Anda terlalu besar");
            }
            else if (bil2 < bil1){
                System.out.println("Hehehe.... Tebakan Anda terlalu kecil");
            }
        }
        System.out.println("Yee Tebakan Anda benar :-)");
    }

}
