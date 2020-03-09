package pl.rynski.quizytesty.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.rynski.quizytesty.repository.AppUserRepository;

@Component
public class AppUserInitialData {

    private PasswordEncoder passwordEncoder;
    private AppUserRepository appUserRepository;

/*    @Autowired
    public AppUserInitialData(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;

        AppUser appUser = new AppUser();
        appUser.setUsername("Michal");
        appUser.setPassword(passwordEncoder.encode("Michal123"));
        appUserRepository.save(appUser);
    }*/


}
