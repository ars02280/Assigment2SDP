package org.example.products;

import org.example.model.IntelFamily;

public final class IntelFrameGenerator extends AbstractProductSupport<IntelFamily> implements FrameGenerator<IntelFamily> {
    public IntelFrameGenerator(IntelFamily family) { super(family); }
    public String generateFrames(int renderedFrames) { return "XeSS Frame Generation: " + renderedFrames + " rendered frames"; }
}
