package hw09_ProjectReference;

import java.util.List;

public interface CrudOperaion<T> {
    T save(T obj);
    void deleteById(int id);
    void deleteByEntity(T obj);
    void deleteAll();
    T update(T obj);
    T getById(int id);
    List<T> getAll();

}
