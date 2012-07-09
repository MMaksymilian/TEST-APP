package app.converter.entity;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.ConfigStandard;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 09.07.12
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = ConfigStandard.class)
public class ConfigStandardConverter extends CommonEntityConverter {
}
