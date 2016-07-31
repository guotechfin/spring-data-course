package com.nwjon.sdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jondann on 7/29/16.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

