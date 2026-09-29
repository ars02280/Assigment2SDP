package org.example.products;

import org.example.model.NvidiaFamily;

public final class NvidiaLatencyReducer extends AbstractProductSupport<NvidiaFamily> implements LatencyReducer<NvidiaFamily> {
    public NvidiaLatencyReducer(NvidiaFamily family) { super(family); }
    public String reduceLatency(int targetFps) { return "Reflex placeholder: target " + targetFps + " FPS"; }
}
