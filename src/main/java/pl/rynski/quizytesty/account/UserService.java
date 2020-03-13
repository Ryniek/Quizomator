package pl.rynski.quizytesty.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.rynski.quizytesty.account.AppUser;
import pl.rynski.quizytesty.account.AppUserDto;
import pl.rynski.quizytesty.account.UserRole;
import pl.rynski.quizytesty.account.VerificationToken;
import pl.rynski.quizytesty.repository.AppUserRepository;
import pl.rynski.quizytesty.repository.UserRoleRepository;
import pl.rynski.quizytesty.repository.VerificationTokenRepository;
import pl.rynski.quizytesty.service.MailSenderService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;
    private VerificationTokenRepository verificationTokenRepository;
    private MailSenderService mailSenderService;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, VerificationTokenRepository verificationTokenRepository, MailSenderService mailSenderService, UserRoleRepository userRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenRepository = verificationTokenRepository;
        this.mailSenderService = mailSenderService;
        this.userRoleRepository = userRoleRepository;
    }

    public void addNewUser(AppUserDto user, HttpServletRequest request) throws MessagingException {
        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setPassword(passwordEncoder.encode(user.getPassword()));
        setRole(appUser, "ROLE_USER");

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, appUser);
        verificationTokenRepository.save(verificationToken);

        String url = "http://" + request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath() +
                "/verify-token?token=" + token;

        mailSenderService.sendMail(user.getUsername(),
                "VerificationToken",
                url,
                false);
    }

    private void setRole(AppUser user, String role) {
        UserRole userRole = userRoleRepository.findByRole(role);
        Set<UserRole> roles = new HashSet();
        if(userRole != null) {
            roles.add(userRole);
            user.setAuthorities(roles);
        } else {
            userRole = new UserRole();
            userRole.setRole(role);
            userRole.getUsers().add(user);
            roles.add(userRole);
            user.setAuthorities(roles);
            userRoleRepository.save(userRole);
        }
    }

    public void verifyToken(String token) {
        AppUser user = verificationTokenRepository.findByValue(token).getAppUser();
        user.setEnabled(true);
        appUserRepository.save(user);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initAdmin() {
        AppUser appUser = new AppUser();
        appUser.setUsername("michalrynski96@gmail.com");
        appUser.setPassword(passwordEncoder.encode("admin123"));
        appUser.setEnabled(true);
        setRole(appUser, "ROLE_ADMIN");
        appUserRepository.save(appUser);
        AppUser appUser2 = new AppUser();
        appUser2.setUsername("legnin@gmail.com");
        appUser2.setPassword(passwordEncoder.encode("user123"));
        appUser2.setEnabled(true);
        setRole(appUser2, "ROLE_USER");
        appUserRepository.save(appUser2);
    }
}
