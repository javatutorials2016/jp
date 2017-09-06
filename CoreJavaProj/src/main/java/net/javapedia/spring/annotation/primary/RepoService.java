package net.javapedia.spring.annotation.primary;

public class RepoService {

    private Repository dao;

    public void invokeRepo() {
        System.out.println("Service calling repo");
        dao.invoke();
    }

    public void setDao(Repository dao) {
        this.dao = dao;
    }
}