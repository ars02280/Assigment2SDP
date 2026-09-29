package org.example.model;

public record Resolution(int width, int height) {
    public Resolution {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Resolution must be positive");
        }
    }

    @Override
    public String toString() {
        return width + "x" + height;
    }
}
