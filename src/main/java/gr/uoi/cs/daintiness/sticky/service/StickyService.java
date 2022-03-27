package gr.uoi.cs.daintiness.sticky.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import gr.uoi.cs.daintiness.sticky.dao.StickyRepoInterface;
import gr.uoi.cs.daintiness.sticky.model.StickyNote;

/**
 * 
 * 
 * @author pvassil
 *
 */

@Service
@Qualifier("StickyService")
public class StickyService implements StickyServiceInterface {
	
	private StickyRepoInterface stickyRepo;
	
	@Autowired
	public StickyService(StickyRepoInterface aStickyRepo) {
		this.stickyRepo = aStickyRepo;
	}//end constructor
	
	@Override
	public List<StickyNote> getAllStickyNotes() {
		return this.stickyRepo.getAllStickyNotes();
	}
	
	@Override
	public String showMostUrgentSticky() {	
		List<StickyNote> notesRepo = stickyRepo.getAllStickyNotes();
		Collections.sort(notesRepo,new Comparator<StickyNote>() {
			@Override
			public int compare(StickyNote o1, StickyNote o2) {
			    //return Integer.compare(o1.getUrgency(), o2.getUrgency());
				return Integer.valueOf(o1.getUrgency()).compareTo(Integer.valueOf(o2.getUrgency()));
			}
			}.reversed());
		
		return notesRepo.get(0).getTitle();
	}
	
	@Override
	public int addNewStickyNote(String title, String text, int urgency, int workload) {
		return stickyRepo.addSticky(title, text, urgency, workload);
	}
	
	@Override
	public int addNewStickyNote(StickyNote newSticky) {
		return stickyRepo.addSticky(newSticky);
	}
	
	@Override
	public boolean removeStickyNote(String title) {
		return this.stickyRepo.delSticky(title);
	}
	
}//end class
