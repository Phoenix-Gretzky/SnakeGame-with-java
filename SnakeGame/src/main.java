import java.util.*;
// Other imports go here
import Classes.*;


// Do NOT change the class name
class Main{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("What should be the size of the grid? ");
        int N=sc.nextInt();
        while(N<5)
        {
            System.out.println("Size is too small enter again!");
            N=sc.nextInt();

        }
        Random rand = new Random(); 
        Node head=new Node(2,2,'\\');
        
        head=head.insertBeg(head,2,3,'*');
        head=head.insertBeg(head,2,4,'*');
        head=head.insertBeg(head,3,4,'O');
        // head=head.insertBeg(head,4,4,'*');
        // head=head.insertBeg(head,5,4,'*');
        // head=head.insertBeg(head,6,4,'\\');
       
        int X = rand.nextInt(N-2)+1;
        int Y = rand.nextInt(N-2)+1;
        

        Node food;
        food=new Node(X,Y,'F');
                
        Func work=new Func();

        work.printer(N,head,food);
        work.inp(N,head,food);
        // Write your code here
        sc.close();
    }
}

