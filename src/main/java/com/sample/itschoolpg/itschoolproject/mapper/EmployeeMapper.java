package com.sample.itschoolpg.itschoolproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.itschoolpg.itschoolproject.entitiy.EmployeeEntity;

@Mapper
public interface EmployeeMapper {
  
  // 社員情報一覧取得(SELECT)
  public List<EmployeeEntity> selectAll();
  // 社員詳細情報取得(SELECT)
  public List<EmployeeEntity> selectDetail(long id);
  // 社員情報検索(SELECT)
  public List<EmployeeEntity> selectName(String name);

  // 社員情報追加(INSERT)
  public void add(EmployeeEntity employeeEntity);

  // 社員情報更新(UPDATE)
  public void update(EmployeeEntity employeeEntity);

  // 社員情報削除(DELETE)
  public void delete(long id);
}
