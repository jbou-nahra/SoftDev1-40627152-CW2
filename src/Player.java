public class Player {
    private String name;
    private int bank;

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

    public boolean checkBank(int betAmount){
        if(betAmount > this.bank)
            return true;
        else
            return false;
    }
}
