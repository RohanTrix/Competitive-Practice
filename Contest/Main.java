import java.io.File;
abstract class ILogger
{
    public ILogger()
    {
        
    }
    void Log(String d, String msg, String type)
    {}
    String msgConcat(String d, String msg, String type)
    {
        StringBuilder str = new StringBuilder();
        str.append(d);
        str.append(", ");
        str.append(msg);
        str.append(", ");
        str.append(type);
        return str.toString();
    }
}
class FileLogger extends ILogger
{
    public FileLogger()
    {
        super();
    }
    void Log(String d, String msg, String ty pe)
    {
        System.out.println(msgConcat(d,msg, type));
    }
}
class DBLogger implements ILogger
{
    public DBLogger()
    {
        super();
    }
    void Log(String d, String msg, String type)
    {
        System.out.println(msgConcat(d,msg, type));
    }
}
class EventLogger implements ILogger
{
    public EventLogger()
    {
        super();
    }
    void Log(String d, String msg, String type)
    {
        System.out.println(msgConcat(d,msg, type));
    }
}