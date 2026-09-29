package org.example.products;

import org.example.model.NvidiaFamily;
import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class DlssUpscaler extends AbstractProductSupport<NvidiaFamily> implements Upscaler<NvidiaFamily> {
    public DlssUpscaler(NvidiaFamily family) { super(family); }
    public String technology() { return "DLSS"; }
    public String upscale(Resolution input, QualityMode mode) { return technology() + " placeholder: " + input + " -> " + mode; }
}
