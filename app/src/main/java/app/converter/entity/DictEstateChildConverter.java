package app.converter.entity;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.estate.DictEstateChild;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 16:21
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = DictEstateChild.class)
public class DictEstateChildConverter extends CommonEntityConverter {
}
