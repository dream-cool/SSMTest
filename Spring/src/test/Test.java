import com.clt.MethodTimeInterceptor;
import com.clt.controller.UserController;
import com.clt.service.UserService;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Random;


public class Test {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private  static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(MethodTimeInterceptor.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
        LOGGER.info("daoda");
        System.out.println("Hello World!");
    }

    @org.junit.Test
    public void m1(){
        Date time =new Date();
        if(time!=null){
            System.out.println(time);
            System.out.println(new Date());
            System.currentTimeMillis();
        }
    }

    @org.junit.Test
    public void rand(){
        Random random=new Random();
        for(int i=0 ;i<100;i++){
            System.out.print(random.nextInt(5));
        }
        System.out.println();
        for(int i=0 ;i<100;i++){
            System.out.print(random.nextInt(5));
        }
    }
    @org.junit.Test
    public void test(){
        Date date=new Date();
        long retime=(24-date.getHours())*3600-(date.getMinutes()*60)-(date.getSeconds());
        System.out.println(retime);
    }

    @org.junit.Test
    public void testSpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/spring-*.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserController userController= (UserController) applicationContext.getBean("userController");
        System.out.println(applicationContext.getBean("userMapper"));
        System.out.println(userService);
        System.out.println(userController);
    }
}
