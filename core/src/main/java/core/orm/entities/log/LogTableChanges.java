package core.orm.entities.log;

import core.orm.entities.core.BaseEntity;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 03.07.12
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */

/**
 * Powinno być zupełnie oddzielnie ze względu na Session Factory, które musi być inne niż dla pozostałych.
 * Inaczej jest nieskończona pętla
 */
@Entity
@Immutable
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="log_table_changes_seq")
public class LogTableChanges extends BaseEntity {
    private String action;

    private String detail;

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime createDate;

    private String entityName;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
