package pipeline.products;

/** NVIDIA family: Reflex. */
public class Reflex implements LatencyReducer {

    @Override
    public String name() {
        return "NVIDIA Reflex";
    }

    @Override
    public double latencyReductionMs() {
        return 12.0;
    }
}
