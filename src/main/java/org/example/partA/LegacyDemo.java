package pipeline.partA;

import pipeline.model.QualityMode;
import pipeline.model.Resolution;

/** Runs the Part A client and shows the "mixed families" flaw. */
public class LegacyDemo {

    public static void main(String[] args) {
        LegacyRenderClient client = new LegacyRenderClient();
        Resolution uhd = new Resolution(3840, 2160);

        System.out.println("=== Part A: consistent stack (nvidia everywhere) ===");
        System.out.printf("Input latency: %.2f ms%n",
                client.estimateInputLatencyMs("nvidia", "nvidia", "nvidia",
                        uhd, QualityMode.QUALITY, 25.0));

        System.out.println();
        System.out.println("=== Part A: accidentally mixed stack (nvidia + amd + intel) ===");
        System.out.printf("Input latency: %.2f ms  <-- accepted without any error%n",
                client.estimateInputLatencyMs("nvidia", "amd", "intel",
                        uhd, QualityMode.QUALITY, 25.0));

        System.out.println();
        System.out.println("=== Part A: typo in platform name ===");
        try {
            client.estimateFps("nvdia", uhd, QualityMode.QUALITY, 25.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Fails only at runtime: " + e.getMessage());
        }
    }
}
