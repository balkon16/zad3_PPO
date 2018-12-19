package geometria;

public class Prostokąt {
    private Punkt lewy;
    private Punkt prawy;

    public Prostokąt(Punkt lewy, Punkt prawy) {
        this.lewy = lewy;
        this.prawy = prawy;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[(" + lewy.getX() + ", " + lewy.getY() + "), " + "(" + prawy.getX()
                + ", " + prawy.getY() + ")]";
    }

    public boolean pusty() {
        return (prawy.getX() < lewy.getX()) || (prawy.getY() < lewy.getY());
    }

    public int pole() {
        if (this.pusty()) {
            return 0;
        } else {
            int bok1 = this.prawy.getX() - this.lewy.getX();
            int bok2 = this.prawy.getY() - this.lewy.getY();
            return bok1 * bok2;
        }
    }

    public void przesuń(int x, int y) {
        this.lewy.setX(this.lewy.getX() + x);
        this.lewy.setY(this.lewy.getY() + y);
        this.prawy.setX(this.prawy.getX() + x);
        this.prawy.setY(this.prawy.getY() + y);
    }

    public Prostokąt przecięcie(Prostokąt pros){
        Punkt p_lewy = new Punkt(Math.max(this.lewy.getX(), pros.lewy.getX()), Math.max(this.lewy.getY(), pros.lewy.getY()));
        Punkt p_prawy = new Punkt(Math.min(this.prawy.getX(), pros.prawy.getX()), Math.min(this.prawy.getY(), pros.prawy.getY()));

        return new Prostokąt(p_lewy, p_prawy);
    }
}
