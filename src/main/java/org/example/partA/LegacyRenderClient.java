package pipeline.partA;

import pipeline.model.QualityMode;
import pipeline.model.Resolution;
import pipeline.products.AmdFrameGenerator;
import pipeline.products.AntiLag;
import pipeline.products.DlssUpscaler;
import pipeline.products.FrameGenerator;
import pipeline.products.FsrUpscaler;
import pipeline.products.IntelFrameGenerator;
import pipeline.products.LatencyReducer;
import pipeline.products.NvidiaFrameGenerator;
import pipeline.products.Reflex;
import pipeline.products.Upscaler;
import pipeline.products.XeLL;
import pipeline.products.XessUpscaler;

/**
 * PART A - the system WITHOUT Factory Method or Abstract Factory.
 *
 * The client creates every product itself with new + if/else on a platform
 * string. This class is kept in the repository on purpose: it is the
 * "before" picture used in docs/PART_A_PROBLEMS.md.
 *
 * Concrete problems (each one is demonstrated by LegacyRenderClientTest):
 *
 * 1. The client depends on 9 concrete classes (see the imports above).
 * 2. The same platform if/else chain is repeated three times
 *    (createUpscaler, createFrameGenerator, createLatencyReducer), so adding
 *    a fourth platform means editing this existing class in three places.
 * 3. Nothing ties the three products together: each method receives its own
 *    platform string, so an NVIDIA upscaler can silently be combined with an
 *    AMD frame generator and an Intel latency reducer.
 * 4. The platform is a plain String, so a typo such as "nvdia" compiles fine
 *    and only fails at runtime.
 */
public class LegacyRenderClient {

    // ---- creation logic, chain #1 ----
    public Upscaler createUpscaler(String platform) {
        if (platform.equals("nvidia")) {
            return new DlssUpscaler();
        } else if (platform.equals("amd")) {
            return new FsrUpscaler();
        } else if (platform.equals("intel")) {
            return new XessUpscaler();
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }

    // ---- creation logic, chain #2 (same strings again) ----
    public FrameGenerator createFrameGenerator(String platform) {
        if (platform.equals("nvidia")) {
            return new NvidiaFrameGenerator();
        } else if (platform.equals("amd")) {
            return new AmdFrameGenerator();
        } else if (platform.equals("intel")) {
            return new IntelFrameGenerator();
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }

    // ---- creation logic, chain #3 (same strings again) ----
    public LatencyReducer createLatencyReducer(String platform) {
        if (platform.equals("nvidia")) {
            return new Reflex();
        } else if (platform.equals("amd")) {
            return new AntiLag();
        } else if (platform.equals("intel")) {
            return new XeLL();
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }

    // ---- business logic 1: upscaled frames per second ----
    public double estimateFps(String platform, Resolution target,
                              QualityMode mode, double nativeFrameTimeMs) {
        Upscaler upscaler = createUpscaler(platform);
        return 1000.0 / frameTimeMs(upscaler, target, mode, nativeFrameTimeMs);
    }

    // ---- business logic 2: input latency of the whole stack ----
    // Three independent platform strings: nothing forces them to match.
    public double estimateInputLatencyMs(String upscalerPlatform,
                                         String frameGenPlatform,
                                         String latencyPlatform,
                                         Resolution target,
                                         QualityMode mode,
                                         double nativeFrameTimeMs) {
        Upscaler upscaler = createUpscaler(upscalerPlatform);
        FrameGenerator frameGenerator = createFrameGenerator(frameGenPlatform);
        LatencyReducer latencyReducer = createLatencyReducer(latencyPlatform);

        double latency = frameTimeMs(upscaler, target, mode, nativeFrameTimeMs)
                + frameGenerator.addedLatencyMs()
                - latencyReducer.latencyReductionMs();
        return Math.max(1.0, latency);
    }

    // The rendering algorithm lives in the client, mixed with creation code.
    private double frameTimeMs(Upscaler upscaler, Resolution target,
                               QualityMode mode, double nativeFrameTimeMs) {
        if (nativeFrameTimeMs <= 0) {
            throw new IllegalArgumentException("nativeFrameTimeMs must be positive");
        }
        Resolution internal = target.scaled(upscaler.renderScale(mode));
        double pixelRatio = (double) internal.pixels() / target.pixels();
        return nativeFrameTimeMs * pixelRatio + upscaler.upscaleCostMs();
    }
}
