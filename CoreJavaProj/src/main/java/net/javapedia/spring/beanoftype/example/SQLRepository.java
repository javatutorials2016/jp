package net.javapedia.spring.beanoftype.example;


public class SQLRepository implements Repository {

	@Override
    public void invoke() {
        System.out.println("SQLRepository called");
    }
}