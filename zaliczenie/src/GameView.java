import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameView extends JDialog implements ActionListener {
    private Gra game;


    private JPanel mainPanel;

    public GameView(int wys, int szer, int miny) {
        /*miny
        0 = łatwy = 10% min
        1 = sredni = 20% min
        2 = trudny = 40% min
        */

        game = new Gra();
        game.setDimension(wys, szer);
        game.setMinesOnField(countMinesToDeploy(wys, szer, miny)); //ustawia miny na planszy
        game.updateMinesAroundCount(); //po wylosowaniu min, każdemu polu pokazuje ile jest min dookola niej

        mainPanel.setLayout(new GridLayout(wys, szer)); 

        for (int i = 0; i < wys; i++) {
            for (int o = 0; o < szer; o++) {
                mainPanel.add(new PoleKomponent(game.getPlansza()[i][o]));
            }
        }

        setContentPane(mainPanel);
        setModal(true);


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        mainPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private int countMinesToDeploy(int w, int sz, int m) { //poziom trudnosci
        if (m == 0) {
            return (int) Math.ceil(w * sz * 0.1);
        } else if (m == 1) {
            return (int) Math.ceil(w * sz * 0.2);
        } else {
            return (int) Math.ceil(w * sz * 0.4);
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
