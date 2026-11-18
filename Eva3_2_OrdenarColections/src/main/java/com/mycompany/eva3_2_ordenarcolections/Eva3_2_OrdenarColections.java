/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eva3_2_ordenarcolections;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author dell
 */
public class Eva3_2_OrdenarColections {

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(234);
        lista.add(321);
        lista.add(345);
        lista.add(432);
        lista.add(456);
        lista.add(765);
        //Crear un comparator
       Comparator<Integer> comparador = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Positivo = o1 es mayor
                // Cero = ambos iguales
                // Negativo = o2 es mayor
                return o1 - o2;
            }
        };

        lista.sort(comparador);
        System.out.println(lista);
        
         LinkedList<String> lista2 = new LinkedList<>();
        lista2.add("Mundo");
        lista2.add("Hola");

       Comparator<Object> comparador2 = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String cad1 = (String) o1;
                String cad2 = (String) o2;
                // Negativo = cad1 va antes que cad2
                // Cero = son iguales
                // Positivo = cad1 va después que cad2
                return cad1.compareTo(cad2);
            }
        };

        lista2.sort(comparador2);
        System.out.println(lista2);
    }
    }
          