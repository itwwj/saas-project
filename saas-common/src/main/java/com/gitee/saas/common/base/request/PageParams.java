package com.gitee.saas.common.base.request;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gitee.saas.common.base.entity.SuperEntity;
import com.gitee.saas.common.utils.StrPool;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页参数
 *
 * @author jie
 * @date 2020年02月14日16:19:36
 */
@Data
public class PageParams<T> implements Serializable{

    @NotNull(message = "查询对象model不能为空")
    private T model;

    private long size = 10;

    private long current = 1;

    private String sort = SuperEntity.FIELD_ID;

    private String order = "descending";

    private Map<String, String> map = new HashMap<>(1);

    /**
     * 支持多个字段排序，用法：
     * eg.1, 参数：{order:"name,id", order:"descending,ascending" }。 排序： name desc, id asc
     * eg.2, 参数：{order:"name", order:"descending,ascending" }。 排序： name desc
     * eg.3, 参数：{order:"name,id", order:"descending" }。 排序： name desc
     *
     * @return
     */
    @JsonIgnore
    public IPage buildPage() {
        PageParams params = this;
        //没有排序参数
        if (StrUtil.isEmpty(params.getSort())) {
            Page page = new Page(params.getCurrent(), params.getSize());
            return page;
        }

        Page page = new Page(params.getCurrent(), params.getSize());

        List<OrderItem> orders = new ArrayList<>();
        String[] sortArr = StrUtil.split(params.getSort(), StrPool.COMMA);
        String[] orderArr = StrUtil.split(params.getOrder(), StrPool.COMMA);

        int len = sortArr.length < orderArr.length ? sortArr.length : orderArr.length;
        for (int i = 0; i < len; i++) {
            String humpSort = sortArr[i];
            // 简单的 驼峰 转 下划线
            String underlineSort = StrUtil.toUnderlineCase(humpSort);
            orders.add("ascending".equals(orderArr[i]) ? OrderItem.asc(underlineSort) : OrderItem.desc(underlineSort));
        }

        page.setOrders(orders);

        return page;
    }


    /**
     * 计算当前分页偏移量
     */
    @JsonIgnore
    public long offset() {
        long current = this.current;
        if (current <= 1L) {
            return 0L;
        }
        return (current - 1) * this.size;
    }
}
