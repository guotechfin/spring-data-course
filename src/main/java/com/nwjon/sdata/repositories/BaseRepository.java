package com.nwjon.sdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.Async;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jondann on 8/1/16.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Async
    public List<T> findByIds(ID...ids);
}
