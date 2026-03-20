package manager;

import java.util.HashMap;

import model.User;
import model.VaultOwner;
import exception.DuplicateUserException;

public class UserManager {

    private HashMap<String,User> users=new HashMap<>();

    public void registerUser(String name,String email,String passwordHash) throws DuplicateUserException{

        if(users.containsKey(email)){
            throw new DuplicateUserException("User already exists");
        }

        users.put(email,new VaultOwner(name,email,passwordHash));
    }

    public User getUser(String email){
        return users.get(email);
    }
}