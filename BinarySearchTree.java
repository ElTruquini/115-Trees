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
		//TreeNode<E> temp;

		if (root == null){ //if tree is empty
			throw new RuntimeException ("Tree is empty");
		} else {
			if (retrieve(key) == null){ //if item is not on the list
				throw new RuntimeException ("Item is not on the list");
			} else { //finds the key to delete
				current = root;
				//=======Item to delete is root========
				if (root.item.equals(key)){
					//System.out.println("==Deleting root==");
					deleteRoot(key);


				}
				while (current != null && !root.item.equals(key)){


					//=======Item to delete is LEAF========
					if ((current.right == null && current.left == null)
					&& (current.item.equals(key) ) ){ 
						//System.out.println("==Deleting leaf==");
						deleteLeaf(key);
						break;
					}

					//=======Item to delete 1 child========
					if ((current.right == null || current.left == null)
					&& (current.item.equals(key))){ 
						//System.out.println("==Deleting one child==");
						deleteOneChild(key);
						break;
					}

					//=======Item to delete TWO childs========
					if ((current.right != null && current.left != null)
					&& (current.item.equals(key))){ 
						//System.out.println("==Deleting two childs==");
						deleteTwoChild(key);
						break;
					}

					//traversing until item is found
					parent = current;
					if (key.compareTo(parent.item)<  0){
						current = parent.left;
					}else {
						current = parent.right;
					}

				}
			}
		}

	}
	private void deleteRoot (E key){
		TreeNode<E> current = root;
		TreeNode<E> temp = root;

		current = current.right;
			//System.out.println("=======Item to delete root========");

		while (current.left != null ){ 
			current = current.left;
		}
		//System.out.println("Current: " + current.item);
		root = current;
		root.left = temp.left;
		root.right = temp.right;

		//eliminate copied node
		temp = current;
		temp = temp.right;
			if (temp == current){ // first move to the right
				current.right = null;
			}
			//finds the link that is looping to the copied curr and deletes
			while (temp.left != current && temp.left != null){
				temp = temp.left;
			}
			temp.left = null;

	}


	private void deleteTwoChild(E key){
		TreeNode<E> current = root;
		TreeNode<E> parent = root;
		TreeNode<E> temp;

		current = root;
		while (current != null){


			if ((current.right != null && current.left != null)
			&& (current.item.equals(key))){ 
				//System.out.println("=======Item to delete TWO childs======== with key: " + key);
				//System.out.println("Current is: " + current.item );
				//System.out.println("Parent pre:" + parent.item);


				//finds the inorder successor
				current = current.right;
				while (current.left != null ){ 
					current = current.left;
				}
				//System.out.println("Inorder Succesor (Current): " + current.item);
				

				// creates new links for two child removal
				if (key.compareTo(parent.item)>0){
					temp = parent.right;
					//System.out.println("Went right");
					//System.out.println("Temp initial: " + temp.item + " Current: " + current.item);
					//System.out.println("Parent: " + parent.item);
					parent.right = current;
					current.left = temp.left;
					//System.out.println("Temp PRE: " + temp.item + " Current: " + current.item);
					current.right = temp.right;
					temp = current;
					temp = temp.right;
					if (temp == current){ // first move to the right
						current.right = null;
					}
					//finds the link that is looping to the copied curr and deletes
					while (temp.left != current && temp.left != null){
						temp = temp.left;
					}
					temp.left = null;
					//System.out.println("Temp post: " + temp.item + " Current: " + current.item);

				} else{
					temp = parent.left;
					//System.out.println("Went left");
					//System.out.println("Temp initial: " + temp.item + " Current: " + current.item);
					parent.left = current;
					current.left = temp.left;
					//System.out.println("Parent: " + parent.item + " current: " + current.item + " temp: " + temp.item);
					current.right = temp.right;
					temp = current;
					temp = temp.right;
					if (temp == current){
						current.right = null;
					}
					while (temp.left != current && temp.left !=null){
						temp = temp.left;
					}
					temp.left = null;
					//System.out.println("Temp post: " + temp.item + " Current: " + current.item);
				}

				//System.out.println("Temp final: " + temp.item);
				//System.out.println("Temp right right " + temp.right.right.item);
				break;
			}

			//traversing until item is found
			parent = current;
			if (key.compareTo(parent.item)<  0){
				current = parent.left;
			}else {
				current = parent.right;
			}
		}

	}

	private void deleteOneChild (E key){
		TreeNode<E> current = root;
		TreeNode<E> parent = root;
		TreeNode<E> temp;

		current = root;
		while (current != null){

			if ((current.right == null || current.left == null)
			&& (current.item.equals(key))){ 
				if (key.compareTo(parent.item)<  0){ //parents left subtree
					if (current.left != null){ //current has a child left
						parent.left = current.left;
					} else {
						parent.left = current.right;
					}
				} else { //parents right subtree
					if (current.left != null){ //current has a child left
						parent.right = current.left;
					
					} else {
						parent.right = current.right;
					}
				break;
				}
			}


			//traversing until item is found
			parent = current;
			if (key.compareTo(parent.item)<  0){
				current = parent.left;
			}else {
				current = parent.right;
			}
		}
	}

	private void deleteLeaf (E key ){
		TreeNode<E> current = root;
		TreeNode<E> parent = root;
		//TreeNode<E> temp;

		current = root;
		while (current != null){

			if ((current.right == null && current.left == null)
			&& (current.item.equals(key) ) ){ 
				if (parent.right.item == key){
					parent.right = null;
				}else {
					parent.left = null;
				}
				break;
			}

			//traversing until item is found
			parent = current;
			if (key.compareTo(parent.item)<  0){
				current = parent.left;
			}else {
				current = parent.right;
			}
		
		}

	}


	/*
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	*/
	public ArrayList<E> inOrder() {
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}

