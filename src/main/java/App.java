import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        HelloWorld helloWorld1 = applicationContext.getBean(HelloWorld.class);
        System.out.println(helloWorld == helloWorld1);

        Cat cat = applicationContext.getBean(Cat.class);
        Cat cat2 = applicationContext.getBean(Cat.class);
        System.out.println(cat == cat2);
    }
}