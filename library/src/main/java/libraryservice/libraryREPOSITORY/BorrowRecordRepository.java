

package libraryservice.libraryREPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import libraryservice.libraryEntity.BorrwRecordEntity;

	@Repository
	public interface  BorrowRecordRepository extends JpaRepository<BorrwRecordEntity, Long> {
		
		
	}



