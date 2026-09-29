package pipeline.factorymethod;

import pipeline.model.Resolution;

/**
 * Result of one upscaling pass.
 *
 * @param upscalerName     name of the technology that produced the result
 * @param internalResolution resolution the game actually rendered at
 * @param outputResolution   resolution shown on screen
 * @param frameTimeMs      total GPU time per frame (render + upscale)
 * @param fps              resulting frames per second
 * @param speedupVsNative  fps divided by the fps of native rendering
 */
public record UpscaleReport(
        String upscalerName,
        Resolution internalResolution,
        Resolution outputResolution,
        double frameTimeMs,
        double fps,
        double speedupVsNative) {
}
