package pipeline.products;

import pipeline.model.QualityMode;

/**
 * Product type 1: turns a low internal resolution into the output
 * resolution. Every vendor implements it differently (scale factors and
 * per-frame cost are vendor specific; the numbers are illustrative).
 */
public interface Upscaler {

    String name();

    /** Linear per-axis render scale for the given quality mode (0 < scale <= 1). */
    double renderScale(QualityMode mode);

    /** Fixed GPU cost of the upscaling pass itself, in milliseconds. */
    double upscaleCostMs();
}
