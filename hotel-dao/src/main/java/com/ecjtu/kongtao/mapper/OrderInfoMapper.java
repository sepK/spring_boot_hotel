package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.bean.order.OrderInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface OrderInfoMapper {

    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(OrderInfoExample example);

    /**
     * 带条件的删除
     * @param example
     * @return
     */
    int deleteByExample(OrderInfoExample example);

    /**
     * 通过主键删除
     * @param orderId
     * @return
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(OrderInfo record);

    /**
     * 有选择的插入（允许值为空）
     * @param record
     * @return
     */
    int insertSelective(OrderInfo record);

    /**
     * 查询（可以查询到text属性）
     * @param example
     * @return
     */
    List<OrderInfo> selectByExampleWithBLOBs(OrderInfoExample example);

    /**
     * 带条件的查询
     * @param example
     * @return
     */
    List<OrderInfo> selectByExample(OrderInfoExample example);

    /**
     * 通过主键查询
     * @param orderId
     * @return
     */
    OrderInfo selectByPrimaryKey(Integer orderId);

    /**
     * 有选择的更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    /**
     * 带text属性的任意条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    /**
     * 任意条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    /**
     * 通过主键更新（值允许为空）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * 通过主键更新（值允许为空，带text属性的）
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(OrderInfo record);

    /**
     * 通过主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrderInfo record);
}