package core.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * AppUser: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ConfigStandard {

    @Id
    String key;

    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}