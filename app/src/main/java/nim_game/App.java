package nim_game;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class App {
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


       System.out.println(pebbles);
    }
}
