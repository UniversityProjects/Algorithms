
public class TreeMain {

	public static void main (String[] args) {
		
		Tree tree = new Tree(5, new Tree(8,null,null), new Tree(90, new Tree(31,null,null), new Tree(43,new Tree(3,null,null),new Tree(3,null,null))));
		
		System.out.println ("----- Istanza Albero ----");
		
		System.out.println ("1) Numero Foglie = " + contaFoglie(tree));
		
		System.out.println ("2) Numero Occ. 3 = " + contaOccorrenze(tree,3));
		
		System.out.println ("3) Somma Pari = " + sommaPari(tree));
		
		System.out.println ("4) Profondità = " + deepTree(tree));
		
		System.out.println ("5) Max = " + maxTree(tree));
		
		
		System.out.println ("\n----- Istanza Albero  E Intero ----");
		
		System.out.println ("6) " + 91 + " Present = " + findInTree(tree,91));
		
		System.out.println ("7) " + 8 + " Equals Everything = " + equalInTree(tree,8));
		
		
		System.out.println ("\n----- Istanza Albero E Naturale (LV) ----");
		
		System.out.println ("8) Values At Level " + 3 + " : ");
		System.out.print("   ");
		printTreeAtN(tree,3,0);
		System.out.println();
		
		System.out.println ("9) " + 8 + " present At Level " + 2 + " = " + findInTreeAtN(tree,2,0,8));
		
		
	}
	
	
	// Conta Il Numero DI Foglie Dell'Albero
	public static int contaFoglie (Tree tree) {
		
		if (tree == null) {
			
			return 0;
			
		}
		
		if (tree.isLeaf()) {
			
			return 1;
			
		} else {
			
			int res_left = contaFoglie(tree.getLeft());
			
			int res_right = contaFoglie(tree.getRight());
			
			return (res_left+res_right);
			
		}
		
	}
	
	
	// Trova Quanti Elementi Dell'Albero Hanno Il Valore Uguale A K
	public static int contaOccorrenze (Tree tree, int k) {
		
		if (tree == null) {
			
			return 0;
			
		}
		
		if (tree.isLeaf()) {
			
			if (tree.getValue() == k) {
				
				return 1;
			
			} else {
				
				return 0;
				
			}
			
		} else {
			
			int res_left = contaOccorrenze(tree.getLeft(),k);
			
			int res_right = contaOccorrenze(tree.getRight(),k);
			
			return (res_left+res_right);
			
		}
		
	}
	
	
	// Somma I Valori Pari Dell'Albero
	public static int sommaPari (Tree tree) {
			
		if (tree == null) {
				
			return 0;
				
		}
			
		if (tree.isLeaf()) {
				
			if ((tree.getValue() % 2) == 0) {
					
				return tree.getValue();
				
			} else {
					
				return 0;
					
			}
				
		} else {
			
			int res_left = sommaPari(tree.getLeft());
			
			int res_right = sommaPari(tree.getRight());
			
			return (res_left+res_right);	
				
		}
			
	}
	
	
	// Ritorna La Profondità Dell'Albero
	public static int deepTree (Tree tree) {
				
		if (tree == null) {
					
			return 0;
					
		}
				
		if (tree.isLeaf()) {
					
			return 1;
					
		} else {
				
			int res_left = deepTree(tree.getLeft());
				
			int res_right = deepTree(tree.getRight());
				
			if (res_left >= res_right) {
					
				return (1+res_left);
					
			} else {
					
				return (1+res_right);
					
			}
				
		}
				
	}

	
	// Ritorna Il Massimo Dell'Albero
	public static int maxTree (Tree tree) {
				
		if (tree == null) {
					
			return -1;
					
		}
				
		if (tree.isLeaf()) {
					
			return tree.getValue();
					
		} else {
				
			int max = tree.getValue();
			
			int res_left = maxTree(tree.getLeft());
				
			int res_right = maxTree(tree.getRight());
				
			if (res_left >= max) {
					
				max = res_left;
					
			} 
			
			if ( res_right >= max) {
				
				max = res_right;
				
			}
			
			return max;
				
		}
				
	}
	
	
	// True Se k E' Uguale Al Valore Di Un Nodo
	public static boolean findInTree (Tree tree, int k) {
				
		if (tree == null) {
					
			return false;
					
		}
				
		if (tree.isLeaf()) {
			
			if (tree.getValue() == k) {
				
				return true;
			
			} else {
				
				return false;
				
			}
			
		} 
		
		if (tree.getValue() == k) {
			
			return true;
			
		} else {
			
			boolean res_left = findInTree(tree.getLeft(),k);
			
			boolean res_right = findInTree(tree.getRight(),k);
			
			return (res_left || res_right);
			
		}
				
	}

	
	// True Se Il Valore Di Ogni Nodo E' Uguale A k
	public static boolean equalInTree (Tree tree, int k) {
				
		if (tree == null) {
					
			return false;
					
		}
				
		if (tree.isLeaf()) {
			
			if (tree.getValue() == k) {
				
				return true;
			
			} else {
				
				return false;
				
			}
			
		} 
		
		if (tree.getValue() == k) {
			
			return true;
			
		} else {
			
			boolean res_left = equalInTree(tree.getLeft(),k);
			
			boolean res_right = equalInTree(tree.getRight(),k);
			
			return (res_left && res_right);
			
		}
				
	}
	
	
	// True Se Il Valore Di Ogni Nodo E' Uguale A k
	public static void printTreeAtN (Tree tree, int n, int i) {
					
		if (tree == null) {
						
			return;
						
		}
					
		if (i == n) {
				
			System.out.print(tree.getValue() + " ");
				
		} else {
			
			if (i<n) {
				
				int new_i = i+1;
				
				printTreeAtN (tree.getLeft(),n,new_i);
				
				printTreeAtN (tree.getRight(),n,new_i);
				
			} else {
				
				return;
				
			}
			
		}
					
	}


	// True Se Il Valore Di Ogni Nodo E' Uguale A k
	public static boolean findInTreeAtN (Tree tree, int n, int i, int key) {
					
		if (tree == null) {
						
			return false;
						
		}
					
		if (i == n) {
			
			if (tree.getValue() == key) {
				
				return true;
				
			} else {
				
				return false;
				
			}			
				
		} else {
			
			if (i<n) {
				
				int new_i = i+1;
				
				boolean res_left = findInTreeAtN(tree.getLeft(),n, new_i,key);
				
				boolean res_right = findInTreeAtN(tree.getRight(),n, new_i,key);
				
				return (res_left || res_right);
				
			} else {
				
				return false;
				
			}
			
		}
					
	}
		
}
