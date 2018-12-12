package com.travel.travelapi.api.controller;

import com.travel.travelapi.api.entity.TravelUser;
import com.travel.travelapi.api.entityDo.TravelUserDo;
import com.travel.travelapi.api.service.TravelUserService;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import com.travel.travelapi.utils.ImageUtil;
import io.swagger.annotations.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/travelImage")
@Api(value = "附件上传",description = "附件上传")
public class TravelImageController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TravelUserService travelUserService;

    @Value("${fileUpload.rootSavePath}")
    private String rootSavePath;

    @Value("${fileUpload.rootHttpPath}")
    private String rootHttpPath;

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型，1头像，2头像背景图，3身份证正面，4身份证反面，5评价，6房屋", paramType = "query", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "houseId", value = "房屋ID", paramType = "query", dataType = "String")
    })
    @ResponseBody
    @PutMapping("/uploadImg")
    public ResultMsg uploadImg(
            @ApiParam(value = "上传的文件", required = true)
            @RequestParam(value = "file", required = true) MultipartFile multipartFile,
            @RequestParam(value = "type", required = true) int type,
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "houseId") String houseId)  {
        ResultMsg resultMsg=new ResultMsg();
        String imagePath=rootSavePath;


        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("附件为空");
            return resultMsg;
        }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("附件为空");
            return resultMsg;
        }
        String root_fileName = multipartFile.getOriginalFilename();
        logger.info("上传图片:name={},type={}", root_fileName, contentType);

        logger.info("图片保存路径={}", imagePath);
        String file_name = rootHttpPath;
        try {
            if (type==1 || type ==2 || type ==3 || type ==4){
                TravelUserDo travelUserDo = travelUserService.selectByPrimaryKey(userId);
                if (travelUserDo == null){
                    resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                    resultMsg.setMsg("无该用户信息");
                    return resultMsg;
                }
                if(type == 1) {
                    imagePath += "/headImg";
                    file_name += "/headImg";
                    file_name += ImageUtil.saveImg(multipartFile, imagePath);
                    travelUserDo.setHeadPic(file_name);
                }else if(type == 2){
                    imagePath += "/headBackImg";
                    file_name += "/headBackImg";
                    file_name += ImageUtil.saveImg(multipartFile, imagePath);
                    travelUserDo.setBackPic(file_name);
                }else  if(type == 3){
                    imagePath += "/userIdImg";
                    file_name += "/userIdImg";
                    file_name += ImageUtil.saveImg(multipartFile, imagePath);
                    travelUserDo.setIdFront(file_name);
                }else{
                    imagePath += "/userIdImg";
                    file_name += "/userIdImg";
                    file_name += ImageUtil.saveImg(multipartFile, imagePath);
                    travelUserDo.setIdBehind(file_name);
                }

                TravelUser travelUser = new TravelUser();
                BeanUtils.copyProperties(travelUser, travelUserDo);
                travelUserService.updateByPrimaryKeySelective(travelUser);
            }else if(type==5){

            }else if(type == 6){

            }else{
                resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
                resultMsg.setMsg("未知上传类型");
                return resultMsg;
            }
            resultMsg.setData(file_name);
            logger.info("返回值：{}",resultMsg);
            return resultMsg;
        } catch (Exception e) {
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("上传附件失败");
            return resultMsg;
        }
    }

}
