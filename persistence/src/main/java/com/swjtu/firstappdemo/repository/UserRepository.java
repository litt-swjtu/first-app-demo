package com.swjtu.firstappdemo.repository;

import com.swjtu.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 * @author 李天峒
 * @date 2019/5/29 0:08
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 -> Map
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<Integer, User>();

    private final static AtomicInteger ID_GENERATOR = new AtomicInteger();


    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return  如果保存成功，返回<code>true</code>,
     *         否则，返回<code>false</code>
     */
    public boolean save(User user){

        //Id 从 1 开始
        Integer id = ID_GENERATOR.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
