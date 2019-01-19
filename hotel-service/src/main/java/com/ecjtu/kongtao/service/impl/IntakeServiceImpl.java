package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.service.UserService;

import javax.annotation.Resource;

/**
 * @author sepK
 */
@Deprecated
public class IntakeServiceImpl{
    @Resource
    private RoomService roomService;
    @Resource
    private UserService userService;

/*    @Override
    public List<Intake> getIntakes() {
        return intakeMapper.selectByExample(null);
    }

    @Override
    public Intake getIntake(Integer id) {
        return intakeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result saveIntake(Intake intake) {
        String msg = "";
        try {
            if(intake.getEndTime().compareTo(intake.getStartTime()) <= 0){
                throw new OverTimeException("结束时间小于开始时间");
            }else{
                intakeMapper.updateByPrimaryKeySelective(intake);
                return Result.success();
            }
        }catch (OverTimeException e) {
            msg += e.getMessage();
        }catch (Exception e){
            msg += e.toString();
        }
        return Result.fail(msg);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addIntake(Intake intake) {
        String msg = "";
        try{
            if(roomService.getRoom(intake.getRoomid()) == null) {
                throw new RoomNotFoundException("房间找不到");
            }else{
                if(customerService.checkName(intake.getCusname())){
                    throw new CustomerNotFoundException("用户不存在");
                }else{
                    if(intake.getEndTime().compareTo(intake.getStartTime()) <= 0){
                        throw new OverTimeException("结束时间小于开始时间");
                    }else{
                        String uid = String.valueOf((Math.random() * 9 + 1) * 1000000).substring(0, 7);
                        intake.setId(Integer.parseInt(uid));
                        intakeMapper.insert(intake);
                        return Result.success();
                    }
                }
            }
        }catch (RoomNotFoundException rnfe){
            msg += rnfe.getMessage();
        }catch (CustomerNotFoundException cnfe){
            msg += cnfe.getMessage();
        }catch (OverTimeException ote){
            msg += ote.getMessage();
        }catch (Exception e){
            throw new ExtraException("保存数据失败" + e.toString());
        }
        return Result.fail(msg);
    }

    @Override
    public List<Intake> searchIntakes(String cusName) {
        IntakeExample example = new IntakeExample();
        IntakeExample.Criteria criteria = example.createCriteria();
        criteria.andCusnameLike(cusName);
        return intakeMapper.selectByExample(example);
    }

    @Override
    public Intake getIntakeByCusNameAndRoomId(Integer roomid, String cusname) {
        IntakeExample example = new IntakeExample();
        IntakeExample.Criteria criteria = example.createCriteria();
        criteria.andCusnameEqualTo(cusname);
        criteria.andRoomidEqualTo(roomid);
        return intakeMapper.selectByExample(example).get(0);
    }

    @Override
    public boolean delIntake(Integer id) {
        return intakeMapper.deleteByPrimaryKey(id) > 0;
    }*/

}
