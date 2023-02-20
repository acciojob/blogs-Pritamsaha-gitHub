package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        return blogRepository1.blogList();
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {

        Blog blog=new Blog();
        User user=userRepository1.findById(userId).get();

        blog.setUser(user);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());

        List<Blog>currentList=user.getBlogList();
        currentList.add(blog);
        user.setBlogList(currentList);
        userRepository1.save(user);
    }

    public Blog findBlogById(int blogId){
        //find a blog
        Blog blog=blogRepository1.findById(blogId).get();
        return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it


        Blog blog = blogRepository1.findById(blogId).get();
        //Image image = imageService1.createAndReturn(blog, description, dimensions);
                Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(findBlogById(blogId));
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);

        blogRepository1.save(blog);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog=blogRepository1.findById(blogId).get();
        User user=blog.getUser();
        List<Blog>blogList=user.getBlogList();
        blogList.remove(blog);
        user.setBlogList(blogList);
        userRepository1.save(user);
        if (blog !=null){
            blogRepository1.delete(blog);
        }
    }
}
