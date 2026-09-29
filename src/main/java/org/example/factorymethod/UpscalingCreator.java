package org.example.factorymethod;

import org.example.model.QualityMode;
import org.example.model.Resolution;

public abstract class UpscalingCreator {
    protected abstract UpscalingPass createUpscalingPass();

    public UpscaleReport processFrame(Resolution input, QualityMode mode) {
        UpscalingPass pass = createUpscalingPass();
        UpscaleReport report = pass.upscale(input, mode);
        return new UpscaleReport(report.technology(), report.input(), report.output(), report.status() + "; frame accepted by creator");
    }
}
