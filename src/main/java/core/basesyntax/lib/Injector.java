package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Object tempObject;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            tempObject = new Object();
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
            }
            if (field.getType().equals(BetDao.class)) {
                tempObject = Factory.getBetDao();
            } else if (field.getType().equals(UserDao.class)) {
                tempObject = Factory.getUserDao();
                }
            if (tempObject.getClass().isAnnotationPresent(Dao.class)) {
                field.set(instance, tempObject);
            } else {
                throw new AnnotationException("Can't find Annotation in class!");
            }

        }
        return instance;
    }
}
