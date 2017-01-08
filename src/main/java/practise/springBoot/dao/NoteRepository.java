package practise.springBoot.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import practise.springBoot.entities.Note;
import practise.springBoot.entities.User;

@Transactional
public interface NoteRepository extends
		PagingAndSortingRepository<Note, Serializable> {

	public List<Note> findByStartDate(Date date);

	@Query(value = "SELECT start_date, sum(period),  string_agg(description, ',') FROM Note n where n.user = :uId group by start_date having start_date between :date1 and :date2" , nativeQuery = true)
	public List<Object[]> getByStartAndEndDates(@Param("date1") Date date1, @Param("date2") Date date2, @Param("uId") Integer uId);

	@Query("Select n from Note n, User u where n.user.id = :#{#user.id}")
	public List<Note> getUserNotes(@Param("user") User user);
	
	@Query("Select n from Note n, User u where n.user.id = :#{#user.id} And n.startDate = CURRENT_DATE")
	public List<Note> getTodayNotesOfUser(@Param("user")User user);

}
