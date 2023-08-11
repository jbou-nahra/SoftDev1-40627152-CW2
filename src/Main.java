public class Main {
    public static void main(String[] args) {

        int diceNumber = 2;
        int diceSides = 6;
        int bank = 6;
        int round = 5;

        Player p1 = new Player();//Initialize player.
        p1.setBank(bank);

        //Loops bet 5 times and breaks if player reaches 0 dollars.
        for(int i = 0; i < round; i++){
            p1.play(diceNumber, diceSides);
            if(p1.getBank()<=0){
                p1.finalOutput(0);
                return;
            }
        }
        p1.finalOutput(1);
    }
}
