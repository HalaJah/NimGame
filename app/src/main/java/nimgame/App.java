package nimgame;
import java.util.concurrent.ThreadLocalRandom;

import org.checkerframework.checker.units.qual.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    public static StringBuilder nimSum(ArrayList<Integer> list)
    {
       /*  ArrayList<StringBuilder> binary = new ArrayList<>();
        StringBuilder element = null;

        for(int i = 0; i < list.size(); i++)
        {
            element = new StringBuilder(Integer.toBinaryString(list.get(i)));
            binary.add(element);
        }

         Comparator<StringBuilder> comparator = (sb1, sb2) -> Integer.compare(sb1.length(), sb2.length());
        */


        Integer max = Collections.max(list);
        int maxLength = Integer.toBinaryString(max).length(); 

        int xorSum = 0;

        for(int i = 0; i < list.size(); i++)
        {
            xorSum ^= list.get(i);
        }
        String binaryXorSum = Integer.toBinaryString(xorSum);
        StringBuilder nimSum = new StringBuilder(binaryXorSum);
            int xorSumLength = binaryXorSum.length();

            if( xorSumLength < maxLength)
            {
                char[] zeros = new char[maxLength - xorSumLength];
                Arrays.fill(zeros, '0');

                nimSum.insert(0, zeros);
                
            }
           
        return nimSum;
    }

    public static ArrayList<Integer> zeroNimSum(ArrayList<Integer> list) 
    {
        StringBuilder nimSum = nimSum(list);
        Integer max = Collections.max(list);
        int maxIndex = list.indexOf(max);
        StringBuilder maxSb = new StringBuilder(Integer.toBinaryString(max));

        for(int i = 0; i < nimSum.length(); i++)
        {
            char nimChar = nimSum.charAt(i);
            char maxSbChar = maxSb.charAt(i);
            if(nimChar == '1')
            {
                if(maxSbChar == '1')
                {
                    maxSb.replace(i, i + 1, "0");
                }
                else
                {
                    maxSb.replace(i, i + 1, "1");
                }
                
            }
        }

        Integer maxNum = Integer.parseInt(maxSb.toString(), 2);

        list.set(maxIndex, maxNum);

        return list;
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
       System.out.println(nimSum(pebbles));

       if(Integer.parseInt(nimSum(pebbles).toString(),2) != 0)
       {
            System.out.println(zeroNimSum(pebbles));
       }

       
       

       if(pileNumber == 1)
       {
        System.out.println("I'm Player A, I'll be removing " +  pebbles.get(0) + " pebbles out of the pile");
        pebbles.set(0, 0);

        System.out.println(pebbles);
        System.out.println("Leo wins!");
       }

    






       
    }
}
