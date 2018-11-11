import java.lang.reflect.Method;

/**
 * Created by sc on 2018/11/8.
 */
public class Test1{

    public static void main(String[] args) throws Exception, IllegalAccessException {
        System.out.println(1234567&7654321);
        /*Test1 t=new Test1();
        t.test();*/

    }

    public void test() throws Exception, InstantiationException {
        this.getClass().newInstance();
       /* System.out.println(this.getClass().getMethod("test").getDeclaringClass());
        System.out.println(Test1.class);
        System.out.println(this.getClass().getMethod("test").getDeclaringClass().equals(Test1.class));*/
        Method[] method=Mapper.class.getMethods();
        for (int i = 0; i < method.length; i++) {
            System.out.println(method[i].getModifiers());

        }
    }

    public void aaad(String qq){

    }
}
