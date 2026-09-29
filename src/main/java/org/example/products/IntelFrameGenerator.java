package pipeline.products;

/** Intel family: XeSS frame generation. */
public class IntelFrameGenerator implements FrameGenerator {

    @Override
    public String name() {
        return "Intel XeSS Frame Generation";
    }

    @Override
    public int generatedFramesPerRenderedFrame() {
        return 1;
    }

    @Override
    public double addedLatencyMs() {
        return 7.0;
    }
}
