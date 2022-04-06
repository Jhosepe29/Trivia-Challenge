package Modelo;

import java.util.List;

/**
 *
 * @author Jhosepe11
 */
public class Pregunta {
    private String txtPrgunta;
    private List<OpcionRespuesta> listOpiones;
    public int nivelPregunta;

    public Pregunta(String txtPrgunta, List<OpcionRespuesta> listOpiones, int dificultad) {
        this.txtPrgunta = txtPrgunta;
        this.listOpiones = listOpiones;
        this.nivelPregunta = dificultad;
    }
    
    
    
    public void setTxtPrgunta(String txtPrgunta) {
        this.txtPrgunta = txtPrgunta;
    }

    public void setListOpiones(List<OpcionRespuesta> listOpiones) {
        this.listOpiones = listOpiones;
    }




    public void setNivelPregunta(int nivelPregunta) {
        this.nivelPregunta = nivelPregunta;
    }
    
    
    public String getTxtPrgunta() {
        return txtPrgunta;
    }

    public List<OpcionRespuesta> getListOpiones() {
        return listOpiones;
    }

    public int getNivelPregunta() {
        return nivelPregunta;
    }
    
    
    
    
}

