package in.ashwani.di;

/**
 * Created by Ashwani Kumar on 06/07/18.
 */
public class VisitHandler {

    private final Counter counter;
    private final Logger logger;

    public VisitHandler(Counter counter, Logger logger) {
        this.counter = counter;
        this.logger = logger;
    }

    public void visit() {
        counter.increment();
        logger.log("Visits increased: " + counter.getCount());
    }
}
