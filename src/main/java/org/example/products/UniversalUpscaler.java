package org.example.products;

import org.example.model.QualityMode;
import org.example.model.Resolution;
import org.example.model.UniversalFamily;

public final class UniversalUpscaler extends AbstractProductSupport<UniversalFamily> implements Upscaler<UniversalFamily> {
    public UniversalUpscaler(UniversalFamily family) { super(family); }
    public String technology() { return "Generic Temporal Upscaler"; }
    public String upscale(Resolution input, QualityMode mode) { return technology() + " placeholder: " + input + " -> " + mode; }
}
