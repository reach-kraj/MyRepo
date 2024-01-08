package leetcode;

public class CommonAncestor {
	private class Tree {

		private int data;
		private Tree right;
		private Tree left;

		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
	}

	Tree rootNode;

	public void addTree(int data) {
		rootNode=addTreeRec(rootNode, data);
	}
	public Tree addTreeRec(Tree rootNode,int data) {
		if(rootNode==null) {
			rootNode = new Tree();
			rootNode.setData(data);
		}
		else if(data<rootNode.getData()) {
			rootNode.left=addTreeRec(rootNode.left, data);
		}else if(data>rootNode.getData()){
			rootNode.right=addTreeRec(rootNode.right, data);
		}

		return rootNode;
	}

	public void showDepth() {
		showDepthRec(rootNode);
	}
	public void showDepthRec(Tree rootNode) {
		if (rootNode!=null) {
			System.out.print(rootNode.getData()+" ");
			showDepthRec(rootNode.left);
			showDepthRec(rootNode.right);
		}
	}
	public void ancestor(int a,int b) {
		Tree temp=null;
		temp=rootNode;
		temp=ancestorrec(temp,a,b);
	}
	public Tree ancestorrec(Tree n1,int p,int q) {
		if((n1.left==null) || (n1.right==null)) {
			if(p>q) {
				System.out.println(q);
			}else{
				System.out.println(p);
			}return n1;
		}
		if ((n1.left.getData()==p)&&(n1.right.getData()==q)) {
			System.out.println(n1.getData());
			return n1;
		}
		else {
			if(p<n1.getData()) {
				ancestorrec(n1.left,p,q);
			}else {
				ancestorrec(n1.right,p,q);
			}
		}
		return n1;
	}

	public static void main(String[] args) {
		CommonAncestor t1 = new CommonAncestor();

		t1.addTree(10);
		t1.addTree(5);
		t1.addTree(12);
		t1.addTree(11);
		t1.addTree(7);
		t1.addTree(15);
		t1.addTree(6);

		t1.ancestor(6,7);
	}
}
