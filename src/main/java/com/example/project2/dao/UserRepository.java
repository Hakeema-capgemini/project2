package com.example.project2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project2.vo.UserVO;
@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {


}
