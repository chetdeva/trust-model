package entity.user;

import java.util.List;

public class GithubUser {

    public Long id;
    public String name;
    public String login;
    public String location;
    public String language;
    public String gravatar;
    public Integer followers;
    public List<String> organizations;
    public Integer contributions;

    public GithubUser() {
    }

    public GithubUser(Long id, String name, String login, String location,
                      String language, String gravatar, Integer followers,
                      List<String> organizations, Integer contributions) {
        this.id = id;
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
