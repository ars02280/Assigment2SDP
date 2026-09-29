package org.example.client;

import org.example.factory.FactorySelector;
import org.example.factory.GraphicsFactory;
import org.example.model.GraphicsFamily;
import org.example.model.QualityMode;
import org.example.model.Resolution;
import org.example.service.RenderPipeline;

public final class Client {
    private Client() {}

    public static String run(String[] args, String environmentValue) {
        GraphicsFactory<?> factory = FactorySelector.fromExternalCondition(args, environmentValue);
        return runWithFactory(factory);
    }

    private static <F extends GraphicsFamily> String runWithFactory(GraphicsFactory<F> factory) {
        RenderPipeline<F> pipeline = new RenderPipeline<>(
                factory.createUpscaler(),
                factory.createFrameGenerator(),
                factory.createRayRegenerator(),
                factory.createLatencyReducer()
        );
        Resolution resolution = new Resolution(1920, 1080);
        return factory.family().name() + "\n" +
                pipeline.renderGameFrame(resolution, QualityMode.QUALITY) + "\n" +
                pipeline.optimizeCompetitiveMode(120) + "\n" +
                pipeline.prepareRayTracingMode(resolution);
    }
}
