import javax.swing.*;
import java.util.ArrayList;

public class Player implements Comparable<Player>{
    private String name;
    private int bank;
    private ArrayList<Bet> bets;

    public Player(){
        String name = JOptionPane.showInputDialog(null,"Please enter your name: ","Dice Poker",JOptionPane.INFORMATION_MESSAGE);
        this.name = name;
        this.bank = 6;
        this.bets = new ArrayList<>();

        //These following lines are code that would allow user to enter a different starting bank pool. Remove the above line
        //and place the following three.
        //String bank = JOptionPane.showInputDialog("Please enter the amount you would like to play with: ");
        //bank = Integer.parseInt(EvenOddChoice);
        //this.bank = bank;
    }

    public Player(String name, int bank){
        this.name = name;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public int getBank() {
        return bank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void addBet(Bet bets) {
        this.bets.add(bets);
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }



    //Checks to see if the player bet does not exceed his bank.
    public boolean checkBank(int betAmount){
        if(betAmount > this.bank)
            return false;
        else
            return true;
    }

    //Prepares the final output by calling each result from each bet in the bet array and then prints reason for game
    //end and final bank value.
    public void finalOutput(int endReason){
        String output = this.name+ "\n\n";

        for(int i = 0; i < this.bets.size(); i++ ){
            output = output + this.bets.get(i).getResult() + "\n";
        }

        if(endReason == 0)
            output = output + "\nRan out of funds.\n";
        else
            output = output + "\nNo more tries.\n";

        output = output + "\nFinal Bank Value: " + this.bank;
        JOptionPane.showMessageDialog(null, output, "Dice Poker", JOptionPane.INFORMATION_MESSAGE);
    }

    //This is player roll. It creates a bet and adds it to array, then it calls the three function from Bet class
    //to get the bet size and check available funds it does the actual roll and displays the result.
    public void play(){
        this.bets.add(new Bet(this));
        this.bets.get(bets.size() -1).betSize();
        this.bets.get(bets.size() -1).roll();
        this.bets.get(bets.size() -1).display();
    }

    @Override
    public int compareTo(Player o) {
        if(this.bank != o.getBank()){
            return this.bank - o.getBank();
        }
        return this.name.compareTo(o.getName());
    }
}
