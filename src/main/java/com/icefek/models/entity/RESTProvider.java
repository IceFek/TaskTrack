package com.icefek.models.entity;

import com.icefek.models.notentity.ElementIsntExistException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class RESTProvider {
    protected static boolean post(Todo todo){
        return RestClientHanlder.postRequest(todo);
    }
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
            e.printStackTrace();
            throw new ElementIsntExistException("Such element is not exist");
        }
        return todo;
    }
    protected static boolean delete(String id){
        if(RestClientHanlder.deleteRequest(id)){
            return true;
        }
        else{
            return false;
        }
    }

    protected static boolean update(Todo todo){
        return RestClientHanlder.putRequest(todo);
    }

}
