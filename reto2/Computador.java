package reto2;

public abstract class Computador {
    //caracteristicas o atributos comunes
    protected String codigo;
    protected String procesador;
    protected String memoria;
    protected String disco;

    public Computador(String codigo, String procesador, String memoria, String disco) {
        this.codigo = codigo;
        this.procesador = procesador;
        this.memoria = memoria;
        this.disco = disco;
    }
    
    @Override //este metodo hereda de la clase Object
    public String toString(){
        return "\tComputador portatil - Código: " + codigo + 
               "\tprocesador: " + procesador + "MHz" + 
               "\tmemoria: " +  memoria + "GB" +
               "\tdisco: " + disco + "GB"; 
    }
}
