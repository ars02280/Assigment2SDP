package org.example.products;

import org.example.model.NvidiaFamily;

public final class NvidiaFrameGenerator extends AbstractProductSupport<NvidiaFamily> implements FrameGenerator<NvidiaFamily> {
    public NvidiaFrameGenerator(NvidiaFamily family) { super(family); }
    public String generateFrames(int renderedFrames) { return "DLSS Frame Generation: " + renderedFrames + " rendered frames"; }
}
