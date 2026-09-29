package org.example.factory;

import org.example.model.UniversalFamily;
import org.example.products.*;

public final class UniversalFactory implements GraphicsFactory<UniversalFamily> {
    private final UniversalFamily family = new UniversalFamily();
    public Upscaler<UniversalFamily> createUpscaler() { return new UniversalUpscaler(family); }
    public FrameGenerator<UniversalFamily> createFrameGenerator() { return new UniversalFrameGenerator(family); }
    public RayRegenerator<UniversalFamily> createRayRegenerator() { return new UniversalRayRegenerator(family); }
    public LatencyReducer<UniversalFamily> createLatencyReducer() { return new UniversalLatencyReducer(family); }
    public UniversalFamily family() { return family; }
}
