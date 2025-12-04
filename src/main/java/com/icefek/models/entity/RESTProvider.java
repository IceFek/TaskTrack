package com.icefek.models.entity;

import com.icefek.models.notentity.ElementIsntExistException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class RESTProvider {

    protected static Todo get(int id) throws ElementIsntExistException{
        Todo todo;
        List<Todo> arrayList = null;
        Optional<List<Todo>> op;
        try {
            op = RestClientHanlder.getRequest();
            if (op.isPresent()) {
                arrayList = op.get();
            }
            todo = arrayList.get(id);
        } catch (IOException | InterruptedException | IndexOutOfBoundsException e) {
            throw new ElementIsntExistException("Such element is not exist");
        }
        return todo;
    }

}
