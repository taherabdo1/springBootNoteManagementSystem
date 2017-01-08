package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practise.springBoot.dao.NoteRepository;
import practise.springBoot.dao.UserRepository;
import practise.springBoot.entities.User;

@RestController
@RequestMapping(value="/note")
public class NoteResource {

	@Autowired
	NoteRepository noteRepository;
	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/getAll")
	public String testService() {
		User user = userRepository.findOne(1);
		System.out.println("user name: " + user.getFullName()+" +++++++++++++++++++++++++++++++++++++++++++++++");
		return "first note description" + noteRepository.getUserNotes(user).get(0).getDescription();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTodaysNotes")
	public String todaysNotesService() {
		User user = userRepository.findOne(1);
		System.out.println("user name: " + user.getFullName()+" +++++++++++++++++++++++++++++++++++++++++++++++");
		return "today's note description" + noteRepository.getTodayNotesOfUser(user).get(0).getDescription();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getNotesServiceBetweenDates")
	public String getNotesServiceBetweenDates() {
		User user = userRepository.findOne(1);
		System.out.println("user name: " + user.getFullName()+" +++++++++++++++++++++++++++++++++++++++++++++++");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		Date date2 = new Date();
		date1.setYear(117);
		date1.setMonth(0);
		date1.setDate(5);
		
		date2.setYear(117);
		date2.setMonth(0);
		date2.setDate(10);
		Object[] data = noteRepository.getByStartAndEndDates( date1 ,date2, user.getId()).get(0);
		return "today's note description: \n start Date:" + data[0]+"\n total period: "+data[1]+"\n notes: "+data[2];
	}
}
