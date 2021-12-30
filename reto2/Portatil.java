package reto2;

public class Portatil extends Computador{
    protected String color;
    
    public Portatil(String codigo, String procesador, String memoria, String disco, String color) {
        super(codigo, procesador, memoria, disco);
        this.color = color;
    }
    
    @Override
    public String toString(){
        return "\tComputador portatil - Código: " + codigo + 
               "\n\tprocesador: " + procesador + " MHz" + 
               "\n\tmemoria: " +  memoria + " GB" +
               "\n\tdisco: " + disco + " GB" +
               "\n\tcolor: " + color; 
    }
    
}
