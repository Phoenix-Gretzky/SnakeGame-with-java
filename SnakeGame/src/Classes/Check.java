package Classes;
public class Check{

     boolean check(Node head,int n)
    {
        int x=head.x;
        int y=head.y;
        Node ptr=head.next;
        while(ptr!=null)
        {
            if(x==ptr.x&&y==ptr.y)
            return false;
            ptr=ptr.next;
        }

        if(x==n-1||y==n-1||x==0||y==0)
        return false;

        else 
        return true; 
    }

}