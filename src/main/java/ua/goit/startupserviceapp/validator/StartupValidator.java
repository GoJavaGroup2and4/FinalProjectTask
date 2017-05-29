package ua.goit.startupserviceapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.service.StartupService;

public class StartupValidator implements Validator{

    @Autowired
    private StartupService startupService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Startup.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Startup startup = (Startup) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "needed_investment", "Required");

        if (startup.getName().length() < 5 || startup.getName().length() > 32) {
            errors.rejectValue("name", "Size.startupForm.name");
        }

        if (startup.getDescription().length() < 10 || startup.getDescription().length() > 2500) {
            errors.rejectValue("description", "Size.startupForm.description");
        }

        if (startup.getNeeded_investment() < 0) {
            errors.rejectValue("neededInvestment", "Size.startupForm.neededInvestment");
        }

        if (startupService.findByName(startup.getName()) != null) {
            errors.rejectValue("name", "Duplicate.startupForm.name");
        }
    }
}