/*
 * This recursive method is the one that does the work
 * of traversing the tree in order and placing items
 * into the list.
 */
	private void collectInOrder(ArrayList<E> list, TreeNode<E> node) {
 		if (node != null){
 			collectInOrder(list, node.left);
 			list.add(node.item);
 			collectInOrder(list, node.right);
 		}
	}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {

		
		
		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();	
		PatientLocation p00 = new PatientLocation("Andrea", "Andrea", 338);
		PatientLocation p01 = new PatientLocation("Bob", "Bob",116);
		PatientLocation p02 = new PatientLocation("Carlos", "Carlos",422);
		PatientLocation p03 = new PatientLocation("Donisio", "Donisio",454);
		PatientLocation p031 = new PatientLocation("Daniel", "Daniel",454);
		PatientLocation p04 = new PatientLocation("Ellen", "Ellen",121);
		PatientLocation p05 = new PatientLocation("Francisco", "Francisco",121);
		PatientLocation p06 = new PatientLocation("Gabriela", "Gabriela",121);
		PatientLocation p061 = new PatientLocation("GAA", "GAA",121);
		PatientLocation p07 = new PatientLocation("Hector", "Hector",121);
		PatientLocation p08 = new PatientLocation("Ivan", "Ivan",121);
		PatientLocation p09 = new PatientLocation("Juan", "Juan",121);
		PatientLocation p091 = new PatientLocation("JA", "JA",121);
		PatientLocation p10 = new PatientLocation("KJ", "KJ",121);
		tree.insert(p05);	
		tree.insert(p02);
		tree.insert(p08);
		tree.insert(p00);
		tree.insert(p01);
		tree.insert(p03);
		tree.insert(p031);
		tree.insert(p04);
		tree.insert(p06);
		tree.insert(p061);
		tree.insert(p07);
		tree.insert(p09);
		tree.insert(p091);
		tree.insert(p10);

		System.out.println(		tree.height());
/*
		//tree.delete(p00); //andrea
		//tree.delete(p01);//bob
		//tree.delete(p02); // carlos
		//tree.delete(p03); // dionisio
		//tree.delete(p04);
		//tree.delete(p05); //root francisco
		//tree.delete(p06); //gabriela
		//tree.delete(p061);//GAA
		//tree.delete(p07); // hector
		//tree.delete(p08); // ivan
		//tree.delete(p09); //juan
		//System.out.println(tree.retrieve (p01));
*/
		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();
/*
		
		//PatientLocation p4 = new PatientLocation("Newman","Alfred",607);
		//tree.insert(p4);
		//tree.insert(p3);
		//tree.insert(p2);
		ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		// draw the tree in its current state:
*/

	}

}
