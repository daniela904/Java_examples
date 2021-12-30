package reto2;

public class Escritorio extends Computador{
    protected String tamañoPantalla;
    
    public Escritorio(String codigo, String procesador, String memoria, String disco, String tamañoPantalla) {
        super(codigo, procesador, memoria, disco);
        this.tamañoPantalla = tamañoPantalla;
    }
    
    @Override
    public String toString(){
        return "\tComputador escritorio - Código: " + codigo + 
               "\n\tprocesador: " + procesador + " MHz" + 
               "\n\tmemoria: " +  memoria + " GB" +
               "\n\tdisco: " + disco + " GB" +
               "\n\ttamaño pantalla: " + tamañoPantalla + "\'"; 
    }
}
