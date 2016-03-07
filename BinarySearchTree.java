/**
 * CSC115 Assignment 4 : PatientLocation
 * BinarySearchTree.java
 * Created for use by CSC115 Spring2016 
 * Name: Daniel Olaya Moran
 * ID: V00855054
 * Date: March 05, 2016 
*/
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	int count = 0;
	/**
	 * Create an empty BinarySearchTree.
	 */

	public BinarySearchTree() {
		super();
	}
	/**
	*Inserts a new item into the tree, maintaining its order. If the item already exists in the tree, nothing happens.
	* @item: The newest item
	*/
	public void insert (E newItem){
		//System.out.println(this.root);
		TreeNode<E> newNode = new TreeNode<E> (newItem);
		TreeNode<E> current = root;
		TreeNode<E> parent = null;

		while (current != null){
			parent = current;
			//System.out.println();
			//System.out.println("New item is: " + newItem.toString());
			//System.out.println("Current is: " + current.item);
			if (newItem.compareTo(current.item) < 0 ){
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (root == null){
			root = newNode;
		}
		else if (newItem.compareTo(parent.item) < 0) {
			//System.out.println("LEFT Current Item: " +  current.item + "current.item.compareTo(newItem)" + (current.item.compareTo(newItem) < 0 ) );
			//System.out.println("LEFT Newnode " + newNode.item);
			//System.out.println("LEFT parent " + parent.item);
			//System.out.println("current" + current.item);
			//System.out.println("LEFT parent.item.compareTo(newItem) " + (parent.item.compareTo(newItem)));	
			parent.left = newNode;
		} else {
			//System.out.println("LEFT Current Item: " +  current.item + "current.item.compareTo(newItem)" + (current.item.compareTo(newItem) < 0 ) );
			//System.out.println("RIGHT Newnode" + newNode.item);
			//System.out.println("RIGHT parent" + parent.item);
			//System.out.println("current" + current.item);
			//System.out.println("RIGHT parent.item.compareTo(newItem) " + (parent.item.compareTo(newItem)));
			parent.right = newNode;
		}
		count ++;
	}
	/**
	*Looks for the item in the tree that is equivalent to the key.
	* @param: key - The item that is equivalent to the item we are looking for. Equality is determined by the equals method of the item.
	* @return: - The item if it's in the tree, null if it is not.
	*/
	public E retrieve (E key){
		TreeNode<E> current = root;
		TreeNode<E> parent = root;
		//System.out.println("\n====RETRIEVE TARGET====== " + key );
		if (root != null){
			while (current != null){
				parent = current;
				//System.out.println("Curr: " + current.item + " Curr = Key?: " + current.item.equals(key));
				if (current.item.equals(key)){
					//System.out.println("I FOUND IT! " + current.right + "   " + current.left);
					return current.item;
				}
				else if (key.compareTo(parent.item)<  0){
					//System.out.println("LEFT, parent: " + parent.item + " current: " + current.item);
					current = parent.left;
				}else {
					//System.out.println("RIGHT, parent: " + parent.item + " current: " + current.item);
					current = parent.right;
				}
			}
		}
		return null;
	}
	/*
	* Finds the item that is equivalent to the key and removes it, 
	* if it's in the tree.
	*/
	public void delete (E key){
		TreeNode<E> current = root;
		TreeNode<E> parent = root;

		if (root == null){ //if tree is empty
			throw new RuntimeException ("Tree is empty");
		} else {
			if (retrieve(key) == null){ //if item is not on the list
				throw new RuntimeException ("Item is not on the list");
			} else { //finds the key to delete
				current = root;
				while (current != null){
					parent = current;
					//System.out.println("PARENT: " + parent.item + " CURRENT: " + current.item + " KEY: " + key );
					//System.out.println("parent.right: " + parent.right.item);
					//System.out.println("parent.left: " + parent.left.item);

					//traversing until item is found
					if (key.compareTo(parent.item)<  0){
						current = parent.left;
					}else {
						current = parent.right;
					}

					//item to delete is a leaf
					if ((current.right == null && current.left == null)
					&& (current.item.equals(key) || current.item.equals(key)) ){ 
						System.out.println("=======Item to delete is LEAF========");
						System.out.println("Current is: " + current.item );
						System.out.println("Parent is:" + parent.item);
						System.out.println("Key is:" + key);
						if (parent.right.item == key){
							parent.right = null;
						}else {
							parent.left = null;
						}
					break;
					}

					//item to delete has one child
					if ((current.right == null || current.left == null)
					&& (current.item.equals(key) || current.item.equals(key)) ){ 
						System.out.println("=======Item to delete 1 child========");
						System.out.println("Current is: " + current.item );
						System.out.println("Parent is:" + parent.item);
						System.out.println("Key is:" + key);
						if (current.left != null){
							parent.left = current.left;
						} else {
							parent.right = current.right;
						}
					break;
					}
				}
			}
		}

	}
// me quede tratando de arreglar la doble eliminacion en una leaf




 	/******* COMPLETE MISSING METHODS HERE *******/


	/*
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	 
	public ArrayList<E> inOrder() {
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}*/

/*
 * NOTE TO STUDENT.
 * This recursive method is the one that does the work
 * of traversing the tree in order and placing items
 * into the list.
 * /
	private void collectInOrder(ArrayList<E> list, TreeNode<E> node) {
 		/******* COMPLETE *******/
	//}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
/*
 * NOTE TO STUDENT:
 * Something to get you started...
 * Uncomment as you go, then continue testing.
 */


		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();
		
		PatientLocation p00 = new PatientLocation("Janet", "Janet", 338);
		PatientLocation p01 = new PatientLocation("Bob", "Bob",116);
		PatientLocation p02 = new PatientLocation("Alan", "Alan",422);
		PatientLocation p03 = new PatientLocation("Ellen", "Ellen",454);
		PatientLocation p04 = new PatientLocation("Tom", "Tom",121);
		PatientLocation p05 = new PatientLocation("Karen", "Karen",121);
		PatientLocation p06 = new PatientLocation("Wendy", "wendy",121);


		tree.insert(p00);
		tree.insert(p01);
		tree.insert(p02);
		tree.insert(p03);
		tree.insert(p04);
		//tree.insert(p05);
		tree.insert(p06);
		

		//tree.delete(p00);
		//tree.delete(p01);
		//tree.delete(p02);
		//tree.delete(p03);
		tree.delete(p04);
		//tree.delete(p05);
		tree.delete(p06);

		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();

		/*
		PatientLocation p4 = new PatientLocation("Newman","Alfred",607);
		tree.insert(p4);
		tree.insert(p3);
		tree.insert(p2);
		ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		// draw the tree in its current state:

*/
	}

}
