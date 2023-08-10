import javax.swing.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class ScoreBoard {
    ArrayList<Player> players;
    String scores;

    public ScoreBoard(){
        //this.writeFile();
        this.readFile();
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public void readFile(){
        try {
            this.players = new ArrayList<>();
            FileReader reader = new FileReader("scoreBoard.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            String[] splited;
            int tempBank;

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                splited = line.split("\\s+");

                tempBank = Integer.parseInt(splited[0]);
                this.players.add(new Player(tempBank, splited[1]));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scoreArrange(Player p1){
        this.players.add(p1);
        Collections.sort(this.players, Collections.reverseOrder());
        for(int i = 0; i < this.players.size(); i++ ){
            //System.out.println(this.players.get(i).getBank());
        }
        this.writeFile();
        this.scoreDisplay();
    }

    public void writeFile(){
        try {
            FileWriter writer = new FileWriter("scoreboard.txt", false);
            for(int i = 0; i < 10; i++){
                writer.write(this.players.get(i).getBank() +" "+ this.players.get(i).getName() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scoreDisplay(){
        this.scores = "TOP 10 HIGHEST SCORES\n";
        for(int i = 0; i < 10; i++){
            String bankTemp = String.format("%03d", this.players.get(i).getBank());
            this.scores = this.scores + bankTemp +"    "+ this.players.get(i).getName() + "\n";
        }
        JOptionPane.showMessageDialog(null, this.scores, "Dice Poker", JOptionPane.INFORMATION_MESSAGE);
    }
}
