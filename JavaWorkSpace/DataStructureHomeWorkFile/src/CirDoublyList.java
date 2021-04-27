

//循环双链表类，实现ADT List<T>声明的方法，T表示数据元素的数据类型
public class CirDoublyList<T>
{
    public DoubleNode<T> head;                             //头指针

    public CirDoublyList()                                 //构造空循环双链表
    {
        this.head = new DoubleNode<T>();                   //创建头结点，3个域值均为null
        this.head.prev = this.head;
        this.head.next = this.head;
    }
    public boolean isEmpty()                               //判断循环双链表是否空
    {
        return this.head.next==this.head;
    }

    //插入x作为第i个元素，返回插入结点。若x==null，抛出空对象异常。
    //对序号i采取容错措施，若i<0，插入x在最前；若i>n，插入x在最后。O(n)
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
    public DoubleNode<T> insert(T x)             //尾插入x元素，返回x结点。算法在头结点之前插入，O(1)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        DoubleNode<T> q = new DoubleNode<T>(x, head.prev, head); 
        head.prev.next = q;                                //在头结点之前插入，相当于尾插入
        head.prev = q;
        return q;
    }
    
     //删除第i个元素，返回被删除元素；0≤i<n，若i越界，不删除，返回null。O(n)
    public T remove(int i)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=head && j<i; j++)                 //遍历寻找第i个结点（p指向）
            p = p.next;
        if (p!=head && i>=0)
        {
            p.prev.next = p.next;                          //删除p结点，由JVM稍后释放
            p.next.prev = p.prev;
            return p.data;                                 //返回p结点元素
        }
        return null;                                       //当i<0或i>表长时
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
    
    public CirDoublyList(T[] values)                       //构造循环双链表，由values数组提供元素，尾插入
    {
        this();                                            //创建空循环双链表，只有头结点
        DoubleNode<T> rear=this.head;
        for (int i=0; i<values.length; i++)
        {
            rear.next=new DoubleNode<T>(values[i], rear, this.head);   //尾插入
            rear = rear.next; 
        }
        this.head.prev = rear;
    }
    
    public CirDoublyList(CirDoublyList<T> list)            	//深拷贝构造方法，复制循环双链表
    {
        this();                                          	//创建空循环双链表，只有头结点
        DoubleNode<T> rear = this.head;
        for (DoubleNode<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
        	rear.next = new DoubleNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.prev = rear;
    }

    
    public T get(int i)                            //返回第i个元素，0≤i<长度。若i越界，返回null。O(n)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;          //若p指向第i个结点，返回其元素值
    }
    
    //设置第i个元素为x，0≤i<长度。若i越界，抛出序号越界异常；若x==null，抛出空对象异常。O(n)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //p指向第i个结点
        else throw new IndexOutOfBoundsException(i+"");    //抛出序号越界异常
    }
    
    public int size()                                      //返回循环双链表长度
    {
        int i=0; 
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)//循环条件与单链表不同
            i++;
        return i;
    }   
    
    public String toString()           //返回循环双链表所有元素的描述字符串，循环双链表遍历算法，O(n)
    {
        String str=this.getClass().getName()+"(";          //返回类名
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            str += p.data.toString();
            if (p.next!=this.head) 
                str += ",";
        }
        return str+")";                                    //空表返回()
    }
    
    
    public DoubleNode<T> search(T key) 
    {
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
            if (key.equals(p.data))
                return p;
        return null;
    }
    
    }