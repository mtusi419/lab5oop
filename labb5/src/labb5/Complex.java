package labb5;

import static java.lang.Math.abs;

public class Complex {
    public double x;
    public double y;
    Complex(){
        x = 0;
        y = 0;
    }
    Complex (double x, double y){
        this.x = x;
        this.y = y;
    }
    public Complex sum(Complex b){
        Complex a = new Complex();
        a.x = this.x + b.x;
        a.y = this.y + b.y;
        return a;
    }
    public Complex step2(){
        double buf = x;
        x = x*x - y*y;
        y = 2*buf*y;
        return this;
    }
    public Complex step2sopr(){
        double buf = x;
        x = x*x - y*y;
        y = -2*buf*y;
        return this;
    }
    public Complex AbsImAndReParts(){
        x = abs(x);
        y = abs(y);
        return this;
    }
    public boolean isMoreThan(double a){
        return (x*x + y*y) > a*a;
    }
}
