/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.eva3_1_ordenamientos;

/**
 *
 * @author dell
 */
public class Eva3_1_Ordenamientos {

    public static void main(String[] args) {
        int[] original, selection, insertion, bubble, quick, merge;
        original = new int[10];
        System.out.println("Arreglo original");
        llenar(original);
        imprimir(original);
        System.out.println("");
        System.out.println("Selection Sort");
        selection = copiar(original);
        long ini = System.nanoTime();
        selectionSort(selection);
        long fin = System.nanoTime();
        long tiempo = fin - ini;
        imprimir(selection);
        System.out.println("Selecton sort duración = " + tiempo);
        System.out.println("Insertion Sort");
        insertion = copiar(original);
        ini = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(insertion);
        System.out.println("Insertion sort duración = " + tiempo);
        System.out.println("Bubble Sort");
        bubble = copiar(original);
        ini = System.nanoTime();
        bubbleSort(bubble);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(bubble);
        System.out.println("Bubble sort duración = " + tiempo);
        System.out.println("Quick Sort");
        quick = copiar(original);
        ini = System.nanoTime();
        quickSort(quick);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(quick);
        System.out.println("Quick sort duración = " + tiempo);
    }

    public static void llenar(int[] arreglo) {
        for (int i = 0; i < 10; i++) {
            arreglo[i] = ((int) (Math.random() * 1000));
        }
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static int[] copiar(int[] arreglo) {
        int resu[] = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            resu[i] = arreglo[i];
        }
        return resu; // <--- Faltaba esto
    }

    // Metodos de ordenamiento
    //O(N^2) Compara más
    //O(N) Intercambia menos
    public static void selectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {//Controla las pasadas
            int min = i;//Cuando empieza rl más pequeño es el primer elemento
            for (int j = i + 1; j < arreglo.length; j++) {//Busca el dato más pequeño
                if (arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            //Intercambio o SWAP
            int temp = arreglo[min];
            arreglo[min] = arreglo[i];
            arreglo[i] = temp;

        }
    }

    //O(N^2)
    public static void insertionSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];
            int insP = i;
            int prev = insP - 1;
            while (insP > 0 && arreglo[prev] > temp) {
                arreglo[insP] = arreglo[prev];
                arreglo[prev] = temp;
                insP--;
                prev = insP - 1;
            }
        }
    }

    //O(N^2)
    // Compara mucho, intercambia mucho, es el más sencillo
    public static void bubbleSort(int[] arreglo) {//El peor metodo de ordenamiento
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arreglo) {
        quickSortRec(arreglo, 0, arreglo.length - 1);
    }

    private static void quickSortRec(int[] arreglo, int ini, int fin) {
        if (ini < fin) {
            int pivote = arreglo[ini];
            int big = ini + 1;
            int small = fin;

            while (big <= small) {

                while (big <= fin && arreglo[big] <= pivote) {
                    big++;
                }
                while (small > ini && arreglo[small] > pivote) {
                    small--;
                }
                if (big < small) {
                    int temp = arreglo[big];
                    arreglo[big] = arreglo[small];
                    arreglo[small] = temp;
                } else {
                    int temp = arreglo[ini];
                    arreglo[ini] = arreglo[small];
                    arreglo[small] = temp;
                    break;
                }
            }
            quickSortRec(arreglo, ini, small - 1);
            quickSortRec(arreglo, small + 1, fin);
        }
    }

        //O(N log N)
    // Divide el arreglo a la mitad, ordena cada mitad y las mezcla
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return;
        }
        int[] aux = new int[arreglo.length]; // Arreglo auxiliar para mezclar
        mergeSortRec(arreglo, aux, 0, arreglo.length - 1);
    }

    private static void mergeSortRec(int[] arreglo, int[] aux, int ini, int fin) {
        if (ini < fin) {
            int mid = ini + (fin - ini) / 2;
            mergeSortRec(arreglo, aux, ini, mid);       // Mitad izquierda
            mergeSortRec(arreglo, aux, mid + 1, fin);   // Mitad derecha
            mezclar(arreglo, aux, ini, mid, fin);       // Mezcla ambas mitades
        }
    }

    private static void mezclar(int[] arreglo, int[] aux, int ini, int mid, int fin) {
        // Copia el rango actual al auxiliar
        for (int k = ini; k <= fin; k++) {
            aux[k] = arreglo[k];
        }
        int i = ini;       // Recorre la mitad izquierda
        int j = mid + 1;   // Recorre la mitad derecha
        int k = ini;       // Posición donde se escribe en el original

        while (i <= mid && j <= fin) {
            if (aux[i] <= aux[j]) {
                arreglo[k++] = aux[i++];
            } else {
                arreglo[k++] = aux[j++];
            }
        }
        // Si sobran elementos de la izquierda, se copian.
        // Los de la derecha ya están en su lugar.
        while (i <= mid) {
            arreglo[k++] = aux[i++];
        }
    }}
