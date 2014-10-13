package de.laudert.taotv.exception;

/**
 * User: tvt
 * Date: 10/13/14
 * Time: 3:46 PM
 */
public class ItemNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String message) {
        super(message);
    }
}
