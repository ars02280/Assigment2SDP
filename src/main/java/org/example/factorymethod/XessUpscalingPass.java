package org.example.factorymethod;

import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class XessUpscalingPass implements UpscalingPass {
    @Override
    public String technology() { return "Intel XeSS"; }

    @Override
    public UpscaleReport upscale(Resolution input, QualityMode mode) {
        return new UpscaleReport(technology(), input, input, "XeSS placeholder processed in " + mode + " mode");
    }
}
