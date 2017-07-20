package com.sf.netmarket.model;

public class ProductInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_info.book_id
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    private Integer bookId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_info.book_name
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    private String bookName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_info.book_author
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    private String bookAuthor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_info.book_version
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    private String bookVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_info.publisher_id
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    private Integer publisherId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_info.book_id
     *
     * @return the value of product_info.book_id
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_info.book_id
     *
     * @param bookId the value for product_info.book_id
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_info.book_name
     *
     * @return the value of product_info.book_name
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_info.book_name
     *
     * @param bookName the value for product_info.book_name
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_info.book_author
     *
     * @return the value of product_info.book_author
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_info.book_author
     *
     * @param bookAuthor the value for product_info.book_author
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_info.book_version
     *
     * @return the value of product_info.book_version
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public String getBookVersion() {
        return bookVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_info.book_version
     *
     * @param bookVersion the value for product_info.book_version
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public void setBookVersion(String bookVersion) {
        this.bookVersion = bookVersion == null ? null : bookVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_info.publisher_id
     *
     * @return the value of product_info.publisher_id
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public Integer getPublisherId() {
        return publisherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_info.publisher_id
     *
     * @param publisherId the value for product_info.publisher_id
     *
     * @mbg.generated Wed Jun 07 23:26:42 CST 2017
     */
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
}