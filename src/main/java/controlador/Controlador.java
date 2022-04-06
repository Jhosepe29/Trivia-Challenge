package controlador;



import Modelo.Jugador;
import Modelo.OpcionRespuesta;
import Modelo.Pregunta;
import Modelo.Preguntas;
import Modelo.RondadeJuego;
import Vista.Vista2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhosepe11
 */
public class Controlador implements ActionListener{
    RondadeJuego newPlay;
    Vista2 objVista;
    String [] historicoU;
    String [] lisPreguntas;
    String preguntaActual="";
    int id=0;
 
    boolean bandera = true;

    public Controlador() {
        this.newPlay = new RondadeJuego();
        this.objVista = new Vista2();
        objVista.getBtJugar().addActionListener(this);
        objVista.getBtAjustes().addActionListener(this);
        objVista.getBtSiguiente().addActionListener(this);
        
    }
    
    public void Iniciar(){
        
        objVista.setVisible(true);
        objVista.setLocationRelativeTo(null);
        this.ocultarContenido();
   
    }
    
    public void ocultarContenido(){
       objVista.getrBopcionA().setVisible(false);
       objVista.getrBopcionB().setVisible(false);
       objVista.getrBopcionC().setVisible(false);
       objVista.getrBopcionD().setVisible(false);
       objVista.getJlbNombrePlayer().setVisible(false);
    }
    
       public void mostrarContenido(){
       objVista.getrBopcionA().setVisible(true);
       objVista.getrBopcionB().setVisible(true);
       objVista.getrBopcionC().setVisible(true);
       objVista.getrBopcionD().setVisible(true);
       objVista.getBtSiguiente().setEnabled(true);
       
       historicoU = this.leerHistoricoUser();
       String datos = this.topTres(historicoU);
       String[] verDatos = datos.split("/");
       
       objVista.getTxAtop().setText(verDatos[1]);
       objVista.getJlMejorJugador().setText(verDatos[0]);
       this.reguistroJugador();
       objVista.getJlNivel().setText(""+newPlay.getNivelRonda());
       
    }
    
  
    public void reguistroJugador(){
        String nombreJugador = JOptionPane.showInputDialog(objVista,"Ingrese su Nombre :","Nombre del Jugador",1);
        Jugador jp = new Jugador(id,nombreJugador);
        newPlay.setPlayer(jp);
        
        objVista.getJlbNombrePlayer().setText(nombreJugador);
        objVista.getJlbNombrePlayer().setVisible(true);
        id++;
    } 
    

