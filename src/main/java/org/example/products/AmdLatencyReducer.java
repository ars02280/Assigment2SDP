package org.example.products;

import org.example.model.AmdFamily;

public final class AmdLatencyReducer extends AbstractProductSupport<AmdFamily> implements LatencyReducer<AmdFamily> {
    public AmdLatencyReducer(AmdFamily family) { super(family); }
    public String reduceLatency(int targetFps) { return "Anti-Lag 2 placeholder: target " + targetFps + " FPS"; }
}
