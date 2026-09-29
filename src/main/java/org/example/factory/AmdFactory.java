package org.example.factory;

import org.example.model.AmdFamily;
import org.example.products.*;

public final class AmdFactory implements GraphicsFactory<AmdFamily> {
    private final AmdFamily family = new AmdFamily();
    public Upscaler<AmdFamily> createUpscaler() { return new FsrUpscaler(family); }
    public FrameGenerator<AmdFamily> createFrameGenerator() { return new AmdFrameGenerator(family); }
    public RayRegenerator<AmdFamily> createRayRegenerator() { return new AmdRayRegenerator(family); }
    public LatencyReducer<AmdFamily> createLatencyReducer() { return new AmdLatencyReducer(family); }
    public AmdFamily family() { return family; }
}
