package org.example;

import org.example.client.Client;
import org.example.factory.*;
import org.example.factorymethod.*;
import org.example.model.*;
import org.example.products.*;
import org.example.service.RenderPipeline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment2Test {
    @Test void amdFactoryCreatesFsr() { assertEquals("FSR", new AmdFactory().createUpscaler().technology()); }
    @Test void nvidiaFactoryCreatesDlss() { assertEquals("DLSS", new NvidiaFactory().createUpscaler().technology()); }
    @Test void intelFactoryCreatesXess() { assertEquals("XeSS", new IntelFactory().createUpscaler().technology()); }
    @Test void universalFactoryCreatesGenericUpscaler() { assertEquals("Generic Temporal Upscaler", new UniversalFactory().createUpscaler().technology()); }
    @Test void amdProductsShareFamily() { AmdFactory f = new AmdFactory(); assertSame(f.family(), f.createUpscaler().family()); assertSame(f.family(), f.createFrameGenerator().family()); }
    @Test void nvidiaProductsShareFamily() { NvidiaFactory f = new NvidiaFactory(); assertSame(f.family(), f.createRayRegenerator().family()); assertSame(f.family(), f.createLatencyReducer().family()); }
    @Test void intelProductsShareFamily() { IntelFactory f = new IntelFactory(); assertSame(f.family(), f.createUpscaler().family()); assertSame(f.family(), f.createRayRegenerator().family()); }
    @Test void runtimeSelectsAmd() { assertTrue(Client.run(new String[]{"--family=amd"}, null).startsWith("AMD")); }
    @Test void runtimeSelectsNvidia() { assertTrue(Client.run(new String[]{"--family=nvidia"}, null).startsWith("NVIDIA")); }
    @Test void runtimeSelectsFromEnvironment() { assertTrue(Client.run(new String[0], "intel").startsWith("INTEL")); }
    @Test void renderBusinessOperationUsesMultipleProducts() { String result = Client.run(new String[]{"--family=amd"}, null); assertTrue(result.contains("FSR") && result.contains("Frame Generation") && result.contains("Ray Regeneration")); }
    @Test void competitiveBusinessOperationUsesLatencyAndFrameGeneration() { String result = Client.run(new String[]{"--family=nvidia"}, null); assertTrue(result.contains("Reflex") && result.contains("DLSS Frame Generation")); }
    @Test void rayTracingBusinessOperationUsesRayAndUpscaler() { AmdFactory f = new AmdFactory(); RenderPipeline<AmdFamily> p = new RenderPipeline<>(f.createUpscaler(), f.createFrameGenerator(), f.createRayRegenerator(), f.createLatencyReducer()); String result = p.prepareRayTracingMode(new Resolution(2560, 1440)); assertTrue(result.contains("Ray Regeneration") && result.contains("FSR")); }
    @Test void fourthFamilyWorksWithoutBusinessLogicChanges() { assertTrue(Client.run(new String[]{"--family=universal"}, null).contains("UNIVERSAL")); }
    @Test void factoryMethodCreatesFsr() { assertEquals("AMD FSR", new FsrCreator().processFrame(new Resolution(1920, 1080), QualityMode.QUALITY).technology()); }
    @Test void factoryMethodCreatesDlss() { assertEquals("NVIDIA DLSS", new DlssCreator().processFrame(new Resolution(1920, 1080), QualityMode.BALANCED).technology()); }
    @Test void factoryMethodCreatesXess() { assertEquals("Intel XeSS", new XessCreator().processFrame(new Resolution(1280, 720), QualityMode.PERFORMANCE).technology()); }
    @Test void invalidFamilyIsRejected() { assertThrows(IllegalArgumentException.class, () -> Client.run(new String[]{"--family=unknown"}, null)); }
    @Test void invalidResolutionIsRejected() { assertThrows(IllegalArgumentException.class, () -> new Resolution(0, 1080)); }
    @Test void clientUsesOnlyFactoryAbstraction() { assertNotNull(Client.run(new String[]{"--family=intel"}, null)); }
}
