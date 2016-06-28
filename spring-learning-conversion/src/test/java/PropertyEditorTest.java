import com.panlingxiao.spring.learning.domain.Circle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by panlingxiao on 2016/6/28.
 */
public class PropertyEditorTest {

    @Test
    public void testConversionByPropertyEditor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context-prop.xml");
        Circle circle = context.getBean("circle", Circle.class);
        System.out.println(circle);
    }
}
