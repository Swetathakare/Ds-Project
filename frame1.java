package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
class Node {
	
	String data;
	LinkedList<Node> child;
	Node parent;
	
	Node(String data){
		this.data= data;
	}
}
class Tree extends JFrame {
	
	
	static HashMap<String, String> path = new HashMap<>(); 
	static Scanner sc= new Scanner(System.in);
	
	Node root= new Node("Welcome to the learning journey !");
	
	void add(String data) {
		Node nn= new Node (data);
		
		if(root==null) {
			root=nn;
			System.out.println("Done");
			return;
		}
		Node curr= root;
		
		while(true){
			if(curr.child==null){
				curr.child= new LinkedList<>();
				curr.child.addLast(nn);
				System.out.println("Done");
				return;
			}
			System.out.println("Curr Node :"+curr.data);
			System.out.println("Where do you wish to attach new Course?");
			
			LinkedList<Node> c= curr.child;
			ListIterator list_Iter = c.listIterator();
			System.out.println(0+". Main Topic ");
			int i=1;
			System.out.println("---- As a subtopic of given topic! ----");
			while(list_Iter.hasNext()) {
				Node t=(Node)list_Iter.next();
				System.out.println(i+". "+t.data);
				i++;
			}
			
			int idx= sc.nextInt();
			if(idx==0) {
				if(curr.child==null) {
					curr.child= new LinkedList<>();
				}
				curr.child.add(nn);
				return;
			}else {
				curr= curr.child.get(idx-1);
			
			}
		}
	}
 
static int exp = -1;
static JButton b1;

void display() {
     //new declaration of menu here
	
//	final JFrame j = new JFrame();
//	j.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	j.setSize(400, 400);
//
//	JPanel ob2 = new JPanel();
//
//	b1 = new JButton("Explore");
//	b1.setPreferredSize(new Dimension(200, 70));
//	ob2.add(b1);
//	j.add(ob2);
//	j.setVisible(true);
//	ActionListener button1Listener = new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("Explore clicked!");
//			exp = 1;
//			return;
//		}
//	};
//	b1.addActionListener(button1Listener);
//
//	if (true) {
//		System.out.println("Here 3 ");
		Node ptr = root;
		while (true) {

			if (ptr.child == null) {
				try {
					Desktop.getDesktop().open(new File(path.get(ptr.data)));

				} catch (Exception obj) {
					System.out.println("File Is not Supported");
				}
				return;
			}
            DisplayMenu dm = new DisplayMenu(ptr.child);
            while(dm.isVisible()) {
            	
            }
            int index= dm.getIndex();
            System.out.println("Index "+index);
			int idx = 1;
			for (Node aa : ptr.child) {
				ptr = aa;
				if (index == idx) {
					break;
				}
				idx++;
			}
			System.out.println(idx);

		}
	//}

}

void addLoop(Node ptr) {

	ptr.child = new LinkedList<>();
	
	ptr.child.addLast(new Node("While"));
	ptr.child.addLast(new Node("Do while"));
	ptr.child.addLast(new Node("For"));
}
void addll(Node ptr) {
	
ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("Singly Linked List"));
	ptr.child.addLast(new Node("Doubly Linked List"));
	ptr.child.addLast(new Node("Singly Circular Linked List"));
	ptr.child.addLast(new Node("Doubly Circular Linked List"));

}
void addQueue(Node ptr) {
	
ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("Queue Using Array"));
	ptr.child.addLast(new Node("Queue using LinkedList"));
	ptr.child.addLast(new Node("Circular Queue"));

}
void adddsa(Node ptr) {
ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("LinkedList"));
	ptr.child.addLast(new Node("Stack"));
	ptr.child.addLast(new Node("Queue"));
	ptr.child.addLast(new Node("Tree"));
	ptr.child.addLast(new Node("Graph"));
	ptr.child.addLast(new Node("Heap"));
	ptr.child.addLast(new Node("Hashing"));
	for(Node a: ptr.child ){
		if(a.data.equals("LinkedList")) {
			addll(a);
		}else if(a.data.equals("Tree")) {
			addTree(a);
		}else if(a.data.equals("Queue")) {
			addQueue(a);
		}else if(a.data.equals("Graph")) {
			
		}
	}
}
void addTree(Node ptr) {
    ptr.child=new LinkedList<>();
	ptr.child.addLast(new Node("N-ary Tree"));
	ptr.child.addLast(new Node("Binary Tree"));
	ptr.child.addLast(new Node("Binary Search Tree"));
	
}
void addgph(Node ptr) {
	
ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("Traversal Algorithm"));
	ptr.child.addLast(new Node("Implementation "));
}
void addarr(Node ptr) {
	
ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("1-D Array"));
	ptr.child.addLast(new Node("2-D Array"));
}
void addOpps(Node ptr) {
	
	ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("Inheritance"));
	ptr.child.addLast(new Node("Polymorphism"));
	ptr.child.addLast(new Node("Abstraction"));
	ptr.child.addLast(new Node("Encapsulation"));
}
void addlink(Node ptr){
	ptr.child=new LinkedList<>();
	ptr.child.addLast(new Node("React js"));
	ptr.child.addLast(new Node("Node js "));
}
void addBack(Node ptr){
	ptr.child=new LinkedList<>();
	ptr.child.addLast(new Node("JavaScript "));
	ptr.child.addLast(new Node("PHP"));
}
void addFront(Node ptr){
	ptr.child=new LinkedList<>();
	ptr.child.addLast(new Node("Html "));
	ptr.child.addLast(new Node("Css"));
}

