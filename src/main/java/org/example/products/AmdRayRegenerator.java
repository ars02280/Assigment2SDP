package org.example.products;

import org.example.model.AmdFamily;

public final class AmdRayRegenerator extends AbstractProductSupport<AmdFamily> implements RayRegenerator<AmdFamily> {
    public AmdRayRegenerator(AmdFamily family) { super(family); }
    public String regenerate(String rayTracingInput) { return "FSR Ray Regeneration placeholder: " + rayTracingInput; }
}
