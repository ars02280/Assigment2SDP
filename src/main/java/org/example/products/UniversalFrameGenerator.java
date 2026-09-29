package org.example.products;

import org.example.model.UniversalFamily;

public final class UniversalFrameGenerator extends AbstractProductSupport<UniversalFamily> implements FrameGenerator<UniversalFamily> {
    public UniversalFrameGenerator(UniversalFamily family) { super(family); }
    public String generateFrames(int renderedFrames) { return "Generic Frame Generation placeholder: " + renderedFrames + " rendered frames"; }
}
