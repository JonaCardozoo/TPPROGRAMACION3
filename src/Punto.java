import java.util.Locale;

public class Punto implements Comparable<Punto> {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return (String.format(Locale.US, "(%.1F,%.1F)",x,y));
    }

    @Override
    public int compareTo(Punto o) {
        return Double.compare(this.x, o.getX());
    }
}
