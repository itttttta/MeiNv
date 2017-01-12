package com.wd.Dao;

import com.wd.Enity.Meinv;

public interface MeinvMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meinv record);

    int insertSelective(Meinv record);

    Meinv selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meinv record);

    int updateByPrimaryKey(Meinv record);
}