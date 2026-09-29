package org.example.products;

import org.example.model.GraphicsFamily;

abstract class AbstractProductSupport<F extends GraphicsFamily> {
    private final F family;

    protected AbstractProductSupport(F family) {
        this.family = family;
    }

    public final F family() {
        return family;
    }
}
