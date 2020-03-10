package pl.rynski.quizytesty.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.rynski.quizytesty.repository.AppUserRepository;

import java.util.Collections;
import java.util.Set;

@Component
public class InitialUsers {

    private PasswordEncoder passwordEncoder;
    private AppUserRepository appUserRepository;

    @Autowired
    public InitialUsers(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;

        AppUser appUser = new AppUser();
        appUser.setUsername("michalrynski96@gmail.com");
        appUser.setPassword(passwordEncoder.encode("admin123"));
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_ADMIN");
        Set<UserRole> role = Collections.singleton(userRole);
        appUser.setRoles(role);
        appUserRepository.save(appUser);
    }


}
