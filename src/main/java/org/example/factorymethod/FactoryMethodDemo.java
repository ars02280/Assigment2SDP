package pipeline.factorymethod;

import java.util.List;

import pipeline.model.QualityMode;
import pipeline.model.Resolution;

/** Runs the same client code against three different Creators. */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        Resolution uhd = new Resolution(3840, 2160);
        double nativeFrameTimeMs = 25.0; // 40 FPS without upscaling

        // The loop only knows the abstract Creator type.
        List<UpscalingPass> passes = List.of(
                new DlssUpscalingPass(),
                new FsrUpscalingPass(),
                new XessUpscalingPass());

        System.out.println("=== Part B: Factory Method, 4K, native = 40 FPS ===");
        for (UpscalingPass pass : passes) {
            UpscaleReport report = pass.run(uhd, QualityMode.QUALITY, nativeFrameTimeMs);
            System.out.printf("%-12s internal=%s  frame=%.2f ms  fps=%.1f  speedup=x%.2f%n",
                    report.upscalerName(), report.internalResolution(),
                    report.frameTimeMs(), report.fps(), report.speedupVsNative());
        }

        System.out.println();
        System.out.println("=== Best mode that reaches 100 FPS ===");
        for (UpscalingPass pass : passes) {
            String result = pass.bestModeForTarget(uhd, nativeFrameTimeMs, 100.0)
                    .map(Enum::name)
                    .orElse("not reachable");
            System.out.printf("%-30s -> %s%n", pass.getClass().getSimpleName(), result);
        }
    }
}
