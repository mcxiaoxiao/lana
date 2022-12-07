package com.lana.modules.system.controller;




import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.lana.common.utils.Result;
import com.lana.modules.system.pojo.entity.BusBindingEntity;
import com.lana.modules.system.service.BusBindingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 任务—流程绑定(BusBinding)表控制层
 *
 * @author lyl
 * @since 2022-12-07 21:26:46
 */
@RestController
@Api(tags = "任务绑定流程")
@ApiSupport(author = "liuyulet")
@RequestMapping("/busBinding")
public class BusBindingController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BusBindingService busBindingService;


    /**
     * 新增数据
     *
     * @param busBinding 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增绑定", notes = "新增绑定")
    @PostMapping("/addBinding")
    public Result insert(@RequestBody BusBindingEntity busBinding) {
        return Result.ok(this.busBindingService.save(busBinding));
    }

    /**
     * 修改数据
     *
     * @param busBinding 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改绑定", notes = "修改绑定")
    @PostMapping("/updateBinding")
    public Result update(@RequestBody BusBindingEntity busBinding) {
        return Result.ok(this.busBindingService.updateById(busBinding));
    }

    /**
     * 解除绑定
     *
     * @return 解除绑定
     */
    @ApiOperation(value = "解除绑定", notes = "解除绑定(只能解除未进行的任务)")
    @GetMapping("/delBinding")
    public Result delete(@RequestParam Long id) {
        return Result.ok(this.busBindingService.removeById(id));
    }
}

