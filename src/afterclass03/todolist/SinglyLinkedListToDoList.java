package afterclass03.todolist;



public class SinglyLinkedListToDoList {
	
   public static class Node{
	   String task;
	   Node next;
	   
	   public Node(String task) {
		   this.task=task;
		   this.next=null;
	   }
   }
   
   private Node head;
   private int size;
   
   public SinglyLinkedListToDoList() {
	   head = null;
	   size = 0;
   }
   
   public void addItem(String task) {
	   Node newNode = new Node(task);
	   
	   if(head == null) {
		  head = newNode;
		  size++;
		  return;
	   }
	   else {
	   Node current = head;
	   while(current.next != null) {
		   current = current.next;
	   }
	   current.next = newNode;
	   }
	   size++;
	   System.out.println("Item added: " + task);
	   
   }
   
   public void removeItem(int index) {
	   if(index <0 || index >= size) {
		   System.out.println("Invalid index!");
		   return;
	   }
	   
	   else if(index == 0) {
		   head = head.next;
		   size--;
		   return;
	   }
	   
	   else {
		   Node current = head;
		   for(int i=0; i<index-1; i++) {
			   current = current.next;   
		   }
		   
		   current.next=current.next.next;
		   size--;
		   
	   }
   }
   
   public void displayItems() {
	  if(head == null) {
		  System.out.println("To-do list is empty!");
		  return;
	  }
	  
	  Node current = head;
	  int i = 0;
	  while(current != null) {
		  System.out.println(i + ". " + current.task);
		  current = current.next;
		  i++;
	  }
	  
	  System.out.println("Total items: " + size);
   }
   
   public static void main(String [] args) {
	   SinglyLinkedListToDoList list = new SinglyLinkedListToDoList();
	   list.addItem("Study Data Structure");
	   list.addItem("Pay electricity bill");
	   list.addItem("Go to gym");
	   
	   System.out.println("--- Current List ---");
	   list.displayItems();
	   
	   System.out.println("\n--- Removing item at index 1 (Pay electricity bill) ---");
	   list.removeItem(1);
	   list.displayItems();
	   
	   System.out.println("\n--- Removing item at index 0 (Head removal) ---");
	   list.removeItem(0);;
	   list.displayItems();
   }
}

