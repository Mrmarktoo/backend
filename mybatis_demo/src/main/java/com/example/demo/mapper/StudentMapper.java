package com.example.demo.mapper;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author marktoo
 * @since 2020/1/30
 */
@Mapper
public interface StudentMapper {
    @Select("select id,name,address from student where id=#{id}")
    Student findById(Long id);
}
