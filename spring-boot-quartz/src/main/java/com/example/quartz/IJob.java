package com.example.quartz;


/**
 * IJOB接口
 *
 * @Author: heyuhua
 * @Date: 2021/1/11 14:54
 */
public interface IJob {
    /**
     * 开始任务
     *
     * @param name
     * @param group
     * @param cron
     * @param clazz
     */
    void start(String name, String group, String cron, Class clazz);

}






