package org.example.factorymethod;

import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class DlssUpscalingPass implements UpscalingPass {
    @Override
    public String technology() { return "NVIDIA DLSS"; }

    @Override
    public UpscaleReport upscale(Resolution input, QualityMode mode) {
        return new UpscaleReport(technology(), input, input, "DLSS placeholder processed in " + mode + " mode");
    }
}
