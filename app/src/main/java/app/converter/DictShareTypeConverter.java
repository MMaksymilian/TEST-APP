package app.converter;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.DictShareType;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 16:25
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = DictShareType.class)
public class DictShareTypeConverter extends CommonEntityConverter {
}
