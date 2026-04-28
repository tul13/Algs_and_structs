import java.util.*;
import java.lang.*;
import java.io.*;

class MySet<T>
{
    private Object[] elements;
    private int size;
    private int capacity;


    public MySet(int capacity)
    {
        this.capacity = capacity;
        elements = new Object[capacity];
        size = 0;
    }


    public boolean Contain(Object elem)
    {
        for(int i = 0; i < size; i++)
        {
            if (elem.equals(elements[i])) return true;
        }
        return false;
    }


    public boolean Add(T elem)
    {
        if(Contain(elem)) return false;
        
        if(size == capacity) return false;
        
        elements[size] = elem;
        size++;
        return true;
    }


    public boolean Remove(Object elem)
    {
        int index = -1;
        for(int i = 0; i < size; i++)
        {
            if(elements[i].equals(elem))
            {
                index = i;
                break;
            }
        }
        
        if(index == -1) return false;
        
        for(int i = index; i < size-1; i++)
        {
            elements[i] = elements[i+1];
        }
        
        size--;
        elements[size] = null;
        return true;
    }


    public int Count()
    {
        return size;
    }


    public void Display()
    {
        System.out.print("[");
        if (size > 0) {
            for(int i = 0; i < size-1; i++)
            {
                System.out.print(elements[i]);
                System.out.print(", ");
            }
            System.out.print(elements[size-1]);
        }
        System.out.print("]");
    }


    public void Union(MySet<T> other)
    {
        MySet<T> result = new MySet<>(this.size + other.size);
        
        for(int i = 0; i < this.size; i++)
        {
            result.Add((T)this.elements[i]);
        }
        
        for(int i = 0; i < other.size; i++)
        {
            result.Add((T)other.elements[i]);
        }
        
        result.Display();
    }
    
    
    public void Intersection(MySet<T> other)
    {
        MySet<T> result = new MySet<>(Math.min(this.size,other.size));
        
        for(int i = 0; i < this.size; i++)
        {
            if(other.Contain(this.elements[i])) result.Add((T)this.elements[i]);
        }
        
        result.Display();
    }
    
    
    public void Difference(MySet<T> other)
    {
        MySet<T> result = new MySet<>(this.size);
        
        for(int i = 0; i < this.size; i++)
        {
            if(!other.Contain(this.elements[i])) result.Add((T)this.elements[i]);
        }
        
        result.Display();
    }
}

class Main
{
    public static void main(String[] args)
    {
        MySet<Integer> set1 = new MySet<>(5);
        
        set1.Add(1);
        set1.Add(2);
        set1.Add(3);
        set1.Add(2);
        System.out.print("set1: ");
        set1.Display();
        System.out.println();
        
        MySet<Integer> set2 = new MySet<>(5);
        
        set2.Add(4);
        set2.Add(5);
        set2.Add(6);
        set2.Add(7);
        set2.Remove(6);
        set2.Add(2);
        set2.Add(1);
        System.out.print("set2: ");
        set2.Display();
        System.out.println();
        
        System.out.print("Union: ");
        set1.Union(set2);
        System.out.println();
        
        System.out.print("Intersection: ");
        set1.Intersection(set2);
        System.out.println();
        
        System.out.print("Difference: ");
        set1.Difference(set2);
        System.out.println();
        
        
    }
}