package com.cust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cust.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
