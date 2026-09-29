package org.example.products;

import org.example.model.NvidiaFamily;

public final class NvidiaRayRegenerator extends AbstractProductSupport<NvidiaFamily> implements RayRegenerator<NvidiaFamily> {
    public NvidiaRayRegenerator(NvidiaFamily family) { super(family); }
    public String regenerate(String rayTracingInput) { return "Ray Reconstruction placeholder: " + rayTracingInput; }
}
