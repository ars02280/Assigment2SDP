package org.example.products;

import org.example.model.GraphicsFamily;

public interface RayRegenerator<F extends GraphicsFamily> {
    F family();
    String regenerate(String rayTracingInput);
}
