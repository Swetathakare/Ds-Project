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
	
	Node(String data){
		this.data= data;
	}
}
class Tree extends JFrame {
	
	static HashMap<String, String> path = new HashMap<>(); 
	
	static Scanner sc= new Scanner(System.in);
	
	Node root= new Node("Main Topic");
	
	void add() {

		addFrame af = new addFrame(root);
		af.setVisible(false);
		
		Node ptr = root;

		while (!af.isAdded) {
			addFrame n =null;
			if (af.userChoice != -1) {
				
				int i = 0;
				// n = new addFrame(ptr);
				for (Node a : ptr.child) {
					System.out.println(a.data);
					if (af.userChoice == i) {
						ptr = a;
						 af = new addFrame(ptr);
						break;
					}
					i++;
				}
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
            displayMenu dm = new displayMenu(ptr.child);
            while(dm.isActive()){	
            }
            int index= dm.getIndex();
            
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
		}
	}
}
void addTree(Node ptr) {
    ptr.child=new LinkedList<>();
	ptr.child.addLast(new Node("N-ary Tree"));
	ptr.child.addLast(new Node("Binary Tree"));
	ptr.child.addLast(new Node("Binary Search Tree"));
	
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
	path.put("While","While.java");
	path.put("Graph","Java Graph.pdf");
	path.put("Do while","Do while.pdf");
	path.put("For","For.pdf");
	path.put("Singly Linked List","Singly.pdf");
	path.put("Doubly Linked List","Doubly.pdf");
	path.put("Singly Circular Linked List","Circular Singly.pdf");
	path.put("Doubly Circular Linked List","Circular Doubly.pdf");
	path.put("Queue Using Array","Queue Array.pdf");
	path.put("Circular Queue","Circular Queue.pdf");
	path.put("1-D Array","1d.pdf");
	path.put("2-D Array","2d.pdf");
	path.put("Conditional Statements","conditional.pdf");
	path.put("Recursion ","recursion.pdf");
	path.put("Stack","Java Stack.pdf");
	path.put("N-ary Tree","Nary.pdf");
	path.put("Binary Tree","Nary.pdf");
	path.put("Binary Search Tree","BST.pdf");
	path.put("Heap","Java heap.pdf");
	path.put("Hashing","Java hashing.pdf");
	path.put("Html ","HTML.pdf");
	path.put("Css","CSS.pdf");
	path.put("JavaScript ","javaScript.pdf");
	path.put("PHP","PHP.pdf");
	path.put("React js","ReactJS.pdf");
	path.put("Node js ","Nodejs.pdf");
	path.put("Inheritance","java Inheritance.pdf");
	path.put("Polymorphism","Java Polymorphism.pdf");
	path.put("Abstraction","java_abstraction.pdf");
	path.put("Encapsulation","Java Encapsulation.pdf");
	path.put("Variables and DataTypes","Variables.pdf");

}
}
public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree t = new Tree();
		t.create(t);
		while (true) {
			
			 Myframe f = new Myframe();

			if (Myframe.admn) {
				
                LoginScreen ls = new LoginScreen();
				if (LoginScreen.isValid) {
					adddelete chosen = new adddelete();
					if (chosen.userchoice.equals("add")) {
						System.out.println("reached ");

						t.add();
					}
				  }
			    }else {
				t.display();
			}
			ExpMore em = new ExpMore();
		
			if (em.choice == 0) {
				 continue;
			}else {
				ThankYou ty = new ThankYou();
				 break;
			}

		}
	}

}
