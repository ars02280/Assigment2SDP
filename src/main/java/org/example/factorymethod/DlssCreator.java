package org.example.factorymethod;

public final class DlssCreator extends UpscalingCreator {
    @Override
    protected UpscalingPass createUpscalingPass() { return new DlssUpscalingPass(); }
}
