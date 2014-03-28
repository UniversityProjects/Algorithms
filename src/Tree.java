public class Tree {

	private Tree left;
	private Tree right;
	private int value;
		
	
	// Constructor
	public Tree (int i, Tree a, Tree b) {
		
		this.left = a;
		this.right = b;
		this.value = i;
		
	}

	
	// Return Tree Left
	public Tree getLeft() {
	
		return left;
	
	}
	
	
	// Set Tree Left
	public void setLeft(Tree left) {
	
		this.left = left;
	
	}

	
	// Return Tree Right
	public Tree getRight() {

		return right;
	
	}

	
	// Set Tree Right
	public void setRight(Tree right) {

		this.right = right;
	
	}

	
	// Return The Value Of The Root
	public int getValue() {
	
		return value;
	
	}

	
	// Set The Value Of The Root
	public void setValue(int value) {
	
		this.value = value;
	
	}
	
	
	// Count The Nodes Of The Tree
	public int countNodes(){
		
		if (this == null) {
		
			return 0;
		
		} else {
		
			return ((this.getLeft().countNodes()) + this.getRight().countNodes() + 1);
		
		}
		
	}
	
	
	// Verify If The Root Of This Tree Has Any Sons (Is A Leaf)
	public boolean isLeaf () {
		
		if ((this.left == null) && (this.right == null)) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	
	// Counts The Leafs Of This Tree
	public int countLeafs () {
		
		if (this == null) {
			
			return 0;
			
		}
		
		if (this.isLeaf()) {
			
			return 1;
			
		} else {
			
			int res_left = this.left.countLeafs();
			
			int res_right = this.right.countLeafs();
			
			return (res_left+res_right);
			
		}
		
	}
	
	
	// Returns The Height Of The Tree (Number Of Nodes In The Maximum Walk)
	public int heightTree () {
				
		if (this == null) {
					
			return 0;
					
		}
				
		if (this.isLeaf()) {
					
			return 1;
					
		} else {
				
			int res_left = this.left.heightTree();
				
			int res_right = this.right.heightTree();
				
			if (res_left >= res_right) {
					
				return (1+res_left);
					
			} else {
					
				return (1+res_right);
					
			}
				
		}
				
	}


	// Returns The Deep Of The Tree (Number Of Arcs In The Maximum Walk)
	public int deepTree () {
				
		if (this == null) {
					
			return 0;
					
		}
				
		if (this.isLeaf()) {
					
			return 1;
					
		} else {
				
			return (this.heightTree() - 1 );
					
		}
				
	}

	
	// Return True If key Belong To The Current Tree
	public boolean findInTree (int key) {
				
		if (this == null) {
					
			return false;
					
		}
				
		if (this.isLeaf()) {
			
			if (this.getValue() == key) {
				
				return true;
			
			} else {
				
				return false;
				
			}
			
		} 
		
		if (this.getValue() == key) {
			
			return true;
			
		} else {
			
			boolean res_left = this.left.findInTree(key);
			
			boolean res_right = this.right.findInTree(key);
			
			return (res_left || res_right);
			
		}
				
	}

	
}
