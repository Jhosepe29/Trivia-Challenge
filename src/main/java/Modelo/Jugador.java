
package Modelo;

/**
 *
 * @author Jhosepe11
 */
public class Jugador {
    private int iD; 
    private String nombreJugador;
    private int puntos=0;

    public Jugador(int iD, String nombreJugador) {
        this.iD = iD;
        this.nombreJugador = nombreJugador;
    }
    
    
    public int getiD() {
        return iD;
    }
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}
