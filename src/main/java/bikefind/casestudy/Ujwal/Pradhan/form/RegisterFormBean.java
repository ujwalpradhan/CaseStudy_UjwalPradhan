package bikefind.casestudy.Ujwal.Pradhan.form;

import bikefind.casestudy.Ujwal.Pradhan.validation.EmailUnique;
import bikefind.casestudy.Ujwal.Pradhan.validation.TwoFieldsAreEqual;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "pswrepeat", fieldTwoName = "psw", message = "Password and Conform Password must be the same.")
public class RegisterFormBean {

    // this is a hidden data value and is only needed to distinguish an edit from a create
    private Integer id;

    // making sure the email is not null and is not empty as in ""
    @NotEmpty(message = "Email is required.")
    @Pattern(regexp = "^.+@.+$" , message = "Invalid email format")
    @EmailUnique(message = "Email must be unique")
    private String email;

    @Length(min = 1, max = 50,
            message = "First Name must be between 1 and 5 characters in length.")
    private String firstName;

    @NotEmpty(message = "Last Name is required.")
    private String lastName;

    // these annotations work on integer values only
    @Min(value=3, message="Age must be at least 3")
    @Max(value=10, message="Age must be at most 10")
    private Integer age;

    private String psw;
    private String pswrepeat;

    // this list is populated by the controller with all error messages
    // in the binding result.
    private List<String> errorMessages = new ArrayList<>();



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
