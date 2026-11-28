package DataStructures;
public class Binarytree {
    class Node {
        Node left;
        Node right;
        String key;
        int value;

        public Node(String key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node root;
    public void addnode(String key,int value){
        Node newnode=new Node(key,value);
        if(root==null){
            root=newnode;
            return; // exit function
        }
        Node current=root; // pointer
        while(true){
            if(key.compareTo(current.key)<0){
                if(current.left==null){
                    current.left=newnode;
                    return;
                }
                current=current.left;
            }
            else if(key.compareTo(current.key)>0){
                if(current.right==null){
                    current.right=newnode;
                    return;
                }
                current=current.right;
            }
            else{
                current.value=value;
                return;
            }
        }
    }
    public Integer search(String key){
        return search(root,key);
    }
    public Integer search(Node node,String key){
        if(node==null){
            return null;
        }
        else if(key.compareTo(node.key)<0){
            return search(node.left,key);
        }
        else if(key.compareTo(node.key)>0){
            return search(node.right,key);
        }
        else{
            return node.value;
        }
    }
    public String getmin(){
       Node min;
       if(root==null){
        return null;
       }
       else{
          min=root;
          while (min.left!=null) {
            min=min.left;
       } 
      return min.key;
}} 
}

