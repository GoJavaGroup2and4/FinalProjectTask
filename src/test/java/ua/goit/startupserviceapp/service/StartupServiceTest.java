package ua.goit.startupserviceapp.service;

import org.junit.Before;
import org.junit.Test;
import ua.goit.startupserviceapp.model.StartupEvaluation;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.repository.StartupRepository;
import ua.goit.startupserviceapp.model.Category;
import ua.goit.startupserviceapp.model.Startup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.hamcrest.CoreMatchers.instanceOf;
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
    private StartupRepository startupRepository;

    @Before
    public void init (){
        startupRepository = mock(StartupRepository.class);
        startupService = new StartupServiceImpl(startupRepository);
    }

    @Test
    public void save(){

//       init
        Startup startup = new Startup();
        when(startupRepository.save(startup)).thenReturn(startup);

//       use
        startupService.save(startup);

//       check
        verify(startupRepository, times(1)).save(startup);
        assertEquals(startup, startupRepository.save(startup));
        assertEquals("Draft", startupRepository.save(startup).getStatus());
    }

    @Test
    public void edit(){

//       init
        Startup startup = new Startup();
        startup.setName("GoJava5");
        final String[] authorToCheck = new String[1];
        when(startupRepository.save(startup)).thenReturn(startup);

//       use
        startupService.edit(startup);

//       check
        verify(startupRepository, times(1)).save(startup);
        assertEquals("GoJava5", startupRepository.save(startup).getName());
        assertEquals("Draft", startupRepository.save(startup).getStatus());
    }

    @Test
    public void delete() {

//       init
        Startup startup = new Startup();
        startup.setName("lalala");
        doAnswer(i -> {
            assertEquals(startup, i.getArgumentAt(0, Startup.class));
            return null;
        }).when(startupRepository).delete(startup);

//       use
        startupService.delete(startup);

//       check
        verify(startupRepository, times(1)).delete(startup);
    }

    @Test
    public void deleteById(){
//       init
        Startup startup = new Startup();
        startup.setName("lalala");
        doAnswer(i -> {
            assertEquals(startup.getId(), (long) i.getArgumentAt(0, Long.class));
            return null;
        }).when(startupRepository).delete(startup.getId());

//       use
        startupService.deleteById(startup.getId());

//       check
        verify(startupRepository, times(1)).delete(startup.getId());
    }

    @Test
    public void ready() {
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);
        when(startupRepository.save(startup)).thenReturn(startup);


//      use
        startupService.ready(startup.getId());

//        check
        verify(startupRepository, times(1)).findById(anyLong());
        verify(startup, times(1)).setStatus("Ready for approve");
        verify(startupRepository, times(1)).save(startup);

    }

    @Test
    public void approve() {
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);
        when(startupRepository.save(startup)).thenReturn(startup);


//      use
        startupService.approve(startup.getId());

//        check
        verify(startupRepository, times(1)).findById(anyLong());
        verify(startup, times(1)).setStatus("Approved");
        verify(startupRepository, times(1)).save(startup);

    }
    @Test
    public void reject() {
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);
        when(startupRepository.save(startup)).thenReturn(startup);


//      use
        startupService.reject(startup.getId());

//        check
        verify(startupRepository, times(1)).findById(anyLong());
        verify(startup, times(1)).setStatus("Rejected");
        verify(startupRepository, times(1)).save(startup);

    }

    @Test
    public void close() {
//      init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);
        when(startupRepository.save(startup)).thenReturn(startup);


//      use
        startupService.close(startup.getId());

//      check
        verify(startupRepository, times(1)).findById(anyLong());
        verify(startup, times(1)).setStatus("Closed");
        verify(startupRepository, times(1)).save(startup);

    }

    @Test
    public void findByName(){
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findByName(anyString())).thenReturn(startup);

//        use
        Startup foundStartup = startupService.findByName("startup");

