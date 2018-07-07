package in.ashwani.di.factories;

import in.ashwani.di.Linker;

/**
 * Created by Ashwani Kumar on 06/07/18.
 */
public class SingletonFactory<T> implements Factory<T> {

    public static <T> Factory<T> of(Factory<T> factory) {
        return new SingletonFactory<>(factory);
    }

    private T instance;
    private final Factory<T> factory;

    private SingletonFactory(Factory<T> factory) {
        this.factory = factory;
    }


    @Override
    public T get(Linker linker) {
        if (instance == null) {
            instance = factory.get(linker);
        }
        return instance;
    }
}
