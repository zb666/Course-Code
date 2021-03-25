package com.example.sharing_demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.core.strategy.route.inline.InlineShardingStrategy;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SpringBootTest
class SharingDemoApplicationTests {

    @Test
    void contextLoads() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        //配置第一个数据源
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ds0");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        dataSourceMap.put("ds0",druidDataSource);


        //配置第二个数据源
        DruidDataSource druidDataSource2 = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ds1");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        dataSourceMap.put("ds1",druidDataSource2);

        //配置Order规则
        TableRuleConfiguration ruleConfiguration = new TableRuleConfiguration("t_order","ds${0..1}.t_order");
        //分库策略

        //分库策略制定
        InlineShardingStrategyConfiguration dataBaseInlineStrategy =
                new InlineShardingStrategyConfiguration("order_id","ds${order_id%2}");
        ruleConfiguration.setDatabaseShardingStrategyConfig(dataBaseInlineStrategy);

        //分表策略
        InlineShardingStrategyConfiguration tableInlineStrategy = new InlineShardingStrategyConfiguration("order_id","t_order");
        ruleConfiguration.setTableShardingStrategyConfig(tableInlineStrategy);

        //添加表的配置
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(ruleConfiguration);

        //获取数据源对象
        try {
            DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfiguration, new Properties());

            String sql = "SELECT * FROM t_order=?";

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,2);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //%2 路由到了
                System.out.println("----order id: "+resultSet.getLong(1));
                System.out.println("----user id: "+resultSet.getLong(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
