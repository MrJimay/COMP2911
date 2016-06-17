import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Set<String> set = new ConcreteSet<String>();
		Set<String> set2 = new ConcreteSet<String>();
		int alternate = 0;
		Scanner sc = null;
		try {
			// read input file
			sc = new Scanner(new FileReader(args[0]));
			// process the input until end of file
			while (sc.hasNextLine() && sc.hasNext()) {
				if (alternate == 0) {
					set.add(sc.nextLine());
					alternate = 1;
				} else {
					set2.add(sc.nextLine());
					alternate = 0;
				}
			}
			System.out.println("Printing set 1:");
			set.print();
			System.out.println("Printing set 2:");
			set2.print();
			System.out.println("Printing union of set 1 and set 2 (set 3):");
			Set<String> set3 = set.union(set2);
			set3.print();
			System.out.println("Printing intersection of set 1 and set 2 (set 4):");
			Set<String> set4 = set.intersection(set2);
			set4.print();
			Set<String> set5 = new ConcreteSet<String>();
			set5.add("is");
			System.out.println("Printing set 5:");
			set5.print();
			System.out.println("Checking equality:");
			System.out.println("set 4 equals set 4: " + set4.equals(set4));
			System.out.println("set 4 equals set 5: " + set4.equals(set5));
			System.out.println("set 5 equals set 4: " + set5.equals(set4));
			System.out.println("set 1 equals set 2: " + set.equals(set2));
		}
		catch (FileNotFoundException e) {}
		finally {
			// close scanner when done
		    if (sc != null) sc.close();
		}
	}

}
