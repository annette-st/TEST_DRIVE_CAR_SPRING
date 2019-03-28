package ru.itis.services;

import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.forms.UserForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UsersRepository;

import java.util.UUID;

public class UsersServiceImpl implements UsersService {

    private PasswordEncoder encoder;

    private UsersRepository usersRepository;
    private AuthRepository authRepository;

    public UsersServiceImpl(UsersRepository usersRepository, AuthRepository authRepository) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .hashPassword(encoder.encode(form.getPassword()))
                .build();

        usersRepository.save(user);
    }

    @Override
    public UserForm signIn(SignInForm form) {
        User user = usersRepository.findByEmail(form.getEmail());

        if (user != null && encoder.matches(form.getPassword(), user.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();

            Auth auth = Auth.builder()
                    .user(user)
                    .cookieValue(cookieValue)
                    .build();

            authRepository.save(auth);

            return UserForm.builder()
                    .auth(auth.getCookieValue())
                    .userId(user.getId())
                    .build();
        }
        return null;
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }
}