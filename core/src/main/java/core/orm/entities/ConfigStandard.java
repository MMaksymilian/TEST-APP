package core.orm.entities;

import core.orm.entities.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * AppUser: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="config_standard_seq")
public class ConfigStandard extends BaseEntity {

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

    @Transient
    public String getLogDetail() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConfigStandard KEY: ").append(key)
                .append(", ConfigStandard VALUE: ").append(value);
        return stringBuilder.toString();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ConfigStandard)) return false;
//
//        ConfigStandard that = (ConfigStandard) o;
//
//        if (!key.equals(that.key)) return false;
//        if (!value.equals(that.value)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = key.hashCode();
//        result = 31 * result + value.hashCode();
//        return result;
//    }
}
