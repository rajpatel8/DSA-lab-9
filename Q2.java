public class Q2 {
    
        public static void main(String[] args) {
            BST b = new BST() ;
            b.insert(30);   
            b.insert(17);
            b.insert(45);   b.insert(90);
            b.insert(23);   b.insert(56);
            b.insert(35);   b.insert(40);
            b.insert(50);   b.insert(12);
            b.inorder();
            System.out.println("\n");
            b.max();
            System.out.println("\n");
            b.min();
        }
    
    
}
