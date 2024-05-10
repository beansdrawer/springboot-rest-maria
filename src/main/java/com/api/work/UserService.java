package com.api.work;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getList() {
        return this.userRepository.findAll();
    }
    
    public void addUser(User user) {
    	this.userRepository.save(user);
    }
    
    public User getUser(Integer id) {
    	Optional<User> defUser = this.userRepository.findById(id);
    	if(defUser.isPresent()) {
    		return defUser.get();
    	}else {
    		return null;
    	}
    }
    public void updateUser(User user, String name) {
    	user.setName(name);
    	this.userRepository.save(user);
	}
    public void deleteUser(User user) {
    	this.userRepository.delete(user);
	}

}
