package repository;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<Integer, String> userStore = new HashMap<Integer, String>(){{
        put(1, "Bruno");
        put(2, "Juca");
    }};

    private static UserRepository instance;

    private UserRepository(){}

    public static UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(Integer key, String user){
        userStore.putIfAbsent(key, user);
    }

    public String getUser(Integer key){
        return userStore.getOrDefault(key, "#");
    }

    public String deleteUser(Integer key){
        return userStore.remove(key);
    }

    public String getStringOfAllUsers(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : userStore.entrySet()){
            result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

}
