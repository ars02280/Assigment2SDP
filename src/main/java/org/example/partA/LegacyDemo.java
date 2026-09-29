package org.example.partA;

public final class LegacyDemo {
    private LegacyDemo() {}

    public static void main(String[] args) {
        System.out.println(new LegacyRenderClient().render("amd"));
    }
}