    public String darFormato(String id,String nombre,String puntos){
        return id+";"+nombre+";"+puntos;
    }
     
    
    @Override
    public void actionPerformed(ActionEvent e) {
               
        if(e.getSource()==objVista.getBtJugar()){
            /*JOptionPane.showMessageDialog(objVista,"esta funcionando el boton jugar","mensaje",1);*/
            this.mostrarContenido();
            lisPreguntas = this.leerArchivo();
            preguntaActual = this.escogerPreguntas(newPlay.getNivelRonda());
            this.pintarPregunta(preguntaActual);
           // this.iniciarJuego();
            objVista.getBtJugar().setEnabled(false);
        }
        if(e.getSource()==objVista.getBtSiguiente()){
            
              
              if(this.preguntaCorrecta(preguntaActual,newPlay.getNivelRonda())){
                  newPlay.setNivelRonda(newPlay.getNivelRonda()+1);
                  preguntaActual = this.escogerPreguntas(newPlay.getNivelRonda());
                  this.pintarPregunta(preguntaActual);
                  objVista.getJlPuntos().setText(""+newPlay.getPlayer().getPuntos());
                
            }else{
                JOptionPane.showMessageDialog(objVista,"Respuesta Equivocada: Fin Del Juego","mensaje",1);
                this.guardarJugador(newPlay.getPlayer());
                objVista.getBtSiguiente().setEnabled(false);
                objVista.getBtJugar().setEnabled(true);
              }
            
        }
    }
     public String escogerPreguntas(int nivel){
          String salidaPre="";
            Random rd = new Random();
            int indice;
            boolean banderaLocal = true;
            switch (nivel) {
             case 1:
                 
                  indice = rd.nextInt(5);
                  salidaPre = lisPreguntas[indice];
                 break;
             case 2:
              
                 while(banderaLocal){
                    indice = rd.nextInt(10);
                     if(indice>4){
                         salidaPre = lisPreguntas[indice];
                         banderaLocal = false;
                        }
                 }
                 break;
               case 3:
                
                 while(banderaLocal){
                    indice = rd.nextInt(15);
                     if(indice>9){
                         salidaPre = lisPreguntas[indice];
                         banderaLocal = false;
                        }
                 }
                                 
                 break;
               case 4:
                 
                 while(banderaLocal){
                    indice = rd.nextInt(20);
                     if(indice>14){
                         salidaPre = lisPreguntas[indice];
                         banderaLocal = false;
                        }
                 }
                 break;
                 case 5:
                 
                 while(banderaLocal){
                    indice = rd.nextInt(25);
                     if(indice>19){
                         salidaPre = lisPreguntas[indice];
                         banderaLocal = false;
                        }
                 }
                 break;
                
           
         }
          return salidaPre;
     }
     public boolean preguntaCorrecta(String opcionSeleccionada,int nivel){
         boolean esCorrecta = false;
          String[] pG = opcionSeleccionada.split(";");
          String opc = pG[5];
          
         if(objVista.getrBopcionA().isSelected()){
           if(opc.equals("a")){
               esCorrecta=true;
               JOptionPane.showMessageDialog(objVista,"Correcto felicidades","mensaje",1);
           } 
           }
           if(objVista.getrBopcionB().isSelected()){
           if(opc.equals("b")){
               esCorrecta=true;
                JOptionPane.showMessageDialog(objVista,"Correcto felicidades","mensaje",1);
           } 
           }
             if(objVista.getrBopcionC().isSelected()){
           if(opc.equals("c")){
               esCorrecta=true;
           } 
           }
             if(objVista.getrBopcionD().isSelected()){
           if(opc.equals("d")){
               esCorrecta=true;
                JOptionPane.showMessageDialog(objVista,"Correcto felicidades","mensaje",1);
           } 
           }
         
         if(esCorrecta){
             switch (nivel) {
                 case 1:
                     newPlay.getPlayer().setPuntos(100);
                     break;
              case 2:
                     newPlay.getPlayer().setPuntos((newPlay.getPlayer().getPuntos())+200);
                     break;
             
               case 3:
                     newPlay.getPlayer().setPuntos((newPlay.getPlayer().getPuntos())+300);
                     break;
               case 4:
                     newPlay.getPlayer().setPuntos((newPlay.getPlayer().getPuntos())+400);
                     break;
                case 5:
                     newPlay.getPlayer().setPuntos((newPlay.getPlayer().getPuntos())+500);
                     break;
             }
         }
         
         return esCorrecta;
     }
     public Pregunta selecctorPregunta(int ronda){
         Random aletorio = new Random();
         Preguntas pregCategori;
         Pregunta salidaP;
         List<Pregunta> preguntasS =null;
         
         int pregSelccion = aletorio.nextInt(5);
         pregCategori = newPlay.getPreguntasRonda().get(ronda);
         preguntasS = pregCategori.getPreguntas();
         salidaP = preguntasS.get(pregSelccion);
        
         return salidaP;
     }
    
     public void pintarPregunta(String nuevaPregunta){
         
         String[] pG = nuevaPregunta.split(";");
         
         objVista.getjTextAreaPregunta().setText(pG[0]);
         objVista.getrBopcionA().setText("A. "+pG[1]);
         objVista.getrBopcionB().setText("B. "+pG[2]);
         objVista.getrBopcionC().setText("C. "+pG[3]);
         objVista.getrBopcionD().setText("D. "+pG[4]);
         
     } 
     
    /*guardar Jugador*/
     public void guardarJugador(Jugador jp){
          String guardar = this.darFormato(""+jp.getiD(),jp.getNombreJugador(),""+jp.getPuntos());;
        /*JOptionPane.showConfirmDialog(null,guardar,"Notificacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);*/
          this.escribirArchivo(guardar);
     }
     
    /* Crearemos nuentro objeto juego*/
       /*Crear lista de opciones opciones*/
      public String[] separadorPregunta(String preguntaEntrada){
          String[] partesPregunta;
          partesPregunta = preguntaEntrada.split(";");
          return partesPregunta;
      }
       public List<OpcionRespuesta> crearOpciones(String preguntaEntrada){
           List<OpcionRespuesta> listSalida = new ArrayList<>();
           String[] partesPregunta;
           partesPregunta = preguntaEntrada.split(";");
           String respuesta = partesPregunta[5];
           int numCorrecta = 0;
              switch (respuesta) {
               case "a" -> numCorrecta = 0;
               case "b" -> numCorrecta = 1;
               case "c" -> numCorrecta = 2;
               case "d" -> numCorrecta = 3;
           }
            for (int i = 0; i < 4; i++) {
                
                String textOpc = partesPregunta[i];
                boolean esCorrecta = false;
                    if(i==numCorrecta){
                        esCorrecta = true;
                    }
                listSalida.add(new OpcionRespuesta(textOpc,esCorrecta));
           }         
            
            return listSalida;
       } 
       
