
truncate table t_market_industry_classify;
insert into t_market_industry_classify(industry_id, industry_name) values
(1, '广告'),
(2, '安全'),
(3, '汽车'),
(4, '新闻服务'),
(5, '互联网'),
(6, '金融');


truncate table t_market_secondary_classify;
insert into t_market_secondary_classify(secondary_id, industry_id, secondary_name) values
(1, 1, '预测'),
(2, 1, '文本识别'),
(3, 1, '图像识别'),
(4, 1, '文本分析'),
(5, 1, '数据处理'),
(6, 2, '预测'),
(7, 2, '文本识别'),
(8, 2, '图像识别'),
(9, 2, '文本分析'),
(10, 2, '数据处理'),
(11, 3, '预测'),
(12, 3, '文本识别'),
(13, 3, '图像识别'),
(14, 3, '文本分析'),
(15, 3, '数据处理'),
(16, 4, '预测'),
(17, 4, '文本识别'),
(18, 4, '图像识别'),
(19, 4, '文本分析'),
(20, 4, '数据处理'),
(21, 5, '预测'),
(22, 5, '文本识别'),
(23, 5, '图像识别'),
(24, 5, '文本分析'),
(25, 5, '数据处理'),
(26, 6, '预测'),
(27, 6, '文本识别'),
(28, 6, '图像识别'),
(29, 6, '文本分析'),
(30, 6, '数据处理');