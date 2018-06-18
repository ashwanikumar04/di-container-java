package in.ashwani.di.factories;

import in.ashwani.di.Linker;

/**
 * Created by Ashwani Kumar on 18/06/18.
 */
public interface Factory<T> {
    T get(Linker linker);
}
