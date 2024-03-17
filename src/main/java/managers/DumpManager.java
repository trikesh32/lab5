package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Coordinates;
import models.FuelType;
import models.Vehicle;
import models.VehicleType;
import utils.Console;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class DumpManager {
    private final String filename;
    private final Console console;

    public DumpManager(String filename, Console console) {
        this.filename = filename;
        this.console = console;
    }

    public String java2xml(Stack<Vehicle> obj) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(obj);
        } catch (Exception e) {
            console.printError("Ошибка сереализации");
            return null;
        }
    }

    public HashMap<String, ArrayList<LinkedHashMap<String, Object>>> xml2map(String s) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(s, HashMap.class);
    }

    public Stack<Vehicle> xml2collection(String s) {
        try {
            HashMap<String, ArrayList<LinkedHashMap<String, Object>>> map = xml2map(s);
            ArrayList<LinkedHashMap<String, Object>> temp = map.get("item");
            Stack<Vehicle> collection = new Stack<>();
            for (var data : temp) {
                Integer id = Integer.parseInt((String) data.get("id"));
                String name = (String) data.get("name");
                LinkedHashMap<String, Object> coordinates = (LinkedHashMap<String, Object>) data.get("coordinates");
                Integer x = Integer.parseInt((String) coordinates.get("x"));
                Float y = Float.parseFloat((String) coordinates.get("y"));
                LocalDate creationDate = LocalDate.parse((String) data.get("creationDate"));
                Integer enginePower = (Integer) data.get("enginePower");
                Integer capacity = (Integer) data.get("capacity");
                VehicleType type = VehicleType.valueOf(((String) data.get("type")).toUpperCase());
                FuelType fuelType = FuelType.valueOf(((String) data.get("fuelType")).toUpperCase());
                Vehicle vehicle = new Vehicle(id, name, new Coordinates(x, y), creationDate, enginePower, capacity, type, fuelType);
                if (vehicle.check_validity()) {
                    collection.push(vehicle);
                } else {
                    console.printError("Объект имеет некорректные");
                }
            }
            return collection;
        } catch (Exception e) {
            console.printError("Ошибка десереализации");
            console.println(e);
            return null;
        }
    }

    public <T> void saveDump(T collection) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(filename), collection);
    }
}
