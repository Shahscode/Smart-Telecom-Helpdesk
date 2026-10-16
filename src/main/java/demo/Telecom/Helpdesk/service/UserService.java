package demo.Telecom.Helpdesk.service;

import demo.Telecom.Helpdesk.model.Role;
import demo.Telecom.Helpdesk.model.User;
import demo.Telecom.Helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String name, String email, Role role) {
        User user = User.builder()
                .name(name)
                .email(email)
                .role(role)
                .build();
        return userRepository.save(user);
    }
}