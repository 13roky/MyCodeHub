package com.broky.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author 13roky
 * @date 2021-05-16 11:33
 */
public class IteratorTest {
    @Test
    void test01(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        Iterator iterator = coll.iterator();
        //方式一 (不推荐): 当超出集合范围后会报错
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        //方式二 (不推荐): for循环遍历
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三(推荐): while循环遍历, hasNext()函数用于判断还有没有下一个值
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        //方式四 : 增强for循环遍历
        for (Object o : coll) {
            System.out.println(o);
        }

        //错误方式一 :
//        Iterator iterator1 = coll.iterator();
//        while (iterator1.next()!=null) {
//            System.out.println(iterator1.next());
//        }
        /*
        这种错误方式跳步输出, 在while判断实, 指针下移一次, 在输出时, 指针又下移一次.
         */

//        while (coll.iterator().hasNext()) {
//            System.out.println(coll.iterator().next());
//        }
        /*
        死循环, 每次while创建的都是一个新的迭代器对象
         */
    }


    //测试Iterrator中的remove()
    @Test
    void test02() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add("Tom");
        coll.add(new Date());

        //删除集合中的"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        //遍历时需要重新生成迭代器
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
