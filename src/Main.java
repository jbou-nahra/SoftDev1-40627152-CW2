import javax.swing.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Dice d1 = new Dice(6);
        Dice d2 = new Dice(6);
        Player p1 = new Player("Jon",6);
        ArrayList<Dice> dice = new ArrayList<>();
        dice.add(d1);
        dice.add(d2);

        Bet B1 = new Bet(p1,1,dice);
        B1.roll();
        B1.display();


    }
}