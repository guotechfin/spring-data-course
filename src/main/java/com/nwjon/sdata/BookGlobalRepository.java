package com.nwjon.sdata;

import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by jondann on 8/1/16.
 */
public interface BookGlobalRepository extends BaseRepository<Book, Long> {

    public List<Book> findByPageCountGreaterThan(int pageCount, Sort sort);
}
