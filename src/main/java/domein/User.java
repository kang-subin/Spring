package domein;

public class User { // db값을 매개변수로 받기 위해서 만든 클래스
    String id;
    String name;
    String password;
    public User(){}
    public User (String id, String name, String password){
        this.id = id;
        this.name= name;
        this.password = password;
    }

    public String getId (){
        return this.id;

    }
    public String getName (){
        return this.name;

    }
    public String getPassword (){
        return this.password;

    }
}
