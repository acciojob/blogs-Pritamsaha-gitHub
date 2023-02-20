package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){

        Image image=new Image();
        image.setBlog(blog);
        image.setDescription(description);
        image.setDimensions(dimensions);
        List<Image>currentList=blog.getImageList();
        currentList.add(image);
        blog.setImageList(currentList);
        blogRepository.save(blog);
        return image;
    }

    public void deleteImage(Image image){
        imageRepository2.delete(image);
    }

    public Image findById(int id) {
        Blog blog=imageRepository2.findById(id).get().getBlog();
        List<Image>imageList=blog.getImageList();
        imageList.remove(imageRepository2.findById(id).get());
        blog.setImageList(imageList);
        blogRepository.save(blog);
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {

        String dimensions = image.getDimensions();
        int xi = 0;
        int yi = 0;
        int xs = 0;
        int ys = 0;
        int num = 0;
        for(int i = 0; i<dimensions.length(); i++){
            if(dimensions.charAt(i) == 'X'){
                xi = num;
                num = 0;
                continue;
            }
            num *= 10;
            num += (dimensions.charAt(i) - '0');
        }
        yi = num;
        num = 0;
        for(int i = 0; i<screenDimensions.length(); i++){
            if(screenDimensions.charAt(i) == 'X'){
                xs = num;
                num = 0;
                continue;
            }
            num *= 10;
            num += (screenDimensions.charAt(i) - '0');
        }
        ys = num;
        double a=Double.valueOf(xs);
        double b=Double.valueOf(xi);
        double c=Double.valueOf(ys);
        double d=Double.valueOf(yi);

        int ans = (int) (Math.floor(a/b) * Math.floor(c/d));
        return ans;
    }
}
