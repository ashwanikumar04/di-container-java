package in.ashwani.di;

import in.ashwani.di.factories.Factory;
import in.ashwani.di.factories.SingletonFactory;
import in.ashwani.di.factories.ValueFactory;

import java.io.PrintStream;

/**
 * Created by Ashwani Kumar on 18/06/18.
 */
public class App {

    private static void registerDependencies(ObjectGraph objectGraph) {
        objectGraph
                .getLinker()
                .register(VisitHandler.class, linker -> {
                    Factory<Counter> counterFactory = linker.resolve(Counter.class);
                    Factory<Logger> loggerFactory = linker.resolve(Logger.class);

                    Counter counter = counterFactory.get(linker);
                    Logger logger = loggerFactory.get(linker);

                    return new VisitHandler(counter, logger);
                });

        objectGraph.getLinker().register(Logger.class, linker -> {
            Factory<PrintStream> printStreamFactory = linker.resolve(PrintStream.class);
            return new Logger(printStreamFactory.get(linker));
        });

        objectGraph.getLinker().register(PrintStream.class, ValueFactory.of(System.out));
        objectGraph.getLinker().register(Counter.class, SingletonFactory.of(linker -> new Counter()));
    }


    public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.build();
        registerDependencies(objectGraph);
        VisitHandler visitHandler = objectGraph.get(VisitHandler.class);
        visitHandler.visit();
    }
}
