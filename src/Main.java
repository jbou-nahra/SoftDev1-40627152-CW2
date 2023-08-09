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
        ArrayList<Bet> bets = new ArrayList<>(); // Array to hold each bet in game.

        Player p1 = new Player();
        diceSet(dice, diceNumber, diceSides);//This initializes the dice array.

        //Loops bet 5 times and breaks if player reaches 0 dollars.
        for(int i = 0; i < 5; i++){
            betAmount = betSize(p1);
            bets.add(new Bet(p1,betAmount,dice));
            bets.get(i).roll();
            bets.get(i).display();
            if(p1.getBank()<=0){
                finalOutput(p1,bets,0);
                return;
            }
        }
        finalOutput(p1,bets,1);
    }

    //Initializes the dice array.
    public static void diceSet(ArrayList<Dice> dice, int diceNumber, int diceSides){
        for(int i = 0; i < diceNumber; i++)
            dice.add(new Dice(diceSides));
    }

    //Displays bank value to player and requests a bet amount. Checks to see if it does not exceed player bank.
    public static int betSize(Player p1){
        int betAmount = 1;
        do {
            do {
                String betAmountString = JOptionPane.showInputDialog(null, "Your current bank balance is: "
                        +p1.getBank()+ "\nPlease enter a bet amount between 1 and 4: ", "Dice Poker", JOptionPane.INFORMATION_MESSAGE);
                betAmount = Integer.parseInt(betAmountString);
            } while (betAmount < 1 || betAmount > 4);
            if(p1.checkBank(betAmount) == false){
                JOptionPane.showMessageDialog(null, "Sorry, this bet exceeds your available funds. " +
                        "Please re-enter bet amount.", "Dice Poker", JOptionPane.INFORMATION_MESSAGE);
            }
        }while(p1.checkBank(betAmount) == false);
        return betAmount;
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
