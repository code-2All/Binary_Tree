import java.util.*;
class Node
{
	Node left;
	Node right;
	int data;


	Node(int data)
	{	
		this.data=data;
		
	}
}
class m
{
	static Scanner sc  = null;
	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		Node root = createTree();
		System.out.println(root.data);
		preorder(root);
		inorder(root);
		postorder(root);	
		levelorder(root);
		System.out.println("The height pf the tree is");
		System.out.println(height(root));
		System.out.println("The max diameter of the tree is ");
		System.out.println(diameter(root));
	}
		//*********************create Binary Tree ************************//
	static Node  createTree()
	{
		Node root=null;
		System.out.println("enter the  data");
		int data = sc.nextInt();
		
		if(data==-1)
		
			return null;
		
			root = new Node(data);

			System.out.println("enter the left data");
			root.left =  createTree();

			System.out.println("enter the  right data");
			root.right =  createTree();

			return root;

		
	}
		//********************preorder***********************//
	public static void  preorder(Node root)
	{
		if(root==null)
			 return;
		
				System.out.println(root.data);
				preorder(root.left);
				preorder(root.right);
	}
		//**********************inorder*******************************//
	public static void  inorder(Node root)
	{
		if(root==null)
			 return;
		
				
				inorder(root.left);
				System.out.println(root.data);
				inorder(root.right);
	}
		//*****************************post order *******************//
	public static void  postorder(Node root)
	{
		if(root==null)
			 return;
		
				
				postorder(root.left);
				postorder(root.right);
				System.out.println(root.data);
	}
		//*******************level Order ******************************//
	public static void levelorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		Queue<Node> obj = new LinkedList<>();
		obj.add(root);
		obj.add(null);
		
		while(!obj.isEmpty())
		{
			Node  currNode = obj.remove();
			if(currNode==null)
			{
				System.out.println();
				if(obj.isEmpty()){
				break;
				}
				else{
				obj.add(null);
				}
			}
			else
			{
			System.out.println(currNode.data+ " ");
			if(currNode.left!=null)
			{
				obj.add(currNode.left);
			}
			if(currNode.right!=null)
			{
				obj.add(currNode.right);
			}
			}
		}
	}
	public static int height(Node root)
	{
		if(root == null)
		{
			return -1;
		}
		int leftheight = height(root.left);
		int rightheight  = height(root.right);

		int rootheight = leftheight+rightheight+1;
		int j = Math.max(leftheight,rightheight)+1;

		return j;
	}
	public static int diameter(Node root)  //o(n2)
	{
		if(root==null)
		{
			return -1;
		}
		
		int diaLeft = diameter(root.left);
		int diaRight = diameter(root.right);
		
		int diaroot = height(root.left)+height(root.right)+1;

		return Math.max(Math.max(diaLeft,diaRight),diaroot);

		
	
	}
	
	
	

		
}