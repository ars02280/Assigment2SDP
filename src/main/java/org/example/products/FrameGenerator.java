package org.example.products;

import org.example.model.GraphicsFamily;

public interface FrameGenerator<F extends GraphicsFamily> {
    F family();
    String generateFrames(int renderedFrames);
}
