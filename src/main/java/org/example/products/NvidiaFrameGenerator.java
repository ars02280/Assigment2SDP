package pipeline.products;

/** NVIDIA family: (multi) frame generation. */
public class NvidiaFrameGenerator implements FrameGenerator {

    @Override
    public String name() {
        return "NVIDIA Frame Generation";
    }

    @Override
    public int generatedFramesPerRenderedFrame() {
        return 3;
    }

    @Override
    public double addedLatencyMs() {
        return 6.0;
    }
}
