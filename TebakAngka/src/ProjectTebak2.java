import java.util.Random;
import java.util.Scanner;

public class ProjectTebak2 {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    int bil1 = rand.nextInt(101);
    int bil2 = -1;
    int score = 100;
    int coba,bonus = 0;

    void tebak(){
        System.out.println("Hai.. nama saya Mr. Lappie, saya telah memilih sebuah bilangan bulat secara acak antara 0 s/d 100. Silakan tebak ya!!!");
        while(bil1 != bil2 && score!=0){
            System.out.print("Tebakan Anda : ");
            bil2 = input.nextInt();
            if (bil2 > bil1){
                System.out.println("Hehehe.... Tebakan Anda terlalu besar");
                score -= 2;
                ++coba;
            }
            else if (bil2 < bil1){
                System.out.println("Hehehe.... Tebakan Anda terlalu kecil");
                score -= 2;
                ++coba;
            }
        }
        System.out.println("Yee Tebakan Anda benar :-)");
        if (coba < 5){
            bonus += 50;
        }
        int totalScore = bonus+score;
        System.out.println("=====================================");
        System.out.println("Score Anda  : " + score + "\n" + "Bonus : "  + bonus + "\n" + "Total Score   : "  + totalScore);
        
    }

}

