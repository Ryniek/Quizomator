package pl.rynski.quizytesty.account;

import pl.rynski.quizytesty.validation.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@PasswordMatches
public class AppUserDto {
    @Email(message = "Zachowaj strukture emaila")
    @NotBlank(message = "Pole na login nie moze byc puste")
    private String username;
    @Size(min = 3, max = 150, message = "Haslo minimum 3 znaki")
    private String password;
    private String matchingPassword;

    public AppUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
