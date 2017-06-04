package ua.goit.startupserviceapp.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.goit.startupserviceapp.model.Role;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.repository.UserDBRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for {@link ua.goit.startupserviceapp.service.UserServiceImpl}
 *
 * @author Illia Kulinich
 * @version 1.0
 */
public class UserServiceImplTest {

    private UserServiceImpl userService;
    private UserDBRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Before
    public void init(){
        userRepository = mock(UserDBRepository.class);
        encoder = mock(BCryptPasswordEncoder.class);
        userService = new UserServiceImpl();
        userService.setUserDBRepository(userRepository);
        userService.setbCryptPasswordEncoder(encoder);
    }


    @Test
    public void save() throws Exception {
//        init
        UserDB user = mock(UserDB.class);
        String password = "password";
        when(user.getPassword()).thenReturn(password);
        doAnswer(i -> null).when(user).setPassword(anyString());
        when(encoder.encode(password)).thenReturn("encodedPassword");
        when(userRepository.save(user)).thenReturn(user);

//       use
        userService.save(user);

//        check
        verify(user, times(1)).getPassword();
        verify(encoder, times(1)).encode(password);
        verify(user, times(1)).setPassword("encodedPassword");
        verify(userRepository, times(1)).save(user);
        verifyNoMoreInteractions(user, encoder, userRepository);
    }

    @Test
    public void saveWithoutEncode() throws Exception {
//        init
        UserDB user = mock(UserDB.class);
        when(userRepository.save(user)).thenReturn(user);

//        use
        userService.save(user);

//        check
        verify(userRepository, times(1)).save(user);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void findByLogin() throws Exception {
//        use
        UserDB user = userService.findByLogin(anyString());

//        check
        verify(userRepository, times(1)).findByLogin(anyString());
        verifyNoMoreInteractions(userRepository);

    }

    @Test
    public void getAuthenticatedUser() throws Exception {
//        init
        UserDB user = mock(UserDB.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        SecurityContextImpl context = mock(SecurityContextImpl.class);
        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("SPRING_SECURITY_CONTEXT")).thenReturn(context);
        when(context.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userRepository.findByLogin(anyString())).thenReturn(user);

//        use
        UserDB testUser = userService.getAuthenticatedUser(request);

//        check
        verify(request, times(1)).getSession(true);
        verify(session, times(1)).getAttribute("SPRING_SECURITY_CONTEXT");
        verify(context, times(1)).getAuthentication();
        verify(authentication, times(1)).getPrincipal();
        verify(userRepository, times(1)).findByLogin(anyString());
        assertEquals(user, testUser);
    }

    @Test
    public void getNAuthenticatedUserNotValid() throws Exception{
        //        init
        UserDB user = mock(UserDB.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        SecurityContextImpl context = mock(SecurityContextImpl.class);
        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("SPRING_SECURITY_CONTEXT")).thenReturn(context);
        when(context.getAuthentication()).thenReturn(null);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userRepository.findByLogin(null)).thenReturn(user);

//        use
        UserDB testUser = userService.getAuthenticatedUser(request);

//        check
        verify(request, times(1)).getSession(true);
        verify(session, times(1)).getAttribute("SPRING_SECURITY_CONTEXT");
        verify(context, times(1)).getAuthentication();
        verifyNoMoreInteractions(user, request, session, authentication,
                context, userDetails, userRepository);
    }

    @Test
    public void isAuthenticatedTrue() throws Exception {
//        init
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        SecurityContextImpl context = mock(SecurityContextImpl.class);
        Authentication authentication = mock(Authentication.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("SPRING_SECURITY_CONTEXT")).thenReturn(context);
        when(context.getAuthentication()).thenReturn(authentication);
        when(authentication.isAuthenticated()).thenReturn(true);

//        use
        boolean boo = userService.isAuthenticated(request);

//        check
        verify(request, times(1)).getSession(true);
        verify(session, times(1)).getAttribute("SPRING_SECURITY_CONTEXT");
        verify(context, times(1)).getAuthentication();
        verify(authentication, times(1)).isAuthenticated();
        assertTrue(boo);
    }

    @Test
    public void isAuthenticatedFalse() throws Exception {
//        init
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        SecurityContextImpl context = mock(SecurityContextImpl.class);
        Authentication authentication = mock(Authentication.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("SPRING_SECURITY_CONTEXT")).thenReturn(context);
        when(context.getAuthentication()).thenReturn(null);
        when(authentication.isAuthenticated()).thenReturn(true);

//        use
        boolean boo = userService.isAuthenticated(request);

//        check
        verify(request, times(1)).getSession(true);
        verify(session, times(1)).getAttribute("SPRING_SECURITY_CONTEXT");
        verify(context, times(1)).getAuthentication();
        verifyNoMoreInteractions(request, session, context, authentication);
        assertFalse(boo);
    }

    @Test
    public void isAdminTrue() throws Exception {
//        init
        UserDB user = mock(UserDB.class);
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_INVESTOR");
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        SecurityContextImpl context = mock(SecurityContextImpl.class);
        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("SPRING_SECURITY_CONTEXT")).thenReturn(context);
        when(context.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("userName");
        when(userRepository.findByLogin("userName")).thenReturn(user);
        when(user.getRoles()).thenReturn(roles);

//        use
        boolean boo = userService.isAdmin(request);

//        check
        verify(request, times(1)).getSession(true);
        verify(session, times(1)).getAttribute("SPRING_SECURITY_CONTEXT");
        verify(context, times(1)).getAuthentication();
        verify(authentication, times(1)).getPrincipal();
        verify(userDetails, times(1)).getUsername();
        verify(userRepository, times(1)).findByLogin("userName");
        verify(user, times(1)).getRoles();
        verifyNoMoreInteractions(user, request, session, context, authentication, userDetails, userRepository);
        assertTrue(boo);
    }

    @Test
    public void isStartupOwnerTrue() throws Exception {
//        init
        UserDB user = mock(UserDB.class);
        Role role1 = new Role("ROLE_FOUNDER");
        Role role2 = new Role("ROLE_INVESTOR");
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        SecurityContextImpl context = mock(SecurityContextImpl.class);
        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("SPRING_SECURITY_CONTEXT")).thenReturn(context);
        when(context.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("userName");
        when(userRepository.findByLogin("userName")).thenReturn(user);
        when(user.getRoles()).thenReturn(roles);

//        use
        boolean boo = userService.isAdmin(request);

//        check
        verify(request, times(1)).getSession(true);
        verify(session, times(1)).getAttribute("SPRING_SECURITY_CONTEXT");
        verify(context, times(1)).getAuthentication();
        verify(authentication, times(1)).getPrincipal();
        verify(userDetails, times(1)).getUsername();
        verify(userRepository, times(1)).findByLogin("userName");
        verify(user, times(1)).getRoles();
        verifyNoMoreInteractions(user, request, session, context, authentication, userDetails, userRepository);
        assertFalse(boo);

    }

}