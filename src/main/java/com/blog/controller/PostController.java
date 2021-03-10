package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.Post;
import com.blog.service.Service;

@Controller
public class PostController {
	
	@Autowired
	private Service ser;
	
	@GetMapping("/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> listPost = ser.findAll();
		mv.addObject("posts", listPost);
		return mv;
	}
	
	@GetMapping("/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = ser.findById(id);
		mv.addObject("post", post);
		return mv;
	}
}
