package app.exception.service;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 22.07.12
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class ChildIsUsedException extends Exception {

    public ChildIsUsedException() {
        super("Nieruchomość jest już wykorzystana");
    }

}
