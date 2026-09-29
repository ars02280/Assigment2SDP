package org.example.products;

import org.example.model.IntelFamily;
import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class XessUpscaler extends AbstractProductSupport<IntelFamily> implements Upscaler<IntelFamily> {
    public XessUpscaler(IntelFamily family) { super(family); }
    public String technology() { return "XeSS"; }
    public String upscale(Resolution input, QualityMode mode) { return technology() + " placeholder: " + input + " -> " + mode; }
}
