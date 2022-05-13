package com.example.myservice.controller;

import com.example.myservice.dao.Dept2Dao;
import com.example.myservice.dao.Dept3Dao;
import com.example.myservice.dao.DeptDao;
import com.example.myservice.dao.EmpDao;
import com.example.myservice.model.Dept;
import com.example.myservice.model.Dept2;
import com.example.myservice.model.Dept3;
import com.example.myservice.model.Emp;
import com.example.myservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.myservice.controller
 * fileName : DeptController
 * author : ds
 * date : 2022-05-12
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @RestController : 메뉴달기, 반환값 : JSON 파일 형태
// @Controller : jsp, html, 타임리프 파일 형태
//    Rest API : 웹에서 프로토콜로 던질때 CRUD를 밑 방식으로 씀
//    CRUD (Insert : Post, Select : Get, Update : Put, Delete : Delete)
@RestController
public class DeptController {

//    @Autowired : 객체를 자동으로 의존성 주입을 해줌(자동 DI)
    @Autowired
    DeptDao deptDao;

    @Autowired
    Dept2Dao dept2Dao;

    @Autowired
    Dept3Dao dept3Dao;

    @Autowired
    EmpDao empDao;
    
//    @Autowired : 자동 의존성 주입(DI), 대상 : 스프링에 등록된 객체만 해줌
//    스프링에 객체를 등록 : 클래스 위에 @Component, @Service, @Repository
    @Autowired
    DeptServiceImpl deptService;

    @Autowired
    Dept2ServiceImpl dept2Service;

    @Autowired
    Dept3ServiceImpl dept3Service;

    @Autowired
    EmpServiceImpl empService;

//    @GetMapping : 메뉴달기 : /main, Select 실행
//    localhost:8000/main 접속 : 새메뉴
//    @GetMapping("/main")

    @GetMapping("/dept/all")
    public List<Dept> selectAll(){
//        List<Dept> list = deptDao.selectList();
        List<Dept> list = deptDao.selectAll();
        return list;
    }

//    @PostMapping : Insert 실행
//    HTML을 예로들어서 : 헤더(머리말)와 본문(BODY)이 있음
//    @RequestBody : 본문에 TEXT / JSON 형태로 데이터를 전송하겠다 라는 뜻
    @PostMapping("/dept/new")
    public List<Dept> insertMember(@RequestBody Dept dept){
//        웹 브라우저에서 Json 형태로 데이터를 넘겨 받아(dept 객체)
//        DB에 INSERT문을 실행하는 부분
        deptService.insertMember(dept);
//        데이터 추가되었는지 결과 확인(DB Select)
//        return deptDao.selectList();
        return deptDao.selectAll();
    }

    @PostMapping("/dept2/new")
    public List<Dept2> insertMember(@RequestBody Dept2 dept2){
        dept2Service.insertMember(dept2);
        return dept2Dao.selectAll();
    }

    @PostMapping("/dept3/new")
    public List<Dept3> insertMember(@RequestBody Dept3 dept3){
        dept3Service.insertMember(dept3);
        return dept3Dao.selectAll();
    }

    @GetMapping("/emp/all")
    public List<Emp> selectAll2(){
        List<Emp> list = empDao.selectAll();
        return list;
    }

    @PostMapping("/emp/new")
    public List<Emp> insertMember(@RequestBody Emp emp){
        empService.insertMember(emp);
        return null;
    }
}
