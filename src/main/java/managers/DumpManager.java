package managers;
import models.Vehicle;
import utils.Console;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DumpManager {
    private final String filename;
    private final Console console;
    public DumpManager(String filename, Console console){
        this.filename = filename;
        this.console = console;
    }
//    public void POJO2XML(Vehicle obj) throws IOException {
//        JAXBContext context = JAXBContext.newInstance(MyClass.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(obj, new File("output.xml"));
//    }
}
