public class Area {
    //厉害了！！！！！！！！！1可以借鉴了！！！！！！！
    private int number;
    private String name;
    private int startaddress;
    private int size1;
    private int flag;



    public Area(){};

    public Area(String name,int size1,int startaddress,int flag)
    {
        this.name = name;
        this.size1 = size1;
        this.startaddress = startaddress;
        this.flag = flag;
    }
    public Area(String name,int size1)
    {
        this.name = name;
        this.size1 = size1;

    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSize(int size1)
    {
        this.size1 = size1;
    }
    public int getSize()
    {
        return size1;
    }
    public void setFlag(int flag)
    {
        this.flag = flag;
    }
    public int getFlag()
    {
        return flag;
    }
    public void setStartaddress(int startaddress)
    {
        this.startaddress = startaddress;
    }
    public int getStartaddress()
    {
        return startaddress;
    }

}

