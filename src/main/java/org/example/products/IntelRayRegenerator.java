package org.example.products;

import org.example.model.IntelFamily;

public final class IntelRayRegenerator extends AbstractProductSupport<IntelFamily> implements RayRegenerator<IntelFamily> {
    public IntelRayRegenerator(IntelFamily family) { super(family); }
    public String regenerate(String rayTracingInput) { return "XeSS Ray Reconstruction placeholder: " + rayTracingInput; }
}
