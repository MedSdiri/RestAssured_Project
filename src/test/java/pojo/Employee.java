package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
//Ignore any Json Field that does not match with POJO class fields
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private int salary;
    private int department_id;

}
