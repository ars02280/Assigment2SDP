package pipeline.products;

/**
 * Product type 3: shortens the CPU-to-display pipeline to cut input lag.
 * Frame generation is usually only acceptable together with one of these.
 */
public interface LatencyReducer {

    String name();

    /** How much input latency this technology removes, in milliseconds. */
    double latencyReductionMs();
}
