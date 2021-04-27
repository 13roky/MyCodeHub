                
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
    
   //2. ˳���Ĳ���������貹��
    //����x��Ϊ��i��Ԫ�أ�x!=null������x��š���x==null���׳��ն����쳣��O(n)
    //�����i��ȡ�ݴ��ʩ����i<0������x����ǰ����i>n������x�����
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

    public int insert(T x)                                 //˳���β����xԪ�أ�����x��š���Ա��������
    {
        return this.insert(this.n, x);                     //��������У�this.n��1
    }
    
    //3. ˳����ɾ���������貹��
    public T remove(int i)          //ɾ����i��Ԫ�أ�0��i<n�����ر�ɾ��Ԫ�ء���iԽ�磬����null��//������iԽ�磬�׳����Խ���쳣
    {
        if(this.n>0&&i>=0&&i<this.n){
            T old = (T)this.element[1]
        }
        
        return null;
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
//        String str="(";
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
    
    
    public void clear()                                    //ɾ�����Ա�����Ԫ��
    {
        this.n=0;                                          //���ó���Ϊ0��δ�ͷ�����ռ�
    }
   
    public boolean contains(T key)                         //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=-1;
    }
   
}
