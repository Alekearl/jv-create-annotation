package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Введіть value та risk для вашої ставки");
        ConsoleHandler consoleHandle = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        consoleHandle.handle();
        BetDao betDao = Factory.getBetDao();
        System.out.println("all bets: " + betDao.getAll());
    }
}