       public Pregunta crearPregunta(List<OpcionRespuesta> opcRespuesta, String[] pregunta){
          
           Pregunta preguntaSalida;
           int nivelPreg = Integer.parseInt(pregunta[6]);
           String textPregungta = pregunta[0];
           
           preguntaSalida = new Pregunta(textPregungta,opcRespuesta,nivelPreg);
           
           return preguntaSalida;
       
       }
       
      
      
      public void iniciarJuego(){
          String[] preguntas = this.leerArchivo();
          List<OpcionRespuesta> listOpcR= new ArrayList<>();
          Pregunta preG;
          List<Pregunta> listaPregunta = new ArrayList<>() ;
          Preguntas bancoPre;
          List<Preguntas> bancoPreguntas = new ArrayList<>() ;
          String categoria;
             for (int i = 0; i < preguntas.length; i++) {
                  //JOptionPane.showMessageDialog(objVista,preguntas[i]+""+preguntas.length,"mensaje",1);
                  //JOptionPane.showMessageDialog(objVista,preguntas[i+1]+""+preguntas.length,"mensaje",1);
                 listOpcR = this.crearOpciones(preguntas[i]);
                 preG = this.crearPregunta(listOpcR,this.separadorPregunta(preguntas[i]));
                 categoria = (this.separadorPregunta(preguntas[i]))[7];
                 listaPregunta.add(preG);
                    if(((i+1)%5)==0){
                        bancoPre = new Preguntas(listaPregunta, categoria);
                        bancoPreguntas.add(bancoPre);
                        listaPregunta.clear();
                    }
          }
        this.reguistroJugador();
        newPlay.setPreguntasRonda(bancoPreguntas);
        
          
      
      }
      public String topTres(String[] jugadores){
          String salidaTop;
          int primero= 0;
          int segundo= 0;
          int tercero = 0;
          int apuntadorMayor=0;
          for (int i = 0; i < jugadores.length; i++) {
              if(jugadores[i]!=null){
                  String[] partesLinea = jugadores[i].split(";");
                   int aux =Integer.parseInt(partesLinea[2]);
                    if(primero < aux){
                        tercero=segundo;
                        segundo=primero;
                        primero = aux;
                        apuntadorMayor=i;
                    }
         
              }
             
          }
          String[] partesLinea2 = jugadores[apuntadorMayor].split(";");
          salidaTop = partesLinea2[1]+"/"+"\n\t"+primero+"\n\t"+segundo+"\n\t"+tercero;
          return salidaTop;
      }
     
    
    
     
    FileWriter salida;
    PrintWriter escritor;
    FileReader entrada;
    File archivo=null;
    BufferedReader lector;
    
    public void escribirArchivo(String Dato){
        try {
            salida = new FileWriter("Historico.txt",true);
             escritor = new PrintWriter(salida);
             escritor.println(Dato);
             escritor.close();
             salida.close();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(objVista,"Datos ingresados","Notificacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
       
        
    }
    /*Programamos La lectura de Archivos*/
     public String[] leerArchivo(){
         String[] listPreguntasTemp = new String[25]; 
         try {
             archivo = new  File("D:\\Jhosepe11\\Documents\\NetBeansProjects\\Challenge\\Preguntas.txt");
             entrada = new FileReader(archivo);
             lector =new BufferedReader(entrada);
             String linea;
           
             linea=lector.readLine();
              for (int j = 0; j < 25; j++) {
                  //JOptionPane.showMessageDialog(objVista,linea,"mensaje",1);
                 listPreguntasTemp[j]=(linea);
                 linea = lector.readLine();
             }
                
                 
             
            
         } catch (IOException e) {
             JOptionPane.showConfirmDialog(objVista,"El Archivo no se pudo cargar","Notificacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
         }
         /*JOptionPane.showMessageDialog(objVista,"esto es lo que hay  "+listPreguntasTemp[0],"mensaje",1);*/
         return listPreguntasTemp;
     }
     public String[] leerHistoricoUser(){
         String[] listPreguntasTemp = new String[10]; 
         try {
             archivo = new  File("D:\\Jhosepe11\\Documents\\NetBeansProjects\\Challenge\\Historico.txt");
             entrada = new FileReader(archivo);
             lector =new BufferedReader(entrada);
             String linea;
           
             linea=lector.readLine();
              for (int j = 0; j < 10; j++) {
                  //JOptionPane.showMessageDialog(objVista,linea,"mensaje",1);
                 listPreguntasTemp[j]=(linea);
                 linea = lector.readLine();
             }
                
                 
             
            
         } catch (IOException e) {
             JOptionPane.showConfirmDialog(objVista,"El Archivo no se pudo cargar","Notificacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
         }
         /*JOptionPane.showMessageDialog(objVista,"esto es lo que hay  "+listPreguntasTemp[0],"mensaje",1);*/
         return listPreguntasTemp;
     
     }
    }

  
    
    

