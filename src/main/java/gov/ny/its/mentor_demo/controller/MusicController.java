package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.repo.AlbumRepo;
import gov.ny.its.mentor_demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
	@Autowired
	private AlbumService albumService;

	@Autowired
	private AlbumRepo albumRepo;

	@GetMapping("/music")
	public String getMusic(Model m) {
		m.addAttribute("albums", albumRepo.findAll());

		return "music/home";
	}
}
