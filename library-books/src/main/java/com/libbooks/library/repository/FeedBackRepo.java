package com.libbooks.library.repository;

import com.libbooks.library.model.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepo extends JpaRepository<FeedBack,Integer> {
}
