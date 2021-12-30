package reto3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Laminas {
    public ArrayList<Integer> identificarCategorias(List lista){
        ArrayList<Integer> listaCategorias = new ArrayList<>();
        listaCategorias.add((Integer) lista.get(0));
        
        for(int i=1; i<=lista.size()-1;i++){
            if(listaCategorias.contains((Integer)lista.get(i))==false){
                listaCategorias.add((Integer)lista.get(i));
            }
        }
        
        Collections.sort(listaCategorias);
        return listaCategorias;
    }
    
    public ArrayList<Integer> IdentificarCategoriaLaminasFaltantes(List lista1, List lista2, int categoria){
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaLaminas = new ArrayList<>();
        for(int i=0; i<lista2.size();i++){
            if((Integer)lista2.get(i) == categoria){
                lista.add(i);
            }
        } 
        for(int i=0; i<lista1.size();i++){
            if(lista.contains(lista1.get(i)) == true){
                listaLaminas.add((Integer) lista1.get(i));
            }
        }
        return listaLaminas;
    }
    
    public ArrayList<Integer> identificarLaminasRelevantes(List lista1, List lista2){
        ArrayList<Integer> lista = new ArrayList<>();
        for(int i=0; i<lista1.size();i++){
            if(lista2.contains(lista1.get(i))==false){
                lista.add((Integer)lista1.get(i));
            }
        }     
        return lista;
    }
    
    public Integer identificarLaminasParaCambiar(List lista1, List lista2){
        ArrayList<Integer> listaFamilia1 = new ArrayList<>();
        ArrayList<Integer> listaFamilia2 = new ArrayList<>();
        
        for(int i=0; i<lista1.size();i++){
            if(lista2.contains(lista1.get(i))==false){
                listaFamilia1.add((Integer)lista1.get(i));
            }
        } 
        
        for(int i=0; i<lista2.size();i++){
            if(lista1.contains(lista2.get(i))==false){
                listaFamilia2.add((Integer)lista2.get(i));
            }
        } 
        
        if(listaFamilia1.size()>listaFamilia2.size()){
            return listaFamilia2.size();
        }else{
            return listaFamilia1.size();
        } 
    } 
    
    public static void main(String[] args) {
        Laminas laminas = new Laminas();
        //prueba envio lista categorias
        List lista = new ArrayList();
        Integer[] arreglo = {3, 1, 1, 2, 2, 3, 1, 1, 2, 1, 3, 2, 3, 2, 1, 3, 2, 2, 3, 2, 3, 1, 3, 1, 3, 3, 1, 1, 3, 3, 3, 2, 3, 1, 3, 3, 3, 1, 3, 1, 1, 3, 2, 1, 1, 2, 3, 3, 1, 2, 1, 2, 1, 1, 2, 3, 1, 2, 3, 3, 1, 2, 1, 2, 1, 1, 2, 1, 3, 1, 2, 3, 2, 3, 2, 3, 3, 1, 3, 3, 2, 3, 2, 1, 1, 2, 3, 3, 1, 1, 1, 1, 2, 2, 3, 3, 3, 1, 2, 3, 2, 1, 2, 3, 3, 3, 1, 1, 1, 2, 1, 2, 2, 3, 2, 2, 3, 2, 2, 1, 1, 1, 1, 3, 3, 1, 3, 2, 2, 2, 3, 1, 1, 2, 2, 3, 1, 3, 2, 1, 1, 1, 2, 1, 1, 2, 3, 2, 1, 2, 3, 1, 1, 1, 2, 2, 3, 1, 3, 2, 1, 3, 1, 3, 3, 3, 2, 1, 3, 3, 1, 1, 2, 3, 1, 3, 1, 1, 1, 2, 1, 3, 2, 3, 1, 3, 1, 3, 2, 2, 2, 2, 3, 3, 2, 1, 3, 3, 2, 1, 1, 1, 3, 2, 3, 2, 2, 3, 2, 3, 1, 1, 1, 3, 1, 3, 3, 3, 1, 1, 3, 3, 2, 1, 3, 1, 3, 3, 2, 2, 1, 2, 2, 3, 1, 2, 2, 3, 1, 2, 1, 1, 3, 1, 2, 1, 1, 3, 3, 3, 3, 2, 2, 3, 3, 1, 2, 2, 3, 2, 1, 3, 3, 2, 1, 2, 1, 2, 2, 1, 2, 3, 3, 1, 1, 3, 2, 2, 3, 1, 3, 1, 2, 3, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 3, 1};
        lista = Arrays.asList(arreglo);
        
        //prueba fichas faltantes -- LaminasRelevantes
        List lista1 = new ArrayList();
        List lista2 = new ArrayList();
        Integer[] arreglo1 = {3,5,7,10,15,16};
        Integer[] arreglo2 = {4,10,5,8};
        lista1 = Arrays.asList(arreglo1);
        lista2 = Arrays.asList(arreglo2);
        
        //Identifica las laminas de las categorias faltantes
        List lista3 = new ArrayList();
        List lista4 = new ArrayList();
        Integer[] arreglo3 = {82, 2, 63, 257, 0, 154, 96, 71, 88, 270, 271, 11, 37, 279, 218, 204, 73, 193, 12, 19, 79, 274, 150, 315, 262, 298, 266, 247, 192, 52, 294, 316, 334, 33, 113, 118, 324, 326, 162, 179, 207, 16, 97, 99, 6, 176, 107, 35, 227, 76, 51, 278, 236, 317, 23, 160, 57, 296, 105, 292, 132, 233, 322, 28, 306, 39, 163, 171, 149, 286, 177, 141, 78, 98, 330, 261, 336, 3, 194, 222, 304, 136, 27, 83, 139, 220, 221, 229, 293, 30, 74, 125, 72, 180, 142, 95, 350, 339, 280, 157, 173, 343, 50, 4, 87, 159, 344, 77, 86, 153, 120, 251, 282, 36, 7, 66, 60, 55, 41, 62, 203, 34, 338, 24, 246, 166, 197, 209, 152, 254, 191, 15, 342, 277, 85, 135, 208, 249, 144, 186, 140, 264, 112};
        Integer[] arreglo4 = {5, 3, 4, 2, 5, 3, 4, 4, 3, 4, 1, 2, 1, 4, 1, 3, 1, 1, 4, 4, 3, 2, 5, 1, 2, 5, 5, 1, 5, 5, 2, 1, 2, 4, 2, 4, 3, 2, 1, 5, 4, 1, 5, 2, 1, 1, 1, 3, 2, 1, 1, 2, 1, 5, 2, 3, 2, 5, 4, 5, 5, 2, 5, 1, 1, 5, 2, 1, 4, 5, 4, 4, 3, 1, 1, 3, 4, 2, 3, 1, 4, 1, 3, 5, 2, 2, 4, 3, 4, 4, 1, 4, 3, 2, 1, 1, 3, 3, 2, 1, 5, 1, 1, 1, 4, 2, 4, 1, 3, 3, 5, 2, 2, 2, 5, 2, 4, 5, 1, 1, 1, 3, 3, 2, 3, 1, 3, 5, 5, 4, 5, 2, 4, 4, 1, 3, 1, 3, 1, 2, 3, 4, 4, 3, 5, 3, 3, 4, 3, 2, 3, 3, 2, 1, 3, 3, 4, 3, 5, 3, 5, 2, 1, 3, 2, 2, 2, 4, 5, 1, 5, 2, 1, 1, 3, 2, 1, 3, 2, 3, 1, 2, 4, 4, 3, 5, 4, 2, 1, 5, 3, 1, 4, 4, 5, 1, 1, 4, 4, 5, 5, 1, 1, 2, 2, 3, 4, 4, 2, 4, 1, 4, 1, 4, 1, 1, 5, 5, 2, 3, 5, 1, 4, 1, 4, 4, 5, 5, 4, 4, 4, 1, 4, 5, 2, 1, 4, 1, 1, 3, 4, 2, 3, 4, 5, 2, 5, 4, 1, 1, 1, 4, 1, 5, 1, 1, 2, 2, 3, 3, 1, 5, 4, 5, 4, 1, 2, 4, 4, 4, 3, 2, 4, 3, 4, 2, 2, 5, 4, 4, 5, 1, 2, 2, 3, 5, 1, 3, 3, 1, 4, 5, 3, 1, 4, 4, 2, 3, 3, 3, 4, 3, 5, 4, 5, 5, 3, 1, 1, 2, 3, 2, 3, 1, 4, 1, 1, 1, 2, 3, 3, 4, 2, 3, 2, 1, 4, 5, 5, 2, 1, 1, 1, 2, 5, 2, 1, 1, 2, 1, 5, 2, 2, 1, 1, 5, 3, 4, 3, 1, 4, 5};
        Integer categoria = 2;
        lista3 = Arrays.asList(arreglo3);
        lista4 = Arrays.asList(arreglo4);
        
        System.out.println(laminas.identificarCategorias(lista));
        System.out.println(laminas.identificarLaminasRelevantes(lista1,lista2));
        System.out.println(laminas.IdentificarCategoriaLaminasFaltantes(lista3,lista4,categoria));
        System.out.println(laminas.identificarLaminasParaCambiar(lista1,lista2));
    }
}
