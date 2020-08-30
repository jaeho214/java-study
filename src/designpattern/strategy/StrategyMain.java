package designpattern.strategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StrategyMain {
    public static void main(String[] args) throws IOException {
        StrategyMain strategyMain = new StrategyMain();
        strategyMain.useConsoleLogging();
        strategyMain.useFileLogging();
    }

    public void useConsoleLogging(){
        final Client c = new Client(new ConsoleLogging());
        c.doWork(32);
    }

    public void useFileLogging() throws IOException {
        final File tempFile = File.createTempFile("test", "log");
        final Client c = new Client(new FileLogging(tempFile));
        c.doWork(41);
        c.doWork(42);
        c.doWork(43);

        final BufferedReader br = new BufferedReader(new FileReader(tempFile));
        if("Even number : 42".equals(br.readLine()))
            System.out.println("correct");

    }
}
