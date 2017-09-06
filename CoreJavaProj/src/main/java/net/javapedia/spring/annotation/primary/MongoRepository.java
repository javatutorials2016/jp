package net.javapedia.spring.annotation.primary;


public class MongoRepository implements Repository {

    @Override
    public void invoke() {
        System.out.println("MongoRepository called");
    }
}