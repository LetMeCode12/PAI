package Api.Api.Dto;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surName;
    @Column(nullable = false,unique = true)
    @Email
    private String email;
    @Column(nullable = false,unique = true)
    private String password;
    private String role;

    public User(String name, String surName, @Email String email, String password, String role) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

//    public List<String> getRoleList(){
//        if(this.role.length() >0 ){
//            return Arrays.asList(this.role.split(","));
//        }
//        return new ArrayList<>();
//    }
}
