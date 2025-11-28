package com.tkaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkaEntity.BorrowRecord;
@Repository
public interface  BorrowRecordRepository extends JpaRepository<	BorrowRecord, Long> {
	
	
}
