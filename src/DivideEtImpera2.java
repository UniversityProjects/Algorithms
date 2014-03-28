
import java.util.Scanner;

public class DivideEtImpera2 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int dim = 0;
		
		int x = 0;
		
		System.out.println("Inserisci Il Numero Intero");
		x = kb.nextInt();
		kb.nextLine();
		
		boolean result = false;
		
		do {
	
			System.out.println("Inserisci La Dimensione Del Vettore");
			dim = kb.nextInt();
			kb.nextLine();
		
			if (dim <= 0) {
			
				System.out.println ("Error: Numero Negativo!!!");
			
			}
	
		} while (dim < 0);
		
		int[] array = new int[dim];
		
		for (int i = 0; i < dim; i++) {
			
			System.out.print ("array[" + i + "] = ");
			array[i] = kb.nextInt();
			kb.nextLine();
			
		}
		
		int scelta = menu();
		
		switch (scelta) {
	
			case 1:
				result = f_1(array,0,dim-1,x);
				System.out.println ("X Appartiene All'Array = " + result);
				break;
		
			case 2:
				result = f_2(array,0,dim-1,x);
				System.out.println ("V[i+1] = V[i]+X = " + result);
				break;
		
			case 3:
				result = f_3(array,0,dim-1,x);
				System.out.println ("Ogni Valore Dell'Array E' Uguale A X: " + result);
				break;
		
			case 4:
				result = f_4(array,0,dim-1,x);
				System.out.println ("Per Ogni I  V[i+1] = V[i]+X = " + result);
				break;
						
		}
		
	}
	
	// Menu
	public static int menu () {
		
		int choice = 0;
		
		Scanner kb = new Scanner(System.in);
		
		do {
			
			System.out.println ("Scegli L'opzione Desiderata:\n");
			
			System.out.println ("1) X Appartiene All'Array");
			
			System.out.println ("2) V[i+1] = V[i]+X");
			
			System.out.println ("3) Ogni Valore Dell'Array E' Uguale A X");
			
			System.out.println ("4) Per Ogni I  V[i+1] = V[i]+X");
			
			System.out.print ("Scelta: ");
			choice = kb.nextInt();
			kb.nextLine();
			
			System.out.println ("");
			
		} while (choice<1 && choice>4);
		
		return choice;
		
	}

	
	public static boolean f_1 (int array[], int index, int dim, int x) {
		
		if (index == dim) {
			
			if (array[index] == x) {
				
				return true;
			
			} else {
				
				return false;
				
			}
			
		} else {
			
			int m = (int) (index+dim)/2;
			
			boolean r_1 = f_1 (array,index,m,x);
			
			boolean r_2 = f_1 (array,m+1,dim,x);
			
			return (r_1 || r_2);
					
			
		}
		
	}

	
	public static boolean f_2 (int array[],int index, int dim, int x) {
		
		if (index == dim-1) {
			
			return false;
				
		}
		
		if ( index == dim-2) {
			
			if (array[index]+x == array[index+1]) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			boolean r_1 = f_2 (array,index,m,x);
			
			boolean r_2 = f_2 (array,m+1,dim,x);
			
			if ( array[m]+x == array[m+1]) {
				
				return true;
				
			} else {
				
				return (false || (r_1 || r_2));
				
			}
			 
			
		}
		
	}


	public static boolean f_3 (int array[],int index, int dim, int x) {
		
		if (index == dim -1 ) {
			
			if (array[index] == x) {
				
				return true;
			
			} else {
				
				return false;
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			boolean r_1 = f_3 (array,index,m,x);
			
			boolean r_2 = f_3 (array,m+1,dim,x);
			
			return (r_1 && r_2);
			
		}			
		
	}

	
	public static boolean f_4 (int array[],int index, int dim, int x) {
		
		if (index == dim -1) {
			
			return false; 
			
		}
		
		if (index == dim -2) {
			
			if (array[index]+x == array[index+1] ) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			boolean r_1 = f_1 (array,index,m,x);
			
			boolean r_2 = f_1 (array,m+1,dim,x);
			
			if (array[m]+x == array[m+1]) {
				
				return (true && (r_1 && r_2));
				
			} else {
				
				return false;
				
			}
			
		}
		
	}

	
}

