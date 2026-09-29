package pipeline.products;

/** AMD family: Anti-Lag. */
public class AntiLag implements LatencyReducer {

    @Override
    public String name() {
        return "AMD Anti-Lag";
    }

    @Override
    public double latencyReductionMs() {
        return 10.0;
    }
}
