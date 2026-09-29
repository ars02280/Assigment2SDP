package org.example.factorymethod;

public final class FsrCreator extends UpscalingCreator {
    @Override
    protected UpscalingPass createUpscalingPass() { return new FsrUpscalingPass(); }
}
