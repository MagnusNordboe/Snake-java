import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main_menu extends JPanel{
    JPanel menu;
    JPanel title;
    JButton start;
    JButton highscores;
    JButton quit;
    Model model;
    Main_menu(Model m){
        super();
        model = m;
        menu = new JPanel();
        title = new JPanel();

        start = new JButton("Start game");
        highscores = new JButton("High scores");
        quit = new JButton("Quit");
        
        class StoppBehandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }
        quit.addActionListener(new StoppBehandler());
        
        menu.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());
        
        

        
    }
}
