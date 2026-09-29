package pipeline.model;

/**
 * Upscaling quality preset. Declared from the highest image quality to the
 * highest performance, and some logic relies on this order
 * (see UpscalingPass.bestModeForTarget).
 */
public enum QualityMode {
    QUALITY,
    BALANCED,
    PERFORMANCE
}
