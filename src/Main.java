public class Main {
    public static void main(String[] args) {

        Player p1 = new Player();//Initialize player.
        ScoreBoard s1 = new ScoreBoard();

        //Loops bet 5 times and breaks if player reaches 0 dollars.
        for(int i = 0; i < 5; i++){
            p1.play();
            if(p1.getBank()<=0){
                p1.finalOutput(0);
                s1.scoreArrange(p1);
                return;
            }
        }
        p1.finalOutput(1);
        s1.scoreArrange(p1);
    }
}
