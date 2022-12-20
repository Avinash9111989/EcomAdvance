package com.mycom.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "custid")
  private int custId;

  @Size(min = 3, max = 20, message = "name should be within 3 to 20 characters")
  @Pattern(regexp = "^[A-Za-z]+([ ][a-zA-Z]+)*$", message = "there should be no special characters.")
  private String custName;

  @Size(min = 10, max = 10, message = "Phone number should be 10 digits")
  private Long custPhoneNumber;

  @NotNull
  private Date custRegisterDate;

  @Size(min = 3, max = 12, message = "username should be within 3 to 12 characters")
  @Pattern(regexp = "^[a-zA-Z][\\w]{2,10}$", message = "there should be no special characters.")
  @Column(name = "custUName", unique = true)
  private String custUserName;

  @Size(min = 8, max = 15, message = "password should be within 8 to 15 characters")
  @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d)(?=.*?[#?!@$%^&*-]).{8,15}$", message = "password should contain at least 8 characters with At least one uppercase letter, one lowercase letter,one digit and a special character.")
  private String custPassword;
  
  @OneToOne(cascade = {CascadeType.ALL})
  private Address address;
}
