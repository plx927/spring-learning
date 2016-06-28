import com.panlingxiao.spring.learning.domain.Circle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by panlingxiao on 2016/6/28.
 */
public class ConversionTest {

    @Test
    public void testConversionByConverter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context-conversion.xml");
        Circle circle = context.getBean("circle", Circle.class);
        System.out.println(circle);
    }
}
