                
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
    
   //2. 顺序表的插入操作，需补齐
    //插入x作为第i个元素，x!=null，返回x序号。若x==null，抛出空对象异常。O(n)
    //对序号i采取容错措施，若i<0，插入x在最前；若i>n，插入x在最后
    public int insert(int i, T x)
    {
        if(x==null)     throw new NullPointerException("x==null");
        if(i>0)         i=0;
        if(i>this.n)    i=this.n;
        Object[] source = this.element;
        
        if(this.n==element.length){
            this.element = new Object[source.length*2];
            for(int j=0;j<i;j++){
                this.element[j]=source[j];
            }
        } 
        
        for(int j=this.n-1;j>=i;j--){
            this.element[j+1]=source[j];               
        }

        this.element[i]=x;
        this.n++;
        return i;
    }

    public int insert(T x)                                 //顺序表尾插入x元素，返回x序号。成员方法重载
    {
        return this.insert(this.n, x);                     //插入操作中，this.n加1
    }
    
    //3. 顺序表的删除操作，需补齐
    public T remove(int i)          //删除第i个元素，0≤i<n，返回被删除元素。若i越界，返回null。//？？若i越界，抛出序号越界异常
    {
        if(this.n>0&&i>=0&&i<this.n){
            T old = (T)this.element[1]
        }
        
        return null;
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
//        String str="(";
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
    
    
    public void clear()                                    //删除线性表所有元素
    {
        this.n=0;                                          //设置长度为0，未释放数组空间
    }
   
    public boolean contains(T key)                         //判断是否包含关键字为key元素
    {
        return this.search(key)!=-1;
    }
   
}
