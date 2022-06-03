import java.util.Random;
import java.util.LinkedList;
//0 = Tom rute || 1 = Skatt || 2 = Slange kropp || 3 = Slange hode
public class Model {
    Random rand;
    View view;
    Rute[][] ruter;
    Rute head;
    int boardHeight;
    int boardLength;
    LinkedList<Rute> slange;
    int score;

    Model(int x, int y) {
        boardHeight = x;
        boardLength = y;
        score = 0;
        rand = new Random();
        view = new View();
        ruter = view.ruter;
        head = ruter[boardHeight / 2][boardLength / 2];
        head.bliHode();
        for(int i = 0; i < amountOfTreasures(boardHeight, boardLength);i++){
            placeTreasure(10, y);
        }
        slange = new LinkedList<Rute>();
        slange.add(head);
        Thread teller = new Thread(new TelleTrad(this));
        teller.start();
    }

    void placeTreasure(int x, int y) {
        int randx = rand.nextInt(x);
        int randy = rand.nextInt(y);
        // Skatt kan bare plasseres på tom plass.
        if(ruter[randx][randy].isFree){
            ruter[randx][randy].bliScore();
        }
        else{
            placeTreasure(x, y);
        }
    }

    int amountOfTreasures(int x, int y) {
        // Generer hvor mange skatter skal være på skjermen
        return Math.round((x / 4) + (y / 4));
    }

    //Movement of the snake
    void moveSnake(){
        //determine direction of movement
        String direction = view.direction;
        int loc_x = head.x;
        int loc_y = head.y;
        if(direction == "W"){
            loc_y --;
        }
        else if(direction == "E"){
            loc_y ++;
        }
        else if(direction == "N"){
            loc_x --;
        }
        else{
            loc_x++;
        }
        //Must check if the route it is moving into will end the game
        
        if(!legalMove(loc_x, loc_y)){
            System.exit(0);
        }
        //If game does not end, two possible operations:
        //Snake moves, last element back to empty, head to body, empty to head
        //Snake gets treasure, Head to body, empty to head
        if(ruter[loc_x][loc_y].isScore == true){
            score++;
            head.bliSlange();
            ruter[loc_x][loc_y].bliHode();
            slange.add(ruter[loc_x][loc_y]);
            head = ruter[loc_x][loc_y];
        }
        else{
            head.bliSlange();
            ruter[loc_x][loc_y].bliHode();
            slange.add(ruter[loc_x][loc_y]);
            head = ruter[loc_x][loc_y];
            Rute gone = slange.remove();
            gone.bliTom();
        }
    }

   boolean legalMove(int x, int y){
       if(x >= ruter.length  || y >= ruter[0].length  || x < 0 || y < 0){
           return false;
       }
        if(ruter[x][y].isSnake){
            return false;
        }
        return true;
    }

}