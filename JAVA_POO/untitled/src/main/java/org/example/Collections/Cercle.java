package org.example.Collections;

public class Cercle {

    private Integer x;
    private Integer y;
    private Double rayon;

    public Cercle(Integer x, Integer y, Double rayon){
        this.x = x;
        this.y = y;
        this.rayon = rayon;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Double getRayon() {
        return rayon;
    }

    public void setRayon(Double rayon) {
        this.rayon = rayon;
    }
}
