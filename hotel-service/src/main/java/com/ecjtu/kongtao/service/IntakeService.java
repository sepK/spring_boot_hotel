package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Intake;
import com.ecjtu.kongtao.utils.Msg;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface IntakeService {
    List<Intake> getIntakes();

    Intake getIntake(Integer id);

    Msg saveIntake(Intake intake);

    Msg addIntake(Intake intake);

    boolean delIntake(Integer id);

    List<Intake> searchIntakes(String cusName);

    Intake getIntakeByCusNameAndRoomId(Integer roomid, String cusname);
}
