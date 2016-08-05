package com.myPoc;

import org.springframework.boot.SpringApplication;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends ResourceSupport {


	public static void main(String[] args) {
		SpringApplication.run(User.class, args);
	}
	private final String userId;
	private final String content;

    @JsonCreator
    public User(@JsonProperty("content") String content, @JsonProperty("userId") String userId) {
    	this.userId = userId;
        this.content = content;
    }

	public String getUserId() {
		return userId;
	}
    public String getContent() {
        return content;
    }
}
