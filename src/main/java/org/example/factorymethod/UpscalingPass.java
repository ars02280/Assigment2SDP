package org.example.factorymethod;

import org.example.model.QualityMode;
import org.example.model.Resolution;

public interface UpscalingPass {
    String technology();
    UpscaleReport upscale(Resolution input, QualityMode mode);
}
