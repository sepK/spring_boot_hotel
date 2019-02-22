package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.utils.Result;

import java.util.List;

/**
 * @author sepK
 */
@Deprecated
public interface IntakeService {
    List<Housing> getIntakes();

    Housing getIntake(Integer id);

    Result saveIntake(Housing housing);

    Result addIntake(Housing housing);

    boolean delIntake(Integer id);

    List<Housing> searchIntakes(String userName);

    Housing getIntakeByCusNameAndRoomId(Integer roomId, String userName);
}
