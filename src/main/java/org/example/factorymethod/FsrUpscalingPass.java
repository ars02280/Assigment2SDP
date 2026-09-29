package org.example.factorymethod;

import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class FsrUpscalingPass implements UpscalingPass {
    @Override
    public String technology() { return "AMD FSR"; }

    @Override
    public UpscaleReport upscale(Resolution input, QualityMode mode) {
        return new UpscaleReport(technology(), input, input, "FSR placeholder processed in " + mode + " mode");
    }
}
