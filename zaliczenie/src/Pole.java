public class Pole {
    private boolean mine;
    private boolean revealed;
    private boolean flagged;
    private int minesAround;

    public Pole() {
        mine = false;
        revealed = false;
        flagged = false;
    }

    public void setMine() {
        mine = true;
    }

    public void setRevealed() {
        revealed = true;
    }

    public void setFlagged() {
        flagged = true;
    }

    public void setUnFlagged() {
        flagged = false;
    }

    public boolean checkMine() {
        if (mine) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkReveal() {
        if (revealed) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkFlag() {
        if (flagged) {
            return true;
        } else {
            return false;
        }
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;//to przechowuje ile jest min dookola dopiero po wylosowaniu lin
    }

    public int getMinesAround() {//publiczna metoda ktora zwraca ilosc min dookola
        return minesAround;
    }
}