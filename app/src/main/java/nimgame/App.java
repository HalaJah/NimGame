package nimgame;
import java.util.concurrent.ThreadLocalRandom;

import org.checkerframework.checker.units.qual.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    private static ArrayList<StringBuilder> toBinArrayList(ArrayList<Integer> list)
    {
        ArrayList<StringBuilder> binary = new ArrayList<>();
        StringBuilder element = null;

        for(int i = 0; i < list.size(); i++)
        {
            element = new StringBuilder(Integer.toBinaryString(list.get(i)));
            binary.add(element);
        }

       Comparator<StringBuilder> comparator = (sb1, sb2) -> Integer.compare(sb1.length(), sb2.length());
        StringBuilder max = Collections.max(binary, comparator);
        int maxLength = max.length(); 

        for(int j = 0; j < binary.size(); j++)
        {
            int elementLength = binary.get(j).length();

            if( elementLength < maxLength)
            {
                char[] zeros = new char[maxLength - elementLength];
                Arrays.fill(zeros, '0');

                binary.get(j).insert(0, zeros);
                
            }
        }
        
        
        return binary;
    }

    public static StringBuilder nimSum()
       {
        



        return null;
       }
    public static void main(String[] args) {
       // k is num of piles
       int pileNumber = ThreadLocalRandom.current().nextInt(1, 6);

       // a list containing the number of pebbles in each pile
       ArrayList<Integer> pebbles = new ArrayList<>();

       // pebbles number in a pile
       Integer pebblesNumber = 0;

       for(int i = 0; i < pileNumber; i++)
       {
        pebblesNumber = ThreadLocalRandom.current().nextInt(1, 12);
        pebbles.add(pebblesNumber);
       }
       System.out.println("Please Enter Your Name");
       Scanner in = new Scanner(System.in);
       String playerName = in.nextLine();
       
       System.out.println("Hello " + playerName + " , I am a bot called Leo. I will be playing against you, trying to always win! Hit enter if you ready for the game:");
       in.nextLine();
       System.out.println(pebbles);
       ArrayList<StringBuilder> binary = toBinArrayList(pebbles);
       System.out.println(binary);
       

       if(pileNumber == 1)
       {
        System.out.println("I'm Player A, I'll be removing " +  pebbles.get(0) + " pebbles out of the pile");
        pebbles.set(0, 0);

        System.out.println(pebbles);
        System.out.println("Leo wins!");
       }

    






       
    }
}
