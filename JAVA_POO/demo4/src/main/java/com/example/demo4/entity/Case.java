package com.example.demo4.entity;

public class Case {

    private int x;
    private int y;
    private boolean casePriseOuPas;

    public Case(int x, int y, boolean casePriseOuPas) {
        this.x = x;
        this.y = y;
        this.casePriseOuPas = casePriseOuPas;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCasePriseOuPas() {
        return casePriseOuPas;
    }

    public void setCasePriseOuPas(boolean casePriseOuPas) {
        this.casePriseOuPas = casePriseOuPas;
    }
}
