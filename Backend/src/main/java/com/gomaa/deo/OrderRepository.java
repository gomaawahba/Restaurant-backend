package com.ahmed.deo;

import com.ahmed.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //// http://localhost:8080/orders


    //public Page<Order> findByCategoryId(Long id, Pageable pageable);

    // Like  key%  %key  %key%
  //  public Page<Order> findByNameContaining(String name, Pageable pageable);


    public Page<Order> findByCategoryId(Long id,Pageable pageable);

    public  Page<Order> findByNameContaining(String name,Pageable pageable);
    @Query("select count (id) from Order where category.id = ?1")
    public long getOrderLengthByCategoryId(long id);

    @Query("select count (id) from Order where name LIKE %?1%")
    public long getOrderSizeByKey(String key);

/*

    @Order("select count (id) from Order where category.id = ?1")
    public long getOrderLengthByCategoryId(long id);

    @Query("select count (id) from Order where name LIKE %?1%")
    public long getOrderSizeByKey(String key);

*/
}