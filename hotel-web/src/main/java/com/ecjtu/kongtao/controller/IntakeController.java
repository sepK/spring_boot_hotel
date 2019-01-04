package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Intake;
import com.ecjtu.kongtao.exception.ExtraException;
import com.ecjtu.kongtao.exception.OverTimeException;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/intake")
public class IntakeController extends BaseController{

    @RequestMapping("/index06")
    public String toIndex(){
        return "/admin/index06";
    }

    @RequestMapping(value = "/intakes",method = RequestMethod.GET)
    @ResponseBody
    public Result getIntakes(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn,10);
        List<Intake> list = intakeService.getIntakes();
        PageInfo<Intake> pageInfo = new PageInfo<>(list,5);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/intake/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getIntake(@PathVariable("id") Integer id){
        Intake intake = intakeService.getIntake(id);
        return Result.success().add("intake", intake);
    }

    @RequestMapping(value = "/intake/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveIntake(Intake intake){
        try{
            return intakeService.saveIntake(intake);
        }catch (OverTimeException ote){
            return Result.fail(ote.getMessage());
        }
    }

    @RequestMapping(value = "/intake", method = RequestMethod.POST)
    @ResponseBody
    public Result addIntake(Intake intake){
        try {
            return intakeService.addIntake(intake);
        }catch (ExtraException ee){
            return Result.fail(ee.getMessage());
        }

    }

    @RequestMapping(value = "/intake/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delIntake(@PathVariable("id") Integer id){
        if(intakeService.delIntake(id)){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping(value = "/searchIntakes", method = RequestMethod.GET)
    @ResponseBody
    public Result searchIntakes(@RequestParam("cusname") String cusName){
        List<Intake> intakes = intakeService.searchIntakes(cusName);
        return Result.success().add("intakes",intakes);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
