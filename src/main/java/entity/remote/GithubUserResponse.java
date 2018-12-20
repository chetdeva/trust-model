package entity.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubUserResponse {

    @SerializedName("name")
    public String name;
    @SerializedName("login")
    public String login;
    @SerializedName("location")
    public String location;
    @SerializedName("language")
    public String language;
    @SerializedName("gravatar")
    public String gravatar;
    @SerializedName("followers")
    public Integer followers;
    @SerializedName("organizations")
    public List<String> organizations;
    @SerializedName("contributions")
    public Integer contributions;

    public GithubUserResponse(String name, String login, String location, String language, String gravatar, Integer followers, List<String> organizations, Integer contributions) {
        this.name = name;
        this.login = login;
        this.location = location;
        this.language = language;
        this.gravatar = gravatar;
        this.followers = followers;
        this.organizations = organizations;
        this.contributions = contributions;
    }


}
