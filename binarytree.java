import java.util.*;
import java.lang.*;
import java.io.*;

class MyBinaryTree<T extends Comparable<T>>
{
    private class Node<T>
    {
        private T data;
        private Node<T> right;
        private Node<T> left;
        
        Node(T data)
        {
            this.data = data;
            right = null;
            left = null;
        }
    }
    
    
    private int size;
    private Node<T> peak;
    
    
    public MyBinaryTree()
    {
        peak = null;
        size = 0;
    }
    
    
    public void add(T nu)
    {
        peak = addRecursive(peak, nu);
        size++;
    }
    
    
    private Node<T> addRecursive(Node<T> current, T element)
    {
        if(current == null) return new Node<>(element);
        
        if(element.compareTo(current.data) < 0)
        {
            current.left = addRecursive(current.left, element);
        }
        else if(element.compareTo(current.data) > 0)
        {
            current.right = addRecursive(current.right, element);
        }
        else
        {
            size--;
            return current;
        }
        
        return current;
    }
    
    
    public boolean contains(T element)
    {
        return containsRecursive(peak, element);
    }
    
    
    private boolean containsRecursive(Node<T> current, T element)
    {
        if(current == null) return false;
        
        if(element.compareTo(current.data) == 0)
        {
            return true;
        }
        
        if(element.compareTo(current.data) < 0)
        {
            return containsRecursive(current.left, element);
        }
        else
        {
            return containsRecursive(current.right, element);
        }
    }
    
    
    public boolean remove(T element)
    {
        if(!contains(element)) return false;
        
        peak = removeRecursive(peak, element);
        size--;
        return true;
    }
    
    
    private Node<T> removeRecursive(Node<T> current, T element)
    {
        if(current == null) return null;
        
        if(element.compareTo(current.data) == 0)
        {
            if(current.right == null) return current.left;
            
            if(current.right.left == null)
            {
                current.right.left = current.left;
                return current.right;
            }
            
            Node<T> smallestParent = current.right;
            Node<T> smallest = current.right.left;
            
            while(smallest.left != null)
            {
                smallestParent = smallest;
                smallest = smallest.left;
            }
            
            smallestParent.left = smallest.right;
            smallest.left = current.left;
            smallest.right = current.right;
            
            return smallest;
        }
        else if(element.compareTo(current.data) < 0)
        {
            current.left = removeRecursive(current.left, element);
            return current;
        }
        else
        {
            current.right = removeRecursive(current.right, element);
            return current;
        }
    }
    
    
    public int count()
    {
        return size;
    }
    
    
    public void clear()
    {
        peak = null;
        size = 0;
    }
    
    
    public void PreOrder() 
    {
        PreOrderRecursive(peak);
        System.out.println();
    }
    
    private void PreOrderRecursive(Node<T> node) 
    {
        if (node != null) 
        {
            System.out.print(node.data + " ");
            PreOrderRecursive(node.left);
            PreOrderRecursive(node.right);
        }
    }
    
    
    public void PostOrder() 
    {
        PostOrderRecursive(peak);
        System.out.println();
    }
    
    private void PostOrderRecursive(Node<T> node) 
    {
        if (node != null) 
        {
            PostOrderRecursive(node.left);
            PostOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    
    public void InOrder() 
    {
        InOrderRecursive(peak);
        System.out.println();
    }
    
    private void InOrderRecursive(Node<T> node) 
    {
        if (node != null) 
        {
            InOrderRecursive(node.left);
            System.out.print(node.data + " ");
            InOrderRecursive(node.right);
        }
    }
    
    
    
    
    public static void main(String[] args)
    {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        
        int[] elements = {50, 30, 70, 20, 40, 60, 80, 35, 45, 55, 65};
        for (int element : elements) {
            tree.add(element);
        }
        
        System.out.println("Размер дерева: " + tree.count());
        
        System.out.println("\nОбходы:");
        System.out.print("Прямой (Pre-order): ");
        tree.PreOrder();
        
        System.out.print("Симметричный (In-order): ");
        tree.InOrder();
        
        System.out.print("Обратный (Post-order): ");
        tree.PostOrder();
        
        System.out.println("\nПоиск:");
        System.out.println("Содержит 40? " + tree.contains(40));
        System.out.println("Содержит 100? " + tree.contains(100));
        
        System.out.println("\nУдаляем 20 (лист):");
        tree.remove(20);
        tree.InOrder();

        System.out.println("\nУдаляем 30 (узел с одним потомком):");
        tree.remove(30);
        tree.InOrder();
        
        System.out.println("\nУдаляем 50 (корень с двумя потомками):");
        tree.remove(50);
        tree.InOrder();
        
        System.out.println("\nОчищаем дерево: ");
        tree.clear();
        tree.InOrder();
    }    
}



	
