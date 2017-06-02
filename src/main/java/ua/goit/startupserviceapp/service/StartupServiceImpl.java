package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.startupserviceapp.model.StartupEvaluation;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.repository.StartupRepository;
import ua.goit.startupserviceapp.model.Startup;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ua.goit.startupserviceapp.service.UserService}
 *
 * @author Illia Kulinich
 * @version 1.0
 */

@Service
public class StartupServiceImpl implements StartupService {

    private StartupRepository startupRepository;

    @Autowired
    public StartupServiceImpl(StartupRepository startupRepository) {
        this.startupRepository = startupRepository;
    }

    @Override
    @Transactional
    public void save(Startup startup) {
        startup.setStatus("Draft");
        startupRepository.save(startup);
    }

    @Override
    @Transactional
    public void edit(Startup startup) {
        startup.setStatus("Draft");
        startupRepository.save(startup);
    }

    @Override
    @Transactional
    public void delete(Startup startup) {
        startupRepository.delete(startup);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        startupRepository.delete(id);
    }

    @Override
    @Transactional
    public void ready(long id) {
        Startup startup = startupRepository.findById(id);
        startup.setStatus("Ready for approve");
        startupRepository.save(startup);
    }

    @Override
    @Transactional
    public void approve(long id) {
        Startup startup = startupRepository.findById(id);
        startup.setStatus("Approved");
        startupRepository.save(startup);
    }

    @Override
    @Transactional
    public void reject(long id) {
        Startup startup = startupRepository.findById(id);
        startup.setStatus("Rejected");
        startupRepository.save(startup);
    }

    @Override
    @Transactional
    public void close(long id) {
        Startup startup = startupRepository.findById(id);
        startup.setStatus("Closed");
        startup.setCurrent_investment(0);
        startupRepository.save(startup);
    }

    @Override
    @Transactional
    public List<Startup> getAllStartups() {
        return startupRepository.findAll();
    }

    @Override
    public List<Startup> getStartupsByName(String name) {
        List<Startup> startupsByName = this.getAllStartups();

        startupsByName.removeIf(p -> !p.getName().equals(name));

        return startupsByName;
    }

    @Override
    public Startup getStartupById(long id) {
        return startupRepository.findById(id);
    }

    @Override
    public Startup findByName(String name) {
        return startupRepository.findByName(name);
    }

    @Override
    public List<Startup> getAllApprovedStartups() {
        List<Startup> startups;

        startups = this.getAllStartups().stream()
                .filter(s -> s.getStatus().equalsIgnoreCase("Approved"))
                .collect(Collectors.toList());

        return startups;
    }

    @Override
    public List<Startup> getAllBusinessStartups() {
        List<Startup> startups;

        startups = this.getAllApprovedStartups().stream()
                .filter(s -> s.getCategory().getName().equalsIgnoreCase("Business (shares) for sale"))
                .collect(Collectors.toList());

        return startups;
    }

    @Override
    public List<Startup> getAllInvestmentStartups() {
        List<Startup> startups;

        startups = this.getAllApprovedStartups().stream()
                .filter(s -> s.getCategory().getName().equalsIgnoreCase("Investment projects"))
                .collect(Collectors.toList());

        return startups;
    }

    @Override
    public List<Startup> getAllMobileStartups() {
        List<Startup> startups;

        startups = this.getAllApprovedStartups().stream()
                .filter(s -> s.getCategory().getName().equalsIgnoreCase("Mobile applications"))
                .collect(Collectors.toList());

        return startups;
    }

    @Override
    public Double averageRating(long id) {

        Startup startup = startupRepository.findById(id);
        Set<StartupEvaluation> allMarks = startup.getMarks();

        if (allMarks.size() == 0) {
            return 0.0;
        }

        double averageRating;
        int totalRating = 0;

        for (StartupEvaluation allMark : allMarks) {
            totalRating += allMark.getMark();
        }
        averageRating = (double) totalRating / allMarks.size();

/**
 *      rounding averageRating to 1 decimal place
 */
        averageRating = roundToOneDecimal(averageRating);

        return averageRating;
    }

    @Override
    public int votesCount(long id) {
        Startup startup = startupRepository.findById(id);
        return startup.getMarks().size();
    }

    /**
     * This method rounds any double variable to one decimal
     *
     * @param d the variable to round
     * @return the result of rounding
     */
    private double roundToOneDecimal(double d) {
        d = d * 10;
        d = Math.round(d);
        d = d / 10;
        return d;
    }

    @Override
    @Transactional
    public Collection<Startup> findAllByKeyWord(String key) {
        Collection<Startup> startups;
        if (key.isEmpty()) {
            startups = getAllApprovedStartups();
        } else {
            startups = startupRepository.findAllByKeyWord(key);
        }

        return startups;
    }

    /**
     * This method gets Set of {@link Startup} by {@link UserDB}
     * and puts it into the List of {@link Startup}
     */
    @Override
    @Transactional
    public List<Startup> getStartupsByUser(UserDB user) {

        List<Startup> startups = new ArrayList<>();
        startups.addAll(user.getStartups());

        return startups;
    }

    @Override
    @Transactional
    public void invest(long startupId, int investment) {

        Startup startup = startupRepository.findById(startupId);
        startup.setCurrent_investment(startup.getCurrent_investment() + investment);

        startupRepository.save(startup);
    }
}
