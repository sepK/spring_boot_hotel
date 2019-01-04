package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Photo;
import com.ecjtu.kongtao.exception.RoomNotFoundException;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/photo")
public class PhotoController extends BaseController{

    @RequestMapping(value = "/index07",method = RequestMethod.GET)
    public String toIndex(){
        return "/admin/index07";
    }

    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    @ResponseBody
    public Result getPhotos(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn, 10);
        List<Photo> list = photoService.getPhotos();
        PageInfo<Photo> pageInfo = new PageInfo<>(list, 5);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getPhoto(@PathVariable("id") Integer id){
        Photo photo = photoService.getPhoto(id);
        return Result.success().add("photo", photo);
    }

    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    @ResponseBody
    public Result savePhoto(Photo photo, MultipartFile file){
        upLoadPhoto(file, photo);
        boolean b = photoService.savePhoto(photo);
        return Result.success();
    }

    @RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
    @ResponseBody
    public Result addPhoto(Photo photo, MultipartFile file){
        upLoadPhoto(file, photo);
        String message = null;
        try {
            boolean b = photoService.addPhoto(photo);
            return Result.success();
        }catch (RoomNotFoundException e){
            message = e.getMessage();
        }
        return Result.fail(message);
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delPhoto(@PathVariable("id") Integer id){

        boolean b = photoService.delPhoto(id);
        return Result.success();
    }

    @RequestMapping(value = "/searchPhotos", method = RequestMethod.GET)
    @ResponseBody
    public Result searchPhotos(@RequestParam("roomId") Integer roomId){
        List<Photo> photos = photoService.searchPhotos(roomId);
        return Result.success().add("photos", photos);
    }

    private void upLoadPhoto(MultipartFile file, Photo photo){
        if(!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String path = "F:\\IntelliJ IDEA 2017.3.4\\WorkSpace\\ssm_hotel01\\src\\main\\webapp\\static\\images\\";

            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(path + newFileName);
            photo.setPicture("/images/" + newFileName);
            try {
                file.transferTo(newFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
