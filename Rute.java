import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Rute extends JPanel{
    JLabel label;
    public boolean isScore;
    public boolean isFree;
    public int x, y;
    public boolean isSnake;
    Rute(int inx, int iny){
        super();
        label = new JLabel(" ");
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));   
        this.add(label);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        isScore = false;
        isFree = true;
        isSnake = false;
        x = inx;
        y = iny;
        
    }
    public void setText(String text){
        label.setText(text);
    }

    public void bliSlange(){
        label.setText("+");
        this.setBackground(Color.green);
        isScore = false;
        isFree = false;
        isSnake = true;
    }

    public void bliTom(){
        label.setText(" ");
        this.setBackground(Color.white);
        isScore = false;
        isFree = true;
        isSnake = false;
    }

    public void bliHode(){
        label.setText("O");
        this.setBackground(Color.green);
        isScore = false;
        isFree = false;
        isSnake = true;
    }

    public void bliScore(){
        label.setText("$");
        this.setBackground(Color.white);
        isScore = true;
        isFree = false;
        isSnake = false;
    }
    
}
