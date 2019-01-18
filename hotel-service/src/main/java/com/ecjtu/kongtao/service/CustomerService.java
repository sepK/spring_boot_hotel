package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface CustomerService {

	List<User> getCustomers();

	User getCustomer(Integer id);

	Boolean delCustomer(Integer id);

	boolean updateCustomer(User user);

	List<User> searchCus(String user);

	Boolean addCustomer(User user);

	boolean checkName(String name);

    boolean login(User user);
}
