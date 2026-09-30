package lab02.todolist;

import java.util.Scanner;
import java.io.*;


public class SinglyLinkedListBasedToDoList {
  
   private class Node {
      String task; 
      Node next;

      
      Node(String task) {
         this.task = task;
         next = null;
      }
   }

  
   private Node head; 
   private int count; 

   
   public SinglyLinkedListBasedToDoList() {
      head = null;
      count = 0;
   }

  
   public void addTask(String task) {
      Node newNode = new Node(task);
      
      if(head == null) {
    	 head = newNode;
    	 
      }
      else 	{
    	 Node current = head;
    	 
    	 while(current.next != null) {
    		 current = current.next;
    	 }
    	 
    	 current.next = newNode;
    	
      }
      
      count++;
      System.out.println("Task added: " + task);
   }

  
   public void removeTask(int position) {
      if(position<1 || position > count){
        System.out.println("Invalid task number: " + position);
        return;
      }
      
      String removeTask;
      if(position == 1) {
    	  removeTask = head.task;
    	  head = head.next;
      }
      
      else {
    	  Node current = head; 
    	  for(int i = 1; i <position-1; i++) {
    		  current = current.next;
    	  }
    	  
    	  removeTask = current.next.task;
    	  current.next = current.next.next;
      }
      
      count--; 
      System.out.println("Task removed: " + removeTask);
   }

  
   public void displayTasks() {
      if(head == null) {
    	  System.out.println("To-do list is empty!");
    	  return;
      }
      
      System.out.println("To-do list:");
      Node current = head;
      int taskNumber = 1;
      
      while(current != null) {
    	  System.out.println(taskNumber + ". " + current.task);
    	  current = current.next;
    	  taskNumber++;
      }
      
      System.out.println("Total tasks: " + count);
   }

  
   public void saveTasks(String filename) {
     
      if (count == 0) {
         System.out.println("To-do list is empty! No tasks to save.");
         return; 
      }
     
      try {
         File file = new File(filename);
         PrintWriter output = new PrintWriter(file);
        
         Node current = head; 
         while (current != null) { 
            output.println(current.task);
            current = current.next; 
         }
         output.close(); 
       
         System.out.println("Tasks saved to " + filename);
      } catch (Exception e) {
         
         System.out.println("Error saving tasks to file: " + e.getMessage());
      }
   }

   
   public void loadTasks(String filename) {
      
      try {
         File file = new File(filename);
         Scanner input = new Scanner(file);
         
         while (input.hasNextLine()) {
            String task = input.nextLine();
            addTask(task);
         }
         input.close();
         if (count != 0)
         
            System.out.println("Tasks loaded from " + filename);
        
         else
       
            System.out.println("No tasks in file: " + filename);
      } catch (Exception e) {
         
         System.out.println("Error loading tasks from file: " + e.getMessage());
      }
   }

   
   public static void main(String[] args) {
    
      SinglyLinkedListBasedToDoList toDoList = new SinglyLinkedListBasedToDoList();
      
      toDoList.loadTasks("tasks.txt");

      
      Scanner scanner = new Scanner(System.in);
      int choice;
   
      do {
      
         System.out.println("\nTo-Do List Menu:");
         System.out.println("1. Add task");
         System.out.println("2. Display tasks");
         System.out.println("3. Remove task");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");

        
         choice = scanner.nextInt();
         scanner.nextLine(); 

        
         System.out.println();
         switch (choice) {
            case 1:
               System.out.print("Enter the task description: ");
               String task = scanner.nextLine();
               toDoList.addTask(task);
               break;
            case 2:
               toDoList.displayTasks();
               break;
            case 3: 
               System.out.print("Enter the task number to remove: ");
               int taskNumber = scanner.nextInt();
               toDoList.removeTask(taskNumber);
               break;
            case 4:
               toDoList.saveTasks("tasks.txt");
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid option. Please try again.");
         }

      } while (choice != 4);

      
      scanner.close();
   }
}
