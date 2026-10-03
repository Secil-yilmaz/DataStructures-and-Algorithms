package afterclass03.todolist;

public class DoublyLinkedListToDoList {

    
    public static class Node {
        String task;
        Node next;
        Node prev;

        public Node(String task) {
            this.task = task;
            this.next = null;
            this.prev = null;
        }
    } 

    
    private Node head;
    private int size;

   
    public DoublyLinkedListToDoList() {
        head = null;
        size = 0;
    }

   
    public void addItem(String task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            newNode.prev = current;
        }

        size++;
        System.out.println("Item added: " + task);
    }

   
    public void removeItem(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;

            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }

        size--;
    }

    
    public void displayItems() {
        if (head == null) {
            System.out.println("To-do list is empty!");
            return;
        }

        System.out.println("To-do list:");
        Node current = head;
        int index = 0;

        while (current != null) {
            System.out.println(index + ". " + current.task);
            current = current.next;
            index++;
        }

        System.out.println("Total items: " + size);
    }

   
    public static void main(String[] args) {
        DoublyLinkedListToDoList list = new DoublyLinkedListToDoList();

        list.addItem("Finish the Data Structures assignment.");
        list.addItem("Buy coffee");
        list.addItem("Rest");

        System.out.println("--- Initial state ---");
        list.displayItems();

        System.out.println("\n--- The element at index 1 is being deleted. ---");
        list.removeItem(1);
        list.displayItems();

        System.out.println("\n--- The first element is being deleted. ---");
        list.removeItem(0);
        list.displayItems();
    }
}