package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;

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
	    Explore exp= new Explore();
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
            while(dm.isActive()){	
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
	path.put("Graph","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Do while","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("For","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Singly Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Doubly Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Singly Circular Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
	path.put("Doubly Circular Linked List","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");
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
	path.put("Variables and DataTypes","C:\\Users\\Sweta Thakre\\Downloads\\654_assgn_DLS.pdf");

}
}
public class Nary {

static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Tree t = new Tree();
        t.create(t);
        Myframe f=new Myframe();
       
        if(Myframe.admn) {
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
