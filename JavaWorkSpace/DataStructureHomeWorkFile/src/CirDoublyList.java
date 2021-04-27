

//ѭ��˫�����࣬ʵ��ADT List<T>�����ķ�����T��ʾ����Ԫ�ص���������
public class CirDoublyList<T>
{
    public DoubleNode<T> head;                             //ͷָ��

    public CirDoublyList()                                 //�����ѭ��˫����
    {
        this.head = new DoubleNode<T>();                   //����ͷ��㣬3����ֵ��Ϊnull
        this.head.prev = this.head;
        this.head.next = this.head;
    }
    public boolean isEmpty()                               //�ж�ѭ��˫�����Ƿ��
    {
        return this.head.next==this.head;
    }

    //����x��Ϊ��i��Ԫ�أ����ز����㡣��x==null���׳��ն����쳣��
    //�����i��ȡ�ݴ��ʩ����i<0������x����ǰ����i>n������x�����O(n)
    public DoubleNode<T> insert(int i, T x)
    {
    	if(x==null){
    		throw new NullPointerException("x==null");
    		
    	}
    	
    	DoubleNode<T> front=this.head;
    	
    	for(int j=0;front.next!=this.head&&j<i;j++){
    		front=front.next;
    		
    	}
    	
    	DoubleNode<T> q= new DoubleNode<T>(x,front,front.next);
    	
    	front.next.prev=q;
    	front.next=q;
    	return q;
    }
    public DoubleNode<T> insert(T x)             //β����xԪ�أ�����x��㡣�㷨��ͷ���֮ǰ���룬O(1)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        DoubleNode<T> q = new DoubleNode<T>(x, head.prev, head); 
        head.prev.next = q;                                //��ͷ���֮ǰ���룬�൱��β����
        head.prev = q;
        return q;
    }
    
     //ɾ����i��Ԫ�أ����ر�ɾ��Ԫ�أ�0��i<n����iԽ�磬��ɾ��������null��O(n)
    public T remove(int i)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=head && j<i; j++)                 //����Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        if (p!=head && i>=0)
        {
            p.prev.next = p.next;                          //ɾ��p��㣬��JVM�Ժ��ͷ�
            p.next.prev = p.prev;
            return p.data;                                 //����p���Ԫ��
        }
        return null;                                       //��i<0��i>��ʱ
    }    
    
    public boolean removeKey(CirDoublyList<T> list)
    {
    	boolean a = false;
    	DoubleNode<T> p=this.head.next;
        for (int j=0; p!=head && j<list.size(); j++){               
        	if(p.data=="Key"){
        		p = p.next;
        		a = true;
        	}
        }
       
        if (p!=head && list.size()>=0 && p.data=="Key")
        {
            p.prev.next = p.next;                          
            p.next.prev = p.prev;
            a = true;
        }
        return a;        
    }  
    
    public CirDoublyList(T[] values)                       //����ѭ��˫������values�����ṩԪ�أ�β����
    {
        this();                                            //������ѭ��˫����ֻ��ͷ���
        DoubleNode<T> rear=this.head;
        for (int i=0; i<values.length; i++)
        {
            rear.next=new DoubleNode<T>(values[i], rear, this.head);   //β����
            rear = rear.next; 
        }
        this.head.prev = rear;
    }
    
    public CirDoublyList(CirDoublyList<T> list)            	//������췽��������ѭ��˫����
    {
        this();                                          	//������ѭ��˫����ֻ��ͷ���
        DoubleNode<T> rear = this.head;
        for (DoubleNode<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
        	rear.next = new DoubleNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.prev = rear;
    }

    
    public T get(int i)                            //���ص�i��Ԫ�أ�0��i<���ȡ���iԽ�磬����null��O(n)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;          //��pָ���i����㣬������Ԫ��ֵ
    }
    
    //���õ�i��Ԫ��Ϊx��0��i<���ȡ���iԽ�磬�׳����Խ���쳣����x==null���׳��ն����쳣��O(n)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //pָ���i�����
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }
    
    public int size()                                      //����ѭ��˫������
    {
        int i=0; 
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)//ѭ�������뵥����ͬ
            i++;
        return i;
    }   
    
    public String toString()           //����ѭ��˫��������Ԫ�ص������ַ�����ѭ��˫��������㷨��O(n)
    {
        String str=this.getClass().getName()+"(";          //��������
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            str += p.data.toString();
            if (p.next!=this.head) 
                str += ",";
        }
        return str+")";                                    //�ձ���()
    }
    
    
    public DoubleNode<T> search(T key) 
    {
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
            if (key.equals(p.data))
                return p;
        return null;
    }
    
    }