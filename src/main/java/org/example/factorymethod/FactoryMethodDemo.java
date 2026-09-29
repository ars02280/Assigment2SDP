package org.example.factorymethod;

import org.example.model.QualityMode;
import org.example.model.Resolution;

public final class FactoryMethodDemo {
    private FactoryMethodDemo() {}

    public static void run() {
        Resolution resolution = new Resolution(1920, 1080);
        System.out.println(new FsrCreator().processFrame(resolution, QualityMode.QUALITY));
        System.out.println(new DlssCreator().processFrame(resolution, QualityMode.BALANCED));
        System.out.println(new XessCreator().processFrame(resolution, QualityMode.PERFORMANCE));
    }
}
