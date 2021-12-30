/*La corporación ACME dedicada a la fabricación y distribución de productos peligrosos tiene como objetivo posicionarse en el comercio digital. Hace unos días lanzó su portal de ventas, pero los materiales peligrosos representan riesgos en su distribución, de manera que el equipo de marketing junto con el de producción en su análisis determinaron el índice de riesgo en la distribución de un producto (basado en aspectos como la materia prima, químicos, volumen, etc). Los valores del riesgo de distribución depende de tres factores representados como números enteros:

FRD1:. Corresponde al índice inicial de riesgo de distribución definido por la Agencia de Distribución de Materiales Peligrosos ADMP. 
FRD2: Corresponde a una relación de riesgo definida por el equipo ACME y que se basa en el valor FRD1 para su cálculo: FRD2 equivale a cuatro más el doble del valor del primer factor de costo (FRD1).
FRD3: Corresponde al índice de riesgo de distribución en ACME. Cinco veces el valor del tercer factor de costo (FRD3) equivale a la suma de los valores obtenidos en el primer y segundo factor de costo, FRD1 y FRD2 respectivamente.
El nivel de riesgo de distribución del producto adquirido por el cliente estará sujeto al valor obtenido del tercer factor de costo FRD3 así: 

Si el valor de FRD3 está entre 0 y 20, la distribución tendrá riesgo 1. 
Si el valor de FRD3 se encuentra entre 21 y 30 la distribución tendrá riesgo 2. 
En caso de que el valor de FRD3 esté entre 31 y 50, su riesgo será 3. 
Finalmente, si el valor de FRD3 es mayor a 51, el riesgo será 4.
Elabora un programa en Java que permita, dado el factor de riesgo de distribución de un producto según la ADMP, conocer los valores obtenidos en los diferentes factores de riesgo en la distribución (FRD1, FRD2, FRD3), así como el nivel de riesgo de distribución para ACME en la que se encuentra el producto.*/

import java.util.Scanner;

public class reto1 {
    public static void main(String[] args) {
        int FRD1 = 0;
        int FRD2 = 0;
        int FRD3 = 0;
        String riesgo="";
        
        Scanner input = new Scanner(System.in);
        System.out.print("Digite el índice inicial de riesgo de distribución del producto: ");
        FRD1 = input.nextInt();
        
        FRD2 = 4 + FRD1*2;
        FRD3 = (FRD1 + FRD2)/5;
        
        if(FRD3>=0 && FRD3<=20){
            riesgo="uno";
        } else if(FRD3>=21 && FRD3<=30){
            riesgo="dos";
        } else if(FRD3>=31 && FRD3<=50){
            riesgo="tres";
        } else if (FRD3>=51){
            riesgo="cuatro";
        }
        
        System.out.printf("%d %d %d \n",FRD1,FRD2,FRD3);
        System.out.println(riesgo);
    }
}
