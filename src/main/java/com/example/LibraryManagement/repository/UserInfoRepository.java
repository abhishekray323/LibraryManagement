package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.models.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
