import java.util.*;
import java.lang.*;
import java.io.*;

class MyQueue<T>
{
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        
        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public MyQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    public boolean IsEmpty()
    {
        return size == 0;
    }
    
    public void enqueue(T item)
    {
        Node<T> newNode = new Node<>(item);
        
        if(IsEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    public T dequeue()
    {
        if(IsEmpty()) throw new IllegalStateException("Очередь пустая");
        
        T data = head.data;
        head = head.next;
        size--;
        
        if(IsEmpty()) tail = null;
        
        return data;
    }
    
    public T peek()
    {
        if(IsEmpty()) throw new IllegalStateException("Очередь пустая");
        
        return head.data;
    }
    
    public int size()
    {
        return size;
    }
    
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void display()
    {
        if(IsEmpty()) System.out.println("[]");
        
        else
        {
            System.out.print("[");
            Node<T> current = head;
            while(current != null)
            {
                System.out.print(current.data);
                if(current.next != null) System.out.print(", ");
                current = current.next;
            }
            System.out.println("]");
        }
    }
    
    
    
    public static void main(String[] args)
    {
        MyQueue<String> queue = new MyQueue<>();
        
        System.out.println("Добавляем элементы:");
        for (int i = 1; i <= 10; i++) {
            queue.enqueue("Элемент " + i);
            System.out.println("Добавлен: Элемент " + i + ", размер: " + queue.size());
        }
        
        System.out.print("\nОчередь: ");
        queue.display();
        System.out.println("Первый элемент: " + queue.peek());
        
        System.out.println("\nУдаляем элементы:");
        while (!queue.IsEmpty()) {
            System.out.println("Удалён: " + queue.dequeue() + ", осталось: " + queue.size());
        }
        
        System.out.print("\nОчередь после удаления: ");
        queue.display();
        
        System.out.println("\nДобавляем ещё:");
        queue.enqueue("Новый элемент");
        queue.enqueue("Ещё один");
        System.out.print("Очередь: ");
        queue.display();
        
        queue.clear();
        System.out.print("После очистки: ");
        queue.display();
    }
}



	
