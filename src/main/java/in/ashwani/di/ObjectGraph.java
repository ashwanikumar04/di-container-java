package in.ashwani.di;

/**
 * Created by Ashwani Kumar on 18/06/18.
 */
public class ObjectGraph {

    private Linker linker;

    public static ObjectGraph build() {
        ObjectGraph instance = new ObjectGraph();
        instance.linker = new Linker();
        return instance;
    }

    public Linker getLinker() {
        return linker;
    }

    public <T> T get(Class<T> key) {
        return linker.resolve(key).get(linker);
    }
}
