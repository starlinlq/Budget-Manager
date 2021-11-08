package Manager;

import java.io.Serializable;
import java.util.HashMap;

public class UserCollection implements Serializable {
    HashMap<String, User> list = new HashMap<>();

   public void addUser(User user){
       this.list.put(user.getName(), user);
   }

   public User getUser(String name){
       return this.list.get(name);
   }
}
