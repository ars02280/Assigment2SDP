package org.example.products;

import org.example.model.AmdFamily;

public final class AmdFrameGenerator extends AbstractProductSupport<AmdFamily> implements FrameGenerator<AmdFamily> {
    public AmdFrameGenerator(AmdFamily family) { super(family); }
    public String generateFrames(int renderedFrames) { return "FSR Frame Generation: " + renderedFrames + " rendered frames"; }
}
