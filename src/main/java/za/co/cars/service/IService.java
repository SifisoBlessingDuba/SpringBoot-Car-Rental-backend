package za.co.cars.service;

public interface IService <T,ID> {
    T save(T t);
    T update(T t);
    void delete(ID id);
    T findById(ID id);
}
