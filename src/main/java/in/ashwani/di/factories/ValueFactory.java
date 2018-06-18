package in.ashwani.di.factories;

import in.ashwani.di.Linker;

/**
 * Created by Ashwani Kumar on 18/06/18.
 */
public class ValueFactory<T> implements Factory<T> {
    private T value;

    public ValueFactory(T instance) {
        this.value = instance;
    }

    public static <T> Factory<T> of(T instance) {
        return new ValueFactory<>(instance);
    }


    @Override
    public T get(Linker linker) {
        return value;
    }
}
