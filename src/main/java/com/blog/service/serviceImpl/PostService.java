package com.blog.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.model.Post;
import com.blog.repository.PostRepository;
import com.blog.service.Service;

@org.springframework.stereotype.Service
public class PostService implements Service{
	
	@Autowired
	private PostRepository pr;
	
	@Override
	public List<Post> findAll() {
		return pr.findAll();
	}

	@Override
	public Post findById(Long id) {
		return pr.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return pr.save(post);
	}

}
