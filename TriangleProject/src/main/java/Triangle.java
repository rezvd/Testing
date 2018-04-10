/**
 * Created by 1 on 03.04.2018.
 */

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws LengthException {
        if(a + b > c && a + c > b && b + c > a){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else throw new LengthException("Не соблюдается неравенство треугольника");
    }

    public Triangle(Triangle triangle){
        this.a = triangle.a;
        this.b = triangle.b;
        this.c = triangle.c;
    }

    @Override
    public String toString() {
        return "main.java.Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public boolean isRectangular(){
        double a = Math.pow(this.a, 2);
        double b = Math.pow(this.b, 2);
        double c = Math.pow(this.c, 2);
        return (a+b == c || b + c == a || a + c == b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.a, a) != 0) return false;
        if (Double.compare(triangle.b, b) != 0) return false;
        return Double.compare(triangle.c, c) == 0;

    }

}
