package Actividad13;

import java.util.ArrayList;
import java.util.Comparator;

interface anonClass{
    void anonMethod();
}

interface intFuncional{
    String intFuncionalMethod(ArrayList<String> A);
}

interface metReferencia{
    void metReferenciaMethod(ArrayList<String> A);
}

class Ordenar {

    class diferenciarporalfabeto implements Comparator<String> {
        public int compare(String S1, String S2) {
            return S1.compareTo(S2);
        }

    }

    void ordenarAlf(ArrayList<String> A) {
        A.sort(new diferenciarporalfabeto());

        System.out.println();
        System.out.println("ORDEN DE LOS NOMBRES ALFABETICAMENTE CON LA REFERENCIA:");

        for (String Alfabeto : A) {
            System.out.println(Alfabeto);
        }
    }


    class porLongitud implements Comparator<String> {
        public int compare(String S1, String S2) {

            int L1 = S1.length();
            int L2 = S2.length();

            if (L1 > L2) {
                return 1;
            } else if (L1 < L2) {
                return -1;
            }
            return 0;
        }
    }

    void ordenarLong(ArrayList<String> A) {
        A.sort(new porLongitud());

        System.out.println();
        System.out.println("NOMBRES POR LONGITUD CON REFEERENCIA:");

        for (String Longitud : A) {
            System.out.println(Longitud);
        }
    }


}
public class Ejemplo {
    public static void main(String[] args) {


        ArrayList<String> List = new ArrayList<>();


        List.add("CARLO LOPEZ");
        List.add("ADRIAN GARCIA");
        List.add("MATEO ");
        List.add("MEELYSA GUZMAN");
        List.add("LUIS ");
        List.add("FERNAnDO SALAZAR");
        List.add("TANIA AS");
        List.add("PERLA PACHECO");
        List.add("IVAN ");
        List.add("GABRIEL MEZA");

        anonClass anon = new anonClass() {
            @Override
            public void anonMethod() {
                class diferenciarporalfabeto implements Comparator<String>{
                    public int compare(String S1, String S2){
                        return S1.compareTo(S2);
                    }
                }

                List.sort(new diferenciarporalfabeto());
                System.out.println("ORDEN DE LOS NOMBRES ALFABETICAMENTE POR ANONIMO:");

                for (String Alfabeto : List) {
                    System.out.println(Alfabeto);
                }

                class porlongitud implements Comparator<String>{
                    public int compare(String S1, String S2){

                        int L1 = S1.length();
                        int L2 = S2.length();

                        if(L1 > L2){
                            return 1;
                        }
                        else if (L1 < L2){
                            return -1;
                        }
                        return 0;
                    }
                }

                List.sort(new porlongitud());
                System.out.println();
                System.out.println("ORDEN DE LOS NOMBRES POR LONGITUD POR ANOMINO:");

                for(String Longitud : List){
                    System.out.println(Longitud);
                }
            }
        };

        anon.anonMethod();
        System.out.println();

        intFuncional lambda = (a) -> {
            class compararporalfabeto implements Comparator<String>{
                public int compare(String S1, String S2){
                    return S1.compareTo(S2);
                }
            }

            List.sort(new compararporalfabeto());
            System.out.println("ORDEN DE LOS NOMBRES ALFABETICAMENTE CON LAMBDA:");

            for (String Alfabeto : List) {
                System.out.println(Alfabeto);
            }

            class porlongitud implements Comparator<String>{
                public int compare(String S1, String S2){

                    int L1 = S1.length();
                    int L2 = S2.length();

                    if(L1 > L2){
                        return 1;
                    }
                    else if (L1 < L2){
                        return -1;
                    }
                    return 0;
                }
            }

            List.sort(new porlongitud());
            System.out.println();
            System.out.println("ORDEN DE LOS NOMBRES POR LONGITUD CON LAMBDA:");

            for(String Longitud : List){
                System.out.println(Longitud);
            }
            return null;
        };

        lambda.intFuncionalMethod(List);
        System.out.println();


        Ordenar lista = new Ordenar();

        metReferencia ordenadaAlf = lista::ordenarAlf;
        ordenadaAlf.metReferenciaMethod(List);

        metReferencia ordenadaLong = lista::ordenarLong;
        ordenadaLong.metReferenciaMethod(List);
    }
}