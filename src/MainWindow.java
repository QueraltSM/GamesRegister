import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {
    private static RegisteredGames rg = new RegisteredGames();
    private static Game g1 = new Game("Journey", "Thatgamecompany", "PS3", 18);
    private static Game g2 = new Game("Skylanders: Giants", "Toys for Bob", "PS3", 7);
    private static Game g3 = new Game("Mass Effect 2", "BioWare", "PS3", 18);

    private JScrollPane sp = new JScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


    private JButton addGame = new JButton("Add game");
    private JButton estadistics = new JButton("Estadistics");

    private static JTextArea text = new JTextArea(10, 20);

    private static JRadioButton title = new JRadioButton("Per title");
    private JRadioButton age = new JRadioButton("Per age");

    private ButtonGroup bg = new ButtonGroup();


    public static JTextArea getText() {
        return text;
    }

    public static RegisteredGames getRg() {
        return rg;
    }

    public MainWindow() {

        setLayout(new GridLayout(1, 2));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(11, 1));

        JPanel p2 = new JPanel();
        p2.add(addGame, BorderLayout.CENTER);

        addGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame(new JFrame());
            }
        });

        JPanel aux = new JPanel();
        aux.add(estadistics, BorderLayout.CENTER);
        p1.add(p2);
        p1.add(aux);

        add(p1);

        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        p4.add(sp);

        JPanel p5 = new JPanel();
        p5.setLayout(new GridLayout(2,1));
        p5.add(new JLabel("Order"));

        JPanel p7 = new JPanel();
        p7.setLayout(new FlowLayout());
        p7.add(title);
        p7.add(age);

        age.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rg.setOrder(1);
                text.setText("");
                String result = "";
                for (Game i : rg.getList()) {
                    result += i.toString() + "\n";
                }

                text.setText(result);
            }
        });



        title.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rg.setOrder(0);
                text.setText("");
                String result = "";
                for (Game i : rg.getList()) {
                    result += i.toString() + "\n";
                }

                text.setText(result);
            }
        });

        bg.add(title);
        bg.add(age);

        p5.add(p7);

        p3.add(p4, BorderLayout.NORTH);
        p3.add(p5, BorderLayout.CENTER);

        add(p3);


        estadistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListPlatform(new JFrame());
            }
        });

        setTitle("Registered Games");
        setVisible(true);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new MainWindow();
        title.setSelected(true);
        rg.setOrder(0);

        rg.add(g1);
        rg.add(g2);
        rg.add(g3);

        String result = "";
        for (Game i : rg.getList()) {
            result += i.toString() + "\n";
        }

        text.setText(result);
    }

}
