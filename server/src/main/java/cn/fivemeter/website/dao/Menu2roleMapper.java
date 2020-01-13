package cn.fivemeter.website.dao;

import cn.fivemeter.website.model.Menu2role;

public interface Menu2roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu2role record);

    int insertSelective(Menu2role record);

    Menu2role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu2role record);

    int updateByPrimaryKey(Menu2role record);
}