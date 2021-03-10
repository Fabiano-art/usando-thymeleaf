package com.blog.service;

import java.util.List;

import com.blog.model.Post;

public interface Service {
		
	List<Post> findAll();
	Post findById(Long id);
	Post save(Post post);

}
