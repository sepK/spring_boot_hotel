package com.ecjtu.kongtao.service.impl;


import org.springframework.stereotype.Service;

/**
 * @author sepK
 */
@Deprecated
@Service
public class PhotoServiceImpl{
/*    @Resource
    private RoomService roomService;

    @Override
    public List<Photo> getPhotos() {
        return photoMapper.selectByExample(null);
    }

    @Override
    public Photo getPhoto(Integer id) {
        return photoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean savePhoto(Photo photo) {
        return photoMapper.updateByPrimaryKey(photo) > 0;
    }

    @Override
    public boolean addPhoto(Photo photo) {
        try {
            if(roomService.getRoom(photo.getRoomId())==null){
                throw new RoomNotFoundException("房间找不到");
            }else{
                photoMapper.insert(photo);
                return true;
            }
        }catch (RoomNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new ExtraException(e.getMessage());
        }
    }

    @Override
    public List<Photo> searchPhotos(Integer roomId) {
        PhotoExample example = new PhotoExample();
        PhotoExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        return photoMapper.selectByExample(example);
    }

    @Override
    public boolean delPhoto(Integer id) {
        return photoMapper.deleteByPrimaryKey(id) > 0;
    }*/
}
