package user;

public class MyUser {
    private String uname;
    private Integer password;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
    public String toString(){
        return "myUser:"+uname+"password:"+password;
    }
}
