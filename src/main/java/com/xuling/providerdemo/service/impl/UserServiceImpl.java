package com.xuling.providerdemo.service.impl;

import com.xuling.providerdemo.dao.UserDao;
import com.xuling.providerdemo.model.Result;
import com.xuling.providerdemo.model.User;
import com.xuling.providerdemo.model.dto.UserDto;
import com.xuling.providerdemo.model.vo.UserVo;
import com.xuling.providerdemo.service.UserService;
import com.xuling.providerdemo.service.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static Logger logger=LoggerFactory.getLogger(UserManager.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserManager userManager;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public User getUserByUserName(String userName,Integer delFlg) {
        return userDao.getUserByUserName(userName,delFlg);
    }

    public Result<String> registerUser(UserDto user) {
        Result<String> result;
        try {
            if (null == user){
                result = new Result<>();
                result.setCode(Result.FAIL);
                result.setInfo("入参不能为空");
                return result;
            }
            if (StringUtils.isEmpty(user.getUserName())){
                result = new Result<>();
                result.setCode(Result.FAIL);
                result.setInfo("用户名不能为空");
                return result;
            }
            if (StringUtils.isEmpty(user.getPassword())){
                result = new Result<>();
                result.setCode(Result.FAIL);
                result.setInfo("密码不能为空");
                return result;
            }
            result = userManager.registerUser(user);
        }catch (Exception e){
            logger.error("注册用户异常：",e);
            result = new Result<>();
            result.setCode(Result.FAIL);
            result.setInfo("注册用户异常");
            return result;
        }
        return result;
    }

    @Override
    public Result<List<UserVo>> queryUserPage(UserDto user) {
        Result<List<UserVo>> result;
        try {
            if (null == user){
                result = new Result<>();
                result.setCode(Result.FAIL);
                result.setInfo("入参不能为空");
                return result;
            }
            if (user.getPage() == null || user.getLimit() == null){
                result = new Result<>();
                result.setCode(Result.FAIL);
                result.setInfo("分页参数错误");
                return result;
            }
            result = userManager.queryUserPage(user);
        }catch (Exception e){
            logger.error("查询用户列表异常：",e);
            result = new Result<>();
            result.setCode(Result.FAIL);
            result.setInfo("查询用户列表异常");
            return result;
        }
        return result;
    }

    @Override
    public Result<String> deleteUserByIdList(UserDto userDto) {
        Result<String> result;
        try {
            if (CollectionUtils.isEmpty(userDto.getUserIdList())){
                result = new Result<>();
                result.setCode(Result.FAIL);
                result.setInfo("用户id集合不能为空");
                return result;
            }
            result = userManager.deleteUserByIdList(userDto);
        }catch (Exception e){
            logger.error("删除用户异常",e);
            result = new Result<>();
            result.setCode(Result.FAIL);
            result.setInfo("删除用户异常");
        }
        return result;
    }
}
