package pipeline.products;

import pipeline.model.QualityMode;

/** NVIDIA family: DLSS super resolution. */
public class DlssUpscaler implements Upscaler {

    @Override
    public String name() {
        return "NVIDIA DLSS";
    }

    @Override
    public double renderScale(QualityMode mode) {
        return switch (mode) {
            case QUALITY -> 0.667;
            case BALANCED -> 0.58;
            case PERFORMANCE -> 0.50;
        };
    }

    @Override
    public double upscaleCostMs() {
        return 0.8;
    }
}
