package in.ashwani.di;

import java.io.PrintStream;

/**
 * Created by Ashwani Kumar on 06/07/18.
 */
public class Logger {

    private final PrintStream printStream;

    public Logger(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void log(String log) {
        printStream.println(log);
    }
}
