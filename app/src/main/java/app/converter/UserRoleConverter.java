package app.converter;

import app.converter.common.CommonEntityConverter;
import core.orm.entities.UserRole;

import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(forClass = UserRole.class)
public class UserRoleConverter extends CommonEntityConverter {
}
