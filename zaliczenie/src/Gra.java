import java.awt.*;
import java.util.Random;

public class Gra {
    private Pole[][] plansza;
    private Dimension wymiary;
    private Boolean gameover = false;


    public Pole[][] getPlansza() {
        return plansza;
    }

    public void setDimension(int wys, int szer) { //wypelnij tablice obiektami typu pole
        wymiary = new Dimension(wys, szer);
        plansza = new Pole[wys][szer];
        for (int a = 0; a < plansza.length; a++) {
            for (int b = 0; b < plansza[a].length; b++) {
                plansza[a][b] = new Pole();
            }
        }
        //System.out.print(plansza);

    }

    public void updateMinesAroundCount() {
        for (int a = 0; a < plansza.length; a++) {
            for (int b = 0; b < plansza[a].length; b++) {
                int count = 0;
                //pola nad
                try {
                    if (plansza[a - 1][b - 1].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }
                try {
                    if (plansza[a - 1][b].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }
                try {
                    if (plansza[a - 1][b + 1].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }

                //pola obok
                try {
                    if (plansza[a][b - 1].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }
                try {
                    if (plansza[a][b + 1].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }

                //pola pod
                try {
                    if (plansza[a + 1][b - 1].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }
                try {
                    if (plansza[a + 1][b].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }
                try {
                    if (plansza[a + 1][b + 1].checkMine()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                }


                plansza[a][b].setMinesAround(count);
            }
        }
    }

    public void setMinesOnField(int minesCount) {//polozenie min
        int iteration = 0;
        while (iteration < minesCount) {
            Random r = new Random();//random generuje ulamek
            Random r2 = new Random();
            int x = r.nextInt(wymiary.width);//zaokraglanie do tego, co jest w nawiasie
            int y = r2.nextInt(wymiary.height);
            if (x >= wymiary.width) {//zeby nie wyszlo poza zakres
                x -= 1;
            }
            if (y >= wymiary.height) {
                y -= 1;
            }

            if (!plansza[x][y].checkMine()) {
                plansza[x][y].setMine();
                iteration++;
            }
        }
    }

    public void debugModeMines() {//do testow by sprawdzic czy wyswietlaly sie miny
        for (int z = 0; z < wymiary.getHeight(); z++) {
            System.out.print("\n");
            for (int u = 0; u < wymiary.getWidth(); u++) {
                if (plansza[z][u].checkMine())
                    System.out.print("[M]");
                else {
                    System.out.print("[ ]");
                }
            }
        }

    }

    public Boolean gameover() { //to po to jakby byla opcja monitu ze gra skonczona
        return gameover;
    }

    public void revealField(int x, int y) {
        plansza[y][x].setRevealed();
        if (plansza[y][x].checkMine()) {
            gameover = true;
        }
    }


}
