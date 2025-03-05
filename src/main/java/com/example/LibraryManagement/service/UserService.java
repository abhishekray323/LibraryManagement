package com.example.LibraryManagement.service;

import com.example.LibraryManagement.models.entity.UserInfo;
import com.example.LibraryManagement.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public UserInfo saveOrUpdate(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }
}
