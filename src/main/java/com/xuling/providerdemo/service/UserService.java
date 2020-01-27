package com.xuling.providerdemo.service;

import com.xuling.providerdemo.model.Result;
import com.xuling.providerdemo.model.User;
import com.xuling.providerdemo.model.dto.UserDto;
import com.xuling.providerdemo.model.vo.UserVo;

import java.util.List;

public interface UserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * 根据用户名查询用户
     * @param userName
     * @param delFlg
     * @return
     */
    public User getUserByUserName(String userName, Integer delFlg);

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Result<String> registerUser(UserDto user);

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    Result<List<UserVo>> queryUserPage(UserDto user);

    /**
     * 根据用户id删除用户
     * @param userDto
     * @return
     */
    Result<String> deleteUserByIdList(UserDto userDto);
}
