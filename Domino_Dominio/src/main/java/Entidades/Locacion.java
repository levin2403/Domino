/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * x1=0 y1=0 tamtotal=6cm  y2=y1 x2=x1-7cm  x3=x2+3cm y3=y2+7cm
 * @author skevi
 */
public class Locacion {
    
    private int x;
    private int y;

    public Locacion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Locacion{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
}
