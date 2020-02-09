import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

//dziedziczy po jbutton
public class PoleKomponent extends JButton implements ActionListener {
    Pole p;//tworze puste pole

    public PoleKomponent(Pole pole) {
        super("");//odwolanie do klasy nadrzednej
        this.p = pole;//kopia obiektu
        this.setSize(new Dimension(25, 25));
        this.setText("");
        this.addActionListener(e -> actionPerformed(e));//dodanie actionlistenera na obiekt (na klikniecie)
        this.addMouseListener(new MouseAdapter() {//na klikniecie prawym (flaga)
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (!p.checkFlag() && !p.checkReveal()) {
                        p.setFlagged();
                        setFlagged();
                    } else if (p.checkFlag()) {
                        p.setUnFlagged();
                        setNone();
                    }
                }
            }
        });
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(25, 25);
    }

    public void setFlagged() {
        this.setText("F");
        this.setEnabled(false);//wylaczenie mozliwosci klikania
        this.setBackground(Color.YELLOW);
    }

    public void setBomb() {
        this.setText("B");
        this.setBackground(Color.RED);
        this.setEnabled(false);

    }

    public void setRevealed() {
        this.setText(String.valueOf(p.getMinesAround()));//pokazuje ile min dookola
        this.setEnabled(false);
        this.setBackground(Color.GRAY);

    }

    public void setNone() {
        this.setText("");
        this.setBackground(new JButton().getBackground());
        this.setEnabled(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {//sprawdza obiekt
        if (p.checkMine()) {
            setBomb();
            //System.out.print("Mine");
        } else if (p.checkFlag()) {
            setFlagged();
            //System.out.print("Flag");
        } else if (!p.checkReveal()) {
            p.setRevealed();
            setRevealed();
            //System.out.print("Revealed");

        }
    }
}