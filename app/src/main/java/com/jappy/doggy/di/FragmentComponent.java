package com.jappy.doggy.di;

import android.support.v4.app.Fragment;

/**
 * Created by irenecedeno on 09-02-18.
 */

public interface FragmentComponent<T extends Fragment>{
    /**
     * Indica que T requiere inyección desde este componente
     * @param target T
     */
    void inject(T target);
}
