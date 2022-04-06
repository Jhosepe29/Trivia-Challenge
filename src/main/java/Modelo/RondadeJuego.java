package Modelo;


import java.util.List;


/**
 *
 * @author Jhosepe11
 */
public class RondadeJuego {
    public List<Preguntas> preguntasRonda; 
    public Jugador player;
    public int nivelRonda = 1;

    
    
    
    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }
    
    public List<Preguntas> getPreguntasRonda() {
        return preguntasRonda;
    }

    public void setPreguntasRonda(List<Preguntas> preguntasRonda) {
        this.preguntasRonda = preguntasRonda;
    }

    public int getNivelRonda() {
        return nivelRonda;
    }

    public void setNivelRonda(int nivelRonda) {
        this.nivelRonda = nivelRonda;
    }
    
   
   
    
    
}
