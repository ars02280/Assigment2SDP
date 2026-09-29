package pipeline.products;

/** AMD family: Fluid Motion Frames style interpolation. */
public class AmdFrameGenerator implements FrameGenerator {

    @Override
    public String name() {
        return "AMD Fluid Motion Frames";
    }

    @Override
    public int generatedFramesPerRenderedFrame() {
        return 1;
    }

    @Override
    public double addedLatencyMs() {
        return 8.0;
    }
}
