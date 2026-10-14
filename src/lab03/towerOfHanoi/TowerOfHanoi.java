package lab03.towerOfHanoi;
import java.util.Scanner;

public class TowerOfHanoi {
 
	private static int count = 0;
	
	public static void moveDisks(int n,char fromTwr, char toTwr, char auxTwr) {
	  if (n==1) {
		  count++;
		  System.out.println("Move disk " + n + " from " + fromTwr + " to " + toTwr);
		  return;
	  }
	  
	  moveDisks(n-1, fromTwr, auxTwr, toTwr);
	  count++;
	  System.out.println("Move disk " + n + " from " + fromTwr + " to " + toTwr);
	  moveDisks(n-1, auxTwr, toTwr, fromTwr);
	}
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of disks: ");
		
		int n = input.nextInt();
		input.close();
		
		System.out.println("\nThe moves are:" );
		moveDisks(n, 'A', 'B', 'C');
		
		System.out.println("\nThe total number of the moves is " + count + ".");
		
	}
}
