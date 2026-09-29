package org.example.partA;

import org.example.products.AmdFrameGenerator;
import org.example.products.AmdRayRegenerator;
import org.example.products.AmdLatencyReducer;
import org.example.products.DlssUpscaler;
import org.example.products.FsrUpscaler;
import org.example.products.IntelFrameGenerator;
import org.example.products.IntelRayRegenerator;
import org.example.products.IntelLatencyReducer;
import org.example.products.NvidiaFrameGenerator;
import org.example.products.NvidiaRayRegenerator;
import org.example.products.NvidiaLatencyReducer;
import org.example.products.XessUpscaler;
import org.example.products.Upscaler;
import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class LegacyRenderClient {
    public String render(String family) {
        Upscaler<?> upscaler;
        if (family.equalsIgnoreCase("amd")) {
            upscaler = new FsrUpscaler(new org.example.model.AmdFamily());
            new AmdFrameGenerator(new org.example.model.AmdFamily());
            new AmdRayRegenerator(new org.example.model.AmdFamily());
            new AmdLatencyReducer(new org.example.model.AmdFamily());
        } else if (family.equalsIgnoreCase("nvidia")) {
            upscaler = new DlssUpscaler(new org.example.model.NvidiaFamily());
            new NvidiaFrameGenerator(new org.example.model.NvidiaFamily());
            new NvidiaRayRegenerator(new org.example.model.NvidiaFamily());
            new NvidiaLatencyReducer(new org.example.model.NvidiaFamily());
        } else if (family.equalsIgnoreCase("intel")) {
            upscaler = new XessUpscaler(new org.example.model.IntelFamily());
            new IntelFrameGenerator(new org.example.model.IntelFamily());
            new IntelRayRegenerator(new org.example.model.IntelFamily());
            new IntelLatencyReducer(new org.example.model.IntelFamily());
        } else {
            throw new IllegalArgumentException("Unknown family");
        }
        return upscaler.upscale(new Resolution(1920, 1080), QualityMode.QUALITY);
    }
}
