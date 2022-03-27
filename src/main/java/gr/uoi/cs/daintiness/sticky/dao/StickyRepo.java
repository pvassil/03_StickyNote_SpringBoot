package gr.uoi.cs.daintiness.sticky.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import gr.uoi.cs.daintiness.sticky.model.StickyNote;

/**
 * 
 * 
 * @author pvassil
 *
 */

@Repository
@Qualifier("StickyRepo")
public class StickyRepo implements StickyRepoInterface {
	private List<StickyNote> notesRepo;

	public StickyRepo() {
		super();
		this.notesRepo = new ArrayList<StickyNote>();
		
		notesRepo.add(new StickyNote("Run", "There goes the siren", 20, 20));
		notesRepo.add(new StickyNote("Live to Fly", "that warns of the air raid", 10, 10));
		notesRepo.add(new StickyNote("Fly to Live", "There comes the sound", 30, 30));
		notesRepo.add(new StickyNote("Do or Die", "of the guns sending flak", 20, 40));
	}//end constructor
	
	
	/**
	 * Defensive programming: does not allow access to the internal attribute
	 * but returns a copy, with the items in it
	 * 
	 * @return a List<StickyNote> with the items of the notesRepo
	 */
	@Override
	public List<StickyNote> getAllStickyNotes(){
		List<StickyNote> clone = new ArrayList<StickyNote>();
		clone.addAll(0, this.notesRepo);
		return clone;
	}

	@Override
	public StickyNote getStickyByTitle(String aTitle) {
		StickyNote result = null;
		for(StickyNote r: this.notesRepo) {
			if(r.getTitle().equals(aTitle))
				return r;
		}
		return result;
	}

	@Override
	public int addSticky(String title, String text, int urgency, int workload) {
		this.notesRepo.add(new StickyNote(title, text, urgency, workload));
		return this.notesRepo.size();
	}
	
	@Override
	public int addSticky(StickyNote newSticky) {
		this.notesRepo.add(newSticky);
		return this.notesRepo.size();
	}
	
	@Override
	public boolean delSticky(String title) {
		String cleanTitle = title.trim();
		for(StickyNote iter: this.notesRepo) {
			if(iter.getTitle().trim().equals(cleanTitle)) {
				return this.notesRepo.remove(iter);
			}
		}			
		return false;
	}
	

	
}//end class
