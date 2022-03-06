package bikefind.casestudy.Ujwal.Pradhan.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateProductFormBean {

    // this is a hidden data value and is only needed to distinguish an edit from a create
    private Integer id;

    private String category;

    private String imageUrl;

    @NotEmpty(message = "Product Name is required.")
    private String productName;

    // these annotations work on integer values only
    @Min(value=1, message="Price must be at least $1")
    @Max(value=1000000, message="Price must be at most $1,000,000")
    private Double price;

    // this list is populated by the controller with all error messages
    // in the binding result.
    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
