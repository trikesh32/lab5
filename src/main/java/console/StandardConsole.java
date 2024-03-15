package console;

import utils.Console;

import java.io.File;
import java.util.Scanner;

public class StandardConsole implements Console {
    private final String PROMPT = "$ ";
    private Scanner prompt_scanner = null;

    public void println(Object obj) {
        System.out.println(obj);
    }

    public void print(Object obj) {
        System.out.print(obj);
    }

    public String readln() {
        return prompt_scanner.nextLine();
    }

    public boolean isCanReadLn() {
        return prompt_scanner.hasNextLine();
    }

    public void selectConsoleScanner() {
        prompt_scanner = new Scanner(System.in);
    }

    public void selectFileScanner(Scanner s) {
        prompt_scanner = s;
    }
    public void printError(Object obj){
        System.err.println("Error(err): " + obj);
        System.out.println("Error(out) " + obj);
    }
    public void prompt(){
        print(PROMPT);
    }
    public String getPrompt(){
        return PROMPT;
    }
}
