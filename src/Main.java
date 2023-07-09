import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat myCat = new Cat("Stella",6);

        Field[] catFields = myCat.getClass().getDeclaredFields();

        for (Field field :
                catFields) {
            if (field.getName().equals("name")){
                field.setAccessible(true);
                field.set(myCat,"Jimmy McGill");
            }
        }

        Method[] catMethods = myCat.getClass().getDeclaredMethods();

        for (Method method :
                catMethods) {
            if (method.getName().equals("meow")){
                method.invoke(myCat); //if have parameters (myCat,parameter1,parameter2)
            }
            if(method.getName().equals("heyThisIsPrivate")){
                method.setAccessible(true);
                method.invoke(myCat);
            }
            if (method.getName().equals("thisIsAPrivateStaticMethod")){
                method.setAccessible(true);
                method.invoke(myCat);
            }
        }

    }
}