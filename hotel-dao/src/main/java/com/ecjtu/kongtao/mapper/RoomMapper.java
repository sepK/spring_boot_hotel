package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.room.RoomExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface RoomMapper {

    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(RoomExample example);

    /**
     * 带条件的删除
     * @param example
     * @return
     */
    int deleteByExample(RoomExample example);

    /**
     * 通过主键删除
     * @param roomId
     * @return
     */
    int deleteByPrimaryKey(Integer roomId);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(Room record);

    /**
     * 有选择的插入（允许值为空）
     * @param record
     * @return
     */
    int insertSelective(Room record);

    /**
     * 查询（可以查询到text属性）
     * @param example
     * @return
     */
    List<Room> selectByExampleWithBLOBs(RoomExample example);

    /**
     * 带条件的查询
     * @param example
     * @return
     */
    List<Room> selectByExample(RoomExample example);

    /**
     * 通过主键查询
     * @param roomId
     * @return
     */
    Room selectByPrimaryKey(Integer roomId);

    /**
     * 有选择的更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    /**
     * 带text属性的任意条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") Room record, @Param("example") RoomExample example);

    /**
     * 任意条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    /**
     * 通过主键更新（值允许为空）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Room record);

    /**
     * 通过主键更新（值允许为空，带text属性的）
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Room record);

    /**
     * 通过主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Room record);
}