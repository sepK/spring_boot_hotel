package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface CustomerService {

	List<Customer> getCustomers();

	Customer getCustomer(Integer id);

	Boolean delCustomer(Integer id);

	boolean updateCustomer(Customer customer);

	List<Customer> searchCus(String cusName);

	Boolean addCustomer(Customer customer);

	boolean checkName(String name);

    boolean login(Customer customer);
}
