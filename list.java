import java.util.*;
import java.lang.*;
import java.io.*;

class MyList<T>
{
	private static class Node<T>
	{
		T data;
        Node<T> next;
        
        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
	}
	
	private Node<T> head;
	private int size;
	
	public MyList()
	{
	    head = null;
	    size = 0;
	}
	
	public void add(T element) /*Добавляет в конец*/
	{
	    Node<T> newNode = new Node<>(element);
	    
	    if(head==null) head = newNode;
	    
	    else
	    {
	        Node<T> current = head;
	        while(current.next != null)
	        {
	            current = current.next;
	        }
	        current.next = newNode;
	    }
	    size ++;
	}
	
	public void add(int index, T element) /*Добавляет по индексу*/
	{
	    if(index < 0 || index > size) throw new IndexOutOfBoundsException();
	    
	    Node<T> newNode = new Node<>(element);
	    
	    if(index == 0)
	    {
	        newNode.next = head;
	        head = newNode;
	    }
	    else
	    {
	        Node<T> current = head;
	        for(int i = 0; i < index - 1; i++)
	        {
	            current = current.next;
	        }
	        newNode.next = current.next;
	        current.next = newNode;
	    }
	    size++;
	}
	
	private void checkIndex(int index) /*Вспомогательный метод для проверки принадлежности индекса*/
	{
	    if(index < 0 || index >= size)
	    {
	        throw new IndexOutOfBoundsException();
	    }
	}
	
	public T get(int index) /*Выводит элемент по индексу*/
	{
	    checkIndex(index);
	    
	    Node<T> current = head;
	    for(int i = 0; i < index; i++)
	    {
	        current = current.next;
	    }
	    return current.data;
	}
	
	public void remove(int index) /*Удаляет по индексу*/
	{
	    checkIndex(index);
	    
	    if(index == 0) 
	    {
            head = head.next;
        } 
        else 
        {
            Node<T> current = head;
            for(int i = 0; i < index - 1; i++) 
            {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
	}
	
	public boolean remove(T element) /*Удаляет первое вхождение*/
	{
	    if(head == null) return false;
	    
	    if(head.data == element)
	    {
	        head = head.next;
	        size--;
	        return true;
	    }
	    
	    Node<T> current = head;
	    while(current.next != null)
	    {
	        if(current.next.data == element)
	        {
	            current.next = current.next.next;
	            size--;
	            return true;
	        }
	        current = current.next;
	    }
	    return false;
	}
	
	public boolean contains(T element)
	{
	    Node<T> current = head;
	    while(current != null)
	    {
	        if(current.data == element)
	        {
	            return true;
	        }
	        current = current.next;
	    }
	    return false;
	}
	
	public int size() 
	{
        return size;
    }
    
    public void clear() 
    {
        head = null;
        size = 0;
    }
    
    public void printList()
    {
        System.out.print("[");
        Node<T> current = head;
	    for(int i = 0; i < size - 1; i++)
	    {
	        System.out.print(current.data);
	        System.out.print(", ");
	        current = current.next;
	    }
	    System.out.print(current.data);
	    System.out.println("]");
    }
}

class Main 
{
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");
        list.add(1, "Вставленный");
        list.printList();
        
        System.out.println("Размер: " + list.size());
        
        System.out.println("Элемент с индексом 2: " + list.get(2));
        
        System.out.println("Содержит 'Третий'? : " + list.contains("Третий"));
        
        list.remove("Второй");
        System.out.println("После удаления 'Второй':");
        list.printList();
        
        list.remove(0);
        System.out.println("После удаления индекса 0:");
        list.printList();
        
        list.clear();
        System.out.println("После очистки, размер: " + list.size());
    }
}
