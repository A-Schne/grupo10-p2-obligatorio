package Consultas;

import CSVResources.CSVTweetReader;
import Entities.Driver;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeImpl;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeInt;
import uy.edu.um.prog2.adt.TADs.BST.Entities.Nodo;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

public class ConsultaMostMentioned implements CSVTweetReader {

    private Lista<Driver> drivers;
    private String inputDate;
    private Lista<String[]> textDate;
    private MyTreeInt<Integer, Driver> pilotosOrdenados;
    private Lista<Driver> driversOrdenadosResult;

    public ConsultaMostMentioned(Lista<Driver> drivers, String inputDate) {
        this.drivers = drivers;
        this.textDate = new LinkedList<>();
        this.inputDate = inputDate;
        this.driversOrdenadosResult = new LinkedList<>();
        this.pilotosOrdenados = new MyTreeImpl<>();
    }

    public Lista<Driver> getDrivers() {
        return drivers;
    }

    public String getInputDate() {
        return inputDate;
    }

    public Lista<String[]> getTextDate() {
        return textDate;
    }

    public Lista<Driver> getDriversOrdenadosResult() {
        return driversOrdenadosResult;
    }

    public MyTreeInt<Integer, Driver> getPilotosOrdenados() {
        return pilotosOrdenados;
    }

    //Notar que execute no se llama desde el menu


    public void orderDriverByMentions(Lista<Driver> pilotos) throws Exception {
        Driver dummyDriver = new Driver(null, null, null);
        //Agrego un nodo sin menciones asi todos los elementos que meto tienen mas menciones y van hacia la derecha
        pilotosOrdenados.insert(dummyDriver.getMentions(), dummyDriver);
        for (int i = 0; i < pilotos.size(); i++) {
            pilotosOrdenados.insert(pilotos.get(i).getMentions(), pilotos.get(i));
        }
        for (int j = 0; j < pilotos.size(); j++) {
            get10Drivers(pilotosOrdenados.getRoot());
        }
    }

    public void get10Drivers(Nodo<Integer, Driver> driverNode) throws Exception {
        if (driverNode.getRightChild() != null) {
            get10Drivers(driverNode.getRightChild());
        } else {
            driversOrdenadosResult.add(driverNode.getData());
            pilotosOrdenados.delete(driverNode.getKey());
        }
    }

    public void hacerPrimeraConsulta() throws Exception {
        orderDriverByMentions(drivers);
        System.out.println("Los 10 pilotos con mas menciones en el mes " + this.inputDate + " son: ");
        for (int i = 0; i < 10; i++) {
            String nombre = driversOrdenadosResult.get(i).getFullname();
            int menciones = driversOrdenadosResult.get(i).getMentions();
            System.out.println((i + 1) + ". " + nombre + " con " + menciones + " menciones");
        }
    }
}
