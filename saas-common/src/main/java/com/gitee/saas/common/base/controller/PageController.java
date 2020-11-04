package com.gitee.saas.common.base.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.saas.common.base.request.PageParams;

/**
 * 分页Controller
 *
 * @param <Entity>  实体
 * @param <PageDTO> 分页参数
 * @author jie
 * @date 2020年03月07日22:06:35
 */
public interface PageController<Entity, PageDTO> extends BaseController<Entity> {


    /**
     * 处理参数
     *
     * @param params
     */
    default void handlerQueryParams(PageParams<PageDTO> params) {
    }

    /**
     * 执行查询
     * <p>
     * 可以覆盖后重写查询逻辑
     *
     * @param params
     * @param page
     * @param defSize
     */
    default void query(PageParams<PageDTO> params, IPage<Entity> page, Long defSize) {
        handlerQueryParams(params);

        if (defSize != null) {
            page.setSize(defSize);
        }
        Entity model = BeanUtil.toBean(params.getModel(), getEntityClass());
        getBaseService().page(page);
    }
}
