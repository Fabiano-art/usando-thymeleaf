package com.blog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/newPost")
	public String getPostForm() {
		return "postForm";
	}
	
	@PostMapping("/newPost")
	public String savePost(@Validated Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/newPost";
		}
		else {
			post.setData(LocalDate.now());
			ser.save(post);
			return "redirect:/posts";
		}
	}
}
