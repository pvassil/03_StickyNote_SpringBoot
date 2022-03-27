package gr.uoi.cs.daintiness.sticky.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gr.uoi.cs.daintiness.sticky.model.StickyNote;
import gr.uoi.cs.daintiness.sticky.service.StickyServiceInterface;

@Controller
public class StickyController {
	private StickyServiceInterface repoService;
	
	public StickyController(StickyServiceInterface aRepoService) {
		this.repoService = aRepoService;
	}
	
	@RequestMapping(value = "/listMaxUrgency")
	@ResponseBody
	public String showMostUrgent() {
		String urgentTitle = repoService.showMostUrgentSticky();
		return "<p>Max urgent: " + urgentTitle + "</p>";
	}
	

	@RequestMapping(value = "/show_stickies")
	public ModelAndView showAll(ModelMap model) {
		List<StickyNote> stickies = this.repoService.getAllStickyNotes();
		model.addAttribute("stickyNotes", stickies);
		return new ModelAndView("show_stickies", model);
	}

	@RequestMapping(value = "/add_sticky")
	public ModelAndView gotoAddSticky(ModelMap model) {
		StickyNote sticky = new StickyNote("","",0,0);
		model.addAttribute("obj", sticky);
		return new ModelAndView("add_sticky", model);
	}

	@PostMapping("/save")
	public String addSticky(@ModelAttribute("obj") StickyNote newSticky) {
		this.repoService.addNewStickyNote(newSticky);
		return "redirect:/index.html";
	}

	@RequestMapping(value = "/del_sticky")
	public ModelAndView gotoDelSticky(ModelMap model) {
		List<StickyNote> stickies = this.repoService.getAllStickyNotes();
		model.addAttribute("stickyNotes", stickies);

		return new ModelAndView("del_sticky", model);
	}
	
    @RequestMapping("/delete")
    public String deleteSticky(@RequestParam("title") String title) {
 
    	System.out.println("\n\n\n ************* TITLE ************* ");
    	System.out.println(title);
    	this.repoService.removeStickyNote(title);
    	System.out.println("\nSize of list post deletion: " + this.repoService.getAllStickyNotes().size());
    	System.out.println("************************** \n\n\n");
       return "redirect:/index.html";
    }
}//end class



//TODO: https://stackoverflow.com/questions/24661289/spring-boot-not-serving-static-content/