package af.crm.webplatform.entities;

public class UserFront {
    private long id;
    private String fullName;
    private String email;

    public UserFront(){}

    public UserFront(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public UserFront(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserFront{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String setFrontUser(User user){
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        return this.toString();
    }
}
