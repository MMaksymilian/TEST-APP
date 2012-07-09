package app.converter.entity;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.AppUser;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = AppUser.class)
public class AppUserConverter extends CommonEntityConverter {
}
