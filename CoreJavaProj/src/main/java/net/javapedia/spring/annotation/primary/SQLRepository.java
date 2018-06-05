package net.javapedia.spring.annotation.primary;


public class SQLRepository implements Repository {

	@Override
    public void invoke() {
        System.out.println("SQLRepository called");
    }
}