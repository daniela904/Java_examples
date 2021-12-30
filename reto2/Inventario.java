package reto2;
import java.util.Scanner;

public class Inventario {
    Computador computadores[];
    int numeroComputadores = 0;

    public Inventario() {
        computadores = new Computador[50];
        numeroComputadores = 0;
    }

    public void procesarComandos() {
        int opcion;
        Scanner input = new Scanner(System.in);
            
        do {
            System.out.println("Digite la opcion del comando a ejecutar:");
            String cadena = input.nextLine();

            String[] cadenas = cadena.split("&");
            opcion = Integer.parseInt(cadenas[0]);
            
            switch (opcion) {
                case 1:
                    String tipo = cadenas[1];
                    String codigo = cadenas[2];
                    String procesador = cadenas[3];
                    String memoria = cadenas[4];
                    String disco = cadenas[5];
                    String caract = cadenas[6];
                    adicionarComputador(tipo, codigo, procesador, memoria, disco, caract);
                    break;

                case 2:
                    listarComputadores();
                    break;

                case 3:
                    break;
            }
        }while (opcion != 3);
    }

    public void adicionarComputador(String tipo, String codigo, String procesador, String memoria, String disco, String caract) {
        //System.out.println("adicionar computador");
        if (tipo.equals("portatil")) {
            computadores[numeroComputadores] = new Portatil(codigo, procesador, memoria, disco, caract);
            numeroComputadores+=1;
        } else if (tipo.equals("escritorio")) {
            computadores[numeroComputadores] = new Escritorio(codigo, procesador, memoria, disco, caract);
            numeroComputadores+=1;
        }
    }

    public void listarComputadores() {
        System.out.println("***Inventario de computadores***");
        for(int i=0;i<numeroComputadores;i++){
            System.out.println(computadores[i]);
        } 
    }

    public static void main(String[] args) {
        Inventario d = new Inventario();
        d.procesarComandos();
    }
}
