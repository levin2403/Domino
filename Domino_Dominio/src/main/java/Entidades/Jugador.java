package Entidades;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que define al jugador, la cual contiene diferentes metodos para sus
 * atributos correspondientes.
 * 
 * @author skevi
 */
public class Jugador {
    
    // atributos de la clase 
    private String nickName;
    private int puntos;
    private List<Ficha> fichas;
    private Avatar avatar;

    /**
     * constructor que inicializa tanto el nickname como el avatar del jugador
     * al momento de elegir ambos.
     * 
     * @param nickName nombre por el cual el jugador sera conocido.
     * @param avatar avatar el cual el jugador eligio.
     */
    public Jugador(String nickName, Avatar avatar) {
        this.nickName = nickName;
        this.avatar = avatar;
    }

    /**
     * Metodo para obtener el nickName del jugador.
     * 
     * @return Cadena de texto con el nickName del jugador.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Obtiene el numero de puntos que el jugador a generado.
     * 
     * @return Numero de puntos generados por el jugador.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Metodo que se encarga de agregar mas puntos al jugador, sumando los 
     * puntos actuales de jugador y sumando el nuevo puntaje obtenido en el 
     * parametro.
     * 
     * @param puntos Puntos a sumar al jugador.
     */
    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    /**
     * Metodo que obtiene el abatar perteneciente al jugador.
     * 
     * @return Retornamos el avatar perteneciente al jugador.
     */
    public Avatar getAvatar() {
        return avatar;
    }
    
    /**
     * Metodo para obtener la lista de fichas pertenecientes al jugador.
     * 
     * @return Lista de fichas del jugador.
     */
    public List<Ficha> getFichas() {
        return fichas;
    }

    /**
     * Metodo para establecer las fichas que se le dara al usuario.
     * 
     * @param fichas Lista de fichas para el usuario.
     */
    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    /**
     * Elimina la primera ocurrencia de la ficha dada en el parametro, esto con
     * el fin que despues de cada jugada se pueda eliminar esa ficha de la 
     * mano del jugador.
     * 
     * @param ficha Ficha a eliminar de la mano del jugador.
     */
    public void eliminarFicha(Ficha ficha){
        this.fichas.remove(ficha);
    }
    
    /**
     * Nos retorna la cantidad de fichas que el jugador tiene en mano.
     * 
     * @return Numero de fichas en mano.
     */
    public int cantidadFichas(){
        return this.fichas.size();
    }
    
    /**
     * Añade una ficha a la mano del jugador, normalmente esta se añade desde 
     * el pozo.
     * 
     * @param ficha ficha a añadir a la mano del usuario.
     * 
     */
    public void añadirFicha(Ficha ficha){
        this.fichas.add(ficha);
    }
    
    public Ficha mulaMasGrande(){
        Ficha mula = null;
        for (Ficha ficha : fichas) {
            if(ficha.isMula(ficha)){
                if(mula == null || ficha.getValorSuperior()> mula.getValorSuperior()){
                    mula = ficha;
                }
            }
        }
        return mula;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nickName=" + nickName + ", puntos=" + puntos + ", fichas=" + fichas + ", avatar=" + avatar + '}';
    }
    
    
    
}
