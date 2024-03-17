import console.StandardConsole;
import managers.DumpManager;
import models.*;
import utils.Console;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Console console = new StandardConsole();
            console.selectConsoleScanner();
//            Vehicle vehicle = Asker.askVehicle(console, 1);
            Vehicle vehicle = new Vehicle(1, "huy", new Coordinates(1, 2.F), 1, 1, VehicleType.CAR, FuelType.GASOLINE);
            Vehicle vehicle1 = new Vehicle(2, "gay", new Coordinates(20, -10.F), 1, 1, VehicleType.HOVERBOARD, FuelType.ALCOHOL);
            DumpManager dumpManager = new DumpManager("huy", console);
            Stack<Vehicle> c = new Stack<>();
            c.add(vehicle);
            c.add(vehicle1);
            String xmlString = dumpManager.java2xml(c);
            System.out.println(dumpManager.xml2collection(xmlString));

//        } catch (Asker.AskBreak e){
//            System.out.println("ошибка епт");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}