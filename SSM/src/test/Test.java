import com.clt.pojo.Dog;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Random;


public class Test {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private  static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Test.class);
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
    public void fianlKeyWordTest(){
        final Dog dog = new Dog("旺财");
        Dog dog1 = new Dog("阿狗");
        dog.setName("来福");
        /**
         *  final 修饰的变量 可以改变该变量地址所指向的对象里面的内容
         *  但无法改变该变量所指向的地址，即一旦将该变量指向某一地址后就再无法更改它所指向的地址
         */
//        dog = dog1;  ×
        System.out.println(dog); // Dog{name='来福', age=null}
    }
}
