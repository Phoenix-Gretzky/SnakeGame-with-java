package Classes;
import java.util.*;
public class Func{

    Scanner sc= new Scanner(System.in);
    Check ck=new Check();
    Random rand = new Random(); 
    int X=0;
    int Y=0;
    
    public   void inp(int n,Node head,Node food) 	//this method takes input
    {												// and changes the position of the snake
        											// according to the button pressed
        
         Node ptr=head;
         int xprev,yprev,xnex,ynex;
         char direction;
         char noMove='w';							// the snake can't move back to the body position
         Node ptr2=head;
         
         while(ptr2!=null)
           {
               if(ptr2.x==food.x&&ptr2.y==food.y)
               {
                   X = rand.nextInt(n-2)+1;
                    Y = rand.nextInt(n-2)+1;
                   food=new Node(X,Y,'F');
                   ptr2=head;
               }
               else
               ptr2=ptr2.next;
           }
           ptr2=head;
        while(ck.check(head,n))
        {
            
           direction=sc.next().charAt(0);
           if(direction==noMove)
           continue;
           
        
            switch(direction)
            {
                case 'w':
                ptr=head;
                xprev=ptr.x;
                yprev=ptr.y;
                if(ptr.x-1==food.x&&ptr.y==food.y)
                {
                    Node start=new Node(food.x,food.y,'O');
                    ptr.part='*';
                    start.next=ptr;
                    head=start;
                    X = rand.nextInt(n-2)+1;
                    Y = rand.nextInt(n-2)+1;
                    food=new Node(X,Y,'F');

                }
                else
                {
                ptr.x-=1;
                ptr=ptr.next;
                while(ptr!=null)
                {
                    
                    xnex=ptr.x;
                    ynex=ptr.y;
                    ptr.x=xprev;
                    ptr.y=yprev;
                    xprev=xnex;
                    yprev=ynex;
                    ptr=ptr.next;
                }
                }
                noMove='s';

                break;

                case 'a':
                ptr=head;
                xprev=ptr.x;
                yprev=ptr.y;
                 if(ptr.x==food.x&&ptr.y-1==food.y)
                {
                    Node start=new Node(food.x,food.y,'O');
                    ptr.part='*';
                    start.next=ptr;
                    head=start;
                    X = rand.nextInt(n-2)+1;
                    Y = rand.nextInt(n-2)+1;
                    food=new Node(X,Y,'F');

                }
                else
                {
                ptr.y-=1;
                ptr=ptr.next;
                while(ptr!=null)
                {
                    
                    xnex=ptr.x;
                    ynex=ptr.y;
                    ptr.x=xprev;
                    ptr.y=yprev;
                    xprev=xnex;
                    yprev=ynex;
                    ptr=ptr.next;
                }
                }
                noMove='d';

                break;

                case 's':
                ptr=head;
                xprev=ptr.x;
                yprev=ptr.y;
                 if(ptr.x+1==food.x&&ptr.y==food.y)
                {
                    Node start=new Node(food.x,food.y,'O');
                    ptr.part='*';
                    start.next=ptr;
                    head=start;
                    X = rand.nextInt(n-2)+1;
                    Y = rand.nextInt(n-2)+1;
                    food=new Node(X,Y,'F');

                }
                else
                {
                ptr.x+=1;
                ptr=ptr.next;
                while(ptr!=null)
                {
                    
                    xnex=ptr.x;
                    ynex=ptr.y;
                    ptr.x=xprev;
                    ptr.y=yprev;
                    xprev=xnex;
                    yprev=ynex;
                    ptr=ptr.next;
                }
                }
                noMove='w';

                break;

                case 'd':
                ptr=head;
                xprev=ptr.x;
                yprev=ptr.y;
                 if(ptr.x==food.x&&ptr.y+1==food.y)
                {
                    Node start=new Node(food.x,food.y,'O');
                    ptr.part='*';
                    start.next=ptr;
                    head=start;
                    X = rand.nextInt(n-2)+1;
                    Y = rand.nextInt(n-2)+1;
                    food=new Node(X,Y,'F');

                }
                else
                {
                ptr.y+=1;
                ptr=ptr.next;
                while(ptr!=null)
                {
                    
                    xnex=ptr.x;
                    ynex=ptr.y;
                    ptr.x=xprev;
                    ptr.y=yprev;
                    xprev=xnex;
                    yprev=ynex;
                    ptr=ptr.next;
                }
                }
                noMove='a';

                break;

            }
            ptr2=head;
            while(ptr2!=null)
           {
               if(ptr2.x==food.x&&ptr2.y==food.y)
               {
                   X = rand.nextInt(n-2)+1;
                    Y = rand.nextInt(n-2)+1;
                   food=new Node(X,Y,'F');
                   ptr2=head;
               }
               else
               ptr2=ptr2.next;
           }
           

            printer(n,head,food);
        }
    }
    



    public  void printer(int n,Node head,Node food)
    {
        Node ptr=head;
        char board[][]=new char[n][n];  


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||i==n-1||j==0||j==n-1)
                {
                    board[i][j]='#'; // boundaries are being created 
                }
                
                else
                    board[i][j]=' ';	// the playspace is created here
            }
        }
        board[food.x][food.y]=food.part;	//here the food is stored in the matrix
        
        
        while(ptr!=null)
        {
            board[ptr.x][ptr.y]=ptr.part; 	//here the snake is stored in the matrix
            ptr=ptr.next;

        }

        Node ptr2=head;
        
        
        if(ck.check(ptr2,n)) 
        {
        	
            System.out.print("\033[H\033[2J");  //this line clears the console screen
            // it changes from compiler to compiler .
            System.out.flush(); //this line resets the pointer to the start of the screen  
          
            
            for(int i=0;i<n;i++) // this loop prints the Matrix
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        }
        else
            System.out.println("GAME OVER");

    }

}