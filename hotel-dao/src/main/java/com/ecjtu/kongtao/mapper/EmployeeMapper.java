package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.employee.Employee;
import com.ecjtu.kongtao.bean.employee.EmployeeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface EmployeeMapper {
    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(EmployeeExample example);

    /**
     * 带条件的删除
     *
     * @param example
     * @return
     */
    int deleteByExample(EmployeeExample example);

    /**
     * 通过主键删除
     *
     * @param empId
     * @return
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(Employee record);

    /**
     * 有选择的插入（允许值为空）
     *
     * @param record
     * @return
     */
    int insertSelective(Employee record);

    /**
     * 带条件的查询
     *
     * @param example
     * @return
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * 通过主键查询
     *
     * @param empId
     * @return
     */
    Employee selectByPrimaryKey(Integer empId);

    /**
     * 有选择的更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * 任意条件更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * 通过主键更新（值允许为空）
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * 通过主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Employee record);
}