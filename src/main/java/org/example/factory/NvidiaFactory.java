package org.example.factory;

import org.example.model.NvidiaFamily;
import org.example.products.*;

public final class NvidiaFactory implements GraphicsFactory<NvidiaFamily> {
    private final NvidiaFamily family = new NvidiaFamily();
    public Upscaler<NvidiaFamily> createUpscaler() { return new DlssUpscaler(family); }
    public FrameGenerator<NvidiaFamily> createFrameGenerator() { return new NvidiaFrameGenerator(family); }
    public RayRegenerator<NvidiaFamily> createRayRegenerator() { return new NvidiaRayRegenerator(family); }
    public LatencyReducer<NvidiaFamily> createLatencyReducer() { return new NvidiaLatencyReducer(family); }
    public NvidiaFamily family() { return family; }
}
