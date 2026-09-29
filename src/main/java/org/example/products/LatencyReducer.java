package org.example.products;

import org.example.model.GraphicsFamily;

public interface LatencyReducer<F extends GraphicsFamily> {
    F family();
    String reduceLatency(int targetFps);
}
