package app.bean;

import org.hibernate.validator.constraints.Length;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 29.06.12
 * Time: 09:06
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
public class DeclarationBean {

    @NotNull
//    @Length(min= 3, max= 10)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void process() {
        System.out.println("process");
    }

}