//        check
        verify(startupRepository.findByName(anyString()), times(1));
        assertEquals(startup, foundStartup);
    }

    @Test
    public void getAllStartups(){
//        init
        Startup startup1 = mock(Startup.class);
        Startup startup2 = mock(Startup.class);;
        Startup startup3 = mock(Startup.class);
        List<Startup> testList = new ArrayList<>();
        testList.add(startup1);
        testList.add(startup2);
        testList.add(startup3);

        when(startupRepository.findAll()).thenReturn(testList);

//        use
        List<Startup> listToCheck =  startupService.getAllStartups();

//        check
        assertEquals(testList, listToCheck);
        verify(startupRepository, times(1)).findAll();
    }

    @Test
    public void getAllApprovedStartups(){
//        init
        Startup startup1 = mock(Startup.class);
        when(startup1.getStatus()).thenReturn("Draft");
        Startup startup2 = mock(Startup.class);;
        when(startup2.getStatus()).thenReturn("Approved");
        Startup startup3 = mock(Startup.class);
        when(startup3.getStatus()).thenReturn("Approved");

        List<Startup> testList = new ArrayList<>();
        testList.add(startup1);
        testList.add(startup2);
        testList.add(startup3);

        when(startupRepository.findAll()).thenReturn(testList);

//        use
        List<Startup> listToCheck =  startupService.getAllApprovedStartups();

//        check
        assertTrue(listToCheck.stream().allMatch(p -> p.getStatus().equals("Approved")));
        verify(startupRepository, times(1)).findAll();
    }

    @Test
    public void getAllBusinessStartups(){
//        init
        Startup startup1 = mock(Startup.class);
        when(startup1.getStatus()).thenReturn("Approved");
        when(startup1.getCategory()).thenReturn(new Category("Business (shares) for sale"));
        Startup startup2 = mock(Startup.class);
        when(startup2.getStatus()).thenReturn("Approved");
        when(startup2.getCategory()).thenReturn(new Category("Business (shares) for sale"));
        Startup startup3 = mock(Startup.class);
        when(startup3.getStatus()).thenReturn("Approved");
        when(startup3.getCategory()).thenReturn(new Category("Mobile Appliations"));

        List<Startup> testList = new ArrayList<>();
        testList.add(startup1);
        testList.add(startup2);
        testList.add(startup3);

        when(startupRepository.findAll()).thenReturn(testList);

//        use
        List<Startup> listToCheck =  startupService.getAllBusinessStartups();

//        check
        assertTrue(listToCheck.stream().allMatch(p -> p.getCategory().getName().equalsIgnoreCase("Business (shares) for sale")));
        verify(startupRepository, times(1)).findAll();
    }

    @Test
    public void getStartupsByUser(){
//        init
        UserDB user = mock(UserDB.class);
        Startup startup1 = mock(Startup.class);
        Startup startup2 = mock(Startup.class);
        Set<Startup> set = new HashSet<>();
        when(user.getStartups()).thenReturn(set);

//        use
        List<Startup> listToCheck = startupService.getStartupsByUser(user);

//        check
        verify(user, times(1)).getStartups();
        assertThat(listToCheck, instanceOf(ArrayList.class));
    }


    @Test
    public void getStartupsByName() {
//        init
        Category category = new Category("Test");
        Startup startup1 = new Startup("First", "Test Description", 1000, category);
        Startup startup2 = new Startup("Second", "Test Description", 2000, category);
        Startup startup22 = new Startup("Second", "Test Description", 2222, category);
        Startup startup3 = new Startup("Third", "Test Description", 3000, category);

        List<Startup> allStartups = new ArrayList<>();
        allStartups.add(startup1);
        allStartups.add(startup2);
        allStartups.add(startup22);
        allStartups.add(startup3);

        List<Startup> testList = new ArrayList<>();
        testList.add(startup2);
        testList.add(startup22);

        when(startupRepository.findAll()).thenReturn(allStartups);

//        use
        List<Startup> listToCheck =  startupService.getStartupsByName("Second");

//        check
        verify(startupRepository, times(1)).findAll();
        assertEquals(testList, listToCheck);
    }

    @Test
    public void getStartupById() {
//        init
        Startup startup = new Startup();
        startup.setId(0);

        when(startupRepository.findById(anyLong())).thenReturn(startup);

//        use
        Startup startupToCheck = startupService.getStartupById(1);

//        check
        verify(startupRepository, times(1)).findById(anyLong());
        assertEquals(startup, startupToCheck);
    }

    @Test
    public void averageRating_correct(){
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);

        StartupEvaluation mark1 = new StartupEvaluation(mock(UserDB.class), startup, 1);
        StartupEvaluation mark2 = new StartupEvaluation(mock(UserDB.class), startup, 2);

        Set<StartupEvaluation> marks = new HashSet<>();
        marks.add(mark1);
        marks.add(mark2);

        when(startup.getMarks()).thenReturn(marks);

//        use
        Double rating = startupService.averageRating(anyLong());

//        check
        assertEquals((Double) 1.5, rating);
        verify(startupRepository, times(1)).findById(anyLong());
        verify(startup, times(1)).getMarks();
    }

    @Test
    public void averageRating_empty(){
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);

        Set<StartupEvaluation> marks = new HashSet<>();

        when(startup.getMarks()).thenReturn(marks);

//        use
        Double rating = startupService.averageRating(anyLong());

//        check
        assertEquals((Double) 0.0, rating);
        verify(startupRepository, times(1)).findById(anyLong());
        verify(startup, times(1)).getMarks();
    }

    @Test
    public void votesCount(){
//        init
        Startup startup = mock(Startup.class);
        when(startupRepository.findById(anyLong())).thenReturn(startup);

        Set <StartupEvaluation> set = mock(HashSet.class);
        when(startup.getMarks()).thenReturn(set);
        when(set.size()).thenReturn(5);


//        use
        int votes = startupService.votesCount(anyLong());

//        check
        verify(startup, times(1)).getMarks();
        verify(set, times(1)).size();
        verify(startupRepository, times(1)).findById(anyLong());
        assertEquals(5, votes);
    }


}