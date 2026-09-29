package pipeline.factorymethod;

import pipeline.products.DlssUpscaler;
import pipeline.products.Upscaler;

/** Concrete Creator for the NVIDIA family. */
public class DlssUpscalingPass extends UpscalingPass {

    @Override
    protected Upscaler createUpscaler() {
        return new DlssUpscaler();
    }
}
