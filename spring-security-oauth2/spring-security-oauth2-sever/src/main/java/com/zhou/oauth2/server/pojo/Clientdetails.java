package com.zhou.oauth2.server.pojo;

import javax.persistence.*;

@Table(name = "zhou..clientdetails")
public class Clientdetails {
    @Id
    @Column(name = "appId")
    private String appid;

    @Column(name = "resourceIds")
    private String resourceids;

    @Column(name = "appSecret")
    private String appsecret;

    private String scope;

    @Column(name = "grantTypes")
    private String granttypes;

    @Column(name = "redirectUrl")
    private String redirecturl;

    private String authorities;

    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @Column(name = "additionalInformation")
    private String additionalinformation;

    @Column(name = "autoApproveScopes")
    private String autoapprovescopes;

    /**
     * @return appId
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return resourceIds
     */
    public String getResourceids() {
        return resourceids;
    }

    /**
     * @param resourceids
     */
    public void setResourceids(String resourceids) {
        this.resourceids = resourceids;
    }

    /**
     * @return appSecret
     */
    public String getAppsecret() {
        return appsecret;
    }

    /**
     * @param appsecret
     */
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    /**
     * @return scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return grantTypes
     */
    public String getGranttypes() {
        return granttypes;
    }

    /**
     * @param granttypes
     */
    public void setGranttypes(String granttypes) {
        this.granttypes = granttypes;
    }

    /**
     * @return redirectUrl
     */
    public String getRedirecturl() {
        return redirecturl;
    }

    /**
     * @param redirecturl
     */
    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    /**
     * @return authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * @return access_token_validity
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * @param accessTokenValidity
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * @return refresh_token_validity
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * @param refreshTokenValidity
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * @return additionalInformation
     */
    public String getAdditionalinformation() {
        return additionalinformation;
    }

    /**
     * @param additionalinformation
     */
    public void setAdditionalinformation(String additionalinformation) {
        this.additionalinformation = additionalinformation;
    }

    /**
     * @return autoApproveScopes
     */
    public String getAutoapprovescopes() {
        return autoapprovescopes;
    }

    /**
     * @param autoapprovescopes
     */
    public void setAutoapprovescopes(String autoapprovescopes) {
        this.autoapprovescopes = autoapprovescopes;
    }
}