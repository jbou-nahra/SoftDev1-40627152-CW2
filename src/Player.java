import javax.swing.*;

public class Player {
    private String name;
    private int bank;

    public Player(){
        String name = JOptionPane.showInputDialog(null,"Please enter your name: ","Dice Poker",JOptionPane.INFORMATION_MESSAGE);
        this.name = name;
        this.bank = 6;

        //These following lines are code that would allow user to enter a different starting bank pool. Remove the above line
        //and place the following three.
        //String bank = JOptionPane.showInputDialog("Please enter the amount you would like to play with: ");
        //bank = Integer.parseInt(EvenOddChoice);
        //this.bank = bank;
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

    //Checks to see if the player bet does not exceed his bank.
    public boolean checkBank(int betAmount){
        if(betAmount > this.bank)
            return false;
        else
            return true;
    }
}
