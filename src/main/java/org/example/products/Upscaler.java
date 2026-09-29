package org.example.products;

import org.example.model.GraphicsFamily;
import org.example.model.QualityMode;
import org.example.model.Resolution;

public interface Upscaler<F extends GraphicsFamily> {
    String technology();
    F family();
    String upscale(Resolution input, QualityMode mode);
}
