package com.example.myservice.service;

import com.example.myservice.dao.DeptDao;
import com.example.myservice.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : DeptServiceImpl
 * author : ds
 * date : 2022-05-12
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @Service : Service 컴포넌트가 되어서 스프링에 객체로 등록 됨(@Component의 자식 격임)
//    왜 객체로 등록이 되냐면 @ComponentScan는 컴포넌트들을 자동으로 검색해서 스프링에 등록해주는 어노테이션인데
//    얘가 검색하는 대상은 @Component, @Service, @repository들이 대상임
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptDao deptDao;

//    @Override
//    public List<Dept> selectList() {
//        return null;
//    }

//    select 문을 실행하는 서비스
    @Override
    public List<Dept> selectAll() {
        return deptDao.selectAll();
    }

    @Override
    public void insertMember(Dept dept) {
//        DB에 insert문 실행하는 부분
        deptDao.insert(dept);
    }
}