void addWeb(Node ptr){
	ptr.child=new LinkedList<>();
	ptr.child.addLast(new Node("FrontEnd "));
	ptr.child.addLast(new Node("BackEnd"));
	ptr.child.addLast(new Node("Linking frontend and Backend"));
	for(Node a :ptr.child) {
		if(a.data.equalsIgnoreCase("FrontEnd ")) {
			addFront(a);
		}else if(a.data.equalsIgnoreCase("BackEnd")) {
			addBack(a);
		}else if(a.data.equalsIgnoreCase("Linking frontend and Backend")) {
			addlink(a);
		}
    }
}
void addProgLang(Node ptr) {
	
	ptr.child=new LinkedList<>();
	
	ptr.child.addLast(new Node("Variables and DataTypes"));
	ptr.child.addLast(new Node("Conditional Statements"));
	ptr.child.addLast(new Node("Loops "));
	ptr.child.addLast(new Node("Recursion "));
	ptr.child.addLast(new Node("Array "));
	for(Node a :ptr.child) {
		if(a.data.equalsIgnoreCase("Loops ")) {
			addLoop(a);
		}else if(a.data.equalsIgnoreCase("Array ")){
			addarr(a);
		}
	}
}
boolean isTrue(String un,String pwd) {
	return un.equals("admin") && pwd.equals("admin@123");
}
void create(Tree t) {
	Node ptr= t.root;
	ptr.child= new LinkedList<>();
	ptr.child.addLast(new Node("Basics of Programming Language"));
	ptr.child.addLast(new Node("Web Development"));
	ptr.child.addLast(new Node("Data Structures "));
	ptr.child.addLast(new Node("OOPS "));
	for(Node a : ptr.child){
		if(a.data.equalsIgnoreCase("Basics of Programming Language")) {
			addProgLang(a);
		}else if(a.data.equalsIgnoreCase("Web Development")) {
			addWeb(a);
		}else if(a.data.equalsIgnoreCase("Data Structures ")) {
			adddsa(a);
		}else if(a.data.equalsIgnoreCase("OOPS ")) {
			addOpps(a);
		}
	}
	path.put("While","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Do while","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("For","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Singly Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Doubly Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Singly Circular Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Queue Using Array","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Circular Queue","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("1-D Array","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("2-D Array","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Conditional Statements","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Recursion ","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Stack","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("N-ary Tree","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Binary Tree","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Binary Search Tree","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Heap","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Hashing","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Traversal Algorithm","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Implementation ","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Html ","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Css","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("JavaScript ","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("PHP","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("React js","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Node js ","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Inheritance","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Polymorphism","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Abstraction","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Encapsulation","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	

}
}
class DisplayMenu extends JFrame {
    static int idx = -1;

    DisplayMenu(LinkedList<Node> ptr) {
        setTitle("Select Your Choice");
        JPanel jp = new JPanel();
        int i = 1;

        for (Node a : ptr) {
            JButton b = new JButton(i + ") " + a.data);
            b.setPreferredSize(new Dimension(200, 70));
            jp.add(b);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JButton clickedButton = (JButton) e.getSource();
                    Character choice = clickedButton.getText().charAt(0);
                    String a = choice.toString();
                    System.out.println("Action performed index " + idx);
                    DisplayMenu.idx = Integer.parseInt(a);
                    setVisible(false);
                }
            });

            i++;
        }

        add(jp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
    }

    int getIndex() {
        return idx;
    }
}
//class DisplayMenu extends JFrame{
//	static int idx= -1;
//	JButton b;
//	DisplayMenu(LinkedList<Node> ptr){
//		setTitle("Select Your Choice");
//		JPanel jp = new JPanel();
//		int i=1;
//		
//		for(Node a:ptr) {
//		    b= new JButton(i+") "+a.data);
//			b.setPreferredSize(new Dimension(200, 70));
//			jp.add(b);
//			ActionListener b_listener = new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					Character choice = b.getText().charAt(0);
//					String a=choice.toString();
//					System.out.println("Action performed index"+ idx);
//					DisplayMenu.idx=Integer.parseInt(a);
//				}
//			};
//			b.addActionListener(b_listener);
//			i++;
//		}
//		 add(jp);
//		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	     setSize(400, 500);
//	     setVisible(true);
//	}
////	public void actionPerformed(ActionEvent e) {
////		Character choice = b.getText().charAt(0);
////		String a=choice.toString();
////		System.out.println("Action performed index"+ idx);
////		this.idx=Integer.parseInt(a);
////		
////	}
//	int getIndex(){
//		return idx;
//	}
//}
 class MyFrame extends JFrame{
	 static boolean admn=false;
	 Button b1;
	 Button b2;
    public MyFrame() {
    	
        setTitle("Choose The Type!");
        setSize(700, 700);
        
        JPanel jp= new JPanel();
        
         b1= new Button("Admin");
         b2= new Button("User");
        
        b1.setPreferredSize(new Dimension(200, 70));
        jp.add(b1);
        b2.setPreferredSize(new Dimension(200, 70));
        jp.add(b2);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(jp, gbc);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ActionListener button1Listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	admn=true;
                System.out.println("Admin");
                setVisible(false);
                //dispose();
            }
        };
        ActionListener button2Listener = new ActionListener() {          
            public void actionPerformed(ActionEvent e) {
                // Define the action for Button 2
                System.out.println("User");
                setVisible(false);
            }
        };
        b1.addActionListener(button1Listener);
        b2.addActionListener(button2Listener);   
    }
 }

  class LoginDemo extends JFrame implements ActionListener {
	   JPanel panel;
	   JLabel user_label, password_label, message;
	   JTextField userName_text;
	   JPasswordField password_text;
	   JButton submit, cancel;
	   LoginDemo() {
	      // Username Label
	      user_label = new JLabel();
	      user_label.setText("User Name :");
	      userName_text = new JTextField();
	      // Password Label
	      password_label = new JLabel();
	      password_label.setText("Password :");
	      password_text = new JPasswordField();
	      // Submit
	      submit = new JButton("SUBMIT");
	      panel = new JPanel(new GridLayout(3, 1));
	      panel.add(user_label);
	      panel.add(userName_text);
	      panel.add(password_label);
	      panel.add(password_text);
	      message = new JLabel();
	      panel.add(message);
	      panel.add(submit);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      // Adding the listeners to components..
	      submit.addActionListener(this);
	      add(panel, BorderLayout.CENTER);
	      setTitle("Please Login Here !");
	      setSize(450,350);
	      setVisible(true);
	   }
	   
	   @Override
	  public void actionPerformed(ActionEvent ae){
	      String userName = userName_text.getText();
	      String password = password_text.getText();
	      if (userName.trim().equals("admin") && password.trim().equals("admin")) {
	         message.setText(" Hello " + userName + "");
	      } else {
	         message.setText(" Invalid user.. ");
	      }
	   }
	}
  
public class Nary {

static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Tree t = new Tree();
        t.create(t);
        System.out.println("Login as:\n1. Admin\n2. User");
        MyFrame f=new MyFrame();
        
        while(f.isActive()) {
        	
        }
        if(MyFrame.admn) {
        	LoginDemo ld= new LoginDemo();
        	System.out.println("Enter Username :");
        	sc.nextLine();
        	String name = sc.nextLine();
        	System.out.println("Enter Password :");
        	String pass = sc.nextLine();
        	if(t.isTrue(name,pass)) {
        		System.out.println("Login Successfull !");
        		System.out.println("Add a new topic");
        		String topic = sc.nextLine();
        		t.add(topic);
        		String supp_link = sc.nextLine();
        		t.path.put(topic,supp_link);
        	}else {
        		System.out.println("Incorrect username/password!");
        	}
        }else  {
        
         while(true) {
        	 t.display();
        	 System.out.println("Do you want to explore more?");
        	 int c= sc.nextInt();
        	 if(c==0) {
        		 System.out.println("Thank You!");
        		 break;
        	 }
         }
        }
	}

}
