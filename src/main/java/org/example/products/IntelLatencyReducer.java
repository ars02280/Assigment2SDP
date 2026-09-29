package org.example.products;

import org.example.model.IntelFamily;

public final class IntelLatencyReducer extends AbstractProductSupport<IntelFamily> implements LatencyReducer<IntelFamily> {
    public IntelLatencyReducer(IntelFamily family) { super(family); }
    public String reduceLatency(int targetFps) { return "XeLL placeholder: target " + targetFps + " FPS"; }
}
