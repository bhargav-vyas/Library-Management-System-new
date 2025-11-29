package com.tkaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tkaEntity.Member;

public interface  MemberRepository extends JpaRepository<Member, Long> {
	
	
}
