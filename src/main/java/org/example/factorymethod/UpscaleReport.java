package org.example.factorymethod;

import org.example.model.Resolution;

public record UpscaleReport(String technology, Resolution input, Resolution output, String status) {}
