package mapper;

import entity.remote.GithubUserResponse;
import entity.user.GithubUser;

import java.util.List;

public class GithubUserMapper implements Mapper<GithubUserResponse, GithubUser> {
    @Override
    public GithubUser map(GithubUserResponse githubUserResponse) {
        Long id = 0L;
        String name = githubUserResponse.name;
        String login = githubUserResponse.login;
        String location = githubUserResponse.location;
        String language = githubUserResponse.language;
        String gravatar = githubUserResponse.gravatar;
        Integer followers = githubUserResponse.followers;
        List<String> organizations = githubUserResponse.organizations;
        Integer contributions = githubUserResponse.contributions;
        return new GithubUser(id, name, login, location, language, gravatar, followers, organizations, contributions);
    }
}
