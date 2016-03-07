/**
 * CSC115 Assignment 4 : PatientLocation
 * BinaryTree.java
 * Created for use by CSC115 Spring2016 
 * Name: Daniel Olaya Moran
 * ID: V00855054
 * Date: March 05, 2016 
*/
 
public class BinaryTree<E> {

	/* The root is inherited by any subclass
	 * so it must be protected instead of private.
	 */
	protected TreeNode<E> root;

	/**
	 * Create an empty BinaryTree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Create a BinaryTree with a single item.
	 * @param item The only item in the tree.
	 */
	public BinaryTree(E item) {
		root = new TreeNode<E>(item);
	}

	/**
	 * Used only by subclasses and classes in the same package (directory).
	 * @return The root node of the tree.
	 */
	protected TreeNode<E> getRoot() {
		if (root == null){
			throw new RuntimeException ("The tree is empty");
		} else {
			return root;
		}
	}
	/**
	 * @return The height of the tree. The textbook's definition of the height is the maximum number of nodes from the root to a leaf node. 
	 * The height of an empty tree is therefore equal to 0.
	 */
	public int height (){
		if (root == null){
			return 0;
		} else {
			return 9; // *********COMPLETE
		}

	}
	/**
	 * @return True if the tree is empty..
	 */
 	public boolean isEmpty(){
 		return root == null;
 	}

 	/**
	 * Removes all the nodes from the tree, making it empty.
	 */
 	public void makeEmpty(){
 		root = null;
 	}

 	/**
 	* 	------------Internal methods-------------------
 	*/
 	public void setRootItem (E newItem){

 	}
/*
 	public static void attach (String newish, BinaryTree<String> parent){
 		TreeNode newItem = new TreeNode (newish);
 		//ystem.out.println(parent.toString());
 	
 		if (parent.getRoot().left == null){
 			parent.getRoot().left = newItem;
 		}else {
 				parent.getRoot().right = newItem;
 		}
 		

 		if (parent.getRoot().left == null && parent.getRoot().right == null){
 			throw new RuntimeException ("The node has two children already.");
 		} 
		
 	}
 	
 	public void attachLeft (E newItem){
 	}

 	public void attachRight (E newItem){
 	}

 	public void attachLeftSubtree (BinaryTree<E> leftSubtree) throws RuntimeException {
 	}

 	public void detachRightSubtree (BinaryTree<E> rightSubtree) throws RuntimeException {
 	}

 	public void detachLeftSubtree (BinaryTree<E> leftSubtree) throws RuntimeException {
 	}
 	

 	//Internal tester
 	public static void main(String[] args) {

 		BinaryTree<String> a = new BinaryTree<String> ("Comp Sci");
 		//TreeNode<String> b = new TreeNode<String> ("110");
 		//BinaryTree<String> c = new BinaryTree<String> ("115");
 		//BinaryTree<String> d = new BinaryTree<String> ("106");
 		attach("110",a);
 		attach("222",)
 		DrawableBTree<String> picture = new DrawableBTree<String>(a);
		picture.showFrame();
 	}
 	*/
}

	
