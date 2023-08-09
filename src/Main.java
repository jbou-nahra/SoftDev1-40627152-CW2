import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // These 2 variables set the amount of dice to be used and the amount of sides each dice can have.
        // Code can be added that will take input from user to change these values if desired.
        int diceNumber = 2;
        int diceSides = 6;
        int betAmount;

        ArrayList<Dice> dice = new ArrayList<>(); // Array to hold multiple dice, this can be more than 2
        //ArrayList<Bet> bets = new ArrayList<>(); // Array to hold each bet in game.

        Player p1 = new Player();
        diceSet(dice, diceNumber, diceSides);//This initializes the dice array.

        //Loops bet 5 times and breaks if player reaches 0 dollars.
        for(int i = 0; i < 5; i++){
            p1.addBet(new Bet(p1,dice));
            ArrayList<Bet> tempBet = p1.getBets();
            tempBet.get(i).betSize();
            tempBet.get(i).roll();
            tempBet.get(i).display();
            if(p1.getBank()<=0){
                finalOutput(p1,p1.getBets(),0);
                return;
            }
        }
        finalOutput(p1,p1.getBets(),1);
    }

    //Initializes the dice array.
    public static void diceSet(ArrayList<Dice> dice, int diceNumber, int diceSides) {
        for (int i = 0; i < diceNumber; i++)
            dice.add(new Dice(diceSides));
    }

    //Prepares the final output by calling each result from each bet in the bet array and then prints reason for game
    //end and final bank value.
    public static void finalOutput(Player p1,ArrayList<Bet> bets, int endReason){
        String output = p1.getName()+ "\n\n";

        for(int i = 0; i < bets.size(); i++ ){
            output = output + bets.get(i).displayReturn() + "\n";
        }

        if(endReason == 0)
            output = output + "\nRan out of funds.\n";
        else
            output = output + "\nNo more tries.\n";

        output = output + "\nFinal Bank Value: " + p1.getBank();
        JOptionPane.showMessageDialog(null, output, "Dice Poker", JOptionPane.INFORMATION_MESSAGE);

    }
}
