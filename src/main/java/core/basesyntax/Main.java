package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введіть value та risk для вашої ставки");
        ConsoleHandler consoleHandle = new ConsoleHandler();
        consoleHandle.handle();
    }
}
