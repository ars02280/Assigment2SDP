package pipeline.products;

import pipeline.model.QualityMode;

/** Intel family: XeSS super sampling. */
public class XessUpscaler implements Upscaler {

    @Override
    public String name() {
        return "Intel XeSS";
    }

    @Override
    public double renderScale(QualityMode mode) {
        return switch (mode) {
            case QUALITY -> 0.667;
            case BALANCED -> 0.59;
            case PERFORMANCE -> 0.50;
        };
    }

    @Override
    public double upscaleCostMs() {
        return 1.0;
    }
}
