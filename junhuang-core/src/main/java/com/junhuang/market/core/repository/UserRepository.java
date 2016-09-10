package com.junhuang.market.core.repository;

import com.junhuang.market.core.common.CacheConstants;
import com.junhuang.market.core.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created
 * by pengweiyuan on 7/12/16.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByUserNameAndPassword(String userName, String password);

    User findByUserName(String userName);

    @Cacheable(value = CacheConstants.USER_DATA_CACHE, key = "#email")
    User findByEmail(String email);
}
