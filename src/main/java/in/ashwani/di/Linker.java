package in.ashwani.di;

import in.ashwani.di.factories.Factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ashwani Kumar on 18/06/18.
 */
public class Linker {
    private Map<Class<?>, Factory<?>> registered = new HashMap<>();

    public <T> void register(Class<T> key, Factory<T> factory) {
        registered.put(key, factory);
    }

    public <T> Factory<T> resolve(Class<T> key) {
        return (Factory<T>) registered.get(key);
    }
}
