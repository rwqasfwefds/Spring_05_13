package com.example.myservice.dao;

import com.example.myservice.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.myservice.dao
 * fileName : DeptDao
 * author : ds
 * date : 2022-05-12
 * description : 부서 테이블에 접근해서 데이터를 처리 할 클래스(DAO)
 *               하는 일 : CRUD
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @Mapper : myBatis에서 사용하는 어노테이션
//    xml문에서 select문을 작성하게 만들어 줌
//    myBatis랑 DB랑 연동하게 해줌
@Mapper
public interface DeptDao {
//    select문 메소드
    List<Dept> selectList(); // 부서 정보를 select 하는 메소드

    void insert(Dept dept); // 부서 정보를 insert 하는 메소드
}
