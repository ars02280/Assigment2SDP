package pipeline.model;

/**
 * Immutable pixel resolution. Used both as the output (target) resolution
 * and as the smaller internal resolution the game actually renders at
 * before an upscaler stretches it.
 */
public record Resolution(int width, int height) {

    public Resolution {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Resolution must be positive: " + width + "x" + height);
        }
    }

    public long pixels() {
        return (long) width * height;
    }

    /** Returns a new resolution scaled by the given linear factor (per axis). */
    public Resolution scaled(double factor) {
        return new Resolution(
                Math.max(1, (int) Math.round(width * factor)),
                Math.max(1, (int) Math.round(height * factor)));
    }

    @Override
    public String toString() {
        return width + "x" + height;
    }
}
