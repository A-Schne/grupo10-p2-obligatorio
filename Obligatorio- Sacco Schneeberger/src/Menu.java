import CSVResources.CSVLoader;
import Consultas.*;
import Entities.Driver;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        int menu;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\nElija que consulta hacer:\n1.Listar los 10 pilotos activos mas mencionados en cierto mes \n2.Top 15 usuarios con mas tweets \n3.Cantidad de hashtags distintos para un dia dado \n4.Hashtag mas usado en un dia \n5.Top 7 cuentas con mas favoritos \n6.Cantidad de tweets con una palabra\n7.Terminar consultas\n\nRespuesta: ");
            menu = scanner.nextInt();
            switch (menu) {

                case 1:
                    primeraConsulta();
                    break;
                case 2:
                    segundaConsulta();
                    break;
                case 3:
                    terceraConsulta();
                    break;
                case 4:
                    cuartaConsulta();
                    break;
                case 5:
                    quintaConsulta();
                    break;
                case 6:
                    sextaConsulta();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Numero ingresado invalido, porfavor pruebe de nuevo.");

            }

        } while(menu!=7);

    }

    public static void primeraConsulta() throws Exception {

        Scanner scannerFecha = new Scanner(System.in);
        System.out.println("¿En que mes quiere buscar? Escribalo de la forma yyyy-mm");
        String date = scannerFecha.nextLine();

        //Creo un file con el path a drivers.txt, de esta manera al hacer scanner puedo ir consiguiendo sus nombres 1 por 1
        File file = new File("src/CSVResources/drivers.txt");
        Scanner scannerPilotos = new Scanner(file);

        //Luego usare esta lista de pilotos para poder contar cuantas veces fueron mencionadas en un mes
        Lista<Driver> pilotosTemp = new LinkedList<>();

        //Agrega todos los nombres de los corredores del .txt uno en uno
        while(scannerPilotos.hasNextLine()){
            String nombrePiloto = scannerPilotos.nextLine();

            String[] partesDeNombre = nombrePiloto.split("\\s");

            String nombre = null;
            String apellido = null;

            if(partesDeNombre.length == 2){
                nombre = partesDeNombre[0];
                apellido = partesDeNombre[1];
            }
            if(partesDeNombre.length == 3){
                nombre = partesDeNombre[0];
                apellido = partesDeNombre[1]+" "+partesDeNombre[2];
            }

            Driver pilotoNuevo = new Driver(nombrePiloto, nombre, apellido);
            pilotosTemp.add(pilotoNuevo);
        }

        ConsultaMostMentioned primerConsulta = new ConsultaMostMentioned(pilotosTemp, date);
        CSVLoader a = new CSVLoader(primerConsulta);
        a.readCSV();
        primerConsulta.hacerPrimeraConsulta();
    }

    public static void segundaConsulta() throws Exception {

        ConsultaMostTweetsUser segundaConsulta = new ConsultaMostTweetsUser();
        CSVLoader loader = new CSVLoader(segundaConsulta);
        long inicio = System.currentTimeMillis();
        loader.readCSV();
        segundaConsulta.hacerSegundaConsulta();
        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
    }

    public static void terceraConsulta() throws Exception {

        Scanner scannerFecha = new Scanner(System.in);
        System.out.println("¿En que dia quiere buscar? Escribalo de la forma yyyy-mm-dd");
        String date = scannerFecha.nextLine();

        ConsultaAmountOfTweets terceraConsulta = new ConsultaAmountOfTweets(date);
        CSVLoader loader = new CSVLoader(terceraConsulta);

        long inicio = System.currentTimeMillis();
        loader.readCSV();
        terceraConsulta.hacerTerceraConsulta();
        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
    }

    public static void cuartaConsulta() throws Exception {

        Scanner scannerFecha = new Scanner(System.in);
        System.out.println("¿En que dia quiere buscar? Escribalo de la forma yyyy-mm-dd");
        String date = scannerFecha.nextLine();

        ConsultaHashtagMostUsed cuartaConsulta = new ConsultaHashtagMostUsed(date);
        CSVLoader loader = new CSVLoader(cuartaConsulta);
        long inicio = System.currentTimeMillis();
        loader.readCSV();
        cuartaConsulta.hacerCuartaConsulta();
        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
    }

    public static void quintaConsulta() throws Exception {

        ConsultaUserWithMostFavs quintaConsulta = new ConsultaUserWithMostFavs();
        CSVLoader loader = new CSVLoader(quintaConsulta);
        long inicio = System.currentTimeMillis();
        loader.readCSV();
        quintaConsulta.hacerQuintaConsulta();
        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
    }

    public static void sextaConsulta() throws Exception {
        Scanner scannerTexto = new Scanner(System.in);
        System.out.println("¿Escriba una palabra o frase con la que quiera hacer la consulta: ");
        String texto = scannerTexto.nextLine().toLowerCase();

        ConsultaTextInTweets sextaConsulta = new ConsultaTextInTweets(texto);
        CSVLoader loader = new CSVLoader(sextaConsulta);

        long inicio = System.currentTimeMillis();
        loader.readCSV();
        sextaConsulta.hacerSextaConsulta();

        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
    }

}