package pipeline.products;

import pipeline.model.QualityMode;

/** AMD family: FidelityFX Super Resolution. */
public class FsrUpscaler implements Upscaler {

    @Override
    public String name() {
        return "AMD FSR";
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
        return 0.6;
    }
}
