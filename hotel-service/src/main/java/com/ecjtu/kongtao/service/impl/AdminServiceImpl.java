package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.Admin;
import com.ecjtu.kongtao.bean.AdminExample;
import com.ecjtu.kongtao.service.AdminService;
import com.ecjtu.kongtao.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public class AdminServiceImpl extends BaseService implements AdminService {

    @Override
    public boolean checkInfo(Admin admin) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andPasswordEqualTo(admin.getPassword());
        List<Admin> admins = adminMapper.selectByExample(example);
        return admins.size() != 0;
    }
}
