package com.gitee.saas.common.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.saas.common.base.request.PageParams;
import com.gitee.saas.common.base.request.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

/**
 * 查询Controller
 *
 * @param <Entity>  实体
 * @param <Id>      主键
 * @param <PageDTO> 分页参数
 * @author jie
 * @date 2020年03月07日22:06:35
 */
public interface QueryController<Entity, Id extends Serializable, PageDTO> extends PageController<Entity, PageDTO> {

    /**
     * 查询
     *
     * @param id 主键id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    default R<Entity> get(@PathVariable Id id) {
        return success(getBaseService().getById(id));
    }

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/page")
    default R<IPage<Entity>> page(@RequestBody @Validated PageParams<PageDTO> params) {
        // 处理参数
        IPage<Entity> page = params.buildPage();
        query(params, page, null);
        return success(page);
    }
}
