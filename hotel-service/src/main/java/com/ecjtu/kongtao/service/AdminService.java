package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Admin;
import org.springframework.stereotype.Service;

/**
 * @author sepK
 */
@Service
public interface AdminService {
    boolean checkInfo(Admin admin);
}
