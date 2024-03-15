package utils;

import java.util.Scanner;

public interface Console {
    void print(Object obj);
    void println(Object obj);
    String readln();
    boolean isCanReadLn();
    void printError(Object obj);
    void prompt();
    String getPrompt();
    void selectFileScanner(Scanner obj);
    void selectConsoleScanner();
}
