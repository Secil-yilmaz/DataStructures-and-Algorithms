package afterclass03.todolist;

public class ArrayToDoList {
   private String[] items;
   private int size;
   
   
   public ArrayToDoList() {
	   items = new String[10];
	   size = 0;
   }
   
   public void addItem(String item) {
	   if(size == items.length) {
		  System.out.println("List is full!");
		  return;
	   }
	   
		   items[size]=item;
		   size++; 
		   System.out.println("Item added: " + item);
   }
   
   public void removeItem(int index) {
	 if(index < 0 || index >= size) {
		System.out.println("Invalid index: " + index);
		return;
	 }
	 
	 String removedItem = items[index];
	 
	 for(int i = index; i < size-1; i++) {
		 items[i] = items[i+1];
		  
	 }
	 
	 items[size - 1] = null;
	 size--;
	 
	 System.out.println("Item removed: " + removedItem);
   }
   
   public void displayItem() {
	   if (size == 0) {
		   System.out.println("To-do list is empty!");
		return;
	   }
	   
	   System.out.println("To-do list: ");
	   
	   for(int i=0; i< size; i++) {
		   System.out.println(i + ". " + items[i]);  
	   }
	   
	   System.out.println("Total items: " + size);
   }
   
   public static void main(String [] args) {
	   ArrayToDoList myList = new ArrayToDoList();
	   
	   myList.addItem("Study");
	   myList.addItem("Pay bill");
	   myList.addItem("Do sport");
	   
	   myList.displayItem();
	   
	   myList.removeItem(1);
	   
	   myList.displayItem();
   }
}
