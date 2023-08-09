import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class ScoreBoard {
    ArrayList<Player> players;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ScoreBoard(){
        //this.writeFile();
        this.readFile();
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
                System.out.println(line);
                splited = line.split("\\s+");

                tempBank = Integer.parseInt(splited[1]);
                this.players.add(new Player(splited[0],tempBank));
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
            System.out.println(this.players.get(i).getBank());
        }
        this.writeFile();
    }

    public void writeFile(){
        try {
            FileWriter writer = new FileWriter("scoreboard.txt", false);
            for(int i = 0; i < 10; i++){
                writer.write(this.players.get(i).getBank() +" "+ this.players.get(i).getName() + "\n");
            }
            writer.close();
           /*writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
