package com.sf.netmarket.model;

public class UserSalt {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_salt.user_id
     *
     * @mbg.generated Mon Jul 17 23:40:43 CST 2017
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_salt.salt
     *
     * @mbg.generated Mon Jul 17 23:40:43 CST 2017
     */
    private String salt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_salt.user_id
     *
     * @return the value of user_salt.user_id
     *
     * @mbg.generated Mon Jul 17 23:40:43 CST 2017
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_salt.user_id
     *
     * @param userId the value for user_salt.user_id
     *
     * @mbg.generated Mon Jul 17 23:40:43 CST 2017
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_salt.salt
     *
     * @return the value of user_salt.salt
     *
     * @mbg.generated Mon Jul 17 23:40:43 CST 2017
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_salt.salt
     *
     * @param salt the value for user_salt.salt
     *
     * @mbg.generated Mon Jul 17 23:40:43 CST 2017
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}