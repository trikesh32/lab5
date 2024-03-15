package console;

import models.Coordinates;
import models.FuelType;
import models.Vehicle;
import models.VehicleType;
import utils.Console;

import java.util.NoSuchElementException;

public class Asker {
    public static class AskBreak extends Exception {
    }

    public static Vehicle askVehicle(Console console, int id) throws AskBreak {
        String name = askString("name", console);
        Coordinates coordinates = askCoordinates(console);
        Integer enginePower = null;
        do {
            enginePower = askInteger("engine power (> 0)", console);
        } while (enginePower == null || enginePower <= 0);
        Integer capacity = null;
        do {
            capacity = askInteger("capacity (> 0)", console);
        } while (capacity == null || capacity <= 0);
        VehicleType vehicleType = askVehicleType(console);
        FuelType fuelType = askFuelType(console);
        return new Vehicle(id, name, coordinates, enginePower, capacity, vehicleType, fuelType);
    }

    public static Coordinates askCoordinates(Console console) throws AskBreak {
        Integer x = null;
        Float y = null;
        do {
            x = askInteger("x (<= 636)", console);
        } while (x == null || x > 636);
        do {
            y = askFloat("y", console);
        } while (y == null);
        return new Coordinates(x, y);
    }

    public static String askString(String n, Console console) throws AskBreak {
        try {
            String name;
            do {
                console.print("Enter " + n + ": ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
            } while (name.isEmpty());
            return name;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Integer askInteger(String n, Console console) throws AskBreak {
        try {
            Integer x = null;
            do {
                console.print("Enter " + n + ": ");
                String number = console.readln().trim();
                if (number.equals("exit")) throw new AskBreak();
                if (!number.isEmpty()) {
                    try {
                        x = Integer.parseInt(number);
                    } catch (NumberFormatException e) {
                        console.println("Это должно быть целым числом!!!");
                    }
                }
            } while (x == null);
            return x;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Float askFloat(String n, Console console) throws AskBreak {
        try {
            Float y = null;
            do {
                console.print("Enter " + n + ": ");
                String number = console.readln().trim();
                if (number.equals("exit")) throw new AskBreak();
                if (!number.isEmpty()) {
                    try {
                        y = Float.parseFloat(number);
                    } catch (NumberFormatException e) {
                        console.println("Это должно быть числом!!!");
                    }
                }
            } while (y == null);
            return y;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
    public static VehicleType askVehicleType(Console console) throws AskBreak {
        try {
            console.print("VehicleType ("+VehicleType.names()+"): ");
            VehicleType r;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.isEmpty()) {
                    try { r = VehicleType.valueOf(line.toUpperCase()); break; } catch (NullPointerException | IllegalArgumentException  e) { }
                }
                console.print("VehicleType: ");
            }
            return r;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
    public static FuelType askFuelType(Console console) throws AskBreak {
        try {
            console.print("FuelType ("+FuelType.names()+"): ");
            FuelType r;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.isEmpty()) {
                    try { r = FuelType.valueOf(line.toUpperCase()); break; } catch (NullPointerException | IllegalArgumentException  e) { }
                }
                console.print("FuelType: ");
            }
            return r;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
}
