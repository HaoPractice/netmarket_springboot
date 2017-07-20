package com.sf.netmarket.mapper;

import com.sf.netmarket.model.UserSalt;
import com.sf.netmarket.model.UserSaltExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSaltMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    long countByExample(UserSaltExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int deleteByExample(UserSaltExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int insert(UserSalt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int insertSelective(UserSalt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    List<UserSalt> selectByExample(UserSaltExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    UserSalt selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") UserSalt record, @Param("example") UserSaltExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int updateByExample(@Param("record") UserSalt record, @Param("example") UserSaltExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int updateByPrimaryKeySelective(UserSalt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_salt
     *
     * @mbg.generated Mon Jul 17 23:49:26 CST 2017
     */
    int updateByPrimaryKey(UserSalt record);
}