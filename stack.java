import java.util.*;
import java.lang.*;
import java.io.*;

class MyStack<T>
{
    private class Node<T>
    {
        T data;
        Node<T> next;
        
        Node(T data)
        {
            this.data = data;
        }
    }
    
    
    private Node<T> top;
    private int size;
    
    MyStack()
    {
        top = null;
        size = 0;
    }
    
    
    public boolean isEmpty()
    {
        return top == null;
    }
    
    public void push(T x)
    {
        Node<T> newNode = new Node<>(x);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public T pop()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Стек пустой");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    public T peek()
    {
       if(isEmpty())
        {
            throw new RuntimeException("Стек пустой");
        }
        return top.data;
    }
    
    public int size()
    {
        return size;
    }
    
    public void clear()
    {
        top = null;
        size = 0;
    }
    
    public void show()
    {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        
        
        Node<T> current = top;
        System.out.print("[");
        
        while(current != null)
        {
            System.out.print(current.data);
            if (current.next != null)
            {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
    
    
    
    public static void main(String[] args)
    {
        MyStack<Integer> stack = new MyStack<>();
        System.out.println("Стек пуст? " + stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Размер: " + stack.size());
        System.out.println("Вершина: " + stack.peek());
        
        System.out.print("Содержимое стека: ");
        stack.show();
        
        System.out.println("Извлекли: " + stack.pop());
        System.out.print("После извлечения: ");
        stack.show();
    }
}



	
