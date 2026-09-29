package org.example.factory;

import org.example.model.GraphicsFamily;
import org.example.products.FrameGenerator;
import org.example.products.LatencyReducer;
import org.example.products.RayRegenerator;
import org.example.products.Upscaler;

public interface GraphicsFactory<F extends GraphicsFamily> {
    Upscaler<F> createUpscaler();
    FrameGenerator<F> createFrameGenerator();
    RayRegenerator<F> createRayRegenerator();
    LatencyReducer<F> createLatencyReducer();
    F family();
}
