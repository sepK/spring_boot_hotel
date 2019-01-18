package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Admin;
import org.springframework.stereotype.Service;

/**
 * @author sepK
 */
@Service
public interface AdminService {
    /**
     * 检查管理员信息
     * @param admin
     * @return
     */
    boolean checkInfo(Admin admin);
}
