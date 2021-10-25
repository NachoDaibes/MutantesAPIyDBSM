package com.example.magneto;

import com.example.magneto.matrices.Matriz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrizTest {

    private Matriz matriz = new Matriz();

    @Test
    public void horizontalTest(){
        boolean esperado = true;
        boolean resultado = false;

        matriz.getDna().add("AAAA");
        matriz.getDna().add("AAAA");
        matriz.getDna().add("FFCC");
        matriz.getDna().add("AAAG");

        for (String s : matriz.getDna()) {
            matriz.analisisHorizontal(s);
            if (matriz.getCounter() > 1){
                resultado = true;
            }
        }
        assertEquals(esperado,resultado);
    }

    @Test
    public void verticalTest(){
        boolean esperado = true;
        boolean resultado = false;

        matriz.getDna().add("AFAA");
        matriz.getDna().add("AFAA");
        matriz.getDna().add("AFCC");
        matriz.getDna().add("AFAG");
        matriz.analisisVertical(matriz.getDna());
        if (matriz.getCounter() > 1){
            resultado = true;
        }
        assertEquals(esperado, resultado);
    }

    @Test
    public void diagonalPrincipalTest(){
        boolean esperado = true;
        boolean resultado = false;

        matriz.getDna().add("AFAAA");
        matriz.getDna().add("AQFAF");
        matriz.getDna().add("QAAFA");
        matriz.getDna().add("AFAAF");
        matriz.getDna().add("AFAAA");
        matriz.diagonalPrincipalArriba(matriz.getDna());
        matriz.diagonalPrincipalAbajo(matriz.getDna());
        if (matriz.getCounter() > 1){
            resultado = true;
        }
        assertEquals(esperado,resultado);
    }

    @Test
    public void diagonalPrincipal2Test(){
        boolean esperado = true;
        boolean resultado = false;

        matriz.getDna().add("AFAAA");
        matriz.getDna().add("AQAAA");
        matriz.getDna().add("QAAAA");
        matriz.getDna().add("AQAAQ");
        matriz.getDna().add("AAAGA");
        matriz.diagonalPrincipal2Arriba(matriz.getDna());
        matriz.diagonalPrincipal2Abajo(matriz.getDna());
        if (matriz.getCounter() > 1){
            resultado = true;
        }
        assertEquals(esperado,resultado);
    }

    @Test
    public void isMutantTest(){
        boolean resultado = false;
        boolean esperado = true;

        matriz.getDna().add("AAAAT");
        matriz.getDna().add("GACAT");
        matriz.getDna().add("TTTTG");
        matriz.getDna().add("TGTAA");
        matriz.getDna().add("ATCAA");
        assertEquals(esperado, matriz.isMutant(matriz.getDna()));
    }
}
