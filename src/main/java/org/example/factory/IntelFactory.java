package org.example.factory;

import org.example.model.IntelFamily;
import org.example.products.*;

public final class IntelFactory implements GraphicsFactory<IntelFamily> {
    private final IntelFamily family = new IntelFamily();
    public Upscaler<IntelFamily> createUpscaler() { return new XessUpscaler(family); }
    public FrameGenerator<IntelFamily> createFrameGenerator() { return new IntelFrameGenerator(family); }
    public RayRegenerator<IntelFamily> createRayRegenerator() { return new IntelRayRegenerator(family); }
    public LatencyReducer<IntelFamily> createLatencyReducer() { return new IntelLatencyReducer(family); }
    public IntelFamily family() { return family; }
}
