package com.example.jpatest.repository;

import com.example.jpatest.entity.TestMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMemberRepository extends JpaRepository<TestMemberEntity,Long> {

    public TestMemberEntity findByEmailAndPassword(String email, String password);
}
/*
데이터 -  하나의 컬럼에 저장된 하나의 값
레코드 - 각 컬럼에 저장된 데이터의 집합

        save() - > insert , update  새로운 데이터를 테이블에저장, 또는특정 데이터 변경
        findOne() -> 하나의 레코드를찾기,  primarykey로 지정된 컬럼값 을 찾기
        findAll() -> 테이블의 전체 레코드 가져오기( 정렬 , 페이징 가능)
        count() - > 테이블의 전체 레코드 갯수 를 알려준다.
        delete() -> 삭제



        findByName("김똥개")
        ->  select * from 테이블명 where name='김똥개' ;

        select * from 테이블명 where email='입력값' and password='입력값' ;
        findByEmailAndPassword( );

        or  ->   findByEmailOrName( );

        컬럼의 두값 사이에 있는 항목 검색
        BetWeen  ->   findByEmailBetween('a' , 'd')

        포함된 값 검색
        like -> findByNameLike('만');

        정렬 하여 가져오기
        OrderBY  ->  findAllOrderByNameDesc()   Desc-내림차순 , Asc- 오름차순
                 -> findByAgeOrderByIdAsc(30) : 나이가 30인 데이터들을 오름차순으로 정렬해서 가져와라
 */