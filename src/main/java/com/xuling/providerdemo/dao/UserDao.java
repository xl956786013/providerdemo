package com.xuling.providerdemo.dao;

import com.xuling.providerdemo.model.User;
import com.xuling.providerdemo.model.dto.UserDto;
import com.xuling.providerdemo.model.vo.UserVo;
import com.xuling.providerdemo.utils.MapUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends BaseDao {
    public User getUserById(Integer id){
        return getSqlSession().selectOne("User.getUserById",id);
    }

    public Integer saveUser(UserDto user){
        return getSqlSession().insert("User.saveUser",user);
    }

    public User getUserByUserName(String userName, Integer delFlg){
        return getSqlSession().selectOne("User.getUserByUserName",MapUtils.buildKeyValueMap("userName",userName,"delFlg",delFlg));
    }

    public Integer queryUserPageCount(UserDto userDto){
        return getSqlSession().selectOne("User.queryUserPageCount",userDto);
    }
    public List<UserVo> queryUserPage(UserDto userDto) {
        return getSqlSession().selectList("User.queryUserPage",userDto);
    }

    public Integer deleteUserByIdList(UserDto userDto) {
        return getSqlSession().update("User.deleteUserByIdList",userDto);
    }
}
