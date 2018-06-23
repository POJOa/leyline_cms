package com.k41d.leyline.framework.infrastructure.common;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Created by POJO on 5/30/16.
 */

public class ClassEraser<T> {

    private  Supplier<? extends T> ctor;


    public ClassEraser(Supplier<? extends T> ctor) {
        this.ctor = Objects.requireNonNull(ctor);
    }

    public T get() {
        if (ctor != null) {
            return ctor.get();
        } else {
            return null;
        }
    }

}
