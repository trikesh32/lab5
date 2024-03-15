import console.Asker;
import console.StandardConsole;
import managers.DumpManager;
import models.*;
import utils.Console;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Console console = new StandardConsole();
            console.selectConsoleScanner();
            Vehicle vehicle = Asker.askVehicle(console, 1);

        } catch (Asker.AskBreak e){
            System.out.println("ошибка епт");
        }

    }
}