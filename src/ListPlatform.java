import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPlatform extends JDialog {
    private JTextArea text = new JTextArea(10, 10);
    private JButton ok = new JButton("Ok");
    private JScrollPane sp = new JScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


    public ListPlatform(JFrame f) {
        super(f, "List Platforms");

        JPanel p = new JPanel();
        p.add(sp, BorderLayout.CENTER);
        add(p, BorderLayout.NORTH);

        String result = "";
        for (String s: MainWindow.getRg().getListPlatforms() ) {
            result += s + "\n";
        }

        text.setText(result);

        JPanel p2 = new JPanel();
        p2.add(ok);

        add(p2, BorderLayout.CENTER);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        setSize(300, 300);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(f);
    }
}
