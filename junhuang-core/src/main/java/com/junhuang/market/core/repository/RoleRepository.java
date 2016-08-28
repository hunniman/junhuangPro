package com.junhuang.market.core.repository;

import com.junhuang.market.core.domain.Role;
import com.junhuang.market.core.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created
 * by pengweiyuan on 7/12/16.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
}
