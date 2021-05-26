package com.broky.Collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 13roky
 * @date 2021-05-26 16:15
 */
public class CollectionsTest {
    @Test
    void testCollectons() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list); //调用Integer的compareto()函数
        System.out.println(list);

        System.out.println(Collections.frequency(list, 43));

        //        ArrayList dest = new ArrayList(); 报异常
        //        ArrayList dest = new ArrayList(list.size()); //这么写, 是指定ArrayList中底层实现数组的大小,而不是ArrayList中size()的大小

        List dest = Arrays.asList(new Object[list.size()]); //new Object[list.size()]为长度为list.size(),值为null的object类型数组
        System.out.println(dest);
        Collections.copy(dest, list); //copy中dest.size()必须大于list.size()
        System.out.println(dest);
    }

    @Test
    void testSynchronized() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        List list1 = Collections.synchronizedList(list);

    }
}
