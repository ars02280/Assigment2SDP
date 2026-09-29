package org.example;

import org.example.client.Client;
import org.example.factorymethod.FactoryMethodDemo;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        System.out.println("Factory Method:");
        FactoryMethodDemo.run();
        System.out.println();
        System.out.println("Abstract Factory + business scenario:");
        System.out.println(Client.run(args, System.getenv("GPU_FAMILY")));
    }
}
