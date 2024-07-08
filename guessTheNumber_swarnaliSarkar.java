
import java.util.Random;
import java.util.Scanner;
public class guessTheNumber_swarnaliSarkar {
    int n;
    int i;
    guessTheNumber_swarnaliSarkar(){
        Random r = new Random();
        this.n = r.nextInt(100);
    }
    void input(){
        System.out.println("ENTER YOUR CHOICE");
        Scanner s = new Scanner(System.in);
        i = s.nextInt();
    }
    boolean correct(){
        if(n==i){
            return true;
        }else if(i>n){
            System.out.println("CHOOSE A LESSER NUMBER");
        }else if(i<n){
            System.out.println("CHOOSE A GREATER NUMBER");
        }
        return false;
    }
    public static void main(String[] args) {
        guessTheNumber_swarnaliSarkar g = new guessTheNumber_swarnaliSarkar();
        double points=0.0;
        int max =8;
        int  count=0;
        boolean ans=false;
        while(!ans){
            g.input();
            ++count;
            ans = g.correct();

            if(count>max){
                System.out.println("OHH NO! YOU HAVE REACHED THE MAXIMUM NUMBER OD GUESSES.BETTER LUCK NEXT TIME!!");
                System.out.println("YOUR SCORE IS "+points);
                ans=true;
            }
        }
            if(count<max){ 
                System.out.println("NUMBER OF GUESSES: "+count);
                points = (count*100)/max;
                System.out.println("YOUR SCORE IS "+points);
            }
    }
}
