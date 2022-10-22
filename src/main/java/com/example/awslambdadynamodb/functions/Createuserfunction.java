package com.example.awslambdadynamodb.functions;

import com.example.awslambdadynamodb.model.UserEntity;
import com.example.awslambdadynamodb.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Component
public class Createuserfunction implements Function<Map<String, String>, UserEntity> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity apply(Map<String, String> stringStringMap) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(stringStringMap, UserEntity.class);
        userEntity.setId(UUID.randomUUID().toString());
        userRepository.save(userEntity);
        return userEntity;
    }
}