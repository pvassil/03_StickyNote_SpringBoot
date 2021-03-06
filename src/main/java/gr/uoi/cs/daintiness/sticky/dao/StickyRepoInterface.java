package gr.uoi.cs.daintiness.sticky.dao;

import java.util.List;

import gr.uoi.cs.daintiness.sticky.model.StickyNote;

public interface StickyRepoInterface {


	List<StickyNote> getAllStickyNotes();

	StickyNote getStickyByTitle(String aTitle);

	int addSticky(String title, String text, int urgency, int workload);

	int addSticky(StickyNote newSticky);

	boolean delSticky(String title);

}