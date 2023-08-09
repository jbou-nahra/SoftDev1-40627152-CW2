public class Dice {
    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    //This is the basic roll for a single dice. It randomizes the result based on the number of sides of the dice.
    public int roll(){
        int min = 1;
        int max = this.sides;

        int result = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return result;

    }
}
