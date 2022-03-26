package gr.uoi.cs.daintiness.sticky.service;

import java.util.List;

import gr.uoi.cs.daintiness.sticky.model.StickyNote;

public interface StickyServiceInterface {

	List<StickyNote> getAllStickyNotes();

	String showMostUrgentSticky();

	int addNewStickyNote(String title, String text, int urgency, int workload);

	int addNewStickyNote(StickyNote newSticky);

	boolean removeStickyNote(String title);

}