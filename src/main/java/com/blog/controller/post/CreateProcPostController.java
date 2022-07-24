package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProcPostController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcPostController.METHOD;
    }

    private PostDTO makeDTO(HttpServletRequest request) {
        PostDTO dto = new PostDTO();

        dto.setUserId(Integer.valueOf(request.getParameter("userId")));
        dto.setTitle(request.getParameter("title"));
        dto.setBody(request.getParameter("body"));

        return dto;

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDTO dto = makeDTO(request);
        PostService postService = new PostService(request);

        postService.createPost(dto);

        return "/WEB-INF/common/redirect.jsp";
    }
}
