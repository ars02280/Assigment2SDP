package pipeline.factorymethod;

import pipeline.products.Upscaler;
import pipeline.products.XessUpscaler;

/** Concrete Creator for the Intel family. */
public class XessUpscalingPass extends UpscalingPass {

    @Override
    protected Upscaler createUpscaler() {
        return new XessUpscaler();
    }
}
