


public class CirDoublyList_ex 
{
	public static Integer[] random(int n)              //���ز���n�������������
	{
	    Integer[] elements = new Integer[n];
	    for (int i=0; i<n; i++)
	        elements[i] = (int)(Math.random()*100);   //���������
	    return elements;
	}
	
	public static void main(String args[])
	{
        Integer values[]=random(5);        

        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(values);
        System.out.println("list1="+list1.toString());    


        System.out.print("list1: "+list1.toString()+"��");
        
        list1.insert(-1, -1);                              //����λ���ݴ�
        list1.insert(0, 0);
        list1.insert(6, 6);
        list1.insert(100, 100);                            //����λ���ݴ�
        list1.set(3, new Integer((int)(list1.get(3).intValue()+100)));
        System.out.println("�����: "+list1.toString());
        list1.remove(0);
	     
        System.out.println("ɾ����: "+list1.toString());
	    
    }
}
