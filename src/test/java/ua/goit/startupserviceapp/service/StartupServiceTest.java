package ua.goit.startupserviceapp.service;

import org.junit.Before;
import org.junit.Test;
import ua.goit.startupserviceapp.dao.StartupDAO;
import ua.goit.startupserviceapp.model.Category;
import ua.goit.startupserviceapp.model.Startup;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for {@link ua.goit.startupserviceapp.service.StartupServiceImpl}
 *
 * @author Illia Kulinich
 * @version 1.0
 */
public class StartupServiceTest {

    private StartupServiceImpl startupService;
    private StartupDAO startupDAO;

    @Before
    public void init (){
        startupDAO = mock(StartupDAO.class);
        startupService = new StartupServiceImpl(startupDAO);
    }

    @Test
    public void save(){

//       init
        Startup startup = new Startup();
        when(startupDAO.save(startup)).thenReturn(startup);

//       use
        startupService.save(startup);

//       check
        verify(startupDAO, times(1)).save(startup);
        assertEquals(startup, startupDAO.save(startup));
    }

    @Test
    public void edit(){

//       init
        Startup startup = new Startup();
        startup.setName("GoJava5");
        final String[] authorToCheck = new String[1];
        when(startupDAO.save(startup)).thenReturn(startup);
        when(startupDAO.save(startup)).thenReturn(startup);

//       use
        startupService.edit(startup);

//       check
        verify(startupDAO, times(1)).save(startup);
        assertEquals("GoJava5", startupDAO.save(startup).getName());
    }

    @Test
    public void delete() {

//       init
        Startup startup = new Startup();
        startup.setName("lalala");
        doAnswer(i -> {
            assertEquals(startup, i.getArgumentAt(0, Startup.class));
            return null;
        }).when(startupDAO).delete(startup);

//       use
        startupService.delete(startup);

//       check
        verify(startupDAO, times(1)).delete(startup);
    }

    @Test
    public void deleteById(){
//       init
        Startup startup = new Startup();
        startup.setName("lalala");
        doAnswer(i -> {
            assertEquals(startup.getId(), (long) i.getArgumentAt(0, Long.class));
            return null;
        }).when(startupDAO).delete(startup.getId());

//       use
        startupService.deleteById(startup.getId());

//       check
        verify(startupDAO, times(1)).delete(startup.getId());
    }

    @Test
    public void ready() {
//        init
        Startup startup = mock(Startup.class);
        when(startup.getStatus()).thenReturn("Draft");
        doAnswer(i -> {
            when(startup.getStatus()).thenReturn("Ready");
            assertEquals("Ready", startup.getStatus());
            return null;
        }).when(startup).setStatus("Ready");

//      use
        startupService.ready(startup);

//        check
        verify(startup, times(1)).setStatus("Ready");
        verify(startup, times(2)).getStatus();
        verifyNoMoreInteractions(startup);

    }

    @Test
    public void ready_wrong_status() {
//        init
        Startup startup = mock(Startup.class);
        when(startup.getStatus()).thenReturn("Approved");

//      use
        startupService.ready(startup);

//        check
        verify(startup, times(1)).getStatus();
        assertNotEquals("Ready", startup.getStatus());

    }

    @Test
    public void approve() {
//        init
        Startup startup = mock(Startup.class);
        when(startup.getStatus()).thenReturn("Ready");
        doAnswer(i -> {
            when(startup.getStatus()).thenReturn("Approved");
            assertEquals("Approved", startup.getStatus());
            return null;
        }).when(startup).setStatus("Approved");

//      use
        startupService.approve(startup);

//        check
        verify(startup, times(1)).setStatus("Approved");
        verify(startup, times(2)).getStatus();
        verifyNoMoreInteractions(startup);

    }

    @Test
    public void approve_wrong_status() {
//        init
        Startup startup = mock(Startup.class);
        when(startup.getStatus()).thenReturn("Draft");

//      use
        startupService.ready(startup);

//        check
        verify(startup, times(1)).getStatus();
        assertNotEquals("Approved", startup.getStatus());

    }

    @Test
    public void reject() {
//        init
        Startup startup = mock(Startup.class);
        when(startup.getStatus()).thenReturn("Ready");
        doAnswer(i -> {
            when(startup.getStatus()).thenReturn("Rejected");
            assertEquals("Rejected", startup.getStatus());
            return null;
        }).when(startup).setStatus("Rejected");

//      use
        startupService.reject(startup);

//        check
        verify(startup, times(1)).setStatus("Rejected");
        verify(startup, times(2)).getStatus();
        verifyNoMoreInteractions(startup);

    }

    @Test
    public void reject_wrong_status() {
//        init
        Startup startup = mock(Startup.class);
        when(startup.getStatus()).thenReturn("Draft");

//      use
        startupService.ready(startup);

//        check
        verify(startup, times(1)).getStatus();
        assertNotEquals("Rejected", startup.getStatus());

    }

    @Test
    public void getAllStartups(){
//        init
        Category category = new Category("Test");
        Startup startup1 = new Startup("First", 1000, category);
        Startup startup2 = new Startup("Second", 2000, category);
        Startup startup3 = new Startup("Third", 3000, category);
        List<Startup> testList = new ArrayList<>();
        testList.add(startup1);
        testList.add(startup2);
        testList.add(startup3);

        when(startupDAO.findAll()).thenReturn(testList);

//        use
        List<Startup> listToCheck =  startupService.getAllStartups();

//        check
        assertEquals(testList, listToCheck);
        verify(startupDAO, times(1)).findAll();
    }

    @Test
    public void getStartupsByName() {
//        init
        Category category = new Category("Test");
        Startup startup1 = new Startup("First", 1000, category);
        Startup startup2 = new Startup("Second", 2000, category);
        Startup startup22 = new Startup("Second", 2222, category);
        Startup startup3 = new Startup("Third", 3000, category);

        List<Startup> allStartups = new ArrayList<>();
        allStartups.add(startup1);
        allStartups.add(startup2);
        allStartups.add(startup22);
        allStartups.add(startup3);

        List<Startup> testList = new ArrayList<>();
        testList.add(startup2);
        testList.add(startup22);

        when(startupDAO.findAll()).thenReturn(allStartups);

//        use
        List<Startup> listToCheck =  startupService.getStartupsByName("Second");

//        check
        verify(startupDAO, times(1)).findAll();
        assertEquals(testList, listToCheck);
    }

    @Test
    public void getStartupById() {
//        init
        Startup startup1 = new Startup();
        startup1.setId(0);
        Startup startup2 = new Startup();
        startup2.setId(1);
        Startup startup3 = new Startup();
        startup3.setId(2);

        List<Startup> allStartups = new ArrayList<>();
        allStartups.add(startup1);
        allStartups.add(startup2);
        allStartups.add(startup3);

        when(startupDAO.findAll()).thenReturn(allStartups);

//        use
        Startup startupToCheck = startupService.getStartupById(1);

//        check
        verify(startupDAO, times(1)).findAll();
        assertEquals(startup2, startupToCheck);
    }


}