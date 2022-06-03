import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View {
    JFrame vindu;
    JPanel panel, konsoll, rutenett;
    public Rute[][] ruter = new Rute[10][10];
    JLabel status;
    JButton stoppknapp;
    JButton up;
    JButton down;
    JButton left;
    JButton right;
    public String direction;

    View(){
        try{
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch(Exception e){
            System.exit(9);
        }
        vindu = new JFrame("Snake");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setPreferredSize(new Dimension(600,600));

        panel = new JPanel();
        vindu.add(panel);

        panel.setLayout(new BorderLayout());

        konsoll = new JPanel();
        konsoll.setLayout(new BorderLayout());
        panel.add(konsoll, BorderLayout.NORTH);

        status = new JLabel("Velg en rute");
        konsoll.add(status, BorderLayout.NORTH);

        stoppknapp = new JButton("Stopp");
        

        class StoppBehandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }
        stoppknapp.addActionListener(new StoppBehandler());
        konsoll.add(stoppknapp, BorderLayout.CENTER);

        class Left implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                direction = "W";
            }
        }

        class Right implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                direction = "E";
            }
        }

        class Up implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                direction = "N";
            }
        }

        class Down implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                direction = "S";
            }
        }

        up = new JButton("Opp");
        up.addActionListener(new Up());
        konsoll.add(up, BorderLayout.NORTH);
        down = new JButton("Ned");
        down.addActionListener(new Down());
        konsoll.add(down, BorderLayout.SOUTH);
        left = new JButton("Venstre");
        left.addActionListener(new Left());
        konsoll.add(left, BorderLayout.WEST);
        right = new JButton("Høyre");
        right.addActionListener(new Right());
        konsoll.add(right, BorderLayout.EAST);


        //Rutenett
        rutenett = new JPanel();
        rutenett.setLayout(new GridLayout(10,10));
        for(int rx = 0; rx < 10; ++rx){
            for(int kx = 0; kx < 10; ++kx){
                Rute b = new Rute(rx,kx);
                
                ruter[rx][kx] = b;
                rutenett.add(b);
            }
        }
        panel.add(rutenett, BorderLayout.CENTER);

        vindu.pack();
        vindu.setVisible(true); 
        
    }
}
