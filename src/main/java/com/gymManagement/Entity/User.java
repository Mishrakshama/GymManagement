package com.gymManagement.Entity;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true) //make email unique
    private String email;
    @Column(nullable = false)
    private String password;
    private String role;
    private boolean enabled;
    @Column(length=80) // define length
    private String Message;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    
    
public User(Integer id, String name, String email, String password, String role, boolean enabled, String message,
			String verificationCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		Message = message;
		this.verificationCode = verificationCode;
	}
public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getMessage() {
        return Message;
    }
    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", Message='" + Message + '\'' +
                '}';
    }
}