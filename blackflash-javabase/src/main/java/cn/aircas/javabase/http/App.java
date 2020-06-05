package cn.aircas.javabase.http;

public class App extends BaseEntity {

  private String name;

  private String appId;

  private String orgId;

  private String orgName;

  private String ownerName;

  private String ownerEmail;

  public String getAppId() {
    return appId;
  }

  public String getName() {
    return name;
  }

  public String getOrgId() {
    return orgId;
  }

  public String getOrgName() {
    return orgName;
  }

  public String getOwnerEmail() {
    return ownerEmail;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public void setOwnerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public static class Builder {

    public Builder() {
    }

    private App app = new App();

    public Builder name(String name) {
      app.setName(name);
      return this;
    }

    public Builder appId(String appId) {
      app.setAppId(appId);
      return this;
    }

    public Builder orgId(String orgId) {
      app.setOrgId(orgId);
      return this;
    }

    public Builder orgName(String orgName) {
      app.setOrgName(orgName);
      return this;
    }

    public Builder ownerName(String ownerName) {
      app.setOwnerName(ownerName);
      return this;
    }

    public Builder ownerEmail(String ownerEmail) {
      app.setOwnerEmail(ownerEmail);
      return this;
    }

    public App build() {
      return app;
    }

  }

  public static Builder builder() {
    return new Builder();
  }


}
