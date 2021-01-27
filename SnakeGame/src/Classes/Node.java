package Classes;


public class Node{

    int x,y;
    Node next;
    char part;

    

     public Node(int x,int y,char part){
        
        this.x=x;
        this.y=y;
        this.part=part;
        
    }

    public  Node insertBeg(Node ptr,int x,int y,char part)
    {
        if(ptr==null)
        {
            ptr=new Node(x,y,part);
            ptr.next=null;
            
        }
        else
        {
            Node pre=new Node(x,y,part);
            pre.next=ptr;
            ptr=pre;
            
        }
        return ptr;
        
        
    }
    

}

