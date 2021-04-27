
//§2.2  线性表的顺序存储和实现
//§2.2.2  顺序表



//顺序表类，实现ADT List<T>声明的方法，T表示数据元素的数据类型
public class SeqList<T> extends Object 
{
    protected Object[] element;                            //对象数组，保护成员
    protected int n;                                       //顺序表元素个数（长度）

    //1. 构造、存取
    public SeqList(int length)                             //构造容量为length的空表
    {
        this.element = new Object[length];                 //申请数组的存储空间，元素为null。
                //若length<0，Java抛出负数组长度异常 java.lang.NegativeArraySizeException
        this.n = 0;
    }
    public SeqList()                                       //创建默认容量的空表，构造方法重载
    {
        this(64);                                          //调用本类已声明的指定参数列表的构造方法
    }
    
    public SeqList(T[] values)                             //构造顺序表，由values数组提供元素，忽略其中空对象
    {
        this(values.length);                               //创建容量为values.length的空表
                   //若values==null，用空对象调用方法，Java抛出空对象异常NullPointerException
        for (int i=0; i<values.length; i++)                //复制数组元素，O(n)
            this.element[i] = values[i];                   //对象引用赋值
        this.n = element.length;

    }
    

    
    public boolean isEmpty()                               //判断顺序表是否空，若空返回true，O(1)
    {
        return this.n==0;
    }

    public int size()                                      //返回顺序表元素个数，O(1)
    {
        return this.n;
    }

    //存取操作
    public T get(int i)                                    //返回第i个元素，0≤i<n。若i越界，返回null。O(1)
    {
        if (i>=0 && i<this.n)
            return (T)this.element[i];                     //返回数组元素引用的对象，传递对象引用

        return null;
    }    

    //设置第i个元素为x，0≤i<n。若i越界，抛出序号越界异常；若x==null，抛出空对象异常。O(1)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        if (i>=0 && i<this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i+"");//抛出序号越界异常
    }

    //返回顺序表所有元素的描述字符串，形式为“(,)”。覆盖Object类的toString()方法
    public String toString()
    {
        String str=this.getClass().getName()+"(";          //返回类名

        if (this.n>0)
            str += this.element[0].toString();             //执行T类的toString()方法，运行时多态
        for (int i=1; i<this.n; i++)
            str += ", "+this.element[i].toString();        //执行T类的toString()方法，运行时多态
        return str+") ";                                   //空表返回()
    }

    //返回线性表所有元素的描述字符串（元素次序从后向前），O(n)。必需，优先队列用。方法体省略
    public String toPreviousString()
    {
        return "";
    }
    
    //2. 顺序表的插入操作
    //插入x作为第i个元素，x!=null，返回x序号。若x==null，抛出空对象异常。O(n)
    //对序号i采取容错措施，若i<0，插入x在最前；若i>n，插入x在最后
    public int insert(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        if (i<0)       i=0;                                //插入位置i容错，插入在最前
        if (i>this.n)  i=this.n;                           //插入在最后
        Object[] source = this.element;                    //数组变量引用赋值，source也引用element数组
        if (this.n==element.length)                        //若数组满，则扩充顺序表的数组容量
        {
            this.element = new Object[source.length*2];    //重新申请一个容量更大的数组
            for (int j=0; j<i; j++)                        //复制当前数组前i-1个元素
                this.element[j] = source[j];
        }
        for (int j=this.n-1; j>=i; j--)                    //从i开始至表尾的元素向后移动，次序从后向前
            this.element[j+1] = source[j];
        this.element[i] = x;
        this.n++;
        return i;                                          //返回x序号
    }
    public int insert(T x)                                 //顺序表尾插入x元素，返回x序号。成员方法重载
    {
        return this.insert(this.n, x);                     //插入操作中，this.n加1
    }
    
    //3. 顺序表的删除操作
    public T remove(int i)          //删除第i个元素，0≤i<n，返回被删除元素。若i越界，返回null。//？？若i越界，抛出序号越界异常
    {
        if (this.n>0 && i>=0 && i<this.n) 
        {
            T old = (T)this.element[i];                    //old中存储被删除元素
            for (int j=i; j<this.n-1; j++)
                this.element[j] = this.element[j+1];       //元素前移一个位置
            this.element[this.n-1]=null;                   //设置数组元素对象为空，释放原引用实例
            this.n--;
            return old;                                    //返回old局部变量引用的对象，传递对象引用
        }
        return null;
        //throw new IndexOutOfBoundsException(i+"");         //抛出序号越界异常
    }
    public void clear()                                    //删除线性表所有元素
    {
        this.n=0;                                          //设置长度为0，未释放数组空间
    }
    
    
    //4. 顺序查找
    //顺序查找首次出现的与key相等元素，返回元素序号i，0≤i<n；查找不成功返回-1。
    //若key==null，Java抛出空对象异常NullPointerException
    public int search(T key)
    {

        for (int i=0; i<this.n; i++)
        {

            if (key.equals(this.element[i]))               //执行T类的equals(Object)方法，运行时多态
               return i;
        }
        return -1;                                         //空表或未找到时
    }//不能用逐元循环，无法返回i
    
    public boolean contains(T key)                         //判断是否包含关键字为key元素
    {
        return this.search(key)!=-1;
    }
    //【思考题2-2】基于查找的操作
    public T remove(T key)                                 //删除首个与key相等元素，返回被删除元素；查找不成功返回null
    {
        return this.remove(this.search(key));              //先查找，再调用remove(i)。若查找不成功，返回-1，则不删除
    }  

  
 
    //6. 顺序表比较相等
    public boolean equals(Object obj)                      //比较两个顺序表是否相等。覆盖。O(n)
    {
        if (this==obj)                                     //若this和obj引用同一个顺序表实例，则相等
            return true;
        if (obj instanceof SeqList<?>)                     //若obj引用顺序表实例。SeqList<?>是所有SeqList<T>的父类
        {
            SeqList<T> list = (SeqList<T>)obj;             //声明list也引用obj引用的实例
            if (this.n==list.n)                            //比较两者长度是否相等
            {
                for (int i=0; i<this.n; i++)               //比较两个顺序表的所有元素是否相等
                    if (!(this.get(i).equals(list.get(i))))//equals(Object)运行时多态
                        return false; 
                return true;
            }
        }
        return false;
    }    
   
    
    
}
