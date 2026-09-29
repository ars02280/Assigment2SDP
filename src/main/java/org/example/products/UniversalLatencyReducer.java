package org.example.products;

import org.example.model.UniversalFamily;

public final class UniversalLatencyReducer extends AbstractProductSupport<UniversalFamily> implements LatencyReducer<UniversalFamily> {
    public UniversalLatencyReducer(UniversalFamily family) { super(family); }
    public String reduceLatency(int targetFps) { return "Generic Latency Reduction placeholder: target " + targetFps + " FPS"; }
}
