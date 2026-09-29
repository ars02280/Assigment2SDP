package pipeline.products;

/**
 * Product type 2: inserts extra generated frames between rendered ones.
 * Raises the displayed FPS but adds input latency.
 */
public interface FrameGenerator {

    String name();

    /** How many extra frames are generated per one rendered frame. */
    int generatedFramesPerRenderedFrame();

    /** Input latency added by holding frames back for interpolation, in ms. */
    double addedLatencyMs();
}
