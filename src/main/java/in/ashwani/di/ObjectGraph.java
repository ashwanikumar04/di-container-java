package in.ashwani.di;

/**
 * Created by Ashwani Kumar on 18/06/18.
 */
public class ObjectGraph {

    private static ObjectGraph instance;
    private Linker linker;

    public static ObjectGraph build() {
        instance = new ObjectGraph();
        instance.linker = new Linker();
        return instance;
    }

    public <T> T get(Class<T> key) {
        return linker.get(key).get(linker);
    }
}
