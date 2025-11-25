package com.icefek.models.entity;

import com.icefek.models.notentity.ElementIsntExistException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class RESTProvider {


    protected static Todo get(int id){
        Todo todo;
        Optional<List<Todo>> op;
        try {
            op = RestClientHanlder.getRequest();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Todo> arrayList;
        if (op.isPresent()) {
            arrayList = op.get();
        }
        else {
            throw new ElementIsntExistException("Such element is not exist");
        }
        todo = arrayList.get(id);
        return todo;
    }

}
