package knight.springframework.petstoredemo.map;

import knight.springframework.petstoredemo.model.BaseEntity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T extends BaseEntity,ID extends Long> {


    protected Map<ID,T> map = new HashMap<>();


    Set<T> findAll() {

        return new HashSet<>(map.values());
    }


    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
       return map.put(id,object);

    }

    void deleteById(ID id){

        map.remove(id);
    }

    void delete(T object) {

        map.entrySet().removeIf(entry -> entry.getValue().equals(object));

    }










}
