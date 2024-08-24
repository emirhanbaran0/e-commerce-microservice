package com.emirhan.baran.user_ms.service;

import com.emirhan.baran.user_ms.dto.AddressRegisterDto;
import com.emirhan.baran.user_ms.dto.UserProfileDto;
import com.emirhan.baran.user_ms.dto.UserRegisterDto;
import com.emirhan.baran.user_ms.entity.User;
import com.emirhan.baran.user_ms.repository.UserRepository;
import com.emirhan.baran.user_ms.util.GenericMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GenericMapper genericMapper;

    public UserProfileDto getByUserId(Long id) {
        Optional<User> user=userRepository.findById(id);
        return user.map(mappedUser -> genericMapper.convertEntityToTargetEntity(mappedUser, UserProfileDto.class)).orElse(null);
    }

    @Transactional
    public boolean saveUser(UserRegisterDto userRegisterDto){
        try {
            User user=genericMapper.convertEntityToTargetEntity(userRegisterDto, User.class);
            userRepository.save(user);
            return true;
        }catch (Exception e){
            System.out.println("Error saving user: "+e.getMessage());
            return false;
        }

    }
}
