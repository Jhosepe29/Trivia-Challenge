package Modelo;

/**
 *
 * @author Jhosepe11
 */
public class OpcionRespuesta {
    private String textRespuesta;
    public boolean esCorrecata;

    public OpcionRespuesta(String textRespuesta, boolean esCorrecata) {
        this.textRespuesta = textRespuesta;
        this.esCorrecata = esCorrecata;
    }

    public OpcionRespuesta() {
    }
    
    
    public String getTextRespuesta() {
        return textRespuesta;
    }

    public void setTextRespuesta(String textRespuesta) {
        this.textRespuesta = textRespuesta;
    }

     public boolean isEsCorrecata() {
        return esCorrecata;
    }

    public void setEsCorrecata(boolean esCorrecata) {
        this.esCorrecata = esCorrecata;
    }
    
    
}
