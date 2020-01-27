package com.xuling.providerdemo.service.manager;

import com.xuling.providerdemo.dao.UserDao;
import com.xuling.providerdemo.model.Result;
import com.xuling.providerdemo.model.User;
import com.xuling.providerdemo.model.dto.UserDto;
import com.xuling.providerdemo.model.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager {
    private static Logger log=LoggerFactory.getLogger(UserManager.class);
    @Autowired
    private UserDao userDao;

    public Result<String> registerUser(UserDto user) {
        Result<String> result;
        User userInfo = userDao.getUserByUserName(user.getUserName(),0);
        if (userInfo!=null){
            result = new Result<>();
            result.setCode(Result.FAIL);
            result.setInfo("用户名已存在");
            return result;
        }
        userDao.saveUser(user);
        result = new Result<>();
        result.setCode(Result.SUCCESS);
        return result;
    }

    public Result<List<UserVo>> queryUserPage(UserDto user) {
        user.setStart((user.getPage() - 1) * user.getLimit());
        Integer count = userDao.queryUserPageCount(user);
        if (count != null && count == 0){
            Result<List<UserVo>> listResult = new Result<List<UserVo>>();
            listResult.setCode(Result.SUCCESS);
            listResult.setTotal(0);
            return listResult;
        }
        List<UserVo> userList = userDao.queryUserPage(user);
        Result<List<UserVo>> listResult = new Result<List<UserVo>>();
        listResult.setCode(Result.SUCCESS);
        listResult.setData(userList);
        listResult.setTotal(count);
        return listResult;
    }

    public Result<String> deleteUserByIdList(UserDto userDto) {
        Result<String> result = new Result<>();
        Integer count = userDao.deleteUserByIdList(userDto);
        if (!count.equals(userDto.getUserIdList().size())){
            result.setCode(Result.FAIL);
            result.setInfo("删除用户失败");
            return result;
        }
        result.setCode(Result.SUCCESS);
        return result;
    }
}
