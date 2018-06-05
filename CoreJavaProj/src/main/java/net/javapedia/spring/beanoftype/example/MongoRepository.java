package net.javapedia.spring.beanoftype.example;


public class MongoRepository implements Repository {

    @Override
    public void invoke() {
        System.out.println("MongoRepository called");
    }
}