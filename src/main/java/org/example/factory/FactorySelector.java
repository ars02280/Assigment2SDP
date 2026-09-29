package org.example.factory;

import java.util.Locale;

public final class FactorySelector {
    private FactorySelector() {}

    public static GraphicsFactory<?> fromExternalCondition(String[] args, String environmentValue) {
        String family = readArgument(args);
        if (family == null || family.isBlank()) {
            family = environmentValue;
        }
        if (family == null || family.isBlank()) {
            family = "amd";
        }
        return switch (family.toLowerCase(Locale.ROOT)) {
            case "amd" -> new AmdFactory();
            case "nvidia" -> new NvidiaFactory();
            case "intel" -> new IntelFactory();
            case "universal" -> new UniversalFactory();
            default -> throw new IllegalArgumentException("Unknown family: " + family);
        };
    }

    private static String readArgument(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--family=")) {
                return arg.substring("--family=".length());
            }
        }
        return null;
    }
}
