//3. ��ͷ���ĵ�������

//�������࣬ʵ��ADT List<T>�����ķ�����T��ʾ����Ԫ�ص���������
public class SinglyList<T> extends Object 
{
    public Node<T> head;                                   //ͷָ�룬ָ�������ͷ���
    
    
    //��1�����췽��
    public SinglyList()                                    //���췽��������յ�����
    {
        this.head = new Node<T>();                         //����ͷ��㣬data��nextֵ��Ϊnull
    }
    
    //���쵥������values�����ṩԪ�أ��������пն��󡣲���β���룬������Ԫ�ش���������Ԫ�ش�����ͬ
    public SinglyList(T[] values)
    {
        this();                                            //�����յ�����ֻ��ͷ���
        Node<T> rear=this.head;                            //rearָ���������һ�����
        for (int i=0; i<values.length; i++)                //��values.length==0�����������
            if (values[i]!=null)
            {
                rear.next=new Node<T>(values[i],null);     //β���룬�����������rear���֮��
                rear = rear.next;                          //rearָ���µ���β���
            }
    }

    public boolean isEmpty()                               //�жϵ������Ƿ�գ�O(1)
    {
        return this.head.next==null;
    }

    //��2����ȡ
    public T get(int i)                                    //���ص�i��Ԫ�أ�0��i<���ȡ���iԽ�磬����null��O(n)
    {
        Node<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)                 //����������Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;          //��pָ���i����㣬������Ԫ��ֵ
    }
   
    
    //���õ�i��Ԫ��Ϊx��0��i<n����iԽ�磬�׳����Խ���쳣����x==null���׳��ն����쳣��O(n)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        Node<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)                 //����Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //pָ���i�����
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }     
    
    //���ص���������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()������O(n)
    public String toString()
    {
        String str=this.getClass().getName()+"(";          //��������

        for (Node<T> p=this.head.next;  p!=null;  p=p.next)//p����������
        {   str += p.data.toString();
            if (p.next!=null) 
                str += ",";                                //�������һ�����ʱ���ӷָ���
        }
        return str+")";                                    //�ձ���()
    }
 
    //��˼����2-5��  
    public int size()                                      //���ص������ȣ�O(n)
    {
        int i=0; 
        for (Node<T> p=this.head.next;  p!=null;  p=p.next) //p����������
            i++;
        return i;
    }
    
    //��3������
    //����x��Ϊ��i��Ԫ�أ�x!=null�����ز����㡣
    //�����i��ȡ�ݴ��ʩ����i<0������x����ǰ����i>n������x�����O(n)
    public Node<T> insert(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        Node<T> front=this.head;                           //frontָ��ͷ���
        for (int j=0;  front.next!=null && j<i;  j++)      //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next;
        front.next = new Node<T>(x, front.next);           //��front֮�����ֵΪx��㣬����ͷ���롢�м�/β����
        return front.next;                                 //���ز�����
    }
    public Node<T> insert(T x)                             //�ڵ�����������x����O(n)
    {
        return insert(Integer.MAX_VALUE, x);
                             
    }
      
    //��4��ɾ��
    public T remove(int i)    //ɾ����i��Ԫ�أ�0��i<n�����ر�ɾ��Ԫ�أ���iԽ�磬����null��O(n)
    {
        Node<T> front=this.head;                           //frontָ��ͷ���
        for (int j=0;  front.next!=null && j<i;  j++)      //����Ѱ�ҵ�i-1��㣨frontָ��
            front = front.next;
        if (i>=0 && front.next!=null)                      //��front�ĺ�̽����ڣ���ɾ��֮
        {
            T old = front.next.data;                       //��ô�ɾ��������õĶ���
            front.next = front.next.next;                  //ɾ��front�ĺ�̽�㣬����ͷɾ�����м�/βɾ��
                                                           //��Java������Ժ��ͷŽ��ռ�ô洢��Ԫ
            return old;
        }
        return null;                                       //��i<0��i>��

    }

    public void clear()                                    //ɾ������������Ԫ��
    {
        this.head.next=null;                               //Java�Զ��ջ����н��ռ�õĴ洢�ռ�
    }

    //��5�����ң�ɢ�б���
    //���ܼ������������׸���key���Ԫ�ؽ�㣬�����Ҳ��ɹ�����null
    //�����������keyΪ�ն���Java���׳��ն����쳣
    //�㷨��Ч�ʣ�˳����ң�O(n)
   
    //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
    //key����ֻ�����ؼ����������T���equals()�����ṩ�Ƚ϶�����ȵ�����
    public Node<T> search(T key) 
    {
        for (Node<T> p=this.head.next;  p!=null;  p=p.next)
            if (key.equals(p.data))                        //ִ��T���equals(Object)����������ʱ��̬
                return p;
        return null;
    }

    public boolean contains(T key)               //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=null;                     //�Բ��ҽ������жϽ��
    }

    
    //β���뻥��Ԫ��x�������ҵ���x�Ĺؼ�����ͬԪ�أ������룬����x��㣻���ǡ�//ɢ�б���
    public Node<T> insertDifferent(T x)
    {
        Node<T> front=this.head, p=front.next;             //front��p��ǰ�����
        while (p!=null && !p.data.equals(x))               //˳�����
        {
            front = p; 
            p = p.next;
        }
        if (p!=null)                                       //���ҳɹ���Ԫ���ظ��������룬����p���
        {
            System.out.println("x="+x+"��Ԫ���ظ���δ���롣");
            return p;
        }
        return front.next = new Node<T>(x,null);           //β����ֵΪx��㣬���ز�����
    }
    
   
}

