/**
 * 
 */
package gr.uoi.cs.daintiness.sticky.model;

import java.util.Objects;

/**
 * Demo class for sticky notes 
 * 
 * @author pvassil
 *
 */
public class StickyNote  {
	private String title;
	private String text;
	private int urgency;
	private int workload;
	
	public StickyNote(String title, String text, int urgency, int workload) {
		super();
		this.title = title;
		this.text = text;
		this.urgency = urgency;
		this.workload = workload;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text, title, urgency, workload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StickyNote other = (StickyNote) obj;
		return Objects.equals(text, other.text) && Objects.equals(title, other.title) && urgency == other.urgency
				&& workload == other.workload;
	}

	@Override
	public String toString() {
		return this.title + "\n" + "Urgency: " + "\n" + this.urgency +
				"\n" + "Workload: " + this.workload + "\n" + this.text;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public int getUrgency() {
		return urgency;
	}

	public int getWorkload() {
		return workload;
	}


	
	
	
}//END CLASS
