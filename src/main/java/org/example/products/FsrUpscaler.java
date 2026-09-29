package org.example.products;

import org.example.model.AmdFamily;
import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class FsrUpscaler extends AbstractProductSupport<AmdFamily> implements Upscaler<AmdFamily> {
    public FsrUpscaler(AmdFamily family) { super(family); }
    public String technology() { return "FSR"; }
    public String upscale(Resolution input, QualityMode mode) { return technology() + " placeholder: " + input + " -> " + mode; }
}
