package org.example.factorymethod;

public final class XessCreator extends UpscalingCreator {
    @Override
    protected UpscalingPass createUpscalingPass() { return new XessUpscalingPass(); }
}
