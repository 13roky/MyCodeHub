
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.2  ˳���



//˳����࣬ʵ��ADT List<T>�����ķ�����T��ʾ����Ԫ�ص���������
public class SeqList<T> extends Object 
{
    protected Object[] element;                            //�������飬������Ա
    protected int n;                                       //˳���Ԫ�ظ��������ȣ�

    //1. ���졢��ȡ
    public SeqList(int length)                             //��������Ϊlength�Ŀձ�
    {
        this.element = new Object[length];                 //��������Ĵ洢�ռ䣬Ԫ��Ϊnull��
                //��length<0��Java�׳������鳤���쳣 java.lang.NegativeArraySizeException
        this.n = 0;
    }
    public SeqList()                                       //����Ĭ�������Ŀձ����췽������
    {
        this(64);                                          //���ñ�����������ָ�������б�Ĺ��췽��
    }
    
    public SeqList(T[] values)                             //����˳�����values�����ṩԪ�أ��������пն���
    {
        this(values.length);                               //��������Ϊvalues.length�Ŀձ�
                   //��values==null���ÿն�����÷�����Java�׳��ն����쳣NullPointerException
        for (int i=0; i<values.length; i++)                //��������Ԫ�أ�O(n)
            this.element[i] = values[i];                   //�������ø�ֵ
        this.n = element.length;

    }
    

    
    public boolean isEmpty()                               //�ж�˳����Ƿ�գ����շ���true��O(1)
    {
        return this.n==0;
    }

    public int size()                                      //����˳���Ԫ�ظ�����O(1)
    {
        return this.n;
    }

    //��ȡ����
    public T get(int i)                                    //���ص�i��Ԫ�أ�0��i<n����iԽ�磬����null��O(1)
    {
        if (i>=0 && i<this.n)
            return (T)this.element[i];                     //��������Ԫ�����õĶ��󣬴��ݶ�������

        return null;
    }    

    //���õ�i��Ԫ��Ϊx��0��i<n����iԽ�磬�׳����Խ���쳣����x==null���׳��ն����쳣��O(1)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        if (i>=0 && i<this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i+"");//�׳����Խ���쳣
    }

    //����˳�������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()����
    public String toString()
    {
        String str=this.getClass().getName()+"(";          //��������

        if (this.n>0)
            str += this.element[0].toString();             //ִ��T���toString()����������ʱ��̬
        for (int i=1; i<this.n; i++)
            str += ", "+this.element[i].toString();        //ִ��T���toString()����������ʱ��̬
        return str+") ";                                   //�ձ���()
    }

    //�������Ա�����Ԫ�ص������ַ�����Ԫ�ش���Ӻ���ǰ����O(n)�����裬���ȶ����á�������ʡ��
    public String toPreviousString()
    {
        return "";
    }
    
    //2. ˳���Ĳ������
    //����x��Ϊ��i��Ԫ�أ�x!=null������x��š���x==null���׳��ն����쳣��O(n)
    //�����i��ȡ�ݴ��ʩ����i<0������x����ǰ����i>n������x�����
    public int insert(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        if (i<0)       i=0;                                //����λ��i�ݴ���������ǰ
        if (i>this.n)  i=this.n;                           //���������
        Object[] source = this.element;                    //����������ø�ֵ��sourceҲ����element����
        if (this.n==element.length)                        //����������������˳������������
        {
            this.element = new Object[source.length*2];    //��������һ���������������
            for (int j=0; j<i; j++)                        //���Ƶ�ǰ����ǰi-1��Ԫ��
                this.element[j] = source[j];
        }
        for (int j=this.n-1; j>=i; j--)                    //��i��ʼ����β��Ԫ������ƶ�������Ӻ���ǰ
            this.element[j+1] = source[j];
        this.element[i] = x;
        this.n++;
        return i;                                          //����x���
    }
    public int insert(T x)                                 //˳���β����xԪ�أ�����x��š���Ա��������
    {
        return this.insert(this.n, x);                     //��������У�this.n��1
    }
    
    //3. ˳����ɾ������
    public T remove(int i)          //ɾ����i��Ԫ�أ�0��i<n�����ر�ɾ��Ԫ�ء���iԽ�磬����null��//������iԽ�磬�׳����Խ���쳣
    {
        if (this.n>0 && i>=0 && i<this.n) 
        {
            T old = (T)this.element[i];                    //old�д洢��ɾ��Ԫ��
            for (int j=i; j<this.n-1; j++)
                this.element[j] = this.element[j+1];       //Ԫ��ǰ��һ��λ��
            this.element[this.n-1]=null;                   //��������Ԫ�ض���Ϊ�գ��ͷ�ԭ����ʵ��
            this.n--;
            return old;                                    //����old�ֲ��������õĶ��󣬴��ݶ�������
        }
        return null;
        //throw new IndexOutOfBoundsException(i+"");         //�׳����Խ���쳣
    }
    public void clear()                                    //ɾ�����Ա�����Ԫ��
    {
        this.n=0;                                          //���ó���Ϊ0��δ�ͷ�����ռ�
    }
    
    
    //4. ˳�����
    //˳������״γ��ֵ���key���Ԫ�أ�����Ԫ�����i��0��i<n�����Ҳ��ɹ�����-1��
    //��key==null��Java�׳��ն����쳣NullPointerException
    public int search(T key)
    {

        for (int i=0; i<this.n; i++)
        {

            if (key.equals(this.element[i]))               //ִ��T���equals(Object)����������ʱ��̬
               return i;
        }
        return -1;                                         //�ձ��δ�ҵ�ʱ
    }//��������Ԫѭ�����޷�����i
    
    public boolean contains(T key)                         //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=-1;
    }
    //��˼����2-2�����ڲ��ҵĲ���
    public T remove(T key)                                 //ɾ���׸���key���Ԫ�أ����ر�ɾ��Ԫ�أ����Ҳ��ɹ�����null
    {
        return this.remove(this.search(key));              //�Ȳ��ң��ٵ���remove(i)�������Ҳ��ɹ�������-1����ɾ��
    }  

  
 
    //6. ˳���Ƚ����
    public boolean equals(Object obj)                      //�Ƚ�����˳����Ƿ���ȡ����ǡ�O(n)
    {
        if (this==obj)                                     //��this��obj����ͬһ��˳���ʵ���������
            return true;
        if (obj instanceof SeqList<?>)                     //��obj����˳���ʵ����SeqList<?>������SeqList<T>�ĸ���
        {
            SeqList<T> list = (SeqList<T>)obj;             //����listҲ����obj���õ�ʵ��
            if (this.n==list.n)                            //�Ƚ����߳����Ƿ����
            {
                for (int i=0; i<this.n; i++)               //�Ƚ�����˳��������Ԫ���Ƿ����
                    if (!(this.get(i).equals(list.get(i))))//equals(Object)����ʱ��̬
                        return false; 
                return true;
            }
        }
        return false;
    }    
   
    
    
}
