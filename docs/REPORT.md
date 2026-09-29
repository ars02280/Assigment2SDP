# Assignment 2 — FSR / DLSS / XeSS Rendering Technology Family

## Domain

The application models a graphics rendering pipeline. It uses placeholder objects for technologies such as AMD FSR, NVIDIA DLSS, Intel XeSS, frame generation, ray regeneration/reconstruction and latency reduction.

No real GPU algorithm is implemented. The products only return descriptive results so the design patterns can be demonstrated safely and clearly.

## Product types

1. Upscaler
2. Frame Generator
3. Ray Regenerator
4. Latency Reducer

## Product families

1. AMD — FSR + AMD Frame Generation + AMD ray regeneration placeholder + Anti-Lag placeholder
2. NVIDIA — DLSS + NVIDIA Frame Generation + Ray Reconstruction placeholder + Reflex placeholder
3. Intel — XeSS + Intel Frame Generation + XeSS ray reconstruction placeholder + XeLL placeholder
4. Universal — generic placeholders for all four product types

The fourth family was added as the extension required by Part G.

## Part A problems

The legacy implementation directly creates concrete classes. This creates three main problems:

- the client knows concrete product classes;
- family selection requires a large conditional chain;
- products from different families can be created independently, so consistency is not represented by the type system.

The legacy implementation is preserved in `src/main/java/org/example/partA` and appears as the first stage of the Git history.

## Factory Method

`UpscalingCreator` is the Creator. Its `createUpscalingPass()` method is the Factory Method. `FsrCreator`, `DlssCreator` and `XessCreator` override it.

The creator also contains business logic in `processFrame()`: it creates a pass, sends a frame through the pass and enriches the resulting report. Therefore the method is not only a `return new ...` wrapper.

## Abstract Factory

`GraphicsFactory<F>` creates four related products:

- `Upscaler<F>`
- `FrameGenerator<F>`
- `RayRegenerator<F>`
- `LatencyReducer<F>`

There are four concrete factories: AMD, NVIDIA, Intel and Universal.

## Compatibility rule

The family type is part of every product interface. For example, an AMD pipeline is `RenderPipeline<AmdFamily>` and accepts only products parameterized with `AmdFamily`.

This makes a mixed pipeline such as AMD upscaler + NVIDIA frame generator difficult to express in normal Java code. Compatibility is represented by generic types instead of a runtime `if`/exception check.

## Runtime selection

The family is selected by an external condition:

```text
--family=amd
--family=nvidia
--family=intel
--family=universal
```

If the command-line argument is absent, `GPU_FAMILY` can be used. If both are absent, AMD is used as the default.

`Client` receives the selected factory through the abstraction and does not instantiate concrete family factories itself.

## Business operations

`RenderPipeline` contains three multi-product operations:

- `renderGameFrame()` combines upscaling, ray processing and frame generation;
- `optimizeCompetitiveMode()` combines latency reduction and frame generation;
- `prepareRayTracingMode()` combines ray processing and upscaling.

## Fourth family

The fourth family is `Universal`. Existing business logic does not contain a special Universal branch. Adding it requires the new family marker, its four products and `UniversalFactory`, plus the runtime selector entry.

## Tests

`Assignment2Test` contains 20 tests covering:

- original family creation;
- concrete product creation;
- family compatibility;
- runtime selection;
- three business scenarios;
- negative scenarios;
- fourth-family support;
- Factory Method behavior;
- abstraction-based client execution.

## UML

The PlantUML class diagram is in `docs/UML.puml`.

## Important scope

FSR, DLSS, XeSS, Frame Generation and ray regeneration/reconstruction are placeholders. There is no actual upscaling, AI inference, frame interpolation or ray reconstruction implementation. The assignment is about Factory Method and Abstract Factory architecture.
