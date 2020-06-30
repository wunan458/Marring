

CREATE TABLE public.application_keeper
(
    app_id SERIAL primary key,
    app_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_time timestamp without time zone,
    app_config text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    owner character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    serving_log text COLLATE pg_catalog."default",
    training_log text COLLATE pg_catalog."default",
    flag text COLLATE pg_catalog."default",
    state integer,
    data_profile_id integer,
    model_def_id character varying(255) COLLATE pg_catalog."default",
    model_path character varying(255) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.application_keeper
    OWNER to postgres;

    CREATE TABLE public.data_profile
(
    data_profile_id SERIAL primary key,
    data_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    data_figure text COLLATE pg_catalog."default",
    data_path character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    depict_state integer,
    description text COLLATE pg_catalog."default",
    owner character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    size_path character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    create_time timestamp without time zone,
    md5 character varying(255) COLLATE pg_catalog."default",
    is_executed integer,
    CONSTRAINT data_path UNIQUE (data_path)
)

TABLESPACE pg_default;

ALTER TABLE public.data_profile
    OWNER to postgres;

COMMENT ON CONSTRAINT data_path ON public.data_profile
    IS '唯一';

    CREATE TABLE public.model_def
(
    model_def_id character varying(64) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    model_json text COLLATE pg_catalog."default",
    model_type character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    owner character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    model_name character varying(255) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    create_time timestamp without time zone,
    CONSTRAINT model_def_pkey PRIMARY KEY (model_def_id)
)

TABLESPACE pg_default;

ALTER TABLE public.model_def
    OWNER to postgres;

-- ----------------------------
-- Records of model_def
-- ----------------------------
BEGIN;
INSERT INTO "public"."model_def" VALUES ('model_lxn_1585561768987', 'XGBoost 是对梯度提升算法的改进，求解损失函数极值时使用了牛顿法，将损失函数泰勒展开到二阶，另外损失函数中加入了正则化项。训练时的目标函数由两部分构成，第一部分为梯度提升算法损失，第二部分为正则化项。', '{"modelDefId":"model_lxn_1585561768987","modelType":"xgb","modelName":"XGBRegressor","params":{"max_depth":5,"learning_rate":0.2,"n_estimators":10,"verbosity":1,"silent":null,"objective":"reg:logistic","booster":"gbtree","n_jobs":1,"nthread":null,"gamma":0,"min_child_weight":1,"max_delta_step":0,"subsample":1,"colsample_bytree":1,"colsample_bylevel":1,"colsample_bynode":1,"reg_alpha":0,"reg_lambda":0.5,"scale_pos_weight":1,"base_score":0.5,"random_state":0,"seed":null,"missing":NaN}}', 'xgb', 'lxn', 'XGBRegressor', NULL);
INSERT INTO "public"."model_def" VALUES ('model_lxn_1586414876320', 'XGBoost 是对梯度提升算法的改进，求解损失函数极值时使用了牛顿法，将损失函数泰勒展开到二阶，另外损失函数中加入了正则化项。训练时的目标函数由两部分构成，第一部分为梯度提升算法损失，第二部分为正则化项。', '{"modelDefId":"model_lxn_1586414876320","modelType":"xgb","modelName":"XGBClassifier","params":{"max_depth":3,"learning_rate":0.1,"n_estimators":100,"verbosity":1,"silent":null,"objective":"binary:logistic","booster":"gbtree","n_jobs":1,"nthread":null,"gamma":0,"min_child_weight":1,"max_delta_step":0,"subsample":1,"colsample_bytree":1,"colsample_bylevel":1,"colsample_bynode":1,"reg_alpha":0,"reg_lambda":1,"scale_pos_weight":1,"base_score":0.5,"random_state":0,"seed":null,"missing":NaN}}', 'xgb', 'lxn', 'XGBClassifier', NULL);
INSERT INTO "public"."model_def" VALUES ('model_lxn_1585561877875', 'XGBoost 是对梯度提升算法的改进，求解损失函数极值时使用了牛顿法，将损失函数泰勒展开到二阶，另外损失函数中加入了正则化项。训练时的目标函数由两部分构成，第一部分为梯度提升算法损失，第二部分为正则化项。', '{"modelDefId":"model_lxn_1585561877875","modelType":"xgb","modelName":"XGBRegressor","params":{"max_depth":3,"learning_rate":0.1,"n_estimators":100,"verbosity":1,"silent":null,"objective":"reg:squarederror","booster":"gbtree","n_jobs":1,"nthread":null,"gamma":0,"min_child_weight":1,"max_delta_step":0,"subsample":1,"colsample_bytree":1,"colsample_bylevel":1,"colsample_bynode":1,"reg_alpha":0,"reg_lambda":1,"scale_pos_weight":1,"base_score":0.5,"random_state":0,"seed":null,"missing":NaN}}', 'xgb', 'lxn', 'XGBRegressor', NULL);
INSERT INTO "public"."model_def" VALUES ('model_lxn_1585548584605', 'XGBoost 是对梯度提升算法的改进，求解损失函数极值时使用了牛顿法，将损失函数泰勒展开到二阶，另外损失函数中加入了正则化项。训练时的目标函数由两部分构成，第一部分为梯度提升算法损失，第二部分为正则化项。', '{"modelDefId":"model_lxn_1585548584605","modelType":"xgb","modelName":"XGBClassifier","params":{"max_depth":5,"learning_rate":0.2,"n_estimators":10,"verbosity":1,"silent":null,"objective":"multi:softmax","booster":"gbtree","n_jobs":1,"nthread":null,"gamma":0,"min_child_weight":1,"max_delta_step":0,"subsample":1,"colsample_bytree":1,"colsample_bylevel":1,"colsample_bynode":1,"reg_alpha":0,"reg_lambda":0.5,"scale_pos_weight":1,"base_score":0.5,"random_state":0,"seed":null,"missing":NaN}}', 'xgb', 'lxn', 'XGBClassifier', NULL);
COMMIT;

-- ----------------------------
-- Primary Key structure for table model_def
-- ----------------------------
ALTER TABLE "public"."model_def" ADD CONSTRAINT "model_def_pkey" PRIMARY KEY ("model_def_id");
