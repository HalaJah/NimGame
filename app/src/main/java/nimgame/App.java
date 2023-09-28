package nimgame;
import java.util.concurrent.ThreadLocalRandom;

import org.checkerframework.checker.units.qual.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    public static  Integer sum(ArrayList<Integer> list)
    {
        Integer sum = 0;
        
        for(int i = 0; i < list.size(); i++)
        {
            sum += list.get(i);
        }

        return sum;
    }


    public static Integer nimSum(ArrayList<Integer> list)
    {
    
        int xorSum = 0;

        for(int i = 0; i < list.size(); i++)
        {
            xorSum ^= list.get(i);
        }
        
           
        return xorSum;
    }

    public static ArrayList<Integer> alterPile(ArrayList<Integer> list) 
    {
        Integer nimSum = nimSum(list);
        
        for(int i = 0; i < list.size(); i++)
        {
            Integer element = list.get(i);
            Integer xorElement = element^nimSum;
            if( xorElement < element)
            {
                list.set(i, xorElement);
                break;
            }
        }

        return list;
    }

    public static ArrayList<Integer> userRemovePebbles(ArrayList<Integer> list, int pileNum, Integer pebblesNum)
    {
        Integer element = list.get(pileNum - 1);
        Integer newElement = element - pebblesNum;

        list.set(pileNum - 1, newElement);
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

       /* ArrayList<Integer> list = new ArrayList<>();
       list.add(9);
       list.add(3);
       list.add(10);

       System.out.println(list); */

       boolean isUserTurn = nimSum(pebbles) == 0;
       do {
           System.out.println(isUserTurn ? "User Turn" : "Bot Turn");
           if (isUserTurn) {
               int pileNum = in.nextInt();
               in.nextLine(); // to consume the remaining newline
               int pebblesNum = in.nextInt();
               userRemovePebbles(pebbles, pileNum, pebblesNum);
           } else {
               alterPile(pebbles);
           }
           System.out.println(pebbles);
           isUserTurn = !isUserTurn;
       } while (sum(pebbles) != 0);
       in.close();
    }       
}
