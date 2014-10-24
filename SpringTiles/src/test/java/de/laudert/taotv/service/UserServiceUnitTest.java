package de.laudert.taotv.service;

import de.laudert.taotv.service.user.UserService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * User: tvt
 * Date: 10/24/14
 * Time: 10:27 AM
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {

    @Mock
    private UserService userService;

    @Test
    public void testDisplay() {
        System.out.println("ON TEST testDisplay()");
        Assert.assertNotNull(userService.findAll());
    }
}
