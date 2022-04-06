package Modelo;

import java.util.List;

/**
 *
 * @author Jhosepe11
 */
public class Preguntas {
    private List<Pregunta> preguntas;
    private String Categoria;

    public Preguntas(List<Pregunta> preguntas, String Categoria) {
        this.preguntas = preguntas;
        this.Categoria = Categoria;
    }
    
    
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
}
