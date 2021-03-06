package com.gitee.saas.common.base.controller;


import com.gitee.saas.common.base.request.R;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;


/**
 * 删除Controller
 *
 * @param <Entity> 实体
 * @param <Id>     主键
 * @author jie
 * @date 2020年03月07日22:02:16
 */
public interface DeleteController<Entity, Id extends Serializable> extends BaseController<Entity> {

    /**
     * 删除方法
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    default R<Boolean> delete(@RequestParam("ids[]") List<Id> ids) {
        R<Boolean> result = handlerDelete(ids);
        if (result.getDefExec()) {
            getBaseService().removeByIds(ids);
        }
        return result;
    }

    /**
     * 自定义删除
     *
     * @param ids
     * @return 返回SUCCESS_RESPONSE, 调用默认更新, 返回其他不调用默认更新
     */
    default R<Boolean> handlerDelete(List<Id> ids) {
        return R.successDef(true);
    }

}
