package pojoclasses;

public class UserRegister {
    private String email;
    private String password;

    public UserRegister() {
    }

    public UserRegister(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
