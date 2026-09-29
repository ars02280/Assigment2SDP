# Assignment 2 — Graphics Technologies Factory System

Java 17 project for Assignment 2. The domain is graphics rendering technologies: FSR, DLSS, XeSS, frame generation, ray regeneration/reconstruction and latency reduction.

The technologies are intentionally placeholders. No real GPU algorithm is implemented.

## Run

With Maven:

```bash
mvn test
mvn package
java -cp target/classes org.example.Main --family=nvidia
```

Supported families:

```text
--family=amd
--family=nvidia
--family=intel
--family=universal
```

The family can also be supplied through `GPU_FAMILY`.

## IntelliJ IDEA

Open the project directory and import it as a Maven project. Use JDK 17 or newer.

Run `org.example.Main` and add `--family=nvidia` to Program arguments if needed.

## Structure

- `factorymethod` — Factory Method
- `factory` — Abstract Factory and runtime selection
- `products` — family-compatible products
- `service` — business operations
- `client` — client working through abstractions
- `partA` — legacy direct-creation version
- `docs/UML.puml` — UML diagram
- `docs/REPORT.md` — assignment explanation
- `src/test` — 20 automated tests
