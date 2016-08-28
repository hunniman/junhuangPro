package com.junhuang.market.core.repository;

import com.junhuang.market.core.domain.Menu;
import com.junhuang.market.core.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created
 * by pengweiyuan on 7/12/16.
 */
@Repository
public interface MenuRepository extends CrudRepository<Menu, String> {
    List<Menu>findALLOrderByOrder();
}
