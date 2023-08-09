import javax.swing.*;
import java.util.ArrayList;

public class Bet {
    private int betAmount;
    private Player player;
    private ArrayList<Dice> dice = new ArrayList<>();
    private String result;
    private int winnings;


    public Bet(Player player, int betAmount, ArrayList<Dice> dice){
        this.dice = dice;
        this.player = player;
        this.betAmount = betAmount;
        this.result = "Bet: \u00a3" +betAmount+ "   ";
    }

    //Rolls each dice in dice array then passes results for testing for identical and sequential. If both fail player loses.
    public void roll(){
        ArrayList<Integer> rolls = new ArrayList<>();
        for(int i = 0; i < this.dice.size();i++){
            rolls.add(i, this.dice.get(i).roll());
            int s = i+1;
            this.result = this.result + "Dice " + s + " roll: ";
            this.result = this.result + Integer.toString(rolls.get(i)) + "   ";
        }
        boolean match;
        match = compareIdentical(rolls);
        if(match == true){
            this.winnings = betAmount * 3;
            player.setBank(player.getBank()+this.winnings);
            this.result = this.result + "Identical Numbers! Win Triple: \u00a3" + this.winnings;
            return;
        }
        boolean sequential;
        sequential = compareSequential(rolls);
        if(sequential == true){
            this.winnings = betAmount * 2;
            player.setBank(player.getBank()+this.winnings);
            this.result = this.result + "Sequential Numbers. Win Double: \u00a3" + this.winnings;
            return;
        }

        if(match == false && sequential == false){
            player.setBank(player.getBank()-betAmount);
            this.result = this.result + "Out of luck. Lose: \u00a3" + this.betAmount;
        }
    }

    //used to display the result at end of every round.
    public void display(){
        JOptionPane.showMessageDialog(null, this.result, "Dice Poker", JOptionPane.INFORMATION_MESSAGE);
    }

    //used to pass the result when called.
    public String displayReturn(){
        return this.result;
    }

    //Arranges the dice roll from smallest to largest then tests to see if they are sequential.
    public boolean compareSequential (ArrayList<Integer> rolls){
        int temp;
        for (int i = 0; i < rolls.size(); i++) {
            for (int j = i+1; j < rolls.size(); j++) {
                if(rolls.get(i) > rolls.get(j)) {
                    temp = rolls.get(i);
                    rolls.set(i, rolls.get(j));
                    rolls.set(j, temp);
                }
            }
        }
        for (int i = 0; i < rolls.size(); i++) {
            for (int j = i+1; j < rolls.size(); j++) {
                if(rolls.get(i) != rolls.get(j)-1) {
                    return false;
                }
            }
        }
        return true;
    }

    //Test for identical values across the dice rolls.
    public boolean compareIdentical (ArrayList<Integer> rolls){
        for (int i = 0; i < rolls.size(); i++) {
            for (int k = 0; k < rolls.size(); k++) {
                if (rolls.get(i) != rolls.get(k)) {
                    return false;
                }

            }
        }
        return true;
    }
}