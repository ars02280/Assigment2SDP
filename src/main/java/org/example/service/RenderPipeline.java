package org.example.service;

import org.example.model.GraphicsFamily;
import org.example.model.QualityMode;
import org.example.model.Resolution;
import org.example.products.FrameGenerator;
import org.example.products.LatencyReducer;
import org.example.products.RayRegenerator;
import org.example.products.Upscaler;

public final class RenderPipeline<F extends GraphicsFamily> {
    private final Upscaler<F> upscaler;
    private final FrameGenerator<F> frameGenerator;
    private final RayRegenerator<F> rayRegenerator;
    private final LatencyReducer<F> latencyReducer;

    public RenderPipeline(Upscaler<F> upscaler, FrameGenerator<F> frameGenerator, RayRegenerator<F> rayRegenerator, LatencyReducer<F> latencyReducer) {
        this.upscaler = upscaler;
        this.frameGenerator = frameGenerator;
        this.rayRegenerator = rayRegenerator;
        this.latencyReducer = latencyReducer;
    }

    public String renderGameFrame(Resolution input, QualityMode mode) {
        String upscale = upscaler.upscale(input, mode);
        String rays = rayRegenerator.regenerate("ray-data");
        String frames = frameGenerator.generateFrames(60);
        return upscale + " | " + rays + " | " + frames;
    }

    public String optimizeCompetitiveMode(int targetFps) {
        String latency = latencyReducer.reduceLatency(targetFps);
        String frames = frameGenerator.generateFrames(targetFps);
        return latency + " | " + frames;
    }

    public String prepareRayTracingMode(Resolution input) {
        String rays = rayRegenerator.regenerate(input.toString());
        String upscale = upscaler.upscale(input, QualityMode.QUALITY);
        return rays + " | " + upscale;
    }
}
