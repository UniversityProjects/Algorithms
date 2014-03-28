
import java.util.Scanner;

public class DivideEtImpera1 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int dim = 0;
		
		int result = 0;
		
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
				result = f_1(array,0,dim);
				System.out.println ("Massimo = " + result);
				break;
		
			case 2:
				result = f_2(array,0,dim);
				System.out.println (" = " + result);
				break;
		
			case 3:
				result = f_3(array,0,dim);
				System.out.println ("Somma_Alternata: " + result);
				break;
		
			case 4:
				result = f_4(array,0,dim);
				System.out.println ("Numero Elementi Con Successore Identico: " + result);
				break;
			
			case 5:
				result = f_5(array,0,dim);
				System.out.println ("Numero Elementi Uguali A 4 Con Successore Identico: " + result);
				break;
			
		}
		
	}
	
	// Menu
	public static int menu () {
		
		int choice = 0;
		
		Scanner kb = new Scanner(System.in);
		
		do {
			
			System.out.println ("Scegli L'opzione Desiderata:\n");
			
			System.out.println ("1) Massimo Del Vettore");
			
			System.out.println ("2) Quante volte 3 è presente");
			
			System.out.println ("3) Somma Alternata");
			
			System.out.println ("4) NUmero Elementi Seguiti Da Identici");
			
			System.out.println ("5) 4) NUmero Elementi Uguali A 3 Seguiti Da Identici");
			
			System.out.print ("Scelta: ");
			choice = kb.nextInt();
			kb.nextLine();
			
			System.out.println ("");
			
		} while (choice<1 && choice>5);
		
		return choice;
		
	}

	// Ritorna Il Massimo Dell'Array
	public static int f_1 (int array[],int index, int dim) {
		
		if (index == dim - 1) {
			
			return array[index];
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			int max_1 = f_1 (array,index,m);
			
			int max_2 = f_1 (array,m+1,dim);
			
			if (max_1 > max_2) {
				
				return max_1;
				
			} else {
				
				return max_2;
				
			}
					
			
		}
	}

	// Ritorna Quante volte 3 appare nell'array
	public static int f_2 (int array[],int index,int dim) {
		
		if (index == dim-1) {
			
			if (array[index] == 3) {
				
				return 1;
				
			} else {
				
				return 0;
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			int k_1 = f_2 (array,index,m);
			
			int k_2 = f_2 (array,m+1,dim);
			
			return (k_1+k_2); 
			
		}
		
	}

	// Ritorna la somma alternata V1 - V2 + V3 ...
	public static int f_3 (int array[],int index,int dim) {
		
		if (index == dim -1 ) {
			
			if ((index%2) == 0) {
				
				return array[index];
			
			} else {
				
				return -array[index];
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			int res_1 = f_3 (array,index,m);
			
			int res_2 = f_3 (array,m+1,dim);
			
			if ((index%2)==0) {
				
				return array[index]+res_1+res_2;
				
			} else {
				
				return -array[index]+res_1+res_2;
				
			}
			
		}
			
			
		
	}

	// Ritorna Quante volte un elemento è seguito da uno identico
	public static int f_4 (int array[], int index, int dim) {
		
		if (index == dim -1) {
			
			return 0; 
			
		}
		
		if (index == dim -2) {
			
			if (array[index] == array[index+1] ) {
				
				return 1;
				
			} else {
				
				return 0;
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			int res_1 = f_4 (array,index,m);
			
			int res_2 = f_4 (array,m+1,dim);
			
			if (array[m] == array[m+1]) {
				
				return (1+res_1+res_2);
				
			} else {
				
				return (res_1+res_2);
				
			}
			
		}
		
	}

	// Ritorna quante volte un elemento uguale a 3 ha come successivo 3
	public static int f_5 (int array[], int index, int dim) {
		
		if (index == dim-1) {
			
			return 0;
			
		}
		
		if ( index == (dim-2) ) {
			
			if (array[index] == 3 && array[index+1] == 3) {
				
				return 1;
				
			} else {
				
				return 0;
				
			}
			
		} else {
			
			int m = (int) (index+dim-1)/2;
			
			int res_1 = f_5 (array,index,m);
			
			int res_2 = f_5 (array,m+1,dim);
		
			if (array[m] == 3 && array[m] == array[m+1]) {
				
				return (1+res_1+res_2);
				
			} else {
				
				return (res_1+res_2);
				
			}
			
		}
		
	}
	
}
