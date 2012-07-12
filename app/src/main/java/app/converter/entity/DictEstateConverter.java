package app.converter.entity;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.estate.DictEstate;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = DictEstate.class)
public class DictEstateConverter extends CommonEntityConverter {
}
