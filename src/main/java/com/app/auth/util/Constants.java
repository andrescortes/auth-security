package com.app.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    // core
    public static final String CATEGORY_NOT_FOUND_WITH_ID = "Category not found with id ";
    public static final String PRODUCT_NOT_FOUND_WITH_ID = "Product not found with id ";

    // database
    public static final String COM_APP = "com.app";
    public static final String PERSISTENCE_UNIT_NAME = "postgres";
    public static final String HIBERNATE_HBM_2_DDL_AUTO = "hibernate.hbm2ddl.auto";
    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    public static final String HIBERNATE_USE_SQL_COMMENTS = "hibernate.use_sql_comments";
    public static final String CREATE_DROP = "create-drop";
    public static final String TRUE = "true";

    // global errors
    public static final String ERROR_PLEASE_TRY_AGAIN = "Internal Server Error, please try again";
    public static final String REQUEST_CHECK_THE_FORMAT = "Error in the request, check the format";
    public static final String PASSWORDS_DONT_MATCH = "Passwords don't match";
}
