import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Player p1 = new Player();//Initialize player.

        //Loops bet 5 times and breaks if player reaches 0 dollars.
        for(int i = 0; i < 5; i++){
            p1.addBet(new Bet(p1));
            ArrayList<Bet> tempBet = p1.getBets();
            tempBet.get(i).betSize();
            tempBet.get(i).roll();
            tempBet.get(i).display();
            if(p1.getBank()<=0){
                p1.finalOutput(0);
                return;
            }
        }
        p1.finalOutput(1);
    }
}
