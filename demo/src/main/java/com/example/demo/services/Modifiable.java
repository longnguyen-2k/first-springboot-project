package com.example.demo.services;

import java.util.List;

public interface Modifiable<T> {
    T getById(Long id);
    List<T>  gets();
    List<T> gets(int offset, int limit);
    T create(T object);
    T update(Long id,T object);
    void delete(Long id);


}
