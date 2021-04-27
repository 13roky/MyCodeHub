


public class CirDoublyList_ex 
{
	public static Integer[] random(int n)              //返回产生n个随机数的数组
	{
	    Integer[] elements = new Integer[n];
	    for (int i=0; i<n; i++)
	        elements[i] = (int)(Math.random()*100);   //产生随机数
	    return elements;
	}
	
	public static void main(String args[])
	{
        Integer values[]=random(5);        

        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(values);
        System.out.println("list1="+list1.toString());    


        System.out.print("list1: "+list1.toString()+"，");
        
        list1.insert(-1, -1);                              //插入位置容错
        list1.insert(0, 0);
        list1.insert(6, 6);
        list1.insert(100, 100);                            //插入位置容错
        list1.set(3, new Integer((int)(list1.get(3).intValue()+100)));
        System.out.println("插入后: "+list1.toString());
        list1.remove(0);
	     
        System.out.println("删除后: "+list1.toString());
	    
    }
}
