package first_task.first_task.service;


import java.util.List;


public interface CRUDService<T1,T2>{
    void create(T2 t2);
    List<T2> read();
    void delete(T2 t2);
}
