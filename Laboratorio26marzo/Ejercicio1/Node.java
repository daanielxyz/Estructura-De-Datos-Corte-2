package Laboratorio26marzo.Ejercicio1;


/**
 * Node class using Generics
 **/


public class Node<T> {

	private Node<T> nextNode;
	private T nodeValue;


	/**
	 * Node constructor
	 * @param nodeValue Element stored in the Node
	 */
	public Node(T nodeValue) {
		this.nodeValue = nodeValue;
	}


	/**
	 * Node constructor
	 * @param data Element stored in the Node
	 * @param next Link to the next Node
	 */
	public Node(T data, Node<T> next) {
		super();
		this.nodeValue = data;
		this.nextNode = next;
	}


	// Getters and setters for the Node class

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public T getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(T nodeValue) {
		this.nodeValue = nodeValue;
	}
}