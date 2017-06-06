package websitebuilder;
// Generated Jun 5, 2017 7:12:50 PM by Hibernate Tools 4.3.1

public class Users  implements java.io.Serializable {


     private Integer userId;
     private String username;
     private String pword;

    public Users() {
    }

    public Users(String username, String pword) {
       this.username = username;
       this.pword = pword;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPword() {
        return this.pword;
    }
    
    public void setPword(String pword) {
        this.pword = pword;
    }




}


