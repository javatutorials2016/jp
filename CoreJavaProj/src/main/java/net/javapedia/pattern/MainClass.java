package net.javapedia.pattern;

import java.util.HashMap;

class A
{
     
}
 
class B extends A
{
     
}
 
class C extends B
{
     
}
 
public class MainClass 
{
 

     
    static void overloadedMethod(Object obj)
    {
        System.out.println("THREE");
    }
     
    static void overloadedMethod(B b)
    {
        System.out.println("TWO");
    }
    
    static void overloadedMethod(A a)
    {
        System.out.println("ONE");
    }
     
    public static void main(String[] args)
    {
        C c = new C();
         
        overloadedMethod(c);
        
        HashMap hm = new HashMap<>();
    }
}