package com.example.magneto.matrices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Matriz {

    private List<String> dna = new ArrayList<>();
    private int counter = 0;

    //Algoritmo que analiza todas las diagonales e indica si la persona es mutante o no
    public Boolean isMutant(List<String> dna){

        boolean is = false;
        for (String s : dna) {//por cada palabra del arrray va a hacer un analisis horizontal
            analisisHorizontal(s);
        }
        analisisVertical(dna);//recibe el array completo y compara de a numero de caracteres
        analisisCruzado1(dna);//compara todas las diagonales
        if (counter > 1) {//si encuentra mas de dos pares de 4 letras seguidas retorna true
            is = true;}
        counter = 0;
        return is;}

    //Algoritmo para las lineas horizontales
    public void analisisHorizontal(String s) {
        int counterHoriz = 0;//cuenta las coincidencias de dos letras seguidas en la misma liena horizontal
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {//agarro una letra de una palabra y la comparo con su siguiente
                counterHoriz++;
                if (counterHoriz > 2) {
                    counter++;
                    counterHoriz = 0;
                }
            } else {
                counterHoriz = 0;
            }
        }
    }

    //Algoritmo para las lineas verticales
    public void analisisVertical(List<String> listaOriginal) {
        int counterVert = 0;

        for (int j = 0; j < listaOriginal.get(0).length(); j++) {//itera desde el caracter 0 hasta el tamaño del arreglo
            if (counter > 1){return;}
            for (int i = 1; i < listaOriginal.size(); i++) {
                if (listaOriginal.get(i - 1).charAt(j) == listaOriginal.get(i).charAt(j)) {//compara el caracter 0 de la palabra 1 con el caracter 0 de la palabra 0
                    counterVert++;
                    if (counterVert > 2) {
                        counter++;
                        counterVert = 0;
                    }
                } else {
                    counterVert = 0;
                }
            }
            counterVert = 0;
        }
    }

    //Analisis para las lineas diagonales
    public void analisisCruzado1(List<String> listaOriginal){
        diagonalPrincipalArriba(listaOriginal);
        diagonalPrincipalAbajo(listaOriginal);
        diagonalPrincipal2Arriba(listaOriginal);
        diagonalPrincipal2Abajo(listaOriginal);
    }

    //Algoritmo para la diagonal principal
    public void diagonalPrincipalArriba(List<String> listaOrignal) {
        int counterCruz = 0;
        int i = 1;
        int n = 1;

        for (int k = 1; k < listaOrignal.size() - 2; k++) {

            for (int j = 1; j < listaOrignal.get(0).length(); j++) {
                if (i > listaOrignal.size() - 1){return;}
                if (listaOrignal.get(j).charAt(i) == listaOrignal.get(j - 1).charAt(i - 1)) {
                    counterCruz++;
                    if (counterCruz > 2) {
                        counter++;
                        counterCruz = 0;
                    }
                } else {
                    counterCruz = 0;
                }
                i++;
                if (j == listaOrignal.size() - 1){ i = n + 1;
                    counterCruz = 0;}
            }

        }
    }

    public void diagonalPrincipalAbajo(List<String> listaOrignal) {
        int counterCruz = 0;
        int j = 1;
        int n = 1;

        for (int k = 1; k < listaOrignal.size() - 2; k++) {

            for (int i = 1; i < listaOrignal.get(0).length(); i++) {
                if (j > listaOrignal.size() - 1){return;}
                if (listaOrignal.get(j).charAt(i) == listaOrignal.get(j - 1).charAt(i - 1)) {
                    counterCruz++;
                    if (counterCruz > 2) {
                        counter++;
                        counterCruz = 0;
                    }
                } else {
                    counterCruz = 0;
                }
                j++;
                if (i == listaOrignal.size() - 1){ j = n + 1;
                    counterCruz = 0;}
            }

        }
    }

    //Algoritmo para la diagonal principal 2
    public void diagonalPrincipal2Arriba(List<String> listaOrignal) {
        int counterCruz = 0;
        int i = listaOrignal.get(0).length() - 1; //este indice se utiliza para variar el caracter o columna de la matriz, lo declaro acá porque cuando termina el bucle quiero que inicie con otro valor al que guarda en la última iteración
        int n = listaOrignal.get(0).length() - 2;

        for (int k = 1; k < listaOrignal.get(0).length(); k++){
            for (int j = 1; j < listaOrignal.get(0).length(); j++) {
                i--;
                if (i < 0){return;}
                if (listaOrignal.get(j).charAt(i) == listaOrignal.get(j - 1).charAt(i + 1)) {//comparo la palabra en la pos. j y caracter i, con la palabra en la pos. j-1 y caracter i-1
                    counterCruz++;
                    if (counterCruz > 2) {
                        counter++;
                        counterCruz = 0;
                    }
                } else {
                    counterCruz = 0;
                }
                if (j == listaOrignal.size() - 1){i = n--;//decremento n para poder pasar a la diagonal de arriba y con el contador en 0
                    counterCruz = 0;}
            }
        }
    }

    public void diagonalPrincipal2Abajo(List<String> listaOrignal) {
        int counterCruz = 0;
        int j = 0; //este indice se utiliza para variar la palabra o fila de la matriz, lo declaro acá porque cuando termina el bucle quiero que inicie con otro valor al que guarda en la última iteración
        int n = 1; //este indice se utiliza para definir el valor que tendrá j en la segunda iteración del bucle grande

        for (int k = 1; k < listaOrignal.get(0).length(); k++){//este bucle se utiliza para no solo recorrer la diagonal prinicipal, sino que las de abajo de ella
            for (int i = listaOrignal.size() - 2; i > -1; i--) {//este es el bucle que recorre las diagonales de a una
                j++;
                if (j > listaOrignal.size() - 1){return;}
                if (listaOrignal.get(j).charAt(i) == listaOrignal.get(j - 1).charAt(i + 1)) {
                    counterCruz++;
                    if (counterCruz > 2) {
                        counter++;
                        counterCruz = 0;
                    }
                } else {
                    counterCruz = 0;
                }
                if (i < 1){j = n++;//incremento n y hago el contador 0 para poder pasar a la dagonal de abajo y contar desde 0 las coincidencias
                    counterCruz = 0;}
            }
        }
    }
}
