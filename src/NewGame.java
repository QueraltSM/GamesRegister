import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JDialog {
    private JTextField title = new JTextField(10);
    private JTextField developer = new JTextField(10);
    private JTextField platform = new JTextField(10);
    private JComboBox<String> jComboBox;
    private JButton add = new JButton("Add");
    private JButton cancel = new JButton("Cancel");

    public NewGame(JFrame f) {
        super(f, "New Game");
        setSize(400, 300);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(f);

        setLayout(new GridLayout(6, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(new JLabel("Title:"));
        p1.add(title);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("Developer:"));
        p2.add(developer);
        add(p2);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(new JLabel("Platform:"));
        p3.add(platform);
        add(p3);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(new JLabel("Age:"));

        String[] ages = { "+3", "+7", "+12", "+18"};
        jComboBox = new JComboBox<>(ages);
        p4.add(jComboBox);
        add(p4);

        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout());
        p5.add(add);
        p5.add(cancel);
        add(p5);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                title.setText("");
                developer.setText("");
                platform.setText("");
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String)jComboBox.getSelectedItem();
               if (MainWindow.getRg().add(new Game(title.getText(), developer.getText(),
                        platform.getText(), Integer.parseInt(selected.substring(1))))) {
                   MainWindow.getText().setText("");

                   String result = "";
                   for (Game i : MainWindow.getRg().getList()) {
                       result += i.toString() + "\n";
                   }

                   MainWindow.getText().setText(result);

                   dispose();
               }
            }
        });


    }
}
