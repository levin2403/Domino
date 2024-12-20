/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class JugadorDTO implements Serializable {
    // atributos de la clase 
    private String nickName;
    private int puntos;
    private List<FichaDTO> fichasDTO;
    private AvatarDTO avatar;

    /**
     * Constructor vacio
     */
    public JugadorDTO() {
        fichasDTO = new ArrayList<>();
    }
    
    /**
     * constructor que inicializa tanto el nickname como el avatar del jugador
     * al momento de elegir ambos.
     * 
     * @param nickName nombre por el cual el jugador sera conocido.
     * @param avatar avatar el cual el jugador eligio.
     */
    public JugadorDTO(String nickName, AvatarDTO avatar) {
        this.nickName = nickName;
        this.avatar = avatar;
        fichasDTO = new ArrayList<>(); 
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
    public AvatarDTO getAvatar() {
        return avatar;
    }
    
    /**
     * Metodo para obtener la lista de fichas pertenecientes al jugador.
     * 
     * @return Lista de fichas del jugador.
     */
    public List<FichaDTO> getFichas() {
        return fichasDTO;
    }

    /**
     * Metodo para establecer las fichas que se le dara al usuario.
     * 
     * @param fichas Lista de fichas para el usuario.
     */
    public void setFichas(List<FichaDTO> fichas) {
        this.fichasDTO = fichas;
    }
    
    /**
     * Elimina la primera ocurrencia de la ficha dada en el parametro, esto con
     * el fin que despues de cada jugada se pueda eliminar esa ficha de la 
     * mano del jugador.
     * 
     * @param ficha Ficha a eliminar de la mano del jugador.
     */
    public void eliminarFicha(FichaDTO ficha){
        this.fichasDTO.remove(ficha);
    }
    
    /**
     * Nos retorna la cantidad de fichas que el jugador tiene en mano.
     * 
     * @return Numero de fichas en mano.
     */
    public int cantidadFichas(){
        return this.fichasDTO.size();
    }
    
    /**
     * Añade una ficha a la mano del jugador, normalmente esta se añade desde 
     * el pozo.
     * 
     * @param ficha ficha a añadir a la mano del usuario.
     * 
     */
    public void añadirFicha(FichaDTO ficha){
        this.fichasDTO.add(ficha);
    }

    @Override
    public String toString() {
        return "JugadorDTO{" + "nickName=" + nickName + ", puntos=" + puntos + 
                ", fichasDTO=" + fichasDTO + ", avatar=" + avatar + '}';
    }
    
    
    // lo mismo del otro del avatar :D
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nickName);
        hash = 89 * hash + Objects.hashCode(this.avatar);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JugadorDTO other = (JugadorDTO) obj;
        if (!Objects.equals(this.nickName, other.nickName)) {
            return false;
        }
        return Objects.equals(this.avatar, other.avatar);
    }
    
}
