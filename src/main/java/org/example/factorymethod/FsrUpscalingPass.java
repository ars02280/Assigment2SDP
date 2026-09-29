package pipeline.factorymethod;

import pipeline.products.FsrUpscaler;
import pipeline.products.Upscaler;

/** Concrete Creator for the AMD family. */
public class FsrUpscalingPass extends UpscalingPass {

    @Override
    protected Upscaler createUpscaler() {
        return new FsrUpscaler();
    }
}
