import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

public class Okno extends JFrame {

    private JPanel okienko;
    private JTextField podajWysokosc;
    private JTextField podajSzerokosc;
    private JButton Start;
    private JPanel menu;
    private JPanel okno1;
    private JComboBox comboBox1;

    public Okno() {
        comboBox1.addItem("Łatwy");
        comboBox1.addItem("Średni");
        comboBox1.addItem("Trudny");
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {//sprobuj pobrac z tego dane, jesli nie bedzie zadnych danych albo nie bedzie sie dalo w cyfry to wtedy wywoluje sie catch (zabezpieczenie na cyfry)
                    if (Integer.parseInt(podajWysokosc.getText()) > 0 && Integer.parseInt(podajSzerokosc.getText()) > 0) {
                        GameView gameView = new GameView(Integer.parseInt(podajWysokosc.getText()), Integer.parseInt(podajSzerokosc.getText()), comboBox1.getSelectedIndex());
                        gameView.setMinimumSize(new Dimension(600, 600));
                        gameView.setVisible(true);
                    }
                } catch (NumberFormatException ex) {

                }
            }
        });
        //podajWysokosc.addFocusListener(new FocusAdapter() {
        //});
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Saper");
        frame.setContentPane(new Okno().okienko);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
