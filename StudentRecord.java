import java.util.Scanner;

public class StudentRecord {
    Node start;

    public StudentRecord() {
        start = null;
    }

    public Node getNode(int id) {
        Node newNode = new Node();
        Scanner in = new Scanner(System.in);
        
        newNode.roll = id;
        System.out.println("Enter name =");
        newNode.name = in.nextLine();

        System.out.println("Enter the CGPA =");
        newNode.cgpa = in.nextDouble();
        in.nextLine();  
        
        System.out.println("Enter the department =");
        newNode.dept = in.nextLine();

        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public void bst_in(int id) {
        Node newNode = getNode(id);
        if (start == null) {
            start = newNode;
        } else {
            Node temp = start;
            while (true) {
                if (newNode.roll < temp.roll) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        System.out.println("Inserted to the left");
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (newNode.roll > temp.roll) 
                {
                    if (temp.right == null) 
                        {
                            temp.right = newNode;
                            System.out.println("Inserted to the right");
                            break;
                        } 
                    else 
                        {
                            temp = temp.right;
                        }
                }
            }
        }
    }

    public Node searching(int id) {
        Node temp = start;
        while (temp != null) 
        {
            if (id == temp.roll) 
            {
                return temp;
            } 
            else if (id < temp.roll) 
            {
                temp = temp.left;
            } 
            else 
            {
                temp = temp.right;
            }
        }
        return null;
    }

    public void displayAll() 
    {
        inOrderTraversal(start);
    }
    public void roll()
    {
        inorderroll(start);
    }

    public void inorderroll(Node node)
    {
        if(node!=null)
        {
            inorderroll(node.left);
            System.out.println("Roll No: "+node.roll);
            inorderroll(node.right);
        }
    }

    public void inOrderTraversal(Node node) 
    {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("Roll No: " + node.roll + ", Name: " + node.name + 
                               ", CGPA: " + node.cgpa + ", Department: " + node.dept);
            inOrderTraversal(node.right);
        }
    }
}
