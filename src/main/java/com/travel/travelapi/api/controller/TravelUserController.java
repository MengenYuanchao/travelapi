package com.travel.travelapi.api.controller;


import com.github.pagehelper.PageHelper;
import com.travel.travelapi.api.entity.TravelUser;
import com.travel.travelapi.api.entityDo.TravelUserDo;
import com.travel.travelapi.api.service.EmailService;
import com.travel.travelapi.api.service.TravelHobbyService;
import com.travel.travelapi.api.service.TravelUserService;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import com.travel.travelapi.utils.*;
import io.swagger.annotations.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travelUser")
@Api(value = "用户",description = "用户")
public class TravelUserController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TravelUserService travelUserService;
    @Autowired
    private EmailService emailService;


    @ApiOperation(value="用户登录", notes="登录" )
    @ResponseBody
    @PostMapping("/userLogin")
    public ResultMsg<TravelUserDo> userLogin(@RequestBody TravelUserDo travelUserDo){
        logger.info("用户登录请求信息：{}",travelUserDo.toString());
        ResultMsg resultMsg=new ResultMsg();
        try{
            TravelUserDo userDo = travelUserService.userLogin(travelUserDo);
            switch (travelUserDo.getType()){
                case 2://手机号密码登录
                case 6://邮箱登录
                    if (userDo ==null){
                        resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                        resultMsg.setMsg("无该用户信息");
                        return resultMsg;
                    }else if(!userDo.getPassword().equals(SecurityUtils.encryptDbMemberPassword(travelUserDo.getPassword()))){
                        resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                        resultMsg.setMsg("密码错误");
                        return resultMsg;
                    }
                    break;
                case 3://3微信登录
                case 4://QQ号登录
                case 5://微博登录
                    if(userDo == null) {
                        TravelUser travelUser = new TravelUser();
                        travelUserDo.setId(RandomUtil.getUuid());
                        BeanUtils.copyProperties(travelUser, travelUserDo);
                        travelUserService.insert(travelUser);
                    }
                    break;
                default:
                    resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                    resultMsg.setMsg("未知的登录类型");
                    break;
            }
            if(resultMsg.getCode()==ResultEnum.SUCCESS_CODE.getCode()){
                if(userDo!=null){
                     BeanUtils.copyProperties(travelUserDo, userDo);
                }
                resultMsg.setData(travelUserDo);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("登录失败");
            logger.info("用户登录失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="用户注册", notes="注册" )
    @ResponseBody
    @PostMapping("/registerUser")
    public ResultMsg registerUser(@RequestBody TravelUserDo travelUserDo,@ApiParam(value = "邮箱验证码") @RequestParam(value = "code", required = true) String code){
        logger.info("用户注册请求信息：{}",travelUserDo.toString());
        ResultMsg resultMsg=new ResultMsg();
        try{
            TravelUserDo userDo = travelUserService.userLogin(travelUserDo);
            if(userDo!=null){
                resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                resultMsg.setMsg("该邮箱已注册");
                return resultMsg;
            }
            String[] msgCode = JobConstUtils.emailCodeMap.get(travelUserDo.getEmail());
            if (msgCode == null) {
                resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                resultMsg.setMsg("验证码已过期");
                return resultMsg;
            }
            if (!msgCode[0].equals(code)) {
                resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                resultMsg.setMsg("验证码输入有误");
                return resultMsg;
            }
            TravelUser travelUser = new TravelUser();
            travelUserDo.setId(RandomUtil.getUuid());
            BeanUtils.copyProperties(travelUser, travelUserDo);
            travelUserService.insert(travelUser);
            resultMsg.setMsg("注册成功");
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("注册失败");
            logger.info("用户注册失败失败，失败信息：{}",e.getMessage());
        }

        return resultMsg;
    }

    /*@ApiOperation(value="发送短信码", notes="发送短信验证码" )
    @ResponseBody
    @GetMapping("/sendMsg")
    @ApiImplicitParam(name = "phone", value = "手机号", paramType = "query", required = true, dataType = "String")
    public ResultMsg sendMsg(@RequestParam(value = "phone", required = true) String phone){
        ResultMsg resultMsg=new ResultMsg();
        try {
            if (!StringUtils.isBlank(phone)) {
                if (phone.trim().length() != 11) {
                   resultMsg.setCode(1001);
                   resultMsg.setMsg("手机号输入错误");
                   return resultMsg;
                }
                phone = phone.trim();
                String captcha = RandomUtil.randomNumber(6);
                String[] codeAry = new String[2];
                codeAry[0] = captcha;
                codeAry[1] = String.valueOf(System.currentTimeMillis());
                JobConstUtils.msgCodeMap.put(phone, codeAry);
                resultMsg.setData(captcha);
                logger.info("手机获取验证码成功");
                return resultMsg;
            } else {
                resultMsg.setCode(1001);
                resultMsg.setMsg("参数缺失");
                return resultMsg;
            }
        } catch (Exception e) {
            logger.info("手机获取验证码失败！失败信息："+e.getMessage());
            resultMsg.setCode(1001);
            resultMsg.setMsg("系统异常");
            return resultMsg;
        }
    }*/

    /*@ApiOperation(value="手机号忘记密码", notes="忘记密码" )
    @ResponseBody
    @PostMapping("/findPasswordByPhone")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "phone", value = "手机号",  paramType = "query", required = true, dataType = "String"),
    @ApiImplicitParam(name = "code", value = "手机验证码",  paramType = "query", required = true, dataType = "String"),
    @ApiImplicitParam(name = "password", value = "密码",  paramType = "query", required = true, dataType = "String")})
    public ResultMsg findPasswordByPhone(@RequestParam(value = "phone", required = true) String phone,
                                  @RequestParam(value = "code", required = true) String code,
                                  @RequestParam(value = "password", required = true) String password){
        ResultMsg resultMsg=new ResultMsg();
        if (phone.trim().length() != 11) {
            resultMsg.setCode(1001);
            resultMsg.setMsg("手机号输入错误");
            return resultMsg;
        }
        if (StringUtils.isBlank(code)) {
            resultMsg.setCode(1001);
            resultMsg.setMsg("手机验证码不能为空");
            return resultMsg;
        }
        if (StringUtils.isBlank(password)) {
            resultMsg.setCode(1001);
            resultMsg.setMsg("密码不能为空");
            return resultMsg;
        }
        //查询手机号是否注册过
        TravelUserDo userDo =travelUserService.getTravelUserByMobile(phone,"");
        if(userDo == null){
            resultMsg.setCode(1001);
            resultMsg.setMsg("该手机号还未注册");
            return resultMsg;
        }
        String[] msgCode = JobConstUtils.msgCodeMap.get(phone);
        if (msgCode == null) {
            resultMsg.setCode(1001);
            resultMsg.setMsg("验证码已过期");
            return resultMsg;
        }
        if (!msgCode[0].equals(code)) {
            resultMsg.setCode(1001);
            resultMsg.setMsg("验证码输入有误");
            return resultMsg;
        }
        TravelUser travelUser = new TravelUser();
        travelUser.setId(userDo.getId());
        travelUser.setPassword(SecurityUtils.encryptDbMemberPassword(password));
        int cou = travelUserService.updateByPrimaryKeySelective(travelUser);
        if(cou>0){
            return resultMsg;
        }else{
            resultMsg.setCode(1001);
            resultMsg.setMsg("修改密码失败");
            return resultMsg;
        }
    }*/


    @ApiOperation(value="发送邮箱验证码", notes="发送邮箱验证码" )
    @ResponseBody
    @PostMapping("/sendEmailMsg")
    @ApiImplicitParam(name = "email", value = "邮箱", paramType = "query", required = true, dataType = "String")
    public ResultMsg sendEmailMsg(@RequestParam(value = "email", required = true) String email){
        ResultMsg resultMsg=new ResultMsg();
        try {
            String captcha = RandomUtil.randomNumber(6);
            String[] codeAry = new String[2];
            codeAry[0] = captcha;
            codeAry[1] = String.valueOf(System.currentTimeMillis());
            JobConstUtils.emailCodeMap.put(email, codeAry);
            resultMsg.setData(captcha);
            emailService.sendSimpleMail(email,"验证码",captcha);
            logger.info("验证码已发送");
            return resultMsg;

        } catch (Exception e) {
            logger.info("发送验证码失败！失败信息："+e.getMessage());
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("发送验证码失败");
            return resultMsg;
        }
    }

    @ApiOperation(value="邮箱忘记密码", notes="忘记密码" )
    @ResponseBody
    @PostMapping("/findPasswordByEmail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱",  paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "code", value = "手机验证码",  paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",  paramType = "query", required = true, dataType = "String")})
    public ResultMsg findPasswordByEmail(@RequestParam(value = "email", required = true) String email,
                                         @RequestParam(value = "code", required = true) String code,
                                         @RequestParam(value = "password", required = true) String password){
        ResultMsg resultMsg=new ResultMsg();

        if (StringUtils.isBlank(code)) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("验证码不能为空");
            return resultMsg;
        }
        if (StringUtils.isBlank(password)) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("密码不能为空");
            return resultMsg;
        }
        //查询手机号是否注册过
        TravelUserDo userDo =travelUserService.getTravelUserByMobile("",email);
        if(userDo == null){
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("该邮箱还未注册");
            return resultMsg;
        }
        String[] msgCode = JobConstUtils.emailCodeMap.get(email);
        if (msgCode == null) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("验证码已过期");
            return resultMsg;
        }
        if (!msgCode[0].equals(code)) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("验证码输入有误");
            return resultMsg;
        }
        TravelUser travelUser = new TravelUser();
        travelUser.setId(userDo.getId());
        travelUser.setPassword(SecurityUtils.encryptDbMemberPassword(password));
        int cou = travelUserService.updateByPrimaryKeySelective(travelUser);
        if(cou>0){
            return resultMsg;
        }else{
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("修改密码失败");
            return resultMsg;
        }
    }

    @ApiOperation(value="实名认证", notes="实名认证" )
    @ResponseBody
    @PutMapping("/updateRealName")
    public ResultMsg updateRealName(@RequestBody TravelUserDo travelUserDo){
        ResultMsg resultMsg=new ResultMsg();

        if (StringUtils.isBlank(travelUserDo.getTrueName())) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("姓名不能为空");
            return resultMsg;
        }
        if (StringUtils.isBlank(travelUserDo.getIdCardNo())) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("证件号不能为空");
            return resultMsg;
        }
        if (StringUtils.isBlank(travelUserDo.getId())) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("用户编号为空");
            return resultMsg;
        }

        TravelUserDo userDo = travelUserService.selectByPrimaryKey(travelUserDo.getId());
        if(userDo == null){
            if (StringUtils.isBlank(travelUserDo.getId())) {
                resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                resultMsg.setMsg("无该用户信息");
                return resultMsg;
            }
        }
        TravelUser travelUser = new TravelUser();
        travelUser.setId(userDo.getId());
        travelUser.setTrueName(travelUserDo.getTrueName());
        travelUser.setIdCardNo(travelUserDo.getIdCardNo());
        int cou = travelUserService.updateByPrimaryKeySelective(travelUser);
        if(cou>0){
            return resultMsg;
        }else{
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("实名认证失败");
            return resultMsg;
        }
    }
}
