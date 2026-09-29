package pipeline.factorymethod;

import java.util.Optional;

import pipeline.model.QualityMode;
import pipeline.model.Resolution;
import pipeline.products.Upscaler;

/**
 * PART B - the Creator of the Factory Method pattern.
 *
 * This class owns the whole upscaling algorithm: it decides the internal
 * resolution, computes the frame time and the speedup, and can search for
 * the best quality mode that still reaches a target FPS. The one thing it
 * does NOT know is WHICH upscaler to use; that decision is delegated to the
 * subclasses through the factory method {@link #createUpscaler()}.
 *
 * Why this is Factory Method and not just a static factory:
 * - the creation step is an overridable method of a class that also contains
 *   real business logic (run, bestModeForTarget) which calls it;
 * - the choice of concrete product is made by SUBCLASSING, not by a
 *   switch/if inside one method;
 * - a new vendor is added by writing a new Creator subclass, with no change
 *   to this class and no change to the algorithm.
 */
public abstract class UpscalingPass {

    /** Factory Method: subclasses decide which concrete Upscaler is created. */
    protected abstract Upscaler createUpscaler();

    /** Runs the pass for one quality mode and reports the outcome. */
    public UpscaleReport run(Resolution target, QualityMode mode, double nativeFrameTimeMs) {
        if (nativeFrameTimeMs <= 0) {
            throw new IllegalArgumentException("nativeFrameTimeMs must be positive");
        }

        Upscaler upscaler = createUpscaler();

        Resolution internal = target.scaled(upscaler.renderScale(mode));
        double pixelRatio = (double) internal.pixels() / target.pixels();
        double frameTimeMs = nativeFrameTimeMs * pixelRatio + upscaler.upscaleCostMs();

        double fps = 1000.0 / frameTimeMs;
        double nativeFps = 1000.0 / nativeFrameTimeMs;

        return new UpscaleReport(
                upscaler.name(), internal, target, frameTimeMs, fps, fps / nativeFps);
    }

    /**
     * Returns the highest-quality mode that still reaches the target FPS,
     * or empty if even PERFORMANCE is too slow. Relies on QualityMode being
     * declared from best quality to best performance.
     */
    public Optional<QualityMode> bestModeForTarget(Resolution target,
                                                   double nativeFrameTimeMs,
                                                   double targetFps) {
        for (QualityMode mode : QualityMode.values()) {
            if (run(target, mode, nativeFrameTimeMs).fps() >= targetFps) {
                return Optional.of(mode);
            }
        }
        return Optional.empty();
    }
}
