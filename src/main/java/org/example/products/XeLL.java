package pipeline.products;

/** Intel family: XeSS Low Latency (XeLL). */
public class XeLL implements LatencyReducer {

    @Override
    public String name() {
        return "Intel XeLL";
    }

    @Override
    public double latencyReductionMs() {
        return 9.0;
    }
}
