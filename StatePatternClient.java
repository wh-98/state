package state;
public class StatePatternClient
{
    public static void main(String[] args)
    {       
        Context context=new Context();    //��������       
        context.Handle();    //��������
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
//������
class Context
{
    private State state;
    //���廷����ĳ�ʼ״̬
    public Context()
    {
        this.state=new ConcreteStateA();
    }
    //������״̬
    public void setState(State state)
    {
        this.state=state;
    }
    //��ȡ״̬
    public State getState()
    {
        return(state);
    }
    //������������
    public void Handle()
    {
        state.Handle(this);
    }
}
//����״̬��
abstract class State
{
    public abstract void Handle(Context context);
}
//����״̬A��
class ConcreteStateA extends State
{
    public void Handle(Context context)
    {
        System.out.println("��ǰ״̬�� A.");
        context.setState(new ConcreteStateB());
    }
}
//����״̬B��
class ConcreteStateB extends State
{
    public void Handle(Context context)
    {
        System.out.println("��ǰ״̬�� B.");
        context.setState(new ConcreteStateA());
    }
}