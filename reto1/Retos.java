package retos;
import java.util.Scanner;

public class Retos {
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
