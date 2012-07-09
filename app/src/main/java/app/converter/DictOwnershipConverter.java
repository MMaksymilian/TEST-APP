package app.converter;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.DictOwnership;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 16:25
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = DictOwnership.class)
public class DictOwnershipConverter extends CommonEntityConverter {
}
