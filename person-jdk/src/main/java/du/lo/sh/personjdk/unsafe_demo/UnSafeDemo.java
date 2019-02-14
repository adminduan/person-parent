package du.lo.sh.personjdk.unsafe_demo;

import lombok.Getter;
import lombok.Setter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName UnSafeDemo
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/1 11:32
 * @Version 1.0
 */
public class UnSafeDemo {


    @Setter
    @Getter
    static class UnSafeModel{

        public UnSafeModel(){
            System.out.println("===================");
        }
        private int age;
        private String name;
        private UnSafeModel unSafeModel;


    }

    public static void main(String[] args) {

        Unsafe UNSAFE = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);

            Class<?> cls = UnSafeModel.class;
            long nameOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("name"));
            long ageOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("age"));
            long objOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("unSafeModel"));

            UnSafeModel unSafeModel = new UnSafeModel();
            UNSAFE.putObject(unSafeModel, nameOffset, "zhangsan");
            UNSAFE.putInt(unSafeModel, ageOffset,10);

            System.out.println(unSafeModel.getName());
            System.out.println(unSafeModel.getAge());

            //赋值对象
            UnSafeModel unSafeModel1 = new UnSafeModel();
            unSafeModel1.setName("李四");
            UNSAFE.putObject(unSafeModel, objOffset, unSafeModel1);
            System.out.println(unSafeModel.getUnSafeModel().getName());


            UNSAFE.compareAndSwapObject(unSafeModel, nameOffset, "zhangsan", "lisi");
            System.out.println(unSafeModel.getName());



        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




    }
}
