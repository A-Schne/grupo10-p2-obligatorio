import CSVResources.CSVLoader;
import Consultas.ConsultaActiveDrivers;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija que consulta hacer:\n1.Listar los 10 pilotos activos mas mencionados en cierto mes \n2.Top 15 usuarios con mas tweets \n3.Cantidad de hashtags distintos para un dia dado \n4.Hashtag mas usado en un dia \n5.Top 7 cuentas con mas favoritos \n6.Cantidad de tweets con una palabra\n\nRespuesta: ");
        if (scanner.nextInt()==1){
            primeraConsulta();

        }
    }

    public static void primeraConsulta(){

        Scanner scannerFecha = new Scanner(System.in);
        System.out.println("¿En que mes quiere buscar? Escribalo de la forma yyyy-mm");
        String date = scannerFecha.nextLine();


        ConsultaActiveDrivers primerConsulta = new ConsultaActiveDrivers(date);
        CSVLoader a = new CSVLoader(primerConsulta);
        //a.readCSV();
    }
}