package io.github.seevae.mapper;/*
    name zhang;
    */

import io.github.seevae.bz.UserGroom;
import io.github.seevae.po.User;
import io.github.seevae.po.UserExtend;

import java.util.List;

public interface UserMapper {
        public User queryUserById(int id) throws Exception;
        public List<UserExtend> queryByMoreCon(UserGroom userGroom) throws Exception;
        public List<User> queryByMoreCon2(User userGroom) throws Exception;
        public int queryNumber(UserGroom userGroom) throws Exception;
        public List<User> testForEach(UserGroom userGroom) throws Exception;
}
