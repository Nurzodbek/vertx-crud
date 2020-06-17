package com.simple.vertx.vertx.model;

public class File {


    private Long fileId;

    private Long loginId;

    private String name;

    private String displayName;

    private String uniqueName;

    private String discription;

    private Long size;

    private String mimeType;


    public File(){

    }

    
    public File(Long fileId, Long loginId, 
                String name, String displayName,
                String uniqueName, String discription,
                Long size, String mimeType)
    {

        this.fileId = fileId;
        this.loginId = loginId;
        this.name = name;
        this.displayName = displayName;
        this.uniqueName = uniqueName;
        this.discription = discription;
        this.size = size;
        this.mimeType = mimeType;
    }



    /**
     * @return Long return the fileId
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId the fileId to set
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * @return Long return the loginId
     */
    public Long getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return String return the uniqueName
     */
    public String getUniqueName() {
        return uniqueName;
    }

    /**
     * @param uniqueName the uniqueName to set
     */
    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    /**
     * @return String return the discription
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * @param discription the discription to set
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * @return Long return the size
     */
    public Long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * @return String return the mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @param mimeType the mimeType to set
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }



}