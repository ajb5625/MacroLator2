public class Admin {
    public String username;
    public String password;
    public Admin next;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.next = null;
    }
}
